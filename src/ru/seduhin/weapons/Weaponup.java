package ru.seduhin.weapons;
public abstract class Weaponup {
    protected int ammo;

    public int getAmmo() {
        return ammo;
    }

    public Weaponup(int ammo) {
        if (ammo < 0) throw new IllegalArgumentException("Количество патронов должно быть неотрицательным.");
        this.ammo = ammo;
    }

    public abstract void shoot();

    public int load(int ammo) {
        if (ammo < 0) throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов.");
        this.ammo = ammo;
        return this.ammo;
    }



    public boolean isLoaded() {
        return ammo > 0;
    }
}
