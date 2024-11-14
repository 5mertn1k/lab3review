package ru.seduhin.dom;
public class Dom {
    final int floor;
    //    int setFloor(int floor){
//        this.floor=floor;// ошибка
//        return this.floor;
//    }
    int getFloor(){
        return this.floor;
    }

    public Dom(int floor){
        if (floor<0) {
            throw new IllegalArgumentException("<0");
        }
        this.floor=floor;
    }

    public String slovo(int x){
        if ((x%100>=11 && x%100<=19) || (x%10!=1)){
            return "этажами";
        }
        else{
            return "этажом";
        }
    }
    public String toString(){
        return "дом с " + floor + " " + slovo(floor);
    }
}
