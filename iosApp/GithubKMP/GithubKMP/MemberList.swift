//
//  MemberList.swift
//  GithubKMP
//
//  Created by Smart City on 5/5/19.
//  Copyright © 2019 spl. All rights reserved.
//

import Foundation
import shared

class MemberList {
    var members:[Member] = []
    
    func updateMembers(_ newMembers: [Member]) {
        members.removeAll()
        members.append(contentsOf: newMembers)
    }
    
}

