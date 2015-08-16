#startapp-codenameone
cn1lib for startapp ads network

Library extension of the StartApp Ads SDK (http://www.startapp.com/) for the Codename One platform.(http://www.codenameone.com)

This plugin supports Interstitial Ads (Full Screen Ads) and Video Ads

The library is implemented for Android and iOS.

#Usage

## Add the following build hints

<b>android.xpermissions</b>=\<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>\<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
<br/><b>android.xapplication</b>=\<activity android:name="com.startapp.android.publish.list3d.List3DActivity" android:theme="@android:style/Theme" /> \<activity android:name="com.startapp.android.publish.OverlayActivity" android:theme="@android:style/Theme.Translucent" android:configChanges="orientation|keyboardHidden|screenSize" /> \<activity android:name="com.startapp.android.publish.FullScreenActivity" android:theme="@android:style/Theme" android:configChanges="orientation|keyboardHidden|screenSize" />
<br/><b>ios.add_libs</b>=CoreTelephony.framework;SystemConfiguration.framework;CoreGraphics.framework;StoreKit.framework;AdSupport.framework;QuartzCore.framework;CoreMedia.framework;AVFoundation.framework;libz.dylib

## init the SDK

```java
    public void init(Object context) {
        try {
            Resources theme = Resources.openLayered("/theme");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            //init the startapp SDK
            manager = new StartAppManager();
            manager.initAndroidSDK(<account_id>, <android_app_id>, true);
            manager.initIOSSDK(<account_id>, <ios_app_id>, true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

## Load and Show the Ad

Call:
```java
manager.loadAd(StartAppManager.AD_INTERSTITIALS);
```
or
```java
manager.loadAd(StartAppManager.AD_REWARDED_VIDEO);
```
Notice the loading might take a few seconds.

When you wish to display the Ad call:
```java
manager.showAd();
```





