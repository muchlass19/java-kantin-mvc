/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Chlas
 */
public class UserModel {
    private Integer id;
    private String nama;
    private String username;
    private String password;
    private String role;
    private boolean isLogin;
    
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    
    public boolean getIsLogin(){
        return isLogin;
    }
    public void setIsLogin(boolean isLogin){
        this.isLogin = isLogin;
    }
    public void setDefaultValue(){
        this.id = null;
        this.nama = "";
        this.username = "";
        this.password = "";
        this.role = "";
        this.isLogin = false;
    }
}
