/* Продолжение задания №4 */
package ru.seduhin.weapons;

/**
 * Класс автоматического оружия, наследующий функциональность пистолета
 * с добавлением скорострельности.
 */
public class Automatup extends Pistol {
    private final int speed;
    /**
     * @return текущую скорострельность
     */
    int getSpeed() {
        return speed;
    }
    /**
     * Создает автомат с параметрами по умолчанию:
     * - емкость магазина: 30 патронов
     * - скорострельность: 30 выстрелов в секунду
     */
    public Automatup() {
        super(0, 30);
        this.speed = 30; 
    }
    /**
     * Создает автомат с указанной емкостью магазина.
     * Скорострельность устанавливается как половина емкости.
     * @param maxAmmo максимальная емкость магазина
     */
    public Automatup(int maxAmmo) {
        super(0, maxAmmo);
        this.speed = maxAmmo / 2;
    }

    /**
     * Создает автомат с указанными параметрами
     * @param maxAmmo максимальная емкость магазина
     /* @param speed скорострельность (выстрелов в секунду)
     */
    public Automatup(int maxAmmo, int speed) {
        super(0, maxAmmo);
        if (speed <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной.");
        }
        this.speed = speed;
    }

    /**
     * Производит стрельбу с учетом скорострельности
     /* @param n время стрельбы в секундах
     */
    public void shoot(int n) {
        int shots = n * speed;
        for (int i = 0; i < shots; i++) {
            if (getBullets() > 0) {
                System.out.println("Бах!");
                setCount(getBullets() - 1);
            } else {
                System.out.println("Клац!");
            }
        }
    }

    /**
     * Производит стрельбу в течение указанного времени
     /* @param seconds время стрельбы в секундах
     */
    public void shootNSeconds(int seconds) {
        if (seconds <= 0) {
            System.err.println("Количество секунд должно быть положительным.");
            seconds=1;
            shoot(seconds);
        }
        else{
            shoot(seconds);
        }

    }
    /**
     * Вывод информации
     */
    @Override
    public String toString() {
        if ((getBullets()>19 || getBullets()<11) && (getBullets()%10==1)) {
            return "автомат с " + getBullets() + " патроном, скорострельностью " + speed;
        }
        else {
            return "автомат с " + getBullets() + " патронами, скорострельностью " + speed;
        }
    }
}

