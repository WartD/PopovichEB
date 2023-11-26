package com.example.popovich9.Servlets.Edit;

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

@WebServlet("/editdeal")
public class EditDealServlet extends HttpServlet {

    private final ConnectionProperty prop;
    private final DealsDAO dao;

    public EditDealServlet() throws FileNotFoundException, IOException {
        super();
        prop = new ConnectionProperty();
        dao = new DealsDAO();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        List<Deal> deals;
        try {
            deals = dao.findAll();
            request.setAttribute("deals", deals);
        } catch (Exception e) {
            System.out.println(e);
        }
        String strId = request.getParameter("id");
        Long editDealId = (strId != null) ? Long.parseLong(strId) : null;
        Deal editDeal;
        try {
            editDeal = dao.findById(editDealId);
            request.setAttribute("dealEdit", editDeal);
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("/views/editdeal.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strId = request.getParameter("id");
        Long editDealtId = (strId != null) ? Long.parseLong(strId) : null;
        Deal updateDeal = new Deal(editDealtId, request.getParameter("agreement"),
                request.getParameter("tiker"), request.getParameter("order"),
                request.getParameter("number"), request.getParameter("date"),
                request.getParameter("quantity"), request.getParameter("price"),
                request.getParameter("totalCost"), request.getParameter("trader"),
                request.getParameter("commission"));
        try {
            dao.update(updateDeal);
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("/Popovich9_war/deal");
    }
}
