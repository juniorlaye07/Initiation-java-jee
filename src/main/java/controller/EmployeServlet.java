package controller;

import modele.Employe;
import modele.Service;
import service.EmployeDao;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@WebServlet(name = "employe",urlPatterns = "/employe")
public class EmployeServlet extends HttpServlet {
    EmployeDao employeDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        employeDao = new EmployeDao();
        switch (action){
            case "add":
                req.setAttribute("employes",employeDao.findEmploye());
                req.setAttribute("services",employeDao.findService());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req,resp);
                break;
            case "edit":{
                break;

            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        employeDao = new EmployeDao();
        switch (action){
            case "add":
                try {
                    req.setAttribute("employes",employeDao.findEmploye());
                    req.setAttribute("services",employeDao.findService());
                String matricule = req.getParameter("matricule");
                String nom = req.getParameter("nom");
                DateTimeFormatter df =DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate datenaissance = LocalDate.parse(req.getParameter("datenaissance"),df);
                String salaire = req.getParameter("salaire");
                int ids = Integer.parseInt(req.getParameter("service"));

                Service s = new Service();
                s.setId(ids);

                Employe e = new Employe();
                e.setMatricule(matricule);
                e.setNom(nom);
                e.setSalaire(salaire);
                e.setDatenaissance(datenaissance);
                e.setService_id(s);
                employeDao.addEmployer(e);

                } catch (Exception ex) {
                    req.setAttribute("error","Erreur d'insertion");
                    ex.printStackTrace();
                }

                req.setAttribute("services",employeDao.findService());
                getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(req,resp);
                break;
            case "edit":{
                break;

            }
        }

    }
}
