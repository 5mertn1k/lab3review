package ru.seduhin.weapons;
public class Pistolet1up extends Weaponup {
    final int maxAmmo;

    public int getMaxAmmo() {
        return maxAmmo;
    }

    public Pistolet1up(int ammo, int maxAmmo) {
        super(ammo);
        if (maxAmmo <= 0) throw new IllegalArgumentException("Максимальная вместимость должна быть положительным числом.");
        if (ammo > maxAmmo) throw new IllegalArgumentException("Пуль не может быть больше вместимости!");
        this.maxAmmo = maxAmmo;
    }

    public Pistolet1up() {
        super(5);
        this.maxAmmo = 10;
    }



    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            ammo--;
        } else {
            System.out.println("Клац! ");
        }
    }
    public int unload() {
        int back = this.ammo;
        this.ammo = 0;
        return back;
    }
    public int reload(int bullets) {
        if (bullets < 0) throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов.");

        int freeSpace = maxAmmo - ammo;
        int bulletsToLoad = Math.min(bullets, freeSpace);

        ammo += bulletsToLoad;
        return bullets - bulletsToLoad;
    }


    public String toString() {
        if ((ammo > 19 || ammo < 11) && (ammo % 10 == 1)) {
            return "пистолет с " + ammo + " патроном";
        } else {
            return "пистолет с " + ammo + " патронами";
        }
    }

    public boolean isLoaded() {
        return ammo > 0;
    }
}