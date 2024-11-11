package ru.surname.main;
import ru.surname.weapons.Weapon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //1.1
//        int d;
//        System.out.println("Сколько сущностей дом вы хотите создать?");
//
//        while (true){
//            if (in.hasNextInt()){
//                d= in.nextInt();
//                if (d>0){
//                    break;
//                }
//                else{
//                    System.out.println("Число должно быть положительным! Введите снова:");
//                }
//            }
//            else{
//                System.out.println("Некоректный ввод! Введите снова:");
//                in.next();
//            }
//        }
//        for(int i = 1;i<=d;i++){
//            System.out.println("Введите число для класса Дом:");
//            if (in.hasNextInt()) {
//                int floor = in.nextInt();
//                Dom Dom = new Dom(floor);
//                System.out.println(Dom.toString());
//            }
//            else{
//                System.out.println("ошибка");
//            }
//        }
//        in.nextLine();
        //1.5
//        try{
//            System.out.print("Введите максимальную вместимость магазина: ");
//            int maxkol = in.nextInt();
//            if (maxkol <= 0) {
//                throw new IllegalArgumentException("Максимальная вместимость должна быть больше 0.");
//            }
//
//            System.out.print("Введите начальное количество патронов (меньше или равно " + maxkol + "): ");
//            int kol = in.nextInt();
//            if (kol < 0 || kol > maxkol) {
//                throw new IllegalArgumentException("Количество патронов должно быть в пределах от 0 до " + maxkol + ".");
//            }
//            pistolet pistolet=new pistolet(kol,maxkol);
//            System.out.println("Пистолет успешно создан: " + pistolet);
//
//            while (true) {
//                System.out.println("\nВыберите действие:");
//                System.out.println("1 - Перезарядить пистолет");
//                System.out.println("2 - Выстрелить");
//                System.out.println("3 - Разрядить пистолет");
//                System.out.println("4 - Вывести текущее состояние пистолета");
//                System.out.println("5 - Узнать максимальную вместимость магазина");
//                System.out.println("6 - Проверить, заряжен ли пистолет");
//                System.out.println("0 - Выйти");
//
//                int choose3 = in.nextInt();
//                if (choose3 == 0) {
//                    System.out.println("Выход из программы.");
//                    break;
//                }
//
//                switch (choose3) {
//                    case 1:
//                        System.out.print("Введите количество патронов для перезарядки: ");
//                        int reload = in.nextInt();
//                        int free = pistolet.reload(reload);
//                        if (free > 0) {
//                            System.out.println("Пистолет полностью заряжен. Лишние патроны: " + free);
//                        } else {
//                            System.out.println("Пистолет успешно перезаряжен.");
//                        }
//                        break;
//
//                    case 2:
//                        System.out.print("Введите количество выстрелов: ");
//                        int bax = in.nextInt();
//                        if (bax > 0) {
//                            pistolet.strelba(bax);
//                        } else {
//                            System.out.println("Количество выстрелов должно быть положительным.");
//                        }
//                        break;
//
//                    case 3:
//                        int back = pistolet.unload();
//                        System.out.println("Пистолет разряжен. Снято патронов: " + back);
//                        break;
//
//                    case 4:
//                        System.out.println("Текущее состояние: " + pistolet);
//                        break;
//
//                    case 5:
//                        System.out.println("Максимальная вместимость магазина: " + pistolet.getMaxKol());
//                        break;
//
//                    case 6:
//                        System.out.println(pistolet.isLoaded());
//                        break;
//
//                    default:
//                        System.out.println("Неверный выбор! Попробуйте снова.");
//                        break;
//                }
//            }
//        }
//        catch (InputMismatchException e) {
//            System.out.println("Ошибка ввода!");
//        }

        //2.1
