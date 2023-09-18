package MainTask;

import java.time.LocalDate;

// Модель операции
public class Operation {
    private int ID;                 // Уникальный идентификатор операции
    private int DealID;             // Внешний ключ для связи с моделью Deal (сделка)
    private int SubAccountID;       // Внешний ключ для связи с моделью SubAccount (субсчет)
    private int Number;             // Номер операции
    private LocalDate Date;         // Дата проведения операции
    private String Type;            // Тип операции (покупка, продажа и т. д.)
    private double Sum;             // Приход/расход по операции
    private double SaldoInput;      // Начальное сальдо
    private double SaldoOutput;     // Конечное сальдо

    // Конструктор класса, принимающий параметры для инициализации полей объекта
    public Operation(int ID, int DealID, int SubAccountID, int Number, LocalDate Date, String Type, double Sum, double SaldoInput, double SaldoOutput) {
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

    // Метод printOperationDetails() выводит информацию об операции в консоль
    public void printOperationDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Type: " + Type);
    }
}

