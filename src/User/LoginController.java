/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

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
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
