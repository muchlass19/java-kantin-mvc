/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Helper.CookieManager;
import Kantin.KantinDAO;
import Kantin.KantinDAOImplement;
import Kantin.KantinModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Chlas
 */
public class ListMenuController {
    ListMenu view;
    MenuDAOImplement daoImplement;
    List<MenuModel> listData;
    int ID_KANTIN = Integer.valueOf(CookieManager.getCookie().get("ID_KANTIN"));
    
    public ListMenuController(ListMenu view){
        this.view = view;
        daoImplement = new MenuDAO();
        listData = daoImplement.getAllByKantinId(ID_KANTIN);
    }
    
    public void reset(){
        view.getNama().setText("");
        view.getHarga().setText("");
        view.getCari().setText("");
        view.getIsAvailable().setSelected(true);
    }
    
    public boolean isEmpty(){
        if(view.getNama().getText().equals("")) return true;
        return view.getHarga().getText().equals("");
    }
    
    public boolean isCariEmpty(){
        return view.getCari().getText().equals("");
    }
    
    public void fillTable(){
        listData = daoImplement.getAllByKantinId(ID_KANTIN);
        TableModelMenu table = new TableModelMenu(listData);
        view.getTableMenu().setModel(table);
    }
    
    public void getSingle(){
        if(isCariEmpty()){
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
        } else {
            listData = daoImplement.getSingleByKantinId(view.getCari().getText(), ID_KANTIN);
            TableModelMenu table = new TableModelMenu(listData);
            view.getTableMenu().setModel(table);
            
            if(listData.isEmpty()){
                JOptionPane.showMessageDialog(view, "Data tidak ditemukan!");
                fillTable();
                reset();
            }
        }
    }
    
    public void fillField(int row){
        if(listData.get(row).getIsAvailable() == 0){
            view.getIsAvailable().setSelected(false);
        } else {
            view.getIsAvailable().setSelected(true);
        }
        view.getNama().setText(listData.get(row).getNama());
        view.getHarga().setText(String.valueOf(listData.get(row).getHarga()));
        view.getIdMenu().setText(String.valueOf(listData.get(row).getId()));
    }
    
    public void insert(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
        } else {
            int isAvailable = 0;
            if(view.getIsAvailable().isSelected()){
                isAvailable = 1;
            }
            
            MenuModel menu = new MenuModel();
            menu.setNama(view.getNama().getText());
            menu.setHarga(Float.valueOf(view.getHarga().getText()));
            menu.setIsAvailable(isAvailable);
            menu.setKantinId(ID_KANTIN);
            
            daoImplement.insert(menu);
            JOptionPane.showMessageDialog(view, "Berhasil menambahkan data!");
            fillTable();
            reset();
        }
    }
    
    public void update(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
        } else {
            int isAvailable = 0;
            if(view.getIsAvailable().isSelected()){
                isAvailable = 1;
            }
            
            MenuModel menu = new MenuModel();
            menu.setNama(view.getNama().getText());
            menu.setHarga(Float.valueOf(view.getHarga().getText()));
            menu.setIsAvailable(isAvailable);
            menu.setId(Integer.valueOf(view.getIdMenu().getText()));
            menu.setKantinId(ID_KANTIN);
            
            daoImplement.update(menu);
            JOptionPane.showMessageDialog(view, "Berhasil mengubah data!");
            fillTable();
            reset();
        }
    }
    
    public void delete(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(view, "Data tidak boleh kosong!");
        } else {
            int id = Integer.valueOf(view.getIdMenu().getText());
            daoImplement.delete(id);
            JOptionPane.showMessageDialog(view, "Berhasil menghapus data!");
            fillTable();
            reset();
        }
    }
}
