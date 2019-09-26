package service;

import modele.Employe;
import modele.Service;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmployeDao {
    public List<Service> findService() {
        List<Service> services = new ArrayList<>();
        try {
            String sql = "SELECT * FROM service";
            DatabaseHelper Db = DatabaseHelper.getInstance();
            ResultSet rs = Db.My_ExecuteQuery(sql);
            while (rs.next()) {
                Service s = new Service();
                s.setId(rs.getInt(1));
                s.setLib(rs.getString(2));
                services.add(s);
                 }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return services;
    }
    public List<Employe> findEmploye() {
        List<Employe> employes = new ArrayList<>();
        try {
            String sqle = "SELECT * FROM employer e,service s WHERE e.Service_id=s.id";
            DatabaseHelper Db = DatabaseHelper.getInstance();
            ResultSet rs = Db.My_ExecuteQuery(sqle);
            while (rs.next()) {
                Employe empl = new Employe();
                empl.setId(rs.getInt(1));
                empl.setMatricule(rs.getString(2));
                empl.setNom(rs.getString(3));
                DateTimeFormatter df =DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate datenaissance = LocalDate.parse(rs.getString(4),df);
                empl.setDatenaissance(datenaissance);
                empl.setSalaire(rs.getString(5));

               Service se = new Service();
                se.setId(rs.getInt(6));
                se.setLib(rs.getString(8));
                empl.setService(se);
                employes.add(empl);
            }
            rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employes;
    }
    public void addEmployer(Employe e) throws Exception{

        try {
            String sql = "INSERT INTO employer VALUES (null,?,?,?,?,?)";
            DatabaseHelper Db = DatabaseHelper.getInstance();
            Db.iniPreparedCmd(sql);
            Db.getPstmt().setString(1,e.getMatricule());
            Db.getPstmt().setString(2,e.getNom());
            Db.getPstmt().setString(3,e.getDatenaissance().toString());
            Db.getPstmt().setString(4,e.getSalaire());
            Db.getPstmt().setInt(5,e.getService_id().getId());
            Db.My_ExecutePrepareUpdate();

        } catch (Exception ex) {
            throw ex;
        }
    }
}
