package ru.seduhin.dom;

/**
 * Класс, представляющий дом с определенным количеством этажей.
 * Обеспечивает корректное отображение информации о доме.
 */
public class Dom {
    final int floor;
    //    int setFloor(int floor){
//        this.floor=floor;// ошибка
//        return this.floor;
//    }
    /**
     * @return количество этажей в доме
     */
    int getFloor(){
        return this.floor;
    }

    /**
     * Создает дом с указанным количеством этажей
     * @param floor количество этажей (должно быть положительным)
     */
    public Dom(int floor){
        if (floor<0) {
            System.err.println("Ошибка: количество этажей не может быть отрицательным. Установлено значение 1.");
            this.floor=1;
        }
        else {
            this.floor = floor;
        }
    }
    /**
     * Определяет правильную форму слова "этаж" в зависимости от количества
     * @param x количество этажей
     * @return строку с правильной формой слова
     */
    public String slovo(int x){
        if ((x%100>=11 && x%100<=19) || (x%10!=1)){
            return "этажами";
        }
        else{
            return "этажом";
        }
    }
    /**
     * @return строковое представление дома с указанием количества этажей
     */
    public String toString(){
        return "дом с " + floor + " " + slovo(floor);
    }
}
