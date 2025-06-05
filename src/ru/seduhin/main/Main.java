/*
 * Основная программа для демонстрации работы классов:
 * 1. Home - работа с домами
 * 2. Pistol - базовый пистолет
 * 3. Array - неизменяемый список
 * 4. Automat - автоматическое оружие
 * 5. Pistol1 - улучшенный пистолет
 * 6. Shooter - стрелки с оружием
 * 7. Point - работа с геометрическими точками
 * 8. exponentiate - возведение в степень
 * 9. Pistol1up - модернизированный пистолет
 */

package ru.seduhin.main;

import ru.seduhin.geometry.Point;
import ru.seduhin.weapons.*;
import ru.seduhin.home.*;
import ru.seduhin.array.*;

import java.util.Scanner;
import java.util.InputMismatchException;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Главный класс программы для демонстрации работы всех реализованных классов.
 * Содержит точку входа и методы для взаимодействия с пользователем.
 */
public class Main {

    /**
     * Возводит число x в степень y с обработкой ошибок ввода
     * @param x основание степени (строка)
     * @param y показатель степени (строка)
     * @return результат возведения в степень или Double.NaN при ошибке
     */
    public static double exponentiate(String x, String y) {
        try {
            int x1 = parseInt(x);
            int y1 = parseInt(y);
            return pow(x1, y1);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: оба параметра должны быть целыми числами.");
            return Double.NaN;
        }
    }

    /**
     * Точка входа в программу. Содержит меню для работы со всеми классами.
     * @param args аргументы командной строки не используются
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в демонстрационную программу!");
        System.out.println("Выберите номер задания для выполнения:");
        System.out.println("1 - Работа с классом Dom");
        System.out.println("2 - Работа с классом pistol");
        System.out.println("3 - Работа с классом Array");
        System.out.println("4 - Работа с классом Automat");
        System.out.println("5 - Работа с классом Pistol1");
        System.out.println("6 - Работа с классом Shooter");
        System.out.println("7 - Работа с классом Point");
        System.out.println("8 - Возведение в степень");
        System.out.println("9 - Работа с классом Pistol1up");
        System.out.println("0 - Выход из программы");

        boolean running = true;
        while (running) {
            System.out.print("\nВведите номер задания: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> handleDomCreation(scanner);
                    case 2 -> handlePistolOperations(scanner);
                    case 3 -> handleMassivOperations(scanner);
                    case 4 -> handleAutomatOperations(scanner);
                    case 5 -> handlePistol1Operations(scanner);
                    case 6 -> handleShooterOperations(scanner);
                    case 7 -> handlePointOperations(scanner);
                    case 8 -> handleExponentiation(scanner);
                    case 9 -> handlePistol1UpOperations(scanner);
                    case 0 -> {
                        System.out.println("Выход из программы...");
                        running = false;
                    }
                    default -> System.err.println("Неверный номер задания!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введите число от 0 до 9!");
                scanner.next();
            }
        }

        scanner.close();
    }

    /** Обрабатывает создание объектов Dom */
    private static void handleDomCreation(Scanner scanner) {
        System.out.println("\n=== 1. Работа с классом Dom ===");

        int count;
        while (true) {
            System.out.print("Сколько домов создать? ");
            try {
                count = scanner.nextInt();
                if (count > 0) break;
                System.err.println("Ошибка: число должно быть положительным!");
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введите целое число!");
                scanner.next();
            }
        }

        for (int i = 1; i <= count; i++) {
            System.out.print("Введите этажность для дома " + i + ": ");
            try {
                int floors = scanner.nextInt();
                Home house = new Home(floors);
                System.out.println("Создан дом: " + house);
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: используйте целые числа!");
                scanner.next();
                i--;
            }
        }
    }

