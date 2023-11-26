package com.example.popovich9.Servlets;

import com.example.popovich9.Models.Accounts;
import com.example.popovich9.Models.SubAccount;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/subAccount")
public class SubAccountServlet extends HttpServlet {

    public SubAccountServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Accounts[] accounts = new Accounts[]{
                new Accounts(1L, "Клиентский счет", "Расчетный", "Ф89Б2"),
                new Accounts(2L, "Комиссионный доход", "Валютный", "В774")
        };
        request.setAttribute("accounts", accounts);
        SubAccount[] subAccount = new SubAccount[]{
                new SubAccount(1L, 1L, "Брокерские операции", "БК743", accounts[0]),
                new SubAccount(2L, 2L, "Брокерские операции", "БК434", accounts[1])
        };
        request.setAttribute("subAccount", subAccount);
        request.getRequestDispatcher("views/subAccount.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}