//        Massiv massiv = null;
//
//        System.out.println("Создание неизменяемого списка:");
//        System.out.println("1 - Инициализировать массивом чисел");
//        System.out.println("2 - Инициализировать перечнем чисел через запятую");
//        System.out.println("3 - Инициализировать другим списком");
//        System.out.print("Выберите метод инициализации: ");
//
//        int choice = in.nextInt();
//        in.nextLine();
//
//        try {
//            switch (choice) {
//                case 1 -> {
//                    System.out.print("Введите числа через пробел: ");
//                    String[] tokens = in.nextLine().split(" ");
//                    int[] values = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
//                    massiv = new Massiv(values);
//                }
//                case 2 -> {
//                    System.out.print("Введите числа через запятую: ");
//                    String[] tokens = in.nextLine().split(",");
//                    int[] values = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
//                    massiv = new Massiv(values);
//                }
//                case 3 -> {
//                    System.out.print("Введите числа через пробел: ");
//                    String[] tokens = in.nextLine().split(" ");
//                    List<Integer> values = new ArrayList<>();
//                    for (String token : tokens) {
//                        values.add(Integer.parseInt(token));
//                    }
//                    massiv = new Massiv(values);
//                }
//                default -> System.out.println("Неверный выбор.");
//            }
//
//            if (massiv != null) {
//                while (true) {
//                    System.out.println("\nВыберите действие:");
//                    System.out.println("1 - Получить значение по индексу");
//                    System.out.println("2 - Заменить значение по индексу");
//                    System.out.println("3 - Проверить, пуст ли список");
//                    System.out.println("4 - Узнать размер списка");
//                    System.out.println("5 - Показать все значения");
//                    System.out.println("6 - Показать значения как массив");
//                    System.out.println("0 - Выйти");
//                    System.out.print("Ваш выбор: ");
//
//                    int action1 = in.nextInt();
//                    if (action1 == 0) break;
//
//                    switch (action1) {
//                        case 1 -> {
//                            System.out.print("Введите индекс: ");
//                            int index = in.nextInt();
//                            try {
//                                System.out.println("Значение: " + massiv.get(index));
//                            } catch (IndexOutOfBoundsException e) {
//                                System.out.println("Ошибка: " + e.getMessage());
//                            }
//                        }
//                        case 2 -> {
//                            System.out.print("Введите индекс: ");
//                            int index = in.nextInt();
//                            System.out.print("Введите новое значение: ");
//                            int newValue = in.nextInt();
//                            try {
//                                massiv = massiv.set(index, newValue);
//                                System.out.println("Значение обновлено.");
//                            } catch (IndexOutOfBoundsException e) {
//                                System.out.println("Ошибка: " + e.getMessage());
//                            }
//                        }
//                        case 3 -> System.out.println("Список " + (massiv.isEmpty() ? "пуст." : "не пуст."));
//                        case 4 -> System.out.println("Размер списка: " + massiv.size());
//                        case 5 -> System.out.println("Значения списка: " + massiv.toString());
//                        case 6 -> {
//                            int[] array = massiv.toArray();
//                            System.out.print("Массив значений: ");
//                            for (int num : array) {
//                                System.out.print(num + " ");
//                            }
//                            System.out.println();
//                        }
//
//                        default -> System.out.println("Неверный выбор.");
//                    }
//                }
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("Ошибка ввода! Введите корректное значение.");
//        }
        //3.4
//        System.out.println("Выберите способ создания автомата:");
//        System.out.println("1. Создать автомат по умолчанию (емкость 30, скорострельность 30)");
//        System.out.println("2. Создать автомат с указанием максимальной емкости (скорострельность = емкость / 2)");
//        System.out.println("3. Создать автомат с указанием емкости и скорострельности");
//
//        Avtomat avtomat;
//        try {
//            int choice1 = in.nextInt();
//
//            switch (choice1) {
//                case 1:
//                    avtomat = new Avtomat();
//                    break;
//                case 2:
//                    System.out.print("Введите максимальную емкость автомата: ");
//                    int maxAmmo = in.nextInt();
//                    avtomat = new Avtomat(maxAmmo);
//                    break;
//                case 3:
//                    System.out.print("Введите максимальную емкость автомата: ");
//                    int maxAmmo1 = in.nextInt();
//                    System.out.print("Введите скорострельность автомата: ");
//                    int rateOfFire = in.nextInt();
//                    avtomat = new Avtomat(maxAmmo1, rateOfFire);
//                    break;
//                default:
//                    System.out.println("Неверный выбор, создается автомат по умолчанию.");
//                    avtomat = new Avtomat();
//                    break;
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("Ошибка ввода! Устанавливается автомат по умолчанию.");
//            in.next();
//            avtomat = new Avtomat();
//        }
//        int q=1;
//        while (q==1) {
//            System.out.println("\nВыберите действие:");
//            System.out.println("1. Узнать текущий заряд");
//            System.out.println("2. Проверить, заряжен ли автомат");
//            System.out.println("3. Перезарядить автомат");
//            System.out.println("4. Выстрелить один раз");
//            System.out.println("5. Стрелять N секунд");
//            System.out.println("6. Узнать максимальную емкость магазина");
//            System.out.println("7. Разрядить автомат");
//            System.out.println("8. Показать информацию об автомате");
//            System.out.println("9. Выйти");
//
//            int action;
//            try {
//                action = in.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Ошибка ввода! Пожалуйста, введите номер действия.");
//                in.next();
//                continue;
//            }
//            try {
//                switch (action) {
//                    case 1:
//                        System.out.println("Текущий заряд: " + avtomat.getpul() + " патронов");
//                        break;
//                    case 2:
//                        System.out.println(avtomat.isLoaded());
//                        break;
//                    case 3:
//                        System.out.print("Введите количество патронов для перезарядки: ");
//                        int bullets = in.nextInt();
//                        int ost = avtomat.reload(bullets);
//                        if (ost > 0) {
//                            System.out.println("Автомат полностью заряжен. Лишние: " + ost );
//                        } else {
//                            System.out.println("Автомат успешно перезаряжен.");
//                        }
//                        break;
//                    case 4:
//                        avtomat.strelba(1);
//                        break;
//                    case 5:
//                        System.out.print("Введите количество секунд стрельбы: ");
//                        int seconds = in.nextInt();
//                        avtomat.strelbaNSeconds(seconds);
//                        break;
//                    case 6:
//                        System.out.println("Максимальная емкость магазина: " + avtomat.getMaxKol() + " патронов");
//                        break;
//                    case 7:
//                        int returnedAmmo = avtomat.unload();
//                        System.out.println("Автомат разряжен. Возвращено патронов: " + returnedAmmo);
//                        break;
//                    case 8:
//                        System.out.println(avtomat);
//                        break;
//                    case 9:
//                        System.out.println("Выход...");
//                        q=0;
//                    default:
//                        System.out.println("Некорректный ввод! Пожалуйста, выберите действие от 1 до 9.");
//                }
//
//            }
//            catch (InputMismatchException e) {
//                System.out.println("Ошибка ввода! Пожалуйста, введите номер действия.");
//                in.next();
//            }
//        }
        //4.1
