//
//  ViewController.swift
//  GithubKMP
//
//  Created by Smart City on 5/5/19.
//  Copyright © 2019 spl. All rights reserved.
//

import UIKit
import shared

class ViewController: UIViewController, MemberView {
    
    let memberList = MemberList()
    var isUpdating: Bool = false
    
    lazy var presenter: MembersPresenter = {
        MembersPresenter(view: self, repository: AppDelegate.appDelegate.dataRespository)
    }()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        print("platform version:\(Greeting().greeting())")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        presenter.onCreate()
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        presenter.onDestroy()
    }
    
    func onUpdate(members: [Member]) {
        self.memberList.updateMembers(members)
        print("Member count:\(self.memberList.members.count)")
    }

}

