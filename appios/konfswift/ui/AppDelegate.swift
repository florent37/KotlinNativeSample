import UIKit
import common

let KTUnit = KotlinUnit()

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    
    public lazy var dependencyManager = {
        DependencyManager()
    }()
    
    var window: UIWindow?

    static var me: AppDelegate {
        return UIApplication.shared.delegate as! AppDelegate
    }
    
    public func applicationDidBecomeActive(_ application: UIApplication) {
        //let logger = dependencyManager.logger
    }

    public func applicationWillTerminate(_ application: UIApplication) {
        // TODO: save context
    }
    
    private func generateUuid() -> String {
        return "ios-" + (UIDevice.current.identifierForVendor ?? UUID()).uuidString
    }
}

func dependencies() -> DependencyManager {
    return AppDelegate.me.dependencyManager
}
