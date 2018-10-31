//
//  DependencyManager.swift
//  konfswift
//
//  Created by florent champigny on 30/10/2018.
//  Copyright © 2018 Yan Zhulanow. All rights reserved.
//

import UIKit
import common

class DependencyManager: NSObject {
    
    public lazy var githubRepository : GithubRepository = {
        return GithubRepositoryImpl(logger: logger)
    }()
    
    public lazy var uiContext : KotlinCoroutineContext = {
        UI()
    }()
    
    func githubPresenter() -> GithubPresenter {
        return GithubPresenter(
            uiContext: uiContext,
            repository: githubRepository
        )
    }
    
    public lazy var logger : PlatformLogger = {
        PlatformLoggerIos()
    }()
    
}
