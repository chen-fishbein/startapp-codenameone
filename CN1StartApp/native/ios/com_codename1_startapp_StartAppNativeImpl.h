#import <Foundation/Foundation.h>
/* Import StartApp SDK framework */
#import "StartApp.h"

@interface com_codename1_startapp_StartAppNativeImpl : NSObject<STADelegateProtocol> {
            
    STAStartAppAd *startAppAd;
}

-(void)showAd;
-(void)loadAd:(int)param;
-(void)initSDK:(NSString*)param param1:(NSString*)param1 param2:(BOOL)param2;
-(BOOL)isSupported;
@end
