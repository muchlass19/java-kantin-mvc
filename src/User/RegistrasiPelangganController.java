/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import Helper.MenuMethods;
import javax.swing.JOptionPane;

/**
 *
 * @author Chlas
 */
public class RegistrasiPelangganController {
    RegistrasiPelangganView registrasiView;
    UserDAOImplement daoImplement;
    
    public RegistrasiPelangganController(RegistrasiPelangganView registrasiView) {
        this.registrasiView = registrasiView;
        daoImplement = new UserDAO();
    }
    
    public void reset(){
        registrasiView.getNama().setText("");
        registrasiView.getPassword().setText("");
        registrasiView.getUsername().setText("");
    }
    
    public boolean isEmpty(){
        // TODO = CREATE REGISTRASI CONTROLLER
        if(registrasiView.getNama().getText().equals("")) return true;
        if(registrasiView.getUsername().getText().equals("")) return true;
        return registrasiView.getPassword().getText().equals("");
    }
    
    public void registrasi(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(registrasiView, "Data tidak boleh kosong!");
        } else {
            UserModel user = new UserModel();
            user.setNama(registrasiView.getNama().getText());
            user.setUsername(registrasiView.getUsername().getText());
            user.setPassword(registrasiView.getPassword().getText());
            user.setRole("pelanggan");
            
            daoImplement.registration(user);
            JOptionPane.showMessageDialog(null, "Berhasil registrasi user!");
            MenuMethods.gotoLogin();
        }
    }
    
}
