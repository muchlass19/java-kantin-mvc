/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Home.PelangganHomeView;
import Home.TokoHomeView;
import Kantin.KantinDAO;
import Kantin.KantinDAOImplement;
import Kantin.KantinModel;
import Kantin.RegistrasiKantinView;
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
        
        if(listData.isEmpty()){
            RegistrasiKantinView menu = new RegistrasiKantinView();
            menu.setDataLogin(id);
            menu.setVisible(true);
        } else {
            TokoHomeView menu = new TokoHomeView();
            menu.setDataLogin(id);
            menu.setKantinId(listData.get(0).getId());
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
                    PelangganHomeView home = new PelangganHomeView();
                    // TODO: set data login to view
                    home.setDataLogin(user.getId());
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
