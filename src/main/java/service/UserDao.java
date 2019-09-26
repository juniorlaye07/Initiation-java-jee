package service;

import modele.User;

import java.sql.ResultSet;

public class UserDao {
    public User logon(String login, String pwd) {
        User u = null;
        try {
            String sql = "SELECT * FROM user WHERE login= ? AND password = ?";
            DatabaseHelper Db = DatabaseHelper.getInstance();
            Db.iniPreparedCmd(sql);
            Db.getPstmt().setString(1, login);
            Db.getPstmt().setString(2, pwd);
            ResultSet rs = Db.My_ExecutePrepareQuery();
            if (rs.next()) {
              u = new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }

}
