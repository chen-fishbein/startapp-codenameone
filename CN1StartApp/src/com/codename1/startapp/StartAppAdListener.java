/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.startapp;

/**
 * This class is used to receive Ads callbacks
 * 
 * @author Chen
 */
public interface StartAppAdListener {

    /**
     * Called once the ad has been loaded
     */ 
    public void adLoaded();
    
    /**
     * Called when the ad failed to load
     * @param message the error message
     */ 
    public void adFailedToLoad(String message);
    
    /**
     * Called when the ad is being hidden
     */ 
    public void adHidden();

    /**
     * Called when the ad is displayed
     */ 
    public void adDisplayed();

    /**
     * Called when the ad is clicked
     */ 
    public void adClicked();

    /**
     * Called if the ad is not displayed
     * @param reason the message why is wasn't displayed
     */ 
    public void adNotDisplayed(String reason);
    
}