//        System.out.println("Добро пожаловать! Создадим ваш пистолет.");
//        Pistolet1 pistolet;
//        try {
//            System.out.print("Введите начальное количество патронов: ");
//            int ammo = in.nextInt();
//            System.out.print("Введите максимальное количество патронов: ");
//            int maxAmmo = in.nextInt();
//
//            if (ammo < 0 || maxAmmo <= 0) {
//                System.out.println("Ошибка: начальное количество патронов должно быть неотрицательным, а максимальное количество положительным.");
//                return;
//            }
//            pistolet=new Pistolet1(ammo,maxAmmo);
//        } catch (InputMismatchException e) {
//            System.out.println("Ошибка ввода! Пожалуйста, вводите только целые числа.");
//            return;
//        }
//
//        System.out.println("Ваш пистолет создан: " + pistolet);
//
//        while (true) {
//            System.out.println("\nВыберите действие:");
//            System.out.println("1 - Выстрелить");
//            System.out.println("2 - Перезарядить");
//            System.out.println("3 - Проверить состояние (заряжен или разряжен)");
//            System.out.println("4 - Показать текущее количество патронов");
//            System.out.println("5 - Показать максимальную вместимость");
//            System.out.println("0 - Выход");
//            int choice2;
//            try {
//                choice2 = in.nextInt();
//            }catch(InputMismatchException e) {
//                System.out.println("Ошибка ввода! Пожалуйста, вводите только целые числа.");
//                in.next();
//                continue;
//            }
//            try {
//                switch (choice2) {
//                    case 1 -> pistolet.shoot();
//                    case 2 -> {
//                        System.out.print("Сколько патронов добавить? ");
//                        try {
//                            int bullets = in.nextInt();
//                            int leftover = pistolet.reload(bullets);
//                            System.out.println("Осталось неиспользованных патронов: " + leftover);
//                        } catch (InputMismatchException e) {
//                            System.out.println("Ошибка ввода! Пожалуйста, вводите только целые числа.");
//                        }
//                    }
//                    case 3 -> System.out.println(pistolet.isLoaded() ? "Пистолет заряжен" : "Пистолет разряжен");
//                    case 4 -> System.out.println("Текущее количество патронов: " + pistolet.ammo());
//                    case 5 -> System.out.println("Максимальная вместимость: " + pistolet.getMaxAmmo());
//                    case 0 -> {
//                        System.out.println("Выход из программы.");
//                        return;
//                    }
//                    default -> System.out.println("Неверный выбор, пожалуйста, выберите вариант от 0 до 5.");
//
//
//                }
//            }
//            catch(InputMismatchException e) {
//                System.out.println("Ошибка ввода! Пожалуйста, вводите только целые числа.");
//                in.next();
//            }
//        }
        //5.8
