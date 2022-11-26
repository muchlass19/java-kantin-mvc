/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;

import Menu.MenuModel;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Chlas
 */
public class PelangganHomeTableModel extends AbstractTableModel {
    List<MenuModel> menu;
    
    public PelangganHomeTableModel(List<MenuModel> menu){
        this.menu = menu;
    }

    @Override
    public int getRowCount() {
        return menu.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama Menu / Nama Masakan";
            case 1:
                return "Harga";
            case 2:
                return "Tersedia";
            case 3:
                return "Nama Kantin";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return menu.get(row).getNama();
            case 1:
                return menu.get(row).getHarga();
            case 2:
                String label = "Tidak tersedia";
                if(menu.get(row).getIsAvailable() == 1){
                    label = "Tersedia";
                }
                return label;
            case 3:
                return menu.get(row).getNamaKantin();
            default:
                return null;
        }
    }
    
}
