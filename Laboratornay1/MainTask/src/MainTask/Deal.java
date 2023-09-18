package MainTask;

import java.time.LocalDate;

public class Deal {
    private int ID;             // Уникальный идентификатор сделки
    private String Agreement;   // Номер договора, связанного с сделкой
    private String Tiker;       // Тикер ценной бумаги, связанной с сделкой
    private int Order;          // Номер поручения по сделке
    private int Number;         // Номер сделки
    private LocalDate Date;     // Дата и время заключения сделки
    private int Quantity;       // Количество ценных бумаг, купленных/проданных в сделке
    private double Price;       // Цена одной ценной бумаги в сделке
    private double TotalCost;   // Общая стоимость сделки
    private String Trader;      // Код трейдера, связанного с сделкой
    private double Commission;  // Комиссия торговой площадки за сделку

    // Конструктор класса, принимающий параметры для инициализации полей объекта
    public Deal(int ID, String Agreement, String Tiker, int Order, int Number, LocalDate Date, int Quantity, double Price, double TotalCost, String Trader, double Commission) {
        this.ID = ID;
        this.Agreement = Agreement;
        this.Tiker = Tiker;
        this.Order = Order;
        this.Number = Number;
        this.Date = Date;
        this.Quantity = Quantity;
        this.Price = Price;
        this.TotalCost = TotalCost;
        this.Trader = Trader;
        this.Commission = Commission;
    }

    // Метод printDealDetails() выводит информацию о сделке в консоль
    public void printDealDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Agreement: " + Agreement);
        System.out.println("Tiker: " + Tiker);
    }
}

