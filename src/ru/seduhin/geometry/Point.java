/* Продолжение задания №7 */
package ru.seduhin.geometry;

/**
 * Класс, представляющий точку в двумерном пространстве.
 * Содержит координаты x и y, методы сравнения и преобразования в строку.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Создает точку с указанными координатами
     * @param x координата по оси X
     * @param y координата по оси Y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Сравнивает текущую точку с другим объектом
     * @param obj объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    /**
     * @return строковое представление точки в формате {x; y}
     */
    public String toString() {
        return "{" + x + "; " + y + "}";
    }
}