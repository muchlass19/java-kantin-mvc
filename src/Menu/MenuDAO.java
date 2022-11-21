/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Helper.ConnectionManager;
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
    final String select = "select * from menus where kantin_id = ?;";
    final String selectByNama = "select * from menus where nama like ? and kantin_id = ?";
    final String selectAllAvailable = "select m.*, k.nama from menus as m join kantins as k on m.kantin_id = k.id where m.isAvailable = 1 and k.id = ?";
    final String selectAllAvailableByCust = "select m.*, k.nama from menus as m join kantins as k on m.kantin_id = k.id where m.isAvailable = 1";
    final String selectNama = "select nama from kantins where id = ?";
    
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
    public List<MenuModel> getAllByKantinId(int id) {
        List<MenuModel> listData = null;
        PreparedStatement ps;
        try{
            listData = new ArrayList<>();
            ps = (PreparedStatement) con.prepareStatement(select);
            ps.setInt(1, id);
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
    public List<MenuModel> getSingleByKantinId(String cari, int id) {
        List<MenuModel> listData = null;
        PreparedStatement ps;
        try{
            listData = new ArrayList<>();
            ps = (PreparedStatement) con.prepareStatement(selectByNama);
            ps.setString(1, "%" + cari + "%");
            ps.setInt(2, id);
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
    public List<MenuModel> getAllAvailableByKantinId(int id) {
        List<MenuModel> listData = null;
        PreparedStatement ps;
        try{
            listData = new ArrayList<>();
            ps = (PreparedStatement) con.prepareStatement(selectAllAvailable);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
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

    @Override
    public List<MenuModel> getAllAvailable() {
        List<MenuModel> listData = null;
        try{
            listData = new ArrayList<>();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(selectAllAvailableByCust);
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

    @Override
    public String getKantinNama(int id) {
        String nama = null;
        PreparedStatement ps;
        try {
            ps = (PreparedStatement) con.prepareStatement(selectNama);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nama = rs.getString("nama");
            }
        }catch(SQLException ex){
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nama;
    }
    
}
