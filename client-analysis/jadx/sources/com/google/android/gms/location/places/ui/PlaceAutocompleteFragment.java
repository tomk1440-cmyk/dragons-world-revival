package com.google.android.gms.location.places.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.gms.R;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(12)
public class PlaceAutocompleteFragment extends Fragment {
    private View zzaRh;
    private View zzaRi;
    private EditText zzaRj;

    @Nullable
    private LatLngBounds zzaRk;

    @Nullable
    private AutocompleteFilter zzaRl;

    @Nullable
    private PlaceSelectionListener zzaRm;

    private void zzzF() {
        this.zzaRi.setVisibility(!this.zzaRj.getText().toString().isEmpty() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzzG() {
        int i;
        try {
            startActivityForResult(new PlaceAutocomplete.IntentBuilder(2).setBoundsBias(this.zzaRk).setFilter(this.zzaRl).zzeq(this.zzaRj.getText().toString()).zzig(1).build(getActivity()), 1);
            i = -1;
        } catch (GooglePlayServicesNotAvailableException e) {
            int i2 = e.errorCode;
            Log.e("Places", "Could not open autocomplete activity", e);
            i = i2;
        } catch (GooglePlayServicesRepairableException e2) {
            int connectionStatusCode = e2.getConnectionStatusCode();
            Log.e("Places", "Could not open autocomplete activity", e2);
            i = connectionStatusCode;
        }
        if (i != -1) {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(getActivity(), i, 2);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == -1) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), data);
                if (this.zzaRm != null) {
                    this.zzaRm.onPlaceSelected(place);
                }
                setText(place.getName().toString());
            } else if (resultCode == 2) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), data);
                if (this.zzaRm != null) {
                    this.zzaRm.onError(status);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewInflate = inflater.inflate(R.layout.place_autocomplete_fragment, container, false);
        this.zzaRh = viewInflate.findViewById(R.id.place_autocomplete_search_button);
        this.zzaRi = viewInflate.findViewById(R.id.place_autocomplete_clear_button);
        this.zzaRj = (EditText) viewInflate.findViewById(R.id.place_autocomplete_search_input);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.gms.location.places.ui.PlaceAutocompleteFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlaceAutocompleteFragment.this.zzzG();
            }
        };
        this.zzaRh.setOnClickListener(onClickListener);
        this.zzaRj.setOnClickListener(onClickListener);
        this.zzaRi.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.location.places.ui.PlaceAutocompleteFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PlaceAutocompleteFragment.this.setText("");
            }
        });
        zzzF();
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.zzaRh = null;
        this.zzaRi = null;
        this.zzaRj = null;
        super.onDestroyView();
    }

    public void setBoundsBias(@Nullable LatLngBounds bounds) {
        this.zzaRk = bounds;
    }

    public void setFilter(@Nullable AutocompleteFilter filter) {
        this.zzaRl = filter;
    }

    public void setHint(CharSequence hint) {
        this.zzaRj.setHint(hint);
        this.zzaRh.setContentDescription(hint);
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener listener) {
        this.zzaRm = listener;
    }

    public void setText(CharSequence text) {
        this.zzaRj.setText(text);
        zzzF();
    }
}
