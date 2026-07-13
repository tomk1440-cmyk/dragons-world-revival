package com.facebook.unity;

import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.widget.GameRequestDialog;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class FBUnityGameRequestActivity extends BaseActivity {
    public static final String GAME_REQUEST_PARAMS = "game_request_params";

    @Override // com.facebook.unity.BaseActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle params = getIntent().getBundleExtra(GAME_REQUEST_PARAMS);
        final UnityMessage response = new UnityMessage("OnAppRequestsComplete");
        if (params.containsKey(Constants.CALLBACK_ID_KEY)) {
            response.put(Constants.CALLBACK_ID_KEY, params.getString(Constants.CALLBACK_ID_KEY));
        }
        GameRequestContent.Builder contentBuilder = new GameRequestContent.Builder();
        if (params.containsKey("message")) {
            contentBuilder.setMessage(params.getString("message"));
        }
        if (params.containsKey(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE)) {
            String actionTypeStr = params.getString(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE);
            try {
                GameRequestContent.ActionType type = GameRequestContent.ActionType.valueOf(actionTypeStr);
                contentBuilder.setActionType(type);
            } catch (IllegalArgumentException e) {
                response.sendError("Unknown action type: " + actionTypeStr);
                finish();
                return;
            }
        }
        if (params.containsKey("object_id")) {
            contentBuilder.setObjectId(params.getString("object_id"));
        }
        if (params.containsKey("to")) {
            String toStr = params.getString("to");
            contentBuilder.setRecipients(Arrays.asList(toStr.split(",")));
        }
        if (params.containsKey(ShareConstants.WEB_DIALOG_PARAM_FILTERS)) {
            String filtersStr = params.getString(ShareConstants.WEB_DIALOG_PARAM_FILTERS).toUpperCase(Locale.ROOT);
            try {
                GameRequestContent.Filters filters = GameRequestContent.Filters.valueOf(filtersStr);
                contentBuilder.setFilters(filters);
            } catch (IllegalArgumentException e2) {
                response.sendError("Unsupported filter type: " + filtersStr);
                finish();
                return;
            }
        }
        if (params.containsKey(ShareConstants.WEB_DIALOG_PARAM_DATA)) {
            contentBuilder.setData(params.getString(ShareConstants.WEB_DIALOG_PARAM_DATA));
        }
        if (params.containsKey("title")) {
            contentBuilder.setTitle(params.getString("title"));
        }
        GameRequestContent content = contentBuilder.build();
        GameRequestDialog requestDialog = new GameRequestDialog(this);
        requestDialog.registerCallback(this.mCallbackManager, new FacebookCallback<GameRequestDialog.Result>() { // from class: com.facebook.unity.FBUnityGameRequestActivity.1
            @Override // com.facebook.FacebookCallback
            public void onSuccess(GameRequestDialog.Result result) {
                response.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, result.getRequestId());
                response.put("to", TextUtils.join(",", result.getRequestRecipients()));
                response.send();
            }

            @Override // com.facebook.FacebookCallback
            public void onCancel() {
                response.putCancelled();
                response.send();
            }

            @Override // com.facebook.FacebookCallback
            public void onError(FacebookException e3) {
                response.sendError(e3.getMessage());
            }
        });
        try {
            requestDialog.show(content);
        } catch (IllegalArgumentException exception) {
            response.sendError("Unexpected exception encountered: " + exception.toString());
            finish();
        }
    }
}
