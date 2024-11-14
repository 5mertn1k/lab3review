package ru.seduhin.geometry;
public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }


    public String toString() {
        return "{" + x + "; " + y + "}";
    }
}