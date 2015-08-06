/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.startapp;

import com.codename1.system.NativeInterface;

/**
 *
 * @author Chen
 */
public interface StartAppNative extends NativeInterface{
    
    public void initSDK(String accountId, String appId, boolean enableReturnAd);
    
    public void showAd();

    public void loadAd(int type);
    
}
