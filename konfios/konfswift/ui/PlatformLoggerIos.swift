//
//  PlatformLoggerIos.swift
//  konfswift
//
//  Created by florent champigny on 30/10/2018.
//  Copyright © 2018 Yan Zhulanow. All rights reserved.
//

import Foundation
import common

class PlatformLoggerIos: NSObject, PlatformLogger {
    func logException(tag: String, text: String, exception: KotlinThrowable?) {
        print(text)
    }
    
    func log(tag: String, text: String) {
         print(text)
    }
    
    
}
