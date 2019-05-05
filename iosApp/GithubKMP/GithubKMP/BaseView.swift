//
//  BaseView.swift
//  GithubKMP
//
//  Created by Smart City on 5/5/19.
//  Copyright © 2019 spl. All rights reserved.
//

import Foundation
import shared
import UIKit

extension UIViewController: BaseView {
    public func showError(error: KotlinThrowable) {
        let title: String = "Error"
        var errorMessage: String? = nil
        
        switch error {
        case is UpdateProblems:
            errorMessage = "Failed to get data from server"
        default:
            errorMessage = "Unknown error"
        }
        
        if let message = errorMessage {
            self.showErrow(title: title, message: message)
        }
    }
    
    
    func showErrow(title: String, message: String) {
        let alertController = UIAlertController(title: title, message: message, preferredStyle: UIAlertController.Style.alert)
        alertController.addAction(UIAlertAction(title: "Dismiss", style: UIAlertAction.Style.default, handler: nil))
        self.present(alertController, animated: true, completion: nil)
    }
}
