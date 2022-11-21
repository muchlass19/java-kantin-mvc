/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import User.LoginView;

/**
 *
 * @author Chlas
 */
public class LogoutHelper {
    public void logout(){
        System.out.println(CookieManager.getCookie());
        LoginView menu = new LoginView();
        menu.setVisible(true);
        CookieManager.destroyCookie();
        System.out.println(CookieManager.getCookie());
    }
}
