/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Helper.ConnectionManager;
import User.UserDAO;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chlas
 */
public class MenuDAO implements MenuDAOImplement {
    Connection con;
    final String insert = "insert into menus (nama, harga, isAvailable, kantin_id) values (?, ?, ?, ?)";
    final String update = "update menus set nama = ?, harga = ?, isAvailable = ? where id = ?";
    final String delete = "delete from menus where id = ?";
    final String select = "select * from menus;";
    final String selectByNama = "select * from menus where nama like ?";
    final String selectAllAvailable = "select m.*, k.nama from menus as m join kantins as k on m.kantin_id = k.id where m.isAvailable = 1 ";
    
    public MenuDAO(){
        con = ConnectionManager.getConnection();
    }

    @Override
    public void insert(MenuModel data) {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(insert);
            ps.setString(1, data.getNama());
            ps.setFloat(2, data.getHarga());
            ps.setInt(3, data.getIsAvailable());
            ps.setInt(4, data.getKantinId());
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(MenuModel data) {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(update);
            ps.setString(1, data.getNama());
            ps.setFloat(2, data.getHarga());
            ps.setInt(3, data.getIsAvailable());
            ps.setInt(4, data.getId());
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(delete);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<MenuModel> getAll() {
        List<MenuModel> listData = null;
        try{
            listData = new ArrayList<MenuModel>();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                MenuModel data = new MenuModel();
                data.setId(rs.getInt("id"));
                data.setNama(rs.getString("nama"));
                data.setHarga(rs.getFloat("harga"));
                data.setIsAvailable(rs.getInt("isAvailable"));
                data.setKantinId(rs.getInt("kantin_id"));
                listData.add(data);
            }
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listData;
    }

    @Override
    public List<MenuModel> getSingle(String cari) {
        List<MenuModel> listData = null;
        PreparedStatement ps = null;
        try{
            listData = new ArrayList<MenuModel>();
            ps = (PreparedStatement) con.prepareStatement(selectByNama);
            ps.setString(1, "%" + cari + "%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MenuModel data = new MenuModel();
                data.setId(rs.getInt("id"));
                data.setNama(rs.getString("nama"));
                data.setHarga(rs.getFloat("harga"));
                data.setIsAvailable(rs.getInt("isAvailable"));
                data.setKantinId(rs.getInt("kantin_id"));
                listData.add(data);
            }
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listData;
    }

    @Override
    public List<MenuModel> getAllAvailable() {
        List<MenuModel> listData = null;
        try{
            listData = new ArrayList<MenuModel>();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(selectAllAvailable);
            while(rs.next()){
                MenuModel data = new MenuModel();
                data.setId(rs.getInt("m.id"));
                data.setNama(rs.getString("m.nama"));
                data.setHarga(rs.getFloat("m.harga"));
                data.setIsAvailable(rs.getInt("m.isAvailable"));
                data.setKantinId(rs.getInt("m.kantin_id"));
                data.setNamaKantin(rs.getString("k.nama"));
                listData.add(data);
            }
        } catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listData;
    }
    
}
