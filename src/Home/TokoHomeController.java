/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import Menu.MenuDAO;
import Menu.MenuDAOImplement;
import Menu.MenuModel;
import Menu.TableModelMenu;
import java.util.List;

/**
 *
 * @author Chlas
 */
public class TokoHomeController {
    TokoHomeView view;
    MenuDAOImplement daoImplement;
    List<MenuModel> listData;
    
    public TokoHomeController(TokoHomeView view){
        this.view = view;
        daoImplement = new MenuDAO();
        listData = daoImplement.getAll();
    }
    
    public void fillTable(){
        listData = daoImplement.getAllAvailable();
        TableModelMenu table = new TableModelMenu(listData);
        view.getTableMenu().setModel(table);
    }
}
