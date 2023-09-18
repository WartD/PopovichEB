package MainTask;

import java.time.LocalDate;
import java.util.UUID;

public class AnonymousClasses {
    public static void main(String[] args) {
        // Создаем объекты операции, сделки, субсчета и плана счетов
        Operation operation = new Operation(1, 101, 201, 123, LocalDate.now(), "Покупка", 100.0, 50.0, 150.0);
        Deal deal = new Deal(1001, "Agreement123", "TikerABC", 10, 567, LocalDate.now(), 100, 25.0, 2500.0, "TraderXYZ", 10.0);
        SubAccount subAccount = new SubAccount(201, 301, "Дилерские операции", 1);
        AccountPlan accountPlan = new AccountPlan(301, "Счет клиентов", "Расчетный", 1001);

        // Выводим информацию об объектах с использованием анонимных классов
        operation.printOperationDetails();
        deal.printDealDetails();
        subAccount.printSubAccountDetails();
        accountPlan.printAccountPlanDetails();
    }
}
