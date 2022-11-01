/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

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
public class UserDAO implements UserDAOImplement {
    Connection con;
    final String select = "select nama, username, role from users";
    final String login = "select * from users where username = ? and password = ?";
    final String insert = "insert into users (nama, username, password, role) values (?, ?, ?, ?)";
    final String updateData = "update users set nama = ?, username = ?";
    final String changePassword = "update users set password = ?";
    final String delete = "delete from users where id = ?";
    
    public UserDAO(){
        con = ConnectionManager.getConnection();
    }

    @Override
    public void registration(UserModel user) {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(insert);
            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void updateData(UserModel user) {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(updateData);
            ps.setString(1, user.getNama());
            ps.setString(2, user.getUsername());
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void deleteUser(int id) {
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
    public List<UserModel> getAll() {
        List<UserModel> listData = null;
        try {
            listData = new ArrayList<UserModel>();
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                UserModel users = new UserModel();
                users.setNama(rs.getString("nama"));
                users.setUsername(rs.getString("username"));
                users.setRole(rs.getString("role"));
                listData.add(users);
            }
        }catch(SQLException ex){
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listData;
    }

    @Override
    public void changePassword(String password) {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(changePassword);
            ps.setString(1, password);
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                ps.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void login(UserModel user) {
        PreparedStatement ps = null;
        try {
            ps = (PreparedStatement) con.prepareStatement(login);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user.setId(rs.getInt("id"));
                user.setNama(rs.getString("nama"));
                user.setRole(rs.getString("role"));
                user.setIsLogin(true);
            }
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
    public void logout(UserModel user) {
        user.setDefaultValue();
    }
    
}