    /** Обрабатывает операции с пистолетом */
    private static void handlePistolOperations(Scanner scanner) {
        System.out.println("\n=== 2. Работа с классом pistol ===");

        try {
            System.out.print("Введите максимальную вместимость магазина: ");
            int maxCapacity = scanner.nextInt();
            if (maxCapacity <= 0) {
                System.err.println("Ошибка: вместимость должна быть > 0");
                return;
            }

            System.out.print("Введите начальное количество патронов: ");
            int ammo = scanner.nextInt();
            if (ammo < 0 || ammo > maxCapacity) {
                System.err.println("Ошибка: недопустимое количество патронов");
                return;
            }

            Pistol pistol = new Pistol(ammo, maxCapacity);
            System.out.println("Пистолет создан: " + pistol);

            boolean running = true;
            while (running) {
                System.out.println("\nВыберите действие:");
                System.out.println("1 - Перезарядить");
                System.out.println("2 - Выстрелить");
                System.out.println("3 - Разрядить");
                System.out.println("4 - Показать состояние");
                System.out.println("0 - Выход в меню");

                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            System.out.print("Введите количество патронов: ");
                            int reload = scanner.nextInt();
                            int remaining = pistol.reload(reload);
                            if (remaining > 0) {
                                System.out.println("Лишние патроны: " + remaining);
                            }
                        }
                        case 2 -> {
                            System.out.print("Сколько выстрелов? ");
                            int shots = scanner.nextInt();
                            pistol.shoot(shots);
                        }
                        case 3 -> {
                            int unloaded = pistol.unload();
                            System.out.println("Извлечено патронов: " + unloaded);
                        }
                        case 4 -> System.out.println("Текущее состояние: " + pistol);
                        case 0 -> running = false;
                        default -> System.err.println("Неверный выбор!");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Ошибка: введите число!");
                    scanner.next();
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода данных!");
        }
    }

