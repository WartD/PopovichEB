package com.example.popovich9.Servlets;

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

@WebServlet("/operation")
public class OperationServlet extends HttpServlet {
    public OperationServlet(){
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
                        "45", "99 руб", "4560 руб",
                        "Maxony", "100 руб")
        };
        request.setAttribute("deals", deals);
        Accounts[] accounts = new Accounts[]{
                new Accounts(1L, "Клиентский счет", "Расчетный", "Ф89Б2"),
                new Accounts(2L, "Комиссионный доход", "Валютный", "В774")
        };
        request.setAttribute("accounts", accounts);
        SubAccount[] subAccount = new SubAccount[]{
                new SubAccount(1L, 1L, "Брокерские операции", "БК743", accounts[0]),
                new SubAccount(2L, 2L, "Доверительное управление", "ДВ4341", accounts[1])
        };
        request.setAttribute("subAccount", subAccount);
        Operation[] operations = new Operation[]{
                new Operation(1L, 1L, 1L, "7874fd774", "25.06.2023", "Покупка", "20250", "46500", "26250", deals[0], subAccount[0] ),
                new Operation(2L, 2L, 2L, "234yd893d", "30.10.2023", "Продажа", "4560", "56000", "60560", deals[1], subAccount[1] )
        };
        request.setAttribute("operations", operations);
        request.getRequestDispatcher("views/operation.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}