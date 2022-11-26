/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Chlas
 */
public class TableModelMenu extends AbstractTableModel{
    
    List<MenuModel> listData;
    
    public TableModelMenu(List<MenuModel> listData){
        this.listData = listData;
    }

    @Override
    public int getRowCount() {
        return listData.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Nama Masakan / Nama Menu";
            case 1:
                return "Harga";
            case 2:
                return "Sedang Tersedia";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return listData.get(row).getNama();
            case 1:
                return listData.get(row).getHarga();
            case 2:
                String label = "Tidak Tersedia";
                if(listData.get(row).getIsAvailable() == 1){
                    label = "Tersedia";
                }
                return label;
            default:
                return null;
        }
    }
    
}
