/* Продолжение задания №3 */
package ru.seduhin.mas;
import java.util.Arrays;
import java.util.List;

/**
 * Класс для работы с неизменяемыми массивами целых чисел.
 * Предоставляет основные операции для работы с массивами.
 */
public class Array {
    private final int[] elements;
    /**
     * @return размер массива
     */
    public int size() {
        return elements.length;
    }
    /**
     * Создает массив из переданных значений
     * @param elements элементы массива
     */
    public Array(int... elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    /**
     * Создает массив из списка целых чисел
     * @param elements список целых чисел
     */
    public Array(List<Integer> elements) {
        if (elements == null) {
            System.err.println("Ошибка: передан null вместо списка. Создан пустой массив.");
            this.elements = new int[0];
        } else {
            this.elements = elements.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    /**
     * Получает элемент по индексу
     * @param index индекс элемента
     * @return значение элемента
     */
    public int get(int index) {
        if (index < 0 || index >= elements.length) {
            System.err.println("Ошибка: индекс " + index + " выходит за границы массива");
            return 0;
        }
        return elements[index];
    }
    /**
     * Создает новый массив с измененным элементом
     * @param index индекс изменяемого элемента
     * @param newValue новое значение
     * @return новый массив с изменением
     */
    public Array set(int index, int newValue) {
        if (index < 0 || index >= elements.length) {
            System.err.println("Неверный индекс: " + index);
        }
        int[] newarray = Arrays.copyOf(elements, elements.length);
        newarray[index] = newValue;
        return new Array(newarray);
    }
    /**
     * @return строковое представление массива
     */
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < elements.length; i++) {
            builder.append(elements[i]);
            if (i < elements.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }
    /**
     * @return true если массив пустой, false в противном случае
     */
    public boolean isEmpty() {
        return elements.length == 0;
    }



    /**
     * @return копию внутреннего массива
     */
    public int[] toArray() {
        return Arrays.copyOf(elements, elements.length);
    }
}