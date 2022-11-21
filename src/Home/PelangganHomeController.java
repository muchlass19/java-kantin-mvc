/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import Menu.MenuDAO;
import Menu.MenuDAOImplement;
import Menu.MenuModel;
import java.util.List;

/**
 *
 * @author Chlas
 */
public class PelangganHomeController {
    PelangganHomeView view;
    MenuDAOImplement daoImplement;
    List<MenuModel> listData;
    
    public PelangganHomeController(PelangganHomeView view){
        this.view = view;
        daoImplement = new MenuDAO();
        listData = daoImplement.getAllAvailable();
    }
    
    public void fillTable(){
        listData = daoImplement.getAllAvailable();
        PelangganHomeTableModel table = new PelangganHomeTableModel(listData);
        view.getTableMenu().setModel(table);
    }
}
