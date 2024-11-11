package ru.surname.weapons;
public class Pistolet1 extends Weapon {
    final int maxAmmo;

    public int getMaxAmmo() {
        return maxAmmo;
    }

    Pistolet1(int ammo, int maxAmmo) {
        super(ammo);
        if (maxAmmo <= 0 )
            throw new IllegalArgumentException("Максимальная вместимость должна быть положительным числом.");
        if (ammo<0){
            throw new IllegalArgumentException("Количество пуль должно быть неотрицательным. ");
        }
        if (ammo>maxAmmo){
            throw new IllegalArgumentException("Пуль не может быть больше вместимости!");
        }

        this.maxAmmo = maxAmmo;
    }

    Pistolet1() {
        super(5);
        this.maxAmmo = 10;
    }

    @Override
    public void shoot() {

        if (getAmmo()) {
            System.out.println("Бах!");
        } else {
            System.out.println("Клац! ");
        }
    }

    public int reload(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов.");
        }
        int free = maxAmmo - ammo();
        int addedBullets = Math.min(bullets, free);

        load(ammo() + addedBullets);
        return bullets - addedBullets;
    }

    @Override
    public String toString() {
        int currentAmmo = ammo();
        if ((currentAmmo>19 || currentAmmo<11) && (currentAmmo%10==1))
            return "пистолет с " + currentAmmo + " патроном";
        else
            return "пистолет с " + currentAmmo + " патронами";
    }


    public boolean isLoaded() {
        return ammo() > 0;
    }
}
