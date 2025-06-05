package ru.seduhin.mas;
import java.util.Arrays;
import java.util.List;

/**
 * Класс для работы с неизменяемыми массивами целых чисел.
 * Предоставляет основные операции для работы с массивами.
 */
public class Array {
    private final int[] mas;
    /**
     * @return размер массива
     */
    public int size() {
        return mas.length;
    }
    /**
     * Создает массив из переданных значений
     * @param mas элементы массива
     */
    public Array(int... mas) {
        this.mas = Arrays.copyOf(mas, mas.length);
    }

    /**
     * Создает массив из списка целых чисел
     * @param mas список целых чисел
     */
    public Array(List<Integer> mas) {
        if (mas == null) {
            System.err.println("Ошибка: передан null вместо списка. Создан пустой массив.");
            this.mas = new int[0];
        } else {
            this.mas = mas.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    /**
     * Получает элемент по индексу
     * @param index индекс элемента
     * @return значение элемента
     */
    public int get(int index) {
        if (index < 0 || index >= mas.length) {
            System.err.println("Ошибка: индекс " + index + " выходит за границы массива");
            return 0;
        }
        return mas[index];
    }
    /**
     * Создает новый массив с измененным элементом
     * @param index индекс изменяемого элемента
     * @param newValue новое значение
     * @return новый массив с изменением
     */
    public Array set(int index, int newValue) {
        if (index < 0 || index >= mas.length) {
            System.err.println("Неверный индекс: " + index);
        }
        int[] newmas = Arrays.copyOf(mas, mas.length);
        newmas[index] = newValue;
        return new Array(newmas);
    }
    /**
     * @return строковое представление массива
     */
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
    /**
     * @return true если массив пустой, false в противном случае
     */
    public boolean isEmpty() {
        return mas.length == 0;
    }



    /**
     * @return копию внутреннего массива
     */
    public int[] toArray() {
        return Arrays.copyOf(mas, mas.length);
    }
}