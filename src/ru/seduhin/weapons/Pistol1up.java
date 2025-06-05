/* Продолжение задания №9 */
package ru.seduhin.weapons;

/**
 * Улучшенная версия пистолета с дополнительными функциями.
 * Наследует базовую функциональность от класса Weaponup.
 */
public class Pistol1up extends Weaponup {
    private final int maxAmmo;

    /**
     * @return максимальную емкость магазина
     */
    public int getMaxAmmo() {
        return maxAmmo;
    }

    /**
     * Создает улучшенный пистолет с указанными параметрами
     * @param ammo начальное количество патронов
     * @param maxAmmo максимальная емкость магазина
     */
    public Pistol1up(int ammo, int maxAmmo) {
        super(ammo);
        if (maxAmmo <= 0){
            System.err.println("Максимальная вместимость должна быть положительным числом.");
            this.maxAmmo = 10;
        }
        else if (ammo > maxAmmo){
            System.err.println("Пуль не может быть больше вместимости!");
            this.maxAmmo=ammo;
        }
        else {
            this.maxAmmo = maxAmmo;
        }
    }
    /**
     * Создает улучшенный пистолет с параметрами по умолчанию:
     * - начальные патроны: 5
     * - максимальная емкость: 10
     */
    public Pistol1up() {
        super(5);
        this.maxAmmo = 10;
    }


    /**
     * Переопределенный родительский метод для стрельбы
     */
    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        } else {
            System.out.println("Клац! ");
        }
    }

    /**
     * Полностью разряжает пистолет
     * @return количество извлеченных патронов
     */
    public int unload() {
        int back = this.ammo;
        this.ammo = 0;
        return back;
    }
    /**
     * Перезаряжает пистолет
     * @param bullets количество патронов для зарядки
     * @return количество патронов, которые не поместились
     */
    public int reload(int bullets) {
        if (bullets < 0){
            System.err.println("Нельзя зарядить отрицательное количество патронов.");
            return 0;
        }

        int freeSpace = maxAmmo - ammo;
        int bulletsToLoad = Math.min(bullets, freeSpace);

        ammo += bulletsToLoad;
        return bullets - bulletsToLoad;
    }

    /**
     * Метод для вывода информации
     */
    public String toString() {
        if ((ammo > 19 || ammo < 11) && (ammo % 10 == 1)) {
            return "пистолет с " + ammo + " патроном";
        } else {
            return "пистолет с " + ammo + " патронами";
        }
    }
    /**
     * @return true если пистолет заряжен, false если нет
     */
    public boolean isLoaded() {
        return ammo > 0;
    }
}