package ru.surname.weapons;
public class pistolet {
    private int kol;
    final int maxkol;

    int setKol(int kol){
        this.kol=kol;
        return this.kol;
    }
    int getpul(){
        return this.kol;
    }
    int getMaxKol() {
        return this.maxkol;
    }

    pistolet(int kol, int maxkol) {
        this.kol = kol;
        this.maxkol=maxkol;
    }

    public int reload(int bullets) {
        if (bullets < 0) {
            throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов");
        }
        int free = maxkol - kol;
        if (bullets > free) {
            this.kol = this.maxkol;
            return bullets - free;
        } else {
            this.kol += bullets;
            return 0;
        }
    }
    public String isLoaded() {
        return kol > 0 ? "Пистолет заряжен" : "Пистолет разряжен";
    }
    public int unload() {
        int back = this.kol;
        this.kol = 0;
        return back;
    }

    public void strelba(int n) {
        for (int i = 0; i < n; i++) {
            if (this.kol>0){
                System.out.println("Бах!");
                this.kol--;
            }
            else{
                System.out.println("Клац!");
            }

        }
    }
    public String toString(){
        if ((this.kol>19 || this.kol<11) && (this.kol%10==1))
            return "пистолет с " + this.kol + " патроном";
        else
            return "пистолет с " + this.kol + " патронами";
    }
}
