package ru.seduhin.weapons;
public class Automat extends Weapon {
    final int rateOfFire;

    public Automat(int ammo, int rateOfFire) {
        super(ammo);
        if(ammo<0){
            throw new IllegalArgumentException("Количество пуль должно быть неотрицаельным.");
        }
        if (rateOfFire <= 0) throw new IllegalArgumentException("Скорострельность должна быть положительной!");
        this.rateOfFire = rateOfFire;
    }

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
