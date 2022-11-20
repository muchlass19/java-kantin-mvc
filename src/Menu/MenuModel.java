/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author Chlas
 */
public class MenuModel {
    private int id;
    private String nama;
    private float harga;
    private int is_available;
    private int kantin_id;
    private String nama_kantin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public int getIsAvailable() {
        return is_available;
    }

    public void setIsAvailable(int is_available) {
        this.is_available = is_available;
    }

    public int getKantinId() {
        return kantin_id;
    }

    public void setKantinId(int kantin_id) {
        this.kantin_id = kantin_id;
    }
    
    public void setDefaultValue(){
        this.id = 0;
        this.nama = "";
        this.harga = 0f;
        this.is_available = 1;
        this.kantin_id = 0;
        this.nama_kantin = "";
    }
    
    public String getNamaKantin(){
        return this.nama_kantin;
    }
    public void setNamaKantin(String nama_kantin){
        this.nama_kantin = nama_kantin;
    }
}
