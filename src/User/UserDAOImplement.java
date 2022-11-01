/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.List;

/**
 *
 * @author Chlas
 */
public interface UserDAOImplement {
    public void registration(UserModel user);
    public void login(UserModel user);
    public void logout(UserModel user);
    public void updateData(UserModel user);
    public void deleteUser(int id);
    public void changePassword(String password);
    public List<UserModel> getAll();
//    public List<UserModel> getCariNama(String nama);
}
