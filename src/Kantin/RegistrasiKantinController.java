/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kantin;

import Helper.CookieManager;
import Home.TokoHomeView;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Chlas
 */
public class RegistrasiKantinController {
    RegistrasiKantinView view;
    KantinDAOImplement daoImplement;
    List<KantinModel> listData;
    
    public RegistrasiKantinController(RegistrasiKantinView view){
        this.view = view;
        daoImplement = new KantinDAO();
    }
    
    public void reset(){
        view.getNama().setText("");
        view.getNoUrut().setText("");
    }
    
    public boolean isEmpty(){
        if(view.getNama().getText().equals("")) return true;
        return view.getNoUrut().getText().equals("");
    }
    
    public void registrasi(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
        } else {
            int ID_USER = Integer.valueOf(CookieManager.getCookie().get("ID_USER"));
            KantinModel kantin = new KantinModel();
            kantin.setNama(view.getNama().getText());
            kantin.setNoUrut(view.getNoUrut().getText());
            kantin.setUserId(ID_USER);
            
            daoImplement.registration(kantin);
            JOptionPane.showMessageDialog(null, "Berhasil registrasi user!");
            TokoHomeView menu = new TokoHomeView();
            menu.setVisible(true);
        }
    }
}
