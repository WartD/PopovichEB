package com.example.popovich9.Servlets;

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

@WebServlet("/accountPlan")
public class AccountPlanServlet extends HttpServlet {
    private final ConnectionProperty prop;
    private final AccountsDAO dao;
    public AccountPlanServlet() throws FileNotFoundException, IOException{
        super();
        prop = new ConnectionProperty();
        dao = new AccountsDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Accounts> accounts;
        AccountsDAO dao = new AccountsDAO();
        try{
            accounts = dao.findAll();
            request.setAttribute("accounts", accounts);
        } catch (Exception e){
            System.out.println(e);
        }
        request.getRequestDispatcher("views/accountPlan.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}