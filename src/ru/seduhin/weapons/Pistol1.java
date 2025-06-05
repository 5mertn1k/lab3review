/* Продолжение задания №5 */
package ru.seduhin.weapons;
/**
 * Класс пистолета с ограниченной емкостью магазина.
 * Наследует базовую функциональность от класса Weapon.
 */
public class Pistol1 extends Weapon {
    private final int maxAmmo;

    /**
     * @return максимальную емкость магазина
     */
    public int getMaxAmmo() {
        return maxAmmo;
    }
    /**
     * Создает пистолет с указанными параметрами
     * @param ammo начальное количество патронов
     * @param maxAmmo максимальная емкость магазина
     */
    public Pistol1(int ammo, int maxAmmo) {
        super(ammo);
        if (maxAmmo <= 0){
            System.err.println("Максимальная вместимость должна быть положительным числом.");
            this.maxAmmo = 10;
        }
        else {
            this.maxAmmo = maxAmmo;
        }
        if (ammo>maxAmmo){
            System.err.println("Пуль не может быть больше вместимости!");
            load(this.maxAmmo);
        }
    }
    /**
     * Создает пистолет с параметрами по умолчанию:
     * - начальные патроны: 5
     * - максимальная емкость: 10
     */
    public Pistol1() {
        super(5);
        this.maxAmmo = 10;
    }
    /**
     * Переопределенный родительский метод для стрельбы
     */
    @Override
    public void shoot() {

        if (getAmmo()) {
            System.out.println("Бах!");
        } else {
            System.out.println("Клац! ");
        }
    }
    /**
     * Перезаряжает пистолет
     * @param bullets количество патронов для зарядки
     * @return количество патронов, которые не поместились
     */
    public int reload(int bullets) {
        if (bullets < 0) {
            System.err.println("Нельзя зарядить отрицательное количество патронов.");
            return 0;
        }
        int free = maxAmmo - ammo();
        int addedBullets = Math.min(bullets, free);

        load(ammo() + addedBullets);
        return bullets - addedBullets;
    }
    /**
     * Метод для вывода информации
     */
    public String toString() {
        int currentAmmo = ammo();
        if ((currentAmmo>19 || currentAmmo<11) && (currentAmmo%10==1)) {
            return "пистолет с " + currentAmmo + " патроном";
        }
        else {
            return "пистолет с " + currentAmmo + " патронами";
        }
    }

    /**
     * @return true если пистолет заряжен, false если нет
     */
    public boolean isLoaded() {
        return ammo() > 0;
    }
}
