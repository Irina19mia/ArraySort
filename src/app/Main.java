package app;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {51, 6, 87, 33, 42, 13, 24, 27, 6, 3, 67, 30, 58, 17, 48};

        System.out.println("Початковий вигляд масиву: " + Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {
            // Беремо 2й елемент за ключ
            int key = array[i];
            int j = i - 1;

            // Знаходження елементу меншого ніж ключ і перестановка
            while (j >=0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }

            // Після знаходження елементу меншого ніж ключ
            array[j + 1] = key;
        }
        System.out.println("Відсортований масив: " + Arrays.toString(array));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть число для пошуку");

        int search = scanner.nextInt();

        int index = -1;
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            // Середній індекс масиву
            int mid = (low + high) / 2;

            if (array[mid] == search) {
                index = mid;
                break;

            // Якщо значення лежить в лівій частині масиву
            } else if (array[mid] > search) {
                high = mid - 1;

            // Якщо значення лежить в правій частині масиву
            } else {
                low = mid + 1;
            }
        }

        if (index == -1) {
            System.out.printf("Число %d не знайдено в масиві!", search);
        } else {
            System.out.printf("Індекс числа %d у відсортованому масиві: %d", search, index);
        }
    }
}
