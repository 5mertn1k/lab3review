package ru.seduhin.weapons;


/**
 * Абстрактный класс оружия с базовой функциональностью
 */

public abstract class Weapon {
        private int ammo;

        /**
         * @return текущее количество патронов
         */
        public boolean getAmmo() {
            if(ammo==0) return false;
            ammo--;
            return true;
        }

        /**
         * Конструктор оружия
         * @param ammo количество патронов
         */
        public Weapon(int ammo) {
            if (ammo < 0) {
                System.err.println("Ошибка: количество патронов не может быть отрицательным");
                this.ammo = 0;
            } else {
                this.ammo = ammo;
            }
        }

        /**
         * Производит выстрел
         */
        public abstract void shoot();

        public int ammo() {
            return ammo;
        }


        /**
         * Загружает указанное количество патронов
         * @param ammo количество патронов для загрузки
         */
        public int load(int ammo) {
            if (ammo < 0) {
                System.err.println("Ошибка: нельзя загрузить отрицательное количество патронов");
                return 0;
            }
            else {
                int tmp = ammo;
                this.ammo = ammo;
                return tmp;
            }
        }


}
