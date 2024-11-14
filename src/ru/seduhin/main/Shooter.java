package ru.seduhin.main;
import ru.seduhin.weapons.Weapon;

class Shooter {
    private String name;
    private Weapon weapon;

    public Shooter(String name, Weapon weapon) {
        this.name = name;
        this.weapon=weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        if (weapon != null) {
            System.out.println(name + " стреляет: ");
            weapon.shoot();
        } else {
            System.out.println(name + ": не могу участвовать в перестрелке");
        }
    }
}
