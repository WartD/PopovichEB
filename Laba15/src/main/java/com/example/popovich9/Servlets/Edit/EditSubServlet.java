package com.example.popovich9.Servlets.Edit;

import com.example.popovich9.DAO.AccountsDAO;
import com.example.popovich9.DAO.Connection.ConnectionProperty;
import com.example.popovich9.DAO.SubAccountsDAO;
import com.example.popovich9.Models.Accounts;
import com.example.popovich9.Models.SubAccount;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/editsubaccount")
public class EditSubServlet extends HttpServlet {
    private final ConnectionProperty prop;
    private final AccountsDAO accountsDAO;
    private final SubAccountsDAO subAccountsDAO;

    public EditSubServlet() throws IOException {
        super();
        prop = new ConnectionProperty();
        accountsDAO = new AccountsDAO();
        subAccountsDAO = new SubAccountsDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Accounts> accounts;
        List<SubAccount> subAccounts;
        String strId = request.getParameter("id");
        Long editSubId = (strId != null) ? Long.parseLong(strId) : null;
        SubAccount editSub;
        try {
            accounts = accountsDAO.findAll();
            subAccounts = subAccountsDAO.findAll();
            for (SubAccount ch:subAccounts){
                ch.setAccount(accountsDAO.FindById(ch.getAccountPlanID(), accounts));
            }
            editSub = subAccountsDAO.findById(editSubId);
            editSub.setAccount(accountsDAO.findById(editSub.getAccountPlanID()));
            accounts.removeIf(accounts1 -> accounts1.getId() == editSub.getAccountPlanID());
            request.setAttribute("accounts", accounts);
            request.setAttribute("subAccounts", subAccounts);
            request.setAttribute("subEdit", editSub);
        } catch (Exception e) {
            System.out.println(e);
        }
        request.getRequestDispatcher("/views/editsubaccount.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String strId = request.getParameter("id");
            Long editSubId = (strId != null) ? Long.parseLong(strId) : null;
            String acc = request.getParameter("accountField");
            int index1 = acc.indexOf('=');
            int index2 = acc.indexOf(",");
            String r1 = acc.substring(index1+1, index2);
            long accId = Long.parseLong(r1.trim());
            Accounts accounts = accountsDAO.findById(accId);
            subAccountsDAO.update(new SubAccount(editSubId, accId, request.getParameter("name"), request.getParameter("number"), accounts));
        } catch (Exception e) {
            System.out.println(e);
        }
        response.sendRedirect("/Popovich9_war/subAccount");
    }
}
