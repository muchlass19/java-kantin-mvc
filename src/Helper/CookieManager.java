/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.util.HashMap;

/**
 *
 * @author Chlas
 */
public class CookieManager {
    private static HashMap<String, String> cookie = new HashMap<String, String>();
    
    public static HashMap<String, String> getCookie(){
        return cookie;
    }
    
    public static void setCookie(HashMap<String, String> cookie){
        CookieManager.cookie = cookie;
    }
}
