import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

// Модель Сделка (Deal)
class Deal {
    private int ID;
    private String Agreement;
    private String Tiker;
    private int Order;
    private int Number;
    private Date Date;
    private int Quantity;
    private double Price;
    private double TotalCost;
    private String Trader;
    private double Commission;

    public Deal(int ID, String Agreement, String Tiker, int Order, int Number, Date Date, int Quantity, double Price, double TotalCost, String Trader, double Commission) {
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

    public double getTotalCost() {
        return TotalCost;
    }

    public int getNumber() {
        // Другие геттеры и сеттеры ...
        return Number;
    }
}

// Модель Операция (Operation)
class Operation {
    private int ID;
    private int DealID;
    private int SubAccountID;
    private int Number;
    private Date Date;
    private String Type;
    private double Sum;
    private double SaldoInput;
    private double SaldoOutput;

    public Operation(int ID, int DealID, int SubAccountID, int Number, Date Date, String Type, double Sum, double SaldoInput, double SaldoOutput) {
        this.ID = ID;
        this.DealID = DealID;
        this.SubAccountID = SubAccountID;
        this.Number = Number;
        this.Date = Date;
        this.Type = Type;
        this.Sum = Sum;
        this.SaldoInput = SaldoInput;
        this.SaldoOutput = SaldoOutput;
    }

    public double getSum() {
        return Sum;
    }

    // Другие геттеры и сеттеры ...
}

// Модель Субсчет (SubAccount)
class SubAccount {
    private int ID;
    private int AccountPlanID;
    private String Name;
    private int Number;

    public SubAccount(int ID, int AccountPlanID, String Name, int Number) {
        this.ID = ID;
        this.AccountPlanID = AccountPlanID;
        this.Name = Name;
        this.Number = Number;
    }

    // Другие геттеры и сеттеры ...
}

// Модель План счетов (AccountPlan)
class AccountPlan {
    private int ID;
    private String Name;
    private String Type;
    private int Number;

    public AccountPlan(int ID, String Name, String Type, int Number) {
        this.ID = ID;
        this.Name = Name;
        this.Type = Type;
        this.Number = Number;
    }

    // Другие геттеры и сеттеры ...
}

public class LambdaApp {
    public static void main(String[] args) {
        // Создаем список сделок (Deal)
        List<Deal> deals = new ArrayList<>();
        deals.add(new Deal(1, "Договор1", "Тикер1", 1, 101, new Date(), 10, 100.0, 1000.0, "Трейдер1", 5.0));
        deals.add(new Deal(2, "Договор2", "Тикер2", 2, 102, new Date(), 20, 50.0, 1000.0, "Трейдер2", 10.0));

        // Пример 1: Фильтрация сделок по условию с использованием лямбда-выражения
        Predicate<Deal> дорогиеСделки = сделка -> сделка.getTotalCost() > 500.0;
        List<Deal> отфильтрованныеСделки = фильтроватьСделки(deals, дорогиеСделки);
        System.out.println("Дорогие сделки:");
        выводитьСделки(отфильтрованныеСделки);

        // Создаем список операций (Operation)
        List<Operation> операции = new ArrayList<>();
        операции.add(new Operation(1, 1, 1, 1, new Date(), "Покупка", 500.0, 0.0, 500.0));
        операции.add(new Operation(2, 2, 2, 2, new Date(), "Продажа", 300.0, 0.0, 300.0));

        // Пример 2: Вычисление общей суммы операций с использованием лямбда-выражения
        double общаяСумма = вычислитьОбщуюСумму(операции, операция -> операция.getSum());
        System.out.println("Общая сумма операций: " + общаяСумма);
    }

    // Метод для фильтрации списка сделок
    public static List<Deal> фильтроватьСделки(List<Deal> сделки, Predicate<Deal> условие) {
        List<Deal> отфильтрованныеСделки = new ArrayList<>();
        for (Deal сделка : сделки) {
            if (условие.test(сделка)) {
                отфильтрованныеСделки.add(сделка);
            }
        }
        return отфильтрованныеСделки;
    }

    // Метод для вычисления общей суммы операций
    public static double вычислитьОбщуюСумму(List<Operation> операции, Function<Operation, Double> маппер) {
        double общаяСумма = 0.0;
        for (Operation операция : операции) {
            общаяСумма += маппер.apply(операция);
        }
        return общаяСумма;
    }

    // Метод для вывода списка сделок
    public static void выводитьСделки(List<Deal> сделки) {
        for (Deal сделка : сделки) {
            System.out.println("Сделка номер " + сделка.getNumber() + ", общая стоимость: " + сделка.getTotalCost());
        }
    }
}
