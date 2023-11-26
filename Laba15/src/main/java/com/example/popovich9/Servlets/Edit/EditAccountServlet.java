package com.example.popovich9.Servlets.Edit;

import com.example.popovich9.DAO.AccountsDAO;
import com.example.popovich9.DAO.Connection.ConnectionProperty;
import com.example.popovich9.Models.Accounts;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@WebServlet("/editaccount")
public class EditAccountServlet extends HttpServlet {

    private final ConnectionProperty prop;
    private final AccountsDAO dao;

    public EditAccountServlet() throws FileNotFoundException, IOException {
        super();
        prop = new ConnectionProperty();
        dao = new AccountsDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        List<Accounts> accounts;
        try {
            accounts = dao.findAll();
            request.setAttribute("accounts", accounts);
        } catch (Exception e) {
            System.out.println(e);
        }
        String strId = request.getParameter("id");
        Long editAccountId = (strId != null) ? Long.parseLong(strId) : null;
        Accounts editAccount;
        try {
            editAccount = dao.findById(editAccountId);
            request.setAttribute("accountEdit", editAccount);
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("/views/editaccount.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        Long editAccountId = (strId != null) ? Long.parseLong(strId) : null;
        Accounts updateAccount = new Accounts(editAccountId, request.getParameter("name"),
                request.getParameter("type"), request.getParameter("number"));
        try {
            dao.update(updateAccount);
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("/Popovich9_war/accountPlan");
    }
}