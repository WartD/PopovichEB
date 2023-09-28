// Интерфейс для выполнения математических операций
interface Operationable {
    int calculate(int x, int y);
}

public class LambdaApp {
    public static void main(String[] args) {
        // Пример 1: Сложение с использованием лямбда-выражения
        Operationable addition = (x, y) -> x + y;
        int result1 = addition.calculate(10, 20);
        System.out.println("Результат сложения: " + result1); // Ожидаемый результат: 30

        // Пример 2: Вычитание с использованием лямбда-выражения
        Operationable subtraction = (x, y) -> x - y;
        int result2 = subtraction.calculate(30, 10);
        System.out.println("Результат вычитания: " + result2); // Ожидаемый результат: 20

        // Пример 3: Умножение с использованием лямбда-выражения
        Operationable multiplication = (x, y) -> x * y;
        int result3 = multiplication.calculate(5, 6);
        System.out.println("Результат умножения: " + result3); // Ожидаемый результат: 30

        // Пример 4: Деление с проверкой деления на ноль
        Operationable division = (x, y) -> {
            if (y == 0) {
                return 0; // Предотвращение деления на ноль
            }
            return x / y;
        };
        int result4a = division.calculate(20, 10);
        int result4b = division.calculate(20, 0);
        System.out.println("Результат деления (20 / 10): " + result4a); // Ожидаемый результат: 2
        System.out.println("Результат деления (20 / 0): " + result4b); // Ожидаемый результат: 0 (из-за проверки)

        // Пример 5: Смешанное лямбда-выражение
        Operationable mixedOperation = (x, y) -> {
            if (x > y) {
                return x - y;
            } else {
                return x + y;
            }
        };
        int result5a = mixedOperation.calculate(8, 5);
        int result5b = mixedOperation.calculate(3, 7);
        System.out.println("Результат mixedOperation (8, 5): " + result5a); // Ожидаемый результат: 3
        System.out.println("Результат mixedOperation (3, 7): " + result5b); // Ожидаемый результат: 10
    }
}
