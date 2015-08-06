package com.codename1.startapp;
import android.os.Bundle;
import com.codename1.impl.android.AndroidNativeUtil;
import com.codename1.impl.android.LifecycleListener;
import com.startapp.android.publish.*;

public class StartAppNativeImpl implements LifecycleListener{
    
    private StartAppAd startAppAd;
    
    public void showAd() {
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {

            public void run() {
                startAppAd.showAd(new AdDisplayListener() {

                    public void adHidden(Ad ad) {
                        Callback.adHidden();
                    }

                    public void adDisplayed(Ad ad) {
                        Callback.adDisplayed();
                    }

                    public void adClicked(Ad ad) {
                        Callback.adClicked();
                    }

                    public void adNotDisplayed(Ad ad) {
                        Callback.adNotDisplayed(ad.getNotDisplayedReason().toString());
                    }
                });
            }
        });
    }

    public void loadAd(final int param) {
        AndroidNativeUtil.getActivity().runOnUiThread(new Runnable() {

            public void run() {
                if(param == StartAppManager.AD_REWARDED_VIDEO){
                    startAppAd.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {

                        public void onReceiveAd(Ad ad) {
                            Callback.adLoaded();
                        }

                        public void onFailedToReceiveAd(Ad ad) {
                            Callback.adFailedToLoad(ad.getErrorMessage());
                        }
                    });
                }else{
                    startAppAd.loadAd(new AdEventListener() {

                        public void onReceiveAd(Ad ad) {
                            Callback.adLoaded();
                        }

                        public void onFailedToReceiveAd(Ad ad) {
                            Callback.adFailedToLoad(ad.getErrorMessage());
                        }
                    });
                }
            }
        });
    }

    public void initSDK(String developerId, String appId, boolean returnAds) {
        StartAppSDK.init(AndroidNativeUtil.getActivity(), developerId, appId, returnAds);
        startAppAd = new StartAppAd(AndroidNativeUtil.getActivity());
        AndroidNativeUtil.addLifecycleListener(this);
    }

    public boolean isSupported() {
        return true;
    }

    public void onCreate(Bundle savedInstanceState) {
    }

    public void onResume() {
        if(startAppAd != null){
            startAppAd.onResume();
        }
    }

    public void onPause() {
        if(startAppAd != null){
            startAppAd.onPause();
        }
    }

    public void onDestroy() {
    }

    public void onSaveInstanceState(Bundle b) {
    }

    public void onLowMemory() {
    }

}
