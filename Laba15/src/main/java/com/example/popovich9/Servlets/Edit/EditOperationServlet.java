package com.example.popovich9.Servlets.Edit;

import com.example.popovich9.DAO.Connection.ConnectionProperty;
import com.example.popovich9.DAO.DealsDAO;
import com.example.popovich9.DAO.OperationsDAO;
import com.example.popovich9.DAO.SubAccountsDAO;
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

@WebServlet("/editoperation")
public class EditOperationServlet extends HttpServlet {
    private final ConnectionProperty prop;
    private final DealsDAO dealsDAO;
    private final SubAccountsDAO subAccountsDAO;
    private final OperationsDAO operationsDAO;

    public EditOperationServlet() throws IOException {
        super();
        prop = new ConnectionProperty();
        dealsDAO = new DealsDAO();
        subAccountsDAO = new SubAccountsDAO();
        operationsDAO = new OperationsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Deal> deals;
        List<SubAccount> subAccounts;
        List<Operation> operations;

        String strId = request.getParameter("id");
        Long editOperationId = (strId != null) ? Long.parseLong(strId) : null;
        Operation editOperation;
        try {
            deals = dealsDAO.findAll();
            subAccounts = subAccountsDAO.findAll();
            operations = operationsDAO.findAll();
            for (Operation op:operations){
                op.setDeal(dealsDAO.FindById(op.getDealID(), deals));
                op.setSubAccount(subAccountsDAO.FindById(op.getSubAccountID(), subAccounts));
            }

            editOperation = operationsDAO.findById(editOperationId);
            editOperation.setDeal(dealsDAO.findById(editOperation.getDealID()));
            deals.removeIf(deal1 -> deal1.getId() == editOperation.getDealID());
            editOperation.setSubAccount(subAccountsDAO.findById(editOperation.getSubAccountID()));
            subAccounts.removeIf(subAccount1 -> subAccount1.getId() == editOperation.getSubAccountID());
            request.setAttribute("deals", deals);
            request.setAttribute("subAccounts", subAccounts);
            request.setAttribute("operations", operations);
            request.setAttribute("operationEdit", editOperation);
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("/views/editoperation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String strId = request.getParameter("id");
            Long editOperationId = (strId != null) ? Long.parseLong(strId) : null;

            String deal = request.getParameter("dealField");
            int index1 = deal.indexOf('=');
            int index2 = deal.indexOf(",");
            String r1 = deal.substring(index1+1, index2);
            long dealId = Long.parseLong(r1.trim());
            Deal deals = dealsDAO.findById(dealId);

            String sub = request.getParameter("subField");
            int index3 = sub.indexOf('=');
            int index4 = sub.indexOf(",");
            String r2 = sub.substring(index3+1, index4);
            long subId = Long.parseLong(r2.trim());
            SubAccount subAccount = subAccountsDAO.findById(subId);

            operationsDAO.update(new Operation(editOperationId, dealId, subId, request.getParameter("number"), request.getParameter("date"),
                    request.getParameter("type"), request.getParameter("sum"),
                    request.getParameter("saldoInput"), request.getParameter("saldoOutput"),
                    deals, subAccount));
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("/Popovich9_war/operation");
    }
}
