package ru.seduhin.mas;
import java.util.Arrays;
import java.util.List;

public class Massiv {
    final int[] mas;


    // с независимыми значениями (через запятую) или массивом
    public Massiv(int... mas) {
        this.mas = Arrays.copyOf(mas, mas.length);
    }

    //  с другим списком
    public Massiv(List<Integer> mas) {
        this.mas = mas.stream().mapToInt(Integer::intValue).toArray();
    }


    public int get(int index) {
        if (index < 0 || index >= mas.length) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        return mas[index];
    }

    public Massiv set(int index, int newValue) {
        if (index < 0 || index >= mas.length) {
            throw new IndexOutOfBoundsException("Неверный индекс: " + index);
        }
        int[] newmas = Arrays.copyOf(mas, mas.length);
        newmas[index] = newValue;
        return new Massiv(newmas);
    }

    public String toString() {
        StringBuilder qw = new StringBuilder("[");
        for (int i = 0; i < mas.length; i++) {
            qw.append(mas[i]);
            if (i < mas.length - 1) {
                qw.append(", ");
            }
        }
        qw.append("]");
        return qw.toString();
    }

    public boolean isEmpty() {
        return mas.length == 0;
    }


    public int size() {
        return mas.length;
    }

    public int[] toArray() {
        return Arrays.copyOf(mas, mas.length);
    }
}