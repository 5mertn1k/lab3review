package ru.surname.weapons;
public class Avtomat extends pistolet {
    final int speed;

    int getspeed() {
        return speed;
    }
    
    Avtomat() {
        super(0, 30);
        this.speed = 30; 
    }

    Avtomat(int maxAmmo) {
        super(0, maxAmmo);
        this.speed = maxAmmo / 2;
    }


    Avtomat(int maxAmmo, int speed) {
        super(0, maxAmmo);
        if (speed <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительной.");
        }
        this.speed = speed;
    }


    @Override
    public void strelba(int n) {
        int shots = n * speed;
        for (int i = 0; i < shots; i++) {
            if (getpul() > 0) {
                System.out.println("Бах!");
                setKol(getpul() - 1);
            } else {
                System.out.println("Клац!");
            }
        }
    }


    public void strelbaNSeconds(int seconds) {
        if (seconds <= 0) {
            throw new IllegalArgumentException("Количество секунд должно быть положительным.");
        }
        strelba(seconds);
    }

    @Override
    public String toString() {
        if ((getpul()>19 || getpul()<11) && (getpul()%10==1))
            return "пистолет с " + getpul() + " патроном, скорострельностью "+speed;
        else
            return "пистолет с " + getpul() + " патронами, скорострельностью "+speed;
    }
}

