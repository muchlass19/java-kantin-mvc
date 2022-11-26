/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kantin;

import java.util.List;

/**
 *
 * @author Chlas
 */
public interface KantinDAOImplement {
    public void registration(KantinModel kantin);
    public List<KantinModel> getSingle(int id);
}
