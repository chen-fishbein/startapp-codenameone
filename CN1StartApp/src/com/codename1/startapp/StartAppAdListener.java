/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.startapp;

/**
 *
 * @author Chen
 */
public interface StartAppAdListener {

    public void adLoaded();
    
    public void adFailedToLoad(String message);
    
    public void adHidden();

    public void adDisplayed();

    public void adClicked();

    public void adNotDisplayed(String reason);
    
}
