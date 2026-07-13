package android.support.v4.app;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseFragmentActivityEclair extends BaseFragmentActivityDonut {
    BaseFragmentActivityEclair() {
    }

    @Override // android.support.v4.app.BaseFragmentActivityDonut
    void onBackPressedNotHandled() {
        super.onBackPressed();
    }
}
