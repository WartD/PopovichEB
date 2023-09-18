// Класс EnglishGreeting реализует интерфейс HelloWorld и предоставляет приветствие на английском языке.
public class EnglishGreeting implements HelloWorld {
    private String name = "world"; // Имя по умолчанию.

    @Override
    public void greet() {
        greetSomeone("world"); // При вызове greet() используется имя по умолчанию.
    }

    @Override
    public void greetSomeone(String someone) {
        name = someone; // Устанавливаем имя.
        System.out.println("Hello " + name); // Выводим приветствие на английском.
    }
}
