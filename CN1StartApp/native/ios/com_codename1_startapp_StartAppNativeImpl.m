#import "com_codename1_startapp_StartAppNativeImpl.h"
#import <StartApp/StartApp.h>

@implementation com_codename1_startapp_StartAppNativeImpl


-(void)showAd{
    [startAppAd showAd];
}

-(void)loadAd:(int)param{
    [startAppAd loadAd];
}

-(void)initSDK:(NSString*)param param1:(NSString*)param1 param2:(BOOL)param2{
    // initialize the SDK with your appID and devID
    STAStartAppSDK* sdk = [STAStartAppSDK sharedInstance];
    sdk.devID = param1;
    sdk.appID = param2;
    if(!param2){
        [sdk disableReturnAd];    
    }
    startAppAd = [[STAStartAppAd alloc] init];
}

-(BOOL)isSupported{
    return YES;
}

@end
