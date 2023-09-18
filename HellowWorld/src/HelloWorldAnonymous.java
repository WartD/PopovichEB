// Класс HelloWorldAnonymous содержит метод main и использует анонимные классы для французского и испанского приветствия.
public class HelloWorldAnonymous {
    public static void main(String[] args) {
        HelloWorldAnonymous myApp = new HelloWorldAnonymous();
        myApp.sayHello();
    }

    public void sayHello() {
        // Создаем экземпляр EnglishGreeting для английского приветствия.
        HelloWorld englishGreeting = new EnglishGreeting();

        // Создаем анонимный класс для французского приветствия.
        HelloWorld frenchGreeting = new HelloWorld() {
            private String name = "tout le monde"; // Имя по умолчанию.

            @Override
            public void greet() {
                greetSomeone("tout le monde"); // При вызове greet() используется имя по умолчанию.
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone; // Устанавливаем имя.
                System.out.println("Salut " + name); // Выводим приветствие на французском.
            }
        };

        // Создаем анонимный класс для испанского приветствия.
        HelloWorld spanishGreeting = new HelloWorld() {
            private String name = "mundo"; // Имя по умолчанию.

            @Override
            public void greet() {
                greetSomeone("mundo"); // При вызове greet() используется имя по умолчанию.
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone; // Устанавливаем имя.
                System.out.println("Hola, " + name); // Выводим приветствие на испанском.
            }
        };

        // Вызываем методы приветствия для каждого из анонимных классов.
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Fred");
        spanishGreeting.greet();
    }
}
