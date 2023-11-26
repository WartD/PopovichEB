package com.example.popovich9.Servlets;

import com.example.popovich9.Models.Accounts;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/accountPlan")
public class AccountPlanServlet extends HttpServlet {
    public AccountPlanServlet(){
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Accounts[] accounts = new Accounts[]{
                new Accounts(1L, "Клиентский счет", "Расчетный", "Ф89Б2"),
                new Accounts(2L, "Комиссионный доход", "Валютный", "В774")
        };
        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("views/accountPlan.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}