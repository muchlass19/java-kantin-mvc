/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kantin;

import Helper.CookieManager;
import Home.TokoHomeView;
import javax.swing.JOptionPane;

/**
 *
 * @author Chlas
 */
public class KantinController {
    RegistrasiKantinView view;
    KantinDAOImplement daoImplement;
    
    public KantinController(RegistrasiKantinView view){
        this.view = view;
        daoImplement = new KantinDAO();
    }
    
    public void reset(){
        view.getNama().setText("");
        view.getNoUrut().setText("");
    }
    
    public boolean isEmpty(){
        if(view.getNama().getText().equals("")) return true;
        if(view.getNoUrut().getText().equals("")) return true;
        
        return false;
    }
    
    public void registrasi(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
        } else {
            int ID_USER = Integer.valueOf(CookieManager.getCookie().get("ID_USER"));
            KantinModel data = new KantinModel();
            data.setNama(view.getNama().getText());
            data.setNoUrut(view.getNoUrut().getText());
            data.setUserId(ID_USER);
            
            daoImplement.registration(data);
            JOptionPane.showMessageDialog(view, "Berhasil menambahkan data kantin!");
            TokoHomeView home = new TokoHomeView();
            home.setVisible(true);
        }
    }
}
