//
//  RepoTableViewCell.swift
//  konfswift
//
//  Created by florent champigny on 30/10/2018.
//  Copyright © 2018 Yan Zhulanow. All rights reserved.
//

import UIKit
import common

class RepoTableViewCell : UITableViewCell {
    @IBOutlet private weak var titleLabel: UILabel!
    @IBOutlet private weak var subtitleLabel: UILabel!
    
    func setup(for repo: Repository) {
        titleLabel.text = repo.name
    }
}
