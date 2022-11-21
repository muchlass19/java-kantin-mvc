/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Helper.CookieManager;
import Home.PelangganHomeView;
import Home.TokoHomeView;
import Kantin.KantinDAO;
import Kantin.KantinDAOImplement;
import Kantin.KantinModel;
import Kantin.RegistrasiKantinView;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Chlas
 */
public class LoginController {
    LoginView loginView;
    UserDAOImplement daoImplement;
    
    public LoginController(LoginView loginView){
        this.loginView = loginView;
        daoImplement = new UserDAO();
    }
    
    public void reset(){
        loginView.getUsername().setText("");
        loginView.getPassword().setText("");
    }
    
    public boolean isEmpty(){
        if(loginView.getUsername().getText().equals("")) return true;
        return loginView.getPassword().getText().equals("");
    }
    
    public void hasKantin(int id){
        List<KantinModel> listData;
        KantinDAOImplement kantinDao = new KantinDAO();
        listData = kantinDao.getSingle(id);
        // SET COOKIE
        HashMap<String, String> COOKIE = new HashMap<>();
        String ID_USER = String.valueOf(id);
        COOKIE.put("ID_USER", ID_USER);
        
        if(listData.isEmpty()){
            CookieManager.setCookie(COOKIE);
            
            RegistrasiKantinView menu = new RegistrasiKantinView();
            menu.setVisible(true);
        } else {
            String ID_KANTIN = String.valueOf(listData.get(0).getId());
            COOKIE.put("ID_KANTIN", ID_KANTIN);
            CookieManager.setCookie(COOKIE);
            
            TokoHomeView menu = new TokoHomeView();
            menu.setVisible(true);
        }
    }
    
    public void login(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(loginView, "Data tidak boleh kosong!");
        } else {
            UserModel user = new UserModel();
            user.setDefaultValue();
            user.setUsername(loginView.getUsername().getText());
            user.setPassword(loginView.getPassword().getText());
            
            daoImplement.login(user);
            if(user.getIsLogin()){
                JOptionPane.showMessageDialog(null, "Selamat datang " + user.getNama() + "!");
                if(user.getRole().equals("pelanggan")){
                    // SET COOKIE
                    HashMap<String, String> COOKIE = new HashMap<>();
                    COOKIE.put("USER_ID", String.valueOf(user.getId()));
                    CookieManager.setCookie(COOKIE);
                    // GO TO MENU
                    PelangganHomeView home = new PelangganHomeView();
                    home.setVisible(true);
                } else {
                    hasKantin(user.getId());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
