/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import User.RegistrasiPelangganView;
import User.RegistrasiTokoView;
import User.LoginView;
/**
 *
 * @author Chlas
 */
public class MenuMethods {
    public static void gotoRegistrasiPelanggan(){
        RegistrasiPelangganView menu = new RegistrasiPelangganView();
        menu.setVisible(true);
    }
    public static void gotoRegistrasiToko(){
        RegistrasiTokoView menu = new RegistrasiTokoView();
        menu.setVisible(true);
    }
    public static void gotoLogin(){
        LoginView menu = new LoginView();
        menu.setVisible(true);
    }
}
