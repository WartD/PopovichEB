package MainTask;

public class AccountPlan {
    private int ID;         // Уникальный идентификатор плана счетов
    private String Name;    // Наименование плана счетов
    private String Type;    // Тип счета (например, "Расчетный", "Валютный" и др.)
    private int Number;     // Номер операции (похоже, на номер счета внутреннего учета)

    // Конструктор класса, принимающий параметры для инициализации полей объекта
    public AccountPlan(int ID, String Name, String Type, int Number) {
        this.ID = ID;
        this.Name = Name;
        this.Type = Type;
        this.Number = Number;
    }

    // Метод printAccountPlanDetails() выводит информацию о плане счетов в консоль
    public void printAccountPlanDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Type: " + Type);
    }
}
