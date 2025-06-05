package ru.seduhin.weapons;
/**
 * Абстрактный класс улучшенного оружия с базовой функциональностью.
 * Предоставляет основные методы для работы с боеприпасами.
 */
public abstract class Weaponup {
    protected int ammo;

    /**
     * Получает текущее количество патронов
     * @return количество патронов
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * Конструктор улучшенного оружия
     * @param initialAmmo начальное количество патронов
     */
    public Weaponup(int initialAmmo) {
        if (initialAmmo < 0) {
            System.err.println("Ошибка: количество патронов не может быть отрицательным");
            this.ammo = 0;
        } else {
            this.ammo = initialAmmo;
        }
    }
    /**
     * Абстрактный метод для произведения выстрела
     */
    public abstract void shoot();

    /**
     * Загружает указанное количество патронов
     * @param newAmmo количество патронов для загрузки
     * @return фактически загруженное количество патронов
     */
    public int load(int newAmmo) {
        if (newAmmo < 0) {
            System.err.println("Ошибка: нельзя зарядить отрицательное количество патронов");
            return ammo;
        }
        this.ammo = newAmmo;
        return ammo;
    }



    /**
     * Проверяет, заряжено ли оружие
     * @return true если есть патроны, false если нет
     */
    public boolean isLoaded() {
        return ammo > 0;
    }
}
