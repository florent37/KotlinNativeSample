import UIKit
import common

class GithubViewController: UIViewController, GithubView {
    
    @IBOutlet weak var progressView: UIActivityIndicatorView!
    
    @IBOutlet weak var progress: UIActivityIndicatorView!
    @IBOutlet weak var userSearch: UITextField!
   
    // private var repos: [Repository] = []
    @IBOutlet weak var image: UIImageView!
    @IBOutlet weak var userName: UILabel!
    @IBOutlet weak var company: UILabel!
    
    lazy var presenter: GithubPresenter = {
        dependencies().githubPresenter()
    }()
    
    @IBAction func searchUserName(_ sender: Any) {
        userSearch.resignFirstResponder()
        self.presenter.loadUser(name: userSearch.text!)
    }
    
    var isLoading = false {
        didSet {
            if(isLoading) {
                progressView.isHidden = false
            } else {
                progressView.isHidden = true
            }
        }
    }
    
    override func viewDidLoad() {
        presenter.bind(view: self)
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        presenter.unbind()
    }
    
    func displayUser(user: UserModel) {
        self.userName.text = user.name
        self.company.text = user.company
        
        self.image.sd_setImage(with: URL(string: user.avatar_url), placeholderImage: UIImage(named: "user_default"))
        self.image.layer.cornerRadius = self.image.frame.size.width/2
        self.image.clipsToBounds = true
    }
    
    
    func showError(error: KotlinThrowable) {
        dependencies().logger.logException(tag: "TAG", text: error.message!, exception: error as! KotlinException)
    }
    
    func displayRepos(repos: [Repository]) {
        dependencies().logger.log(tag: "TAG", text: repos.description)
    }
    
}
