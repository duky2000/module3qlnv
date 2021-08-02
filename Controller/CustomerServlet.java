package Controller;

import Model.Customer;
import service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        RequestDispatcher requestDispatcher;

        switch (action){
            case "create":
                int id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                String email = req.getParameter("email");
                String address = req.getParameter("address");

                Customer customer = new Customer(id,name,email,address);
                try {
                    customerService.save(customer);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                req.setAttribute("newcustomer",customerService.list);
                requestDispatcher = req.getRequestDispatcher("view/show.jsp");
                requestDispatcher.forward(req,resp);
                break;

            case "edit":
                int idedit = Integer.parseInt(req.getParameter("id"));
                String nameedit = req.getParameter("name");
                String emailedit = req.getParameter("email");
                String addressedit = req.getParameter("address");

                Customer customerEdit = new Customer(idedit,nameedit,emailedit,addressedit);

                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    customerService.edit(index, customerEdit);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.setAttribute("newcustomer",customerService.list);
                requestDispatcher = req.getRequestDispatcher("view/show.jsp");
                requestDispatcher.forward(req,resp);
                break;
            case "findName":
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        RequestDispatcher dispatcher;
        if (action==null){
            action = "";
        }
        switch (action){
            case "create":
                resp.sendRedirect("view/create.jsp");
                break;
            case "edit":
                int indexEdit = Integer.parseInt(req.getParameter("index"));
                req.setAttribute("customer",customerService.list.get(indexEdit));
                dispatcher = req.getRequestDispatcher("view/edit.jsp");
                dispatcher.forward(req,resp);
                break;
            case "delete":
                int index = Integer.parseInt(req.getParameter("index"));
                try {
                    customerService.delete(index);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/customer");
                break;
            case "findName":
                String name = req.getParameter("find");
                try {
                    req.setAttribute("newcustomer",customerService.findName(name));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                dispatcher = req.getRequestDispatcher("view/show.jsp");
                dispatcher.forward(req,resp);
            default:
                req.setAttribute("newcustomer",customerService.list);
                dispatcher = req.getRequestDispatcher("view/show.jsp");
                dispatcher.forward(req,resp);
        }
    }
}
