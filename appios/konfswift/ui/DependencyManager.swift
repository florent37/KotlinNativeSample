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
