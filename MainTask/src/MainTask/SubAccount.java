package MainTask;

// Модель субсчета
public class SubAccount {
    private int ID;               // Уникальный идентификатор субсчета
    private int AccountPlanID;    // Внешний ключ для связи с моделью плана счетов (AccountPlan)
    private String Name;          // Наименование субсчета
    private int Number;           // Номер субсчета

    // Конструктор класса, принимающий параметры для инициализации полей объекта
    public SubAccount(int ID, int AccountPlanID, String Name, int Number) {
        this.ID = ID;
        this.AccountPlanID = AccountPlanID;
        this.Name = Name;
        this.Number = Number;
    }

    // Метод printSubAccountDetails() выводит информацию о субсчете в консоль
    public void printSubAccountDetails() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + Name);
    }
}
