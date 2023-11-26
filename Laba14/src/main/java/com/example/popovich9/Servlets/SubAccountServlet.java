package com.example.popovich9.Servlets;

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

@WebServlet("/subAccount")
public class SubAccountServlet extends HttpServlet {

    private final ConnectionProperty prop;
    private final AccountsDAO accountsDAO;
    private final SubAccountsDAO subAccountsDAO;
    public SubAccountServlet() throws IOException {
        super();
        prop = new ConnectionProperty();
        accountsDAO = new AccountsDAO();
        subAccountsDAO = new SubAccountsDAO();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Accounts> accounts;
        List<SubAccount> subAccounts;
        try{
            accounts = accountsDAO.findAll();
            request.setAttribute("accounts", accounts);
            subAccounts = subAccountsDAO.findAll();
            request.setAttribute("subAccounts", subAccounts);
            for (SubAccount sb:subAccounts){
                sb.setAccount(accountsDAO.FindById(sb.getAccountPlanID(), accounts));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        request.getRequestDispatcher("views/subAccount.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String account = request.getParameter("account");
            int index1 = account.indexOf('=');
            int index2 = account.indexOf(",");
            String r1 = account.substring(index1+1, index2);
            long accId = Long.parseLong(r1.trim());
            Accounts accounts = accountsDAO.findById(accId);
            subAccountsDAO.insert(new SubAccount(accId, request.getParameter("name"), request.getParameter("number"), accounts));
        }catch (Exception e){
            System.out.println(e);
        }
        doGet(request, response);
    }
}