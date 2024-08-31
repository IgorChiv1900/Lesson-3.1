//Создать классы Собака и Кот с наследованием от класса Животное.
//Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150);-Бобик пробежал 150 м.)
//У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//Добавить подсчет созданных котов, собак и животных.
//Расширить задачу, добавив для котов возможность кушать из миски, выполнив следующие пункты
//Сделать так, чтобы в миске с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
//Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту
//удалось покушать (хватило еды), сытость = true. Считаем, что если коту мало еды в миске, то он её просто не трогает, то есть не может быть
//наполовину сыт (это сделано для упрощения логики программы).
//Создать массив котов и миску с едой, попросить всех котов покушать из этой миски и потом
//вывести информацию о сытости котов в консоль.
//Добавить метод, с помощью которого можно было бы добавлять еду в миску.
class Animal {
    private static int count = 0; // Счетчик всех животных
    protected String name;
    public Animal(String name) {
        this.name = name;
        count++;
    }

    public void run(int distance) {
        throw new UnsupportedOperationException("Метод run должен быть переопределен в подклассе");
    }

    public void swim(int distance) {
        throw new UnsupportedOperationException("Метод swim должен быть переопределен в подклассе");
    }

    public static int getCount() {
        return count;
    }
}

class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }
}

class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0; // Коты не умеют плавать
    private static int foodBowl = 0; // Миска с едой
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false; // Кот голоден
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(int amount) {
        if (amount <= foodBowl) {
            foodBowl -= amount;
            isFull = true;
            System.out.println(name + " покушал " + amount + " единиц еды.");
        } else {
            System.out.println(name + " не может покушать, недостаточно еды в миске.");
        }
    }

    public static void addFood(int amount) {
        foodBowl += amount;
        System.out.println("В миску добавлено " + amount + " единиц еды. Теперь в миске " + foodBowl + " единиц еды.");
    }

    public boolean isFull() {
        return isFull;
    }
}

//Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур: круг, прямоугольник, треугольник.
//Задать для каждой фигуры цвет заливки и цвет границы.
//Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль.
//Попробуйте реализовать базовые методы, такие как расчет периметра фигур, в качестве дефолтных методов в интерфейсе.
// Интерфейс для геометрических фигур
interface Shape {
    // Дефолтные методы для расчета периметра и площади
    default double calculatePerimeter() {
        return 0;
    }

    default double calculateArea() {
        return 0;
    }

    String getFillColor();
    String getBorderColor();
}

// Класс для круга
class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс для прямоугольника
class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Класс для треугольника
class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2; // Полупериметр
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)); // Формула Герона
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

// Главный класс для тестирования
public class Main  {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Red", "Black");
        Shape rectangle = new Rectangle(4, 6, "Blue", "Green");
        Shape triangle = new Triangle(3, 4, 5, "Yellow", "Purple");

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }

    private static void printShapeInfo(Shape shape) {
        System.out.println("Фигура: " + shape.getClass().getSimpleName());
        System.out.println("Периметр: " + shape.calculatePerimeter());
        System.out.println("Площадь: " + shape.calculateArea());
        System.out.println("Цвет заливки: " + shape.getFillColor());
        System.out.println("Цвет границы: " + shape.getBorderColor());
        System.out.println();
    }
}
