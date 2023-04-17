package HomeWork01;

import java.util.Scanner;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
//        CreateArrWithLengtAndInitialValue(5, 7);
//        MinMaxElemInArray();
//        TwoDemArrayWith1Diagonal(9);
//        GoodDayTimeForUser();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        ShiftArrayOnNPosition(array, -2);
    }

    /*1. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int
     длиной len, каждая ячейка которого равна initialValue;*/

    private static void CreateArrWithLengtAndInitialValue(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i : arr) {
            arr[i] = initialValue;
            System.out.printf("%s ", arr[i]);
        }
    }



    // 2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    private static void MinMaxElemInArray() {
        int[] array = new int[]{3, 7, -10, 12, 1, 500, -7};
        int minValue = 0;
        int maxValue = 0;

        for (int i : array) {

            if (i < minValue) {
                minValue = i;
            } else if (i > maxValue) {
                maxValue = i;
            }
        }
        System.out.printf("Minimal value in array is: %s.%nMaximal value in array is: %s .", minValue, maxValue);
    }

/*3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
 заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы
  одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
   то есть [0][0], [1][1], [2][2], …, [n][n];
   1 0 0 0 0 1
   0 1 0 0 1 0
   0 0 1 1 0 0
   0 1 0 0 1 0
   1 0 0 0 0 1
   */

    private static void TwoDemArrayWith1Diagonal(int arrSize) {
        int[][] arr = new int[arrSize][arrSize];
        for (int i = 0; i <= arrSize - 1; i++) {
            for (int j = 0; j <= arrSize - 1; j++) {
                if ((i == j) || (j == (arrSize - 1 - i))) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.printf("%s ", arr[i][j]);
            }
            System.out.println();
        }
    }

    /*4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
     "Доброе утро, <Имя>!", если время от 05:00 до 11:59
      "Добрый день, <Имя>!", если время от 12:00 до 17:59;
     "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
     "Доброй ночи, <Имя>!", если время от 23:00 до 4:59*/
    private static void GoodDayTimeForUser() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name? ");
        String userName = scan.nextLine();

        int time = LocalTime.now().getHour();

        if (time >= 5 && time < 12) {
            System.out.printf("Good morning, %s!", userName);
        } else if (time >= 12 && time < 18) {
            System.out.printf("Good afternoon, %s!", userName);
        } else if (time >= 18 && time < 23) {
            System.out.printf("Good evening, %s!", userName);
        } else {
            System.out.printf("Good night, %s!", userName);
        }
    }

/* 5.** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются
 циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
  Примеры:
  [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
   При каком n в какую сторону сдвиг можете выбирать сами.
 */

    private static void ShiftArrayOnNPosition(int arr[], int n) {
        int temp = 0;
        int arrSize = arr.length - 1;
        int index = 0;

        for (int i : arr) {
            System.out.printf("%s ", i);
        }


        if (n > 0) {
            while (index < n) {
                for (int i = 0; i < arrSize; i++) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
                index++;
            }
        }
        else {
            while (index > n){
                for (int j = arrSize; j > 0; j--){
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
                index--;

            }
        }

        System.out.println(" ");
        for (int i : arr) {
            System.out.printf("%s ", i);
        }
    }
}