//        System.out.print("Введите количество стрелков: ");
//        int shooterCount;
//        while (true) {
//            if (in.hasNextInt()) {
//                shooterCount = in.nextInt();
//                if (shooterCount > 0) {
//                    break;
//                } else {
//                    System.out.println("Ошибка: число должно быть положительным!");
//                }
//            } else {
//                System.out.println("Ошибка: введите целое число!");
//                in.next();
//            }
//        }
//
//        Shooter[] shooters = new Shooter[shooterCount];
//        in.nextLine();
//
//        for (int i = 0; i < shooterCount; i++) {
//            System.out.println("\nСоздаем стрелка " + (i + 1));
//            System.out.print("Введите имя стрелка: ");
//            String name = in.nextLine().trim();
//
//            System.out.println("Выберите оружие для стрелка:");
//            System.out.println("1 - Пистолет");
//            System.out.println("2 - Автомат");
//            System.out.println("3 - Без оружия");
//            System.out.println("Ваш выбор: ");
//            int choice;
//            while (true) {
//                if (in.hasNextInt()) {
//                    choice = in.nextInt();
//                    if (choice >= 1 && choice <= 3) {
//                        break;
//                    } else {
//                        System.out.println("Ошибка: введите число от 1 до 3.");
//                    }
//                } else {
//                    System.out.println("Ошибка: введите целое число.");
//                    in.next();
//                }
//            }
//            switch (choice) {
//                case 1 -> {
//                    System.out.print("Введите количество патронов в пистолете: ");
//                    int ammo;
//                    if (in.hasNextInt()) {
//                        ammo = in.nextInt();
//                        if (ammo < 0) {
//                            System.out.println("число должно быть неотрицательным");
//                            i--;
//                            break;
//                        }
//                    }else{
//                        System.out.println("Введите число!");
//                        i--;
//                        break;
//                    }
//                    System.out.print("Введите максимальное количество патронов для пистолета: ");
//                    if (in.hasNextInt()) {
//                        int maxAmmo = in.nextInt();
//                        if (maxAmmo <= 0) {
//                            System.out.println("число должно быть положительным");
//                            i--;
//                            break;
//                        }
//                        shooters[i] = new Shooter(name, new Pistolet1(ammo, maxAmmo));
//                    }else{
//                        System.out.println("Введите число!");
//                        i--;
//                        break;
//                    }
//                }
//                case 2 -> {
//                    System.out.print("Введите количество патронов в автомате: ");
//                    int ammo;
//                    if (in.hasNextInt()) {
//                        ammo = in.nextInt();
//                        if (ammo < 0) {
//                            System.out.println("число должно быть неотрицательным");
//                            i--;
//                            break;
//                        }
//                    }else{
//                        System.out.println("Введите число!");
//                        i--;
//                        break;
//                    }
//                    System.out.print("Введите скорострельность автомата: ");
//                    if (in.hasNextInt()) {
//                        int rateOfFire = in.nextInt();
//                        shooters[i] = new Shooter(name, new Automat(ammo, rateOfFire));
//                    }else{
//                        System.out.println("Введите число!");
//                        i--;
//                        break;
//                    }
//                }
//                case 3 -> {
//                    System.out.println("Этот стрелок будет без оружия.");
//                    shooters[i] = new Shooter(name, null);
//                }
//                default -> {
//                    System.out.println("Неверный выбор. Попробуйте снова.");
//                }
//            }
//            in.nextLine();
//        }
//
//        System.out.println("\nКаждый стрелок стреляет:");
//        for (Shooter shooter : shooters) {
//            shooter.shoot();
//        }
        System.out.println("Сколько точек вы хотите создать?");
        int numberOfPoints;
        while (true) {
            try {
                System.out.print("Введите целое число: ");
                numberOfPoints = in.nextInt();
                if (numberOfPoints <= 0) {
                    System.out.println("Ошибка! Введите положительное число.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Введите корректное целое число.");
            }
        }

        Weapon.Point[] points = new Weapon.Point[numberOfPoints];


        for (int i = 0; i < numberOfPoints; i++) {
            double x = 0;
            double y = 0;
            while (true) {
                try {
                    System.out.println("Введите координаты для точки " + (i + 1) + ":");
                    System.out.print("Координата X: ");
                    x = in.nextDouble();
                    System.out.print("Координата Y: ");
                    y = in.nextDouble();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка ввода! Введите корректное число.");
                }
            }
            points[i] = new Weapon.Point(x, y);
            System.out.println("Создана точка: " + points[i]);
        }

        System.out.println("\nПроверим, есть ли одинаковые точки.");
        for (int i = 0; i < numberOfPoints; i++) {
            for (int j = i + 1; j < numberOfPoints; j++) {
                if (points[i].equals(points[j])) {
                    System.out.println("Точка " + (i + 1) + " и Точка " + (j + 1) + " совпадают по координатам.");
                }
            }
        }



        in.close();



    }



}