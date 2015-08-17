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
        try {
            startapp = (StartAppNative) NativeLookup.create(StartAppNative.class);            
        } catch (Exception e) {
        }
    }
    
    
    /**
     * Init the startapp Android SDK
     *
     * @param appId
     * @param enableReturnAd 
     */    
    public void initAndroidSDK(String accountId, String appId, boolean enableReturnAd) {
        if (startapp != null && "and".equals(Display.getInstance().getPlatformName())) {
            startapp.initSDK(accountId, appId, enableReturnAd);
        }
    }
    
    /**
     * Init the startapp iOS SDK
     *
     * @param accountId 
     * @param appId
     * @param enableReturnAd 
     */    
    public void initIOSSDK(String accountId, String appId, boolean enableReturnAd) {
        if (startapp != null && "ios".equals(Display.getInstance().getPlatformName())) {
            startapp.initSDK(accountId, appId, enableReturnAd);
        }
    }

    
    /**
     * Show an Ad, call loadAd before.
     */ 
    public void showAd(){    
        if(startapp != null){
            startapp.showAd();
        }
    }
    
    /**
     * Load an Ad, this might take a few seconds.
     * @param type the Ad to load: AD_INTERSTITIALS or AD_REWARDED_VIDEO
     */ 
    public void loadAd(int type){    
        if(startapp != null){
            startapp.loadAd(type);
        }
    }
    
    
    /**
     * Sets an Ad listener to receive Ads callbacks
     * @param l StartAppAdListener Object
     */ 
    public void setAdsListener(StartAppAdListener l) {
        Callback.setListener(l);
    }
    
}
