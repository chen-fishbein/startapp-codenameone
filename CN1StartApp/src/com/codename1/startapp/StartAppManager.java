/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.startapp;

import com.codename1.system.NativeLookup;
import com.codename1.ui.Display;

/**
 *
 * @author Chen
 */
public class StartAppManager {

    public static final int AD_INTERSTITIALS = 0;
    
    public static final int AD_REWARDED_VIDEO = 1;

    private StartAppNative startapp;
    
    public StartAppManager() {
        startapp = (StartAppNative) NativeLookup.create(StartAppNative.class);
    }
    
    
    /**
     * Init the startapp Android SDK
     *
     * @param appId
     * @param enableReturnAd 
     */    
    public void initSDK(String accountId, String appId, boolean enableReturnAd) {
        startapp.initSDK(accountId, appId, enableReturnAd);
    }
    
    /**
     * Init the startapp iOS SDK
     *
     * @param accountId 
     * @param appId
     * @param enableReturnAd 
     */    
    public void initIOSSDK(String accountId, String appId, boolean enableReturnAd) {
    }

    
    public void showAd(){    
        if(startapp != null){
            startapp.showAd();
        }
    }
    
    public void loadAd(int type){    
        if(startapp != null){
            startapp.loadAd(type);
        }
    }
    
    
    public void setAdsListener(StartAppAdListener l) {
        Callback.setListener(l);
    }
    
}
