#import "com_codename1_startapp_StartAppNativeImpl.h"
#import "com_codename1_startapp_Callback.h"
@implementation com_codename1_startapp_StartAppNativeImpl {

}



-(void)showAd{
    dispatch_sync(dispatch_get_main_queue(), ^{
        [startAppAd showAd];
    });
    
}

-(void)loadAd:(int)param{
    dispatch_sync(dispatch_get_main_queue(), ^{
        if (param == 0) {
            [startAppAd loadAdWithDelegate:self];
        } else {
            [startAppAd loadRewardedVideoAdWithDelegate:self];
        }
    });
    
}

-(void)initSDK:(NSString*)param param1:(NSString*)param1 param2:(BOOL)param2{
    // initialize the SDK with your appID and devID
    dispatch_sync(dispatch_get_main_queue(), ^{
        STAStartAppSDK* sdk = [STAStartAppSDK sharedInstance];
        sdk.devID = param;
        sdk.appID = param1;
        if(!param2){
            [sdk disableReturnAd];    
        }
        startAppAd = [[STAStartAppAd alloc] init];
    });
}

-(BOOL)isSupported{
    return YES;
}

#pragma mark STADelegateProtocol methods
/*
 Implementation of the STADelegationProtocol.
 All methods here are optional and you can
 implement only the ones you need.
*/

// StartApp Ad loaded successfully
- (void) didLoadAd:(STAAbstractAd*)ad;
{
    NSLog(@"StartApp Ad had been loaded successfully");
    
    
    // Show the Ad
    if (startAppAd == ad) {
        com_codename1_startapp_Callback_adLoaded__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
    }
}

// StartApp Ad failed to load
- (void) failedLoadAd:(STAAbstractAd*)ad withError:(NSError *)error;
{
    NSLog(@"StartApp Ad had failed to load");
    if (startAppAd == ad) {
        com_codename1_startapp_Callback_adFailedToLoad___java_lang_String(
                CN1_THREAD_GET_STATE_PASS_ARG  
                fromNSString(CN1_THREAD_GET_STATE_PASS_ARG [error localizedDescription])
        );
    }
}

// StartApp Ad is being displayed
- (void) didShowAd:(STAAbstractAd*)ad;
{
    NSLog(@"StartApp Ad is being displayed");
    if (startAppAd == ad) {
        com_codename1_startapp_Callback_adDisplayed__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
    }
}

// StartApp Ad failed to display
- (void) failedShowAd:(STAAbstractAd*)ad withError:(NSError *)error;
{
    
    NSLog(@"StartApp Ad is failed to display");
    if (startAppAd == ad) {
        com_codename1_startapp_Callback_adNotDisplayed___java_lang_String(
                CN1_THREAD_GET_STATE_PASS_ARG
                fromNSString(CN1_THREAD_GET_STATE_PASS_ARG [error localizedDescription])
        );
    }
}

- (void) didCloseAd:(STAAbstractAd*)ad {
    NSLog(@"Add closed");
    if (startAppAd == ad) {
        com_codename1_startapp_Callback_adHidden__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
    }
}

- (void) didClickAd:(STAAbstractAd*)ad {
    NSLog(@"Add clicked");
    if (startAppAd == ad) {
        com_codename1_startapp_Callback_adClicked__(CN1_THREAD_GET_STATE_PASS_SINGLE_ARG);
    }
}


@end
