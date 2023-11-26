package com.example.popovich9.Servlets;

import com.example.popovich9.DAO.AccountsDAO;
import com.example.popovich9.DAO.Connection.ConnectionProperty;
import com.example.popovich9.DAO.DealsDAO;
import com.example.popovich9.Models.Accounts;
import com.example.popovich9.Models.Deal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@WebServlet("/deal")
public class DealServlet extends HttpServlet {
    private final ConnectionProperty prop;
    private final DealsDAO dao;
    public DealServlet() throws FileNotFoundException, IOException{
        super();
        prop = new ConnectionProperty();
        dao = new DealsDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Deal> deals;
        DealsDAO dao = new DealsDAO();
        try{
            deals = dao.findAll();
            request.setAttribute("deals", deals);
        } catch (Exception e){
            System.out.println(e);
        }
        request.getRequestDispatcher("views/deal.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            dao.insert(new Deal(request.getParameter("agreement"), request.getParameter("tiker"),
                    request.getParameter("order"), request.getParameter("number"),
                    request.getParameter("date"), request.getParameter("quantity"),
                    request.getParameter("price"), request.getParameter("totalCost"),
                    request.getParameter("trader"), request.getParameter("commission")));
        }catch (Exception e){
            System.out.println(e);
        }
        doGet(request, response);
    }
}