/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.List;

/**
 *
 * @author Chlas
 */
public interface MenuDAOImplement {
    public void insert(MenuModel data);
    public void update(MenuModel data);
    public void delete(int id);
    public List<MenuModel> getAll();
    public List<MenuModel> getAllAvailable();
    public List<MenuModel> getSingle(String cari);
}
