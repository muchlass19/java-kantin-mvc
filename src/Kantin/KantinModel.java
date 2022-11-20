/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kantin;

/**
 *
 * @author Chlas
 */
public class KantinModel {
    private Integer id;
    private String nama;
    private String no_urut;
    private Integer user_id;
    
    public Integer getId(){
        return this.id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }
    
    public String getNama(){
        return this.nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getNoUrut(){
        return this.no_urut;
    }
    
    public void setNoUrut(String no_urut){
        this.no_urut = no_urut;
    }
    
    public Integer getUserId(){
        return this.user_id;
    }
    
    public void setUserId(Integer user_id){
        this.user_id = user_id;
    }
    
    public void setDefaultValue(){
        this.id = null;
        this.nama = "";
        this.no_urut = "";
        this.user_id = null;
    }
}
