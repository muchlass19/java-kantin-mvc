/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import User.RegistrasiView;
import User.LoginView;
/**
 *
 * @author Chlas
 */
public class MenuMethods {
    public static void gotoRegistrasi(){
        RegistrasiView menu = new RegistrasiView();
        menu.setVisible(true);
    }
    public static void gotoLogin(){
        LoginView menu = new LoginView();
        menu.setVisible(true);
    }
}
