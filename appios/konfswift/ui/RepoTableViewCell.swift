import UIKit
import common

class RepoTableViewCell : UITableViewCell {
    @IBOutlet private weak var titleLabel: UILabel!
    @IBOutlet private weak var subtitleLabel: UILabel!
    
    func setup(for repo: Repository) {
        titleLabel.text = repo.name
    }
}
