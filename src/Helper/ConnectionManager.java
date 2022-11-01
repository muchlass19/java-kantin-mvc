/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.SQLException;

/**
 *
 * @author Chlas
 */
public class ConnectionManager {
    static Connection con;
    private static final String DB_NAME = "db_pertemuan20_kantin";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    
    public static Connection getConnection(){
        if(con == null){
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName(DB_NAME);
            data.setUser(DB_USER);
            data.setPassword(DB_PASS);
            try {
                con = (Connection) data.getConnection();
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        }
        return con;
    }
}
