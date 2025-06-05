/* Продолжение задания №2 */
package ru.seduhin.weapons;

/**
 * Класс, представляющий пистолет с ограниченной емкостью магазина.
 * Реализует базовые операции: стрельба, перезарядка, проверка состояния.
 */
public class Pistol {
    private int bullets;
    private final int maxcount;

    /**
     * Устанавливает текущее количество патронов
     /* @param count новое количество патронов
     * @return фактически установленное количество патронов
     */
    public int setCount(int count){
        this.bullets =count;
        return this.bullets;
    }
    /**
     * @return текущее количество патронов
     */
    public int getBullets(){
        return this.bullets;
    }
    /**
     * @return максимальную емкость магазина
     */
    public int getMaxKol() {
        return this.maxcount;
    }

    /**
     * Создает пистолет с указанным количеством патронов и емкостью магазина
     /* @param bullets начальное количество патронов
     /* @param maxcount максимальная емкость магазина
     */
    public Pistol(int bullets, int maxcount) {
        this.bullets = bullets;
        this.maxcount = maxcount;
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
        int free = maxcount - this.bullets;
        if (bullets > free) {
            this.bullets = this.maxcount;
            return bullets - free;
        } else {
            this.bullets += bullets;
            return 0;
        }
    }
    /**
     * Проверяет, заряжен ли пистолет
     * @return строку с состоянием пистолета
     */
    public String isLoaded() {
        return bullets > 0 ? "Пистолет заряжен" : "Пистолет разряжен";
    }
    /**
     * Разряжает пистолет
     * @return количество извлеченных патронов
     */
    public int unload() {
        int back = this.bullets;
        this.bullets = 0;
        return back;
    }
    /**
     * Производит выстрелы
     * @param n количество выстрелов
     */
    public void shoot(int n) {
        for (int i = 0; i < n; i++) {
            if (this.bullets >0){
                System.out.println("Бах!");
                this.bullets--;
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
        if ((this.bullets >19 || this.bullets <11) && (this.bullets %10==1))
            return "пистолет с " + this.bullets + " патроном";
        else
            return "пистолет с " + this.bullets + " патронами";
    }
}
