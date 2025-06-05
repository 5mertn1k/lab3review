package ru.seduhin.weapons;

/**
 * Автоматическое оружие с заданной скорострельностью
 */
public class Automat extends Weapon {
    final int rateOfFire;

    /**
     * Создает автомат с указанными параметрами
     * @param ammo количество патронов
     * @param rateOfFire скорострельность (выстрелов в секунду)
     */
    public Automat(int ammo, int rateOfFire) {
        super(ammo);
        if (rateOfFire <= 0) {
            System.err.println("Ошибка: скорострельность должна быть положительной");
            this.rateOfFire = 1;
        } else {
            this.rateOfFire = rateOfFire;
        }
    }
    /**
     * Переопределённый родительский метод
     */
    @Override
    public void shoot() {
        int shots =this.rateOfFire;
        for (int i = 0; i < shots; i++) {
            if (getAmmo() ) {
                System.out.println("Бах!");
            }
             else {
                System.out.println("Клац!");
            }
        }
    }
}
