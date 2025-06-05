package ru.seduhin.weapons;

/**
 * Класс автоматического оружия, наследующий функциональность пистолета
 * с добавлением скорострельности.
 */
public class Avtomat extends pistolet {
    private final int speed;
    /**
     * @return текущую скорострельность
     */
    int getspeed() {
        return speed;
    }
    /**
     * Создает автомат с параметрами по умолчанию:
     * - емкость магазина: 30 патронов
     * - скорострельность: 30 выстрелов в секунду
     */
    public Avtomat() {
        super(0, 30);
        this.speed = 30; 
    }
    /**
     * Создает автомат с указанной емкостью магазина.
     * Скорострельность устанавливается как половина емкости.
     * @param maxAmmo максимальная емкость магазина
     */
    public Avtomat(int maxAmmo) {
        super(0, maxAmmo);
        this.speed = maxAmmo / 2;
    }

    /**
     * Создает автомат с указанными параметрами
     * @param maxAmmo максимальная емкость магазина
     /* @param rateofFire скорострельность (выстрелов в секунду)
     */
    public Avtomat(int maxAmmo, int speed) {
        super(0, maxAmmo);
        if (speed <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной.");
        }
        this.speed = speed;
    }

    /**
     * Производит стрельбу с учетом скорострельности
     /* @param seconds время стрельбы в секундах
     */
    @Override
    public void strelba(int n) {
        int shots = n * speed;
        for (int i = 0; i < shots; i++) {
            if (getpul() > 0) {
                System.out.println("Бах!");
                setKol(getpul() - 1);
            } else {
                System.out.println("Клац!");
            }
        }
    }

    /**
     * Производит стрельбу в течение указанного времени
     /* @param seconds время стрельбы в секундах
     */
    public void strelbaNSeconds(int seconds) {
        if (seconds <= 0) {
            System.err.println("Количество секунд должно быть положительным.");
            seconds=1;
            strelba(seconds);
        }
        else{
            strelba(seconds);
        }

    }
    /**
     * Вывод информации
     */
    @Override
    public String toString() {
        if ((getpul()>19 || getpul()<11) && (getpul()%10==1))
            return "автомат с " + getpul() + " патроном, скорострельностью "+speed;
        else
            return "автомат с " + getpul() + " патронами, скорострельностью "+speed;
    }
}

