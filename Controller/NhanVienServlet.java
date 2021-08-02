package Controller;

import Model.NhanVien;
import service.NhanVienService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/nhanvien")
public class NhanVienServlet extends HttpServlet {
    NhanVienService nhanVienService = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        if (action == null) {
            action = "";
        }
        switch (action) {

            case "create":
                resp.sendRedirect("views/createnv.jsp");
                break;
            case "edit":
                int indexedit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("editnhanvien",nhanVienService.list.get(indexedit));
                dispatcher = req.getRequestDispatcher("views/editnv.jsp");
                dispatcher.forward(req, resp);
                break;
            case "delete":
                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    nhanVienService.delete(index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/nhanvien");
                break;
            case "find":
                String name = req.getParameter("find");
                try {
                    req.setAttribute("newnhanvien",nhanVienService.findName(name));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispatcher=req.getRequestDispatcher("views/shownv.jsp");
                dispatcher.forward(req, resp);
            default:
                req.setAttribute("newnhanvien", nhanVienService.list);
                dispatcher = req.getRequestDispatcher("views/shownv.jsp");
                dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        RequestDispatcher dispatcher;

        switch (action) {
            case "create":
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String birthday = req.getParameter("birthday");
                String address = req.getParameter("address");
                String sdt = req.getParameter("sdt");
                String email = req.getParameter("email");
                String department = req.getParameter("department");
                NhanVien nhanVien = new NhanVien(id,name,birthday,address,sdt,email,department);
                try {
                    nhanVienService.create(nhanVien);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/nhanvien");
                break;
            case "edit":
                int idedit = Integer.parseInt(req.getParameter("id"));
                String nameedit = req.getParameter("name");
                String birthdayedit = req.getParameter("birthday");
                String addressedit = req.getParameter("address");
                String sdtedit = req.getParameter("sdt");
                String emailedit = req.getParameter("email");
                String departmentedit = req.getParameter("department");
                NhanVien nhanVienedit = new NhanVien(idedit,nameedit,birthdayedit,addressedit,sdtedit,emailedit,departmentedit);
                int indexedit = Integer.parseInt(req.getParameter("index"));
                try {
                    nhanVienService.edit(indexedit,nhanVienedit);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.setAttribute("newnhanvien", nhanVienService.list);
                dispatcher = req.getRequestDispatcher("views/shownv.jsp");
                dispatcher.forward(req, resp);
                break;
            case "delete":
            default:
        }
    }
}
