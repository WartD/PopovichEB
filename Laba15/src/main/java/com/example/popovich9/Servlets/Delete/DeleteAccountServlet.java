package com.example.popovich9.Servlets.Delete;

import com.example.popovich9.DAO.AccountsDAO;
import com.example.popovich9.DAO.Connection.ConnectionProperty;
import com.example.popovich9.DAO.SubAccountsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deleteaccount")
public class DeleteAccountServlet extends HttpServlet {
    private final ConnectionProperty prop;
    private final AccountsDAO dao;

    public DeleteAccountServlet() throws IOException {
        super();
        prop = new ConnectionProperty();
        dao = new AccountsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        Long deleteid = (strId != null) ? Long.parseLong(strId) : null;
        try {
            dao.delete(deleteid);
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("/Popovich9_war/accountPlan");
    }
}