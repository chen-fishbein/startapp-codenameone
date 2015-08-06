/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.startapp;

import com.codename1.ui.Display;

/**
 *
 * @author Chen
 */
public class Callback {

    private static StartAppAdListener l;

    public static void adLoaded() {
        if (l != null) {
            Display.getInstance().callSerially(new Runnable() {

                public void run() {
                    l.adLoaded();
                }
            });
        }
    }

    public static void adFailedToLoad(final String message) {
        if (l != null) {
            Display.getInstance().callSerially(new Runnable() {

                public void run() {
                    l.adFailedToLoad(message);
                }
            });
        }
    }

    public static void adHidden() {
        if (l != null) {
            Display.getInstance().callSerially(new Runnable() {

                public void run() {
                    l.adHidden();
                }
            });
        }
    }

    public static void adDisplayed() {
        if (l != null) {
            Display.getInstance().callSerially(new Runnable() {

                public void run() {
                    l.adDisplayed();
                }
            });
        }
    }

    public static void adClicked() {
        if (l != null) {
            Display.getInstance().callSerially(new Runnable() {

                public void run() {
                    l.adClicked();
                }
            });
        }
    }

    public static void adNotDisplayed(final String reason) {
        if (l != null) {
            Display.getInstance().callSerially(new Runnable() {

                public void run() {
                    l.adNotDisplayed(reason);
                }
            });
        }
    }

    static void setListener(StartAppAdListener listener) {
        l = listener;
    }

}
