//
//  RepoCell.swift
//  appswift
//
//  Created by florent champigny on 12/11/2018.
//  Copyright © 2018 Yan Zhulanow. All rights reserved.
//

import Foundation
import UIKit
import common

class RepoCell: UITableViewCell {
    
    @IBOutlet weak var labelRepo: UILabel!
    
    func bindRepo(_ repo: Repository){
        labelRepo.text = repo.name
    }
}
