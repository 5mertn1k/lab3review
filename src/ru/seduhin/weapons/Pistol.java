package ru.seduhin.weapons;

/**
 * Класс, представляющий пистолет с ограниченной емкостью магазина.
 * Реализует базовые операции: стрельба, перезарядка, проверка состояния.
 */
public class pistolet {
    private int kol;
    private final int maxkol;

    /**
     * Устанавливает текущее количество патронов
     /* @param kol новое количество патронов
     * @return фактически установленное количество патронов
     */
    public int setKol(int kol){
        this.kol=kol;
        return this.kol;
    }
    /**
     * @return текущее количество патронов
     */
    public int getpul(){
        return this.kol;
    }
    /**
     * @return максимальную емкость магазина
     */
    public int getMaxKol() {
        return this.maxkol;
    }

    /**
     * Создает пистолет с указанным количеством патронов и емкостью магазина
     /* @param initialAmmo начальное количество патронов
     /* @param maxCapacity максимальная емкость магазина
     */
    public pistolet(int kol, int maxkol) {
        this.kol = kol;
        this.maxkol=maxkol;
    }
    /**
     * Перезаряжает пистолет
     * @param bullets количество патронов для зарядки
     * @return количество патронов, которые не поместились в магазин
     */
    public int reload(int bullets) {
        if (bullets < 0) {
            System.err.println("Нельзя зарядить отрицательное количество патронов");
            return 0;
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
    /**
     * Проверяет, заряжен ли пистолет
     * @return строку с состоянием пистолета
     */
    public String isLoaded() {
        return kol > 0 ? "Пистолет заряжен" : "Пистолет разряжен";
    }
    /**
     * Разряжает пистолет
     * @return количество извлеченных патронов
     */
    public int unload() {
        int back = this.kol;
        this.kol = 0;
        return back;
    }
    /**
     * Производит выстрелы
     * @param n количество выстрелов
     */
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
    /**
     *Метод для вывода
     */
    public String toString(){
        if ((this.kol>19 || this.kol<11) && (this.kol%10==1))
            return "пистолет с " + this.kol + " патроном";
        else
            return "пистолет с " + this.kol + " патронами";
    }
}
