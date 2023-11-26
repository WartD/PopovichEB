package com.example.popovich9.Servlets;

import com.example.popovich9.Models.Deal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/deal")
public class DealServlet extends HttpServlet {
    public DealServlet(){
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Deal[] deals = new Deal[]{
                new Deal(1L, "7753824344", "USDT",
                        "88bgf433", "7773FD", "24.06.2023",
                        "200", "100 руб", "20250 руб",
                        "Urder", "250 руб"),
                new Deal(2L, "0989345895", "EUR",
                        "6757ffdh54", "234FD34", "29.10.2023",
                        "45", "98,9 руб", "4560,50 руб",
                        "Maxony", "100 руб")
        };
        request.setAttribute("deals", deals);
        request.getRequestDispatcher("views/deal.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}