package com.example.popovich9.Servlets;

import com.example.popovich9.DAO.Connection.ConnectionProperty;
import com.example.popovich9.DAO.DealsDAO;
import com.example.popovich9.DAO.OperationsDAO;
import com.example.popovich9.DAO.SubAccountsDAO;
import com.example.popovich9.Models.Accounts;
import com.example.popovich9.Models.Deal;
import com.example.popovich9.Models.Operation;
import com.example.popovich9.Models.SubAccount;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/operation")
public class OperationServlet extends HttpServlet {
    private final ConnectionProperty prop;
    private final SubAccountsDAO subAccountsDAO;
    private final DealsDAO dealsDAO;
    private final OperationsDAO operationsDAO;
    public OperationServlet() throws IOException {
        super();
        prop = new ConnectionProperty();
        subAccountsDAO = new SubAccountsDAO();
        dealsDAO = new DealsDAO();
        operationsDAO = new OperationsDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Deal> deals;
        List<SubAccount> subAccounts;
        List<Operation> operations;
        try{
            deals = dealsDAO.findAll();
            request.setAttribute("deals", deals);
            subAccounts = subAccountsDAO.findAll();
            request.setAttribute("subAccounts", subAccounts);
            operations = operationsDAO.findAll();
            request.setAttribute("operations", operations);
            for (Operation op:operations){
                op.setDeal(dealsDAO.FindById(op.getDealID(), deals));
                op.setSubAccount(subAccountsDAO.FindById(op.getSubAccountID(), subAccounts));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        request.getRequestDispatcher("views/operation.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String sub = request.getParameter("subAccount");
            int index1 = sub.indexOf('=');
            int index2 = sub.indexOf(",");
            String r1 = sub.substring(index1+1, index2);
            long subId = Long.parseLong(r1.trim());
            SubAccount subAccount = subAccountsDAO.findById(subId);

            String deals = request.getParameter("deal");
            int index3 = deals.indexOf('=');
            int index4 = deals.indexOf(",");
            String r2 = deals.substring(index3+1, index4);
            long dealId = Long.parseLong(r2.trim());
            Deal deal = dealsDAO.findById(dealId);
            operationsDAO.insert(new Operation(dealId, subId, request.getParameter("number"),
                    request.getParameter("date"), request.getParameter("type"),
                    request.getParameter("sum"), request.getParameter("saldoInput"),
                    request.getParameter("saldoOutput"), deal, subAccount));
        }catch (Exception e){
            System.out.println(e);
        }
        doGet(request, response);
    }
}