/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kantin;

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
public class KantinDAO implements KantinDAOImplement {
    Connection con;
    final String select = "select * from kantins";
    final String selectById = "select * from kantins where user_id = ?";
    final String insert = "insert into kantins (nama, no_urut, user_id) values (?, ?, ?)";
    
    public KantinDAO(){
        con = ConnectionManager.getConnection();
    }

    @Override
    public void registration(KantinModel kantin) {
        PreparedStatement ps = null;
        try{
            ps = (PreparedStatement) con.prepareStatement(insert);
            ps.setString(1, kantin.getNama());
            ps.setString(2, kantin.getNoUrut());
            ps.setInt(3, kantin.getUserId());
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
    public List<KantinModel> getSingle(int id) {
        List<KantinModel> listData = null;
        PreparedStatement ps;
        try {
            listData = new ArrayList<KantinModel>();
            ps = (PreparedStatement) con.prepareStatement(selectById);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KantinModel kantins = new KantinModel();
                kantins.setId(rs.getInt("id"));
                kantins.setNama(rs.getString("nama"));
                kantins.setNoUrut(rs.getString("no_urut"));
                kantins.setUserId(rs.getInt("user_id"));
                listData.add(kantins);
            }
        }catch(SQLException ex){
            Logger.getLogger(KantinDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listData;
    }
}