    /** Обрабатывает операции с Array */
    private static void handleMassivOperations(Scanner scanner) {
        System.out.println("\n=== 3. Работа с классом Massiv ===");

        Array array = null;
        System.out.println("Выберите способ создания списка:");
        System.out.println("1 - Из массива чисел");
        System.out.println("2 - Из строки с числами через запятую");
        System.out.println("3 - Из другого списка");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите числа через пробел: ");
                    String[] tokens = scanner.nextLine().split(" ");
                    int[] values = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
                    array = new Array(values);
                }
                case 2 -> {
                    System.out.print("Введите числа через запятую: ");
                    String[] tokens = scanner.nextLine().split(",");
                    int[] values = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
                    array = new Array(values);
                }
                case 3 -> {
                    System.out.print("Введите числа через пробел: ");
                    String[] tokens = scanner.nextLine().split(" ");
                    List<Integer> values = new ArrayList<>();
                    for (String token : tokens) {
                        values.add(Integer.parseInt(token));
                    }
                    array = new Array(values);
                }
                default -> System.err.println("Неверный выбор!");
            }

            if (array != null) {
                System.out.println("Список создан: " + array);
                handleMassivMenu(scanner, array);
            }
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: вводите только целые числа!");
        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода!");
            scanner.next();
        }
    }

    /** Меню операций с Array */
    private static void handleMassivMenu(Scanner scanner, Array massiv) {
        boolean running = true;
        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Получить значение по индексу");
            System.out.println("2 - Заменить значение");
            System.out.println("3 - Проверить пустоту");
            System.out.println("4 - Узнать размер");
            System.out.println("5 - Показать все значения");
            System.out.println("6 - Преобразовать в массив");
            System.out.println("0 - Выход");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Введите индекс: ");
                        int index = scanner.nextInt();
                        try {
                            System.out.println("Значение: " + massiv.get(index));
                        } catch (IndexOutOfBoundsException e) {
                            System.err.println("Ошибка: " + e.getMessage());
                        }
                    }
                    case 2 -> {
                        System.out.print("Введите индекс: ");
                        int index = scanner.nextInt();
                        System.out.print("Введите новое значение: ");
                        int value = scanner.nextInt();
                        try {
                            massiv = massiv.set(index, value);
                            System.out.println("Значение обновлено.");
                        } catch (IndexOutOfBoundsException e) {
                            System.err.println("Ошибка: " + e.getMessage());
                        }
                    }
                    case 3 -> System.out.println("Список " +
                            (massiv.isEmpty() ? "пуст" : "не пуст"));
                    case 4 -> System.out.println("Размер: " + massiv.size());
                    case 5 -> System.out.println("Значения: " + massiv);
                    case 6 -> {
                        int[] array = massiv.toArray();
                        System.out.print("Массив: ");
                        for (int num : array) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                    }
                    case 0 -> running = false;
                    default -> System.err.println("Неверный выбор!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Ошибка: введите число!");
                scanner.next();
            }
        }
    }

    /** Обрабатывает операции с Automatup */
    private static void handleAutomatOperations(Scanner scanner) {
        System.out.println("\n=== 4. Работа с классом Automatup ===");

        Automatup automatup;
        System.out.println("Выберите способ создания:");
        System.out.println("1 - По умолчанию (30 патронов)");
        System.out.println("2 - С указанием емкости");
        System.out.println("3 - С указанием емкости и скорострельности");

        try {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> automatup = new Automatup();
                case 2 -> {
                    System.out.print("Введите емкость: ");
                    int capacity = scanner.nextInt();
                    automatup = new Automatup(capacity);
                }
                case 3 -> {
                    System.out.print("Введите емкость: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Введите скорострельность: ");
                    int rate = scanner.nextInt();
                    automatup = new Automatup(capacity, rate);
                }
                default -> {
                    System.err.println("Неверный выбор, создан по умолчанию");
                    automatup = new Automatup();
                }
            }

            System.out.println("Автомат создан: " + automatup);
            handleAutomatMenu(scanner, automatup);

        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода!");
            scanner.next();
        }
    }

    /** Меню операций с Automatup */
    private static void handleAutomatMenu(Scanner scanner, Automatup automatup) {
        boolean running = true;
        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Текущий заряд");
            System.out.println("2 - Проверить заряд");
            System.out.println("3 - Перезарядить");
            System.out.println("4 - Выстрелить");
            System.out.println("5 - Стрелять N секунд");
            System.out.println("6 - Емкость магазина");
            System.out.println("7 - Разрядить");
            System.out.println("8 - Информация");
            System.out.println("0 - Выход");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> System.out.println("Заряд: " + automatup.getBullets());
                    case 2 -> System.out.println(automatup.isLoaded());
                    case 3 -> {
                        System.out.print("Введите патроны: ");
                        int bullets = scanner.nextInt();
                        int remaining = automatup.reload(bullets);
                        if (remaining > 0) {
                            System.out.println("Лишние: " + remaining);
                        }
                    }
                    case 4 -> automatup.shoot(1);
                    case 5 -> {
                        System.out.print("Введите секунды: ");
                        int seconds = scanner.nextInt();
                        automatup.shootNSeconds(seconds);
                    }
                    case 6 -> System.out.println("Емкость: " + automatup.getMaxKol());
                    case 7 -> {
                        int unloaded = automatup.unload();
                        System.out.println("Извлечено: " + unloaded);
                    }
                    case 8 -> System.out.println(automatup);
                    case 0 -> running = false;
                    default -> System.err.println("Неверный выбор!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Ошибка ввода!");
                scanner.next();
            }
        }
    }

    /** Обрабатывает операции с Pistol1 */
    private static void handlePistol1Operations(Scanner scanner) {
        System.out.println("\n=== 5. Работа с классом Pistol1 ===");

        try {
            System.out.print("Введите начальное количество патронов: ");
            int ammo = scanner.nextInt();
            System.out.print("Введите максимальное количество: ");
            int maxAmmo = scanner.nextInt();

            if (ammo < 0 || maxAmmo <= 0) {
                System.err.println("Ошибка: недопустимые параметры");
                return;
            }

            Pistol1 pistol = new Pistol1(ammo, maxAmmo);
            System.out.println("Пистолет создан: " + pistol);

            boolean running = true;
            while (running) {
                System.out.println("\nВыберите действие:");
                System.out.println("1 - Выстрелить");
                System.out.println("2 - Перезарядить");
                System.out.println("3 - Проверить состояние");
                System.out.println("4 - Текущие патроны");
                System.out.println("5 - Макс. вместимость");
                System.out.println("0 - Выход");

                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> pistol.shoot();
                        case 2 -> {
                            System.out.print("Сколько патронов добавить? ");
                            int bullets = scanner.nextInt();
                            int remaining = pistol.reload(bullets);
                            System.out.println("Осталось: " + remaining);
                        }
                        case 3 -> System.out.println(pistol.isLoaded() ?
                                "Заряжен" : "Разряжен");
                        case 4 -> System.out.println("Патроны: " + pistol);
                        case 5 -> System.out.println("Макс. вместимость: " +
                                pistol.getMaxAmmo());
                        case 0 -> running = false;
                        default -> System.err.println("Неверный выбор!");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Ошибка ввода!");
                    scanner.next();
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода данных!");
        }
    }

    /** Обрабатывает операции с Shooter */
    private static void handleShooterOperations(Scanner scanner) {
        System.out.println("\n=== 6. Работа с классом Shooter ===");

        System.out.print("Введите количество стрелков: ");
        try {
            int count = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            if (count <= 0) {
                System.err.println("Ошибка: число должно быть положительным");
                return;
            }

            Shooter[] shooters = new Shooter[count];

            for (int i = 0; i < count; i++) {
                System.out.println("\nСоздание стрелка " + (i + 1));
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();

                System.out.println("Выберите оружие:");
                System.out.println("1 - Пистолет");
                System.out.println("2 - Автомат");
                System.out.println("3 - Без оружия");

                int weaponChoice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера

                switch (weaponChoice) {
                    case 1 -> {
                        System.out.print("Введите патроны: ");
                        int ammo = scanner.nextInt();
                        System.out.print("Введите макс. вместимость: ");
                        int maxAmmo = scanner.nextInt();
                        scanner.nextLine(); // Очистка

                        if (ammo < 0 || maxAmmo <= 0) {
                            System.err.println("Ошибка: недопустимые параметры");
                            i--;
                            continue;
                        }

                        shooters[i] = new Shooter(name, new Pistol1(ammo, maxAmmo));
                    }
                    case 2 -> {
                        System.out.print("Введите патроны: ");
                        int ammo = scanner.nextInt();
                        System.out.print("Введите скорострельность: ");
                        int rate = scanner.nextInt();
                        scanner.nextLine(); // Очистка

                        shooters[i] = new Shooter(name, new Automat(ammo, rate));
                    }
                    case 3 -> shooters[i] = new Shooter(name, null);
                    default -> {
                        System.err.println("Неверный выбор, без оружия");
                        shooters[i] = new Shooter(name, null);
                    }
                }
            }

            System.out.println("\nВсе стрелки делают выстрел:");
            for (Shooter shooter : shooters) {
                shooter.shoot();
            }

        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода данных!");
            scanner.next();
        }
    }

    /** Обрабатывает операции с Point */
    private static void handlePointOperations(Scanner scanner) {
        System.out.println("\n=== 7. Работа с классом Point ===");

        System.out.print("Введите количество точек: ");
        try {
            int count = scanner.nextInt();

            if (count <= 0) {
                System.err.println("Ошибка: число должно быть положительным");
                return;
            }

            Point[] points = new Point[count];

            for (int i = 0; i < count; i++) {
                System.out.println("\nТочка " + (i + 1));
                System.out.print("Введите координату X: ");
                double x = scanner.nextDouble();
                System.out.print("Введите координату Y: ");
                double y = scanner.nextDouble();

                points[i] = new Point(x, y);
                System.out.println("Создана точка: " + points[i]);
            }


            System.out.println("\nПроверка совпадений:");
            for (int i = 0; i < count; i++) {
                for (int j = i + 1; j < count; j++) {
                    if (points[i].equals(points[j])) {
                        System.out.println("Точка " + (i+1) + " и " + (j+1) + " совпадают");
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода данных!");
            scanner.next();
        }
    }

    /** Обрабатывает возведение в степень */
    private static void handleExponentiation(Scanner scanner) {
        System.out.println("\n=== 8. Возведение в степень ===");

        System.out.print("Введите основание (X): ");
        String x = scanner.next();
        System.out.print("Введите степень (Y): ");
        String y = scanner.next();

        double result = exponentiate(x, y);
        if (!Double.isNaN(result)) {
            System.out.println("Результат: " + x + "^" + y + " = " + result);
        }
    }

    /** Обрабатывает операции с Pistol1up */
    private static void handlePistol1UpOperations(Scanner scanner) {
        System.out.println("\n=== 9. Работа с классом Pistol1up ===");

        try {
            System.out.print("Введите начальное количество патронов: ");
            int ammo = scanner.nextInt();
            System.out.print("Введите максимальное количество: ");
            int maxAmmo = scanner.nextInt();

            if (ammo < 0 || maxAmmo <= 0) {
                System.err.println("Ошибка: недопустимые параметры");
                return;
            }

            Pistol1up pistol = new Pistol1up(ammo, maxAmmo);
            System.out.println("Пистолет создан: " + pistol);

            boolean running = true;
            while (running) {
                System.out.println("\nВыберите действие:");
                System.out.println("1 - Выстрелить");
                System.out.println("2 - Перезарядить");
                System.out.println("3 - Проверить состояние");
                System.out.println("4 - Текущие патроны");
                System.out.println("5 - Макс. вместимость");
                System.out.println("6 - Разрядить");
                System.out.println("0 - Выход");

                try {
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> pistol.shoot();
                        case 2 -> {
                            System.out.print("Сколько патронов добавить? ");
                            int bullets = scanner.nextInt();
                            int remaining = pistol.reload(bullets);
                            System.out.println("Осталось: " + remaining);
                        }
                        case 3 -> System.out.println(pistol.isLoaded() ?
                                "Заряжен" : "Разряжен");
                        case 4 -> System.out.println("Патроны: " + pistol);
                        case 5 -> System.out.println("Макс. вместимость: " +
                                pistol.getMaxAmmo());
                        case 6 -> {
                            int unloaded = pistol.unload();
                            System.out.println("Извлечено: " + unloaded);
                        }
                        case 0 -> running = false;
                        default -> System.err.println("Неверный выбор!");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Ошибка ввода!");
                    scanner.next();
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Ошибка ввода данных!");
        }
    }
}