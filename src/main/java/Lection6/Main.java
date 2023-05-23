package Lection6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        createSets();
        /* Напишите метод, который заполнить массив из 1000 эл-тов
        случайными цифрами от 0 до 24.
        Создайте метод, в который передайте заполненный массив
        С помощь Set вычислите % уникальных значений в массиве
        Верните его в виде числа с плавающей запятой

        %уникальных чисел = их кол-во * 100 / кол-во эл-тов массива
         */
//        task1();
//        int[] array = task1();
//        System.out.println(persentUniqueEl(array));
        /*
        1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
        а) информационной системой ветеринарной клиники
        б) архивом выставки котов
        в) информационной системой Театра кошек Ю. Д. Куклачёва
        Можно записать в текстовом виде, не обязательно реализовывать в java.
         */
        Cat cat1 = new Cat("Scotish", "Vaska", 2, 4, true, "Petya Ivanov");
        Cat cat2 = new Cat("Persian", "Mashka", 3, 5, false, "Petya Ivanov");
        Cat cat3 = new Cat("Persian", "Mashka", 3, 5, false, "Petya Ivanov");
        VetCat cat4 = new VetCat("Persian", "Mashka", 3, 6, false, "Petya Ivanov",
                "First reception", true);
        TheaterCat cat5 = new TheaterCat("Persian", "Mishka", 3, 6, false,
                "Petya Ivanov", "Jump");
        CatShow cat6 = new CatShow("Persian", "Moshka", 3, 6, false,
                "Petya Ivanov", "grey", "Ann", "Don", 6, 1,
                "beauty");

        Set<Cat> cats = new HashSet<>(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));
        for (Cat oneCat : cats) {
            System.out.println(oneCat);
        }

//        System.out.println(cat1.toString());
//        System.out.println(cat2.toString());
//        System.out.println(cat3.toString());
//        System.out.println(cat4.toString());
//        System.out.println(cat5.toString());
//        System.out.println(cat6.toString());

        System.out.println(cat2 == cat3);
        System.out.println(cat2.equals(cat3));
    }

    public static int[] task1() {

        int[] arr = new int[1000];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(25);
        }

//        for (int a: arr) {
//            System.out.print(a + " ");
//        }

        return arr;
    }

    private static double persentUniqueEl (int[] ourArr) {
        Set<Integer> uniqueValues = new HashSet<Integer>();

        for (int a: ourArr) {
            uniqueValues.add(a);
        }
        int setLength = uniqueValues.size();
        int arrLength = ourArr.length;
        double persentUniqueEl = setLength * 100.0 / arrLength;
        return persentUniqueEl;
    }

    private static void createSets() {
        Set<Integer> set = new HashSet<>(Arrays.asList(7, 1, 2, 3, 4, 5, 6, 3));
        System.out.println("\nНаш хэшсет: ");
        for (int a:set) {
            System.out.print(a + " ");
        }
        Set<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(7, 1, 2, 3, 4, 5, 6, 3));
        System.out.println("\nНаш линкдхэшсет: ");
        for (int b:linkedHashSet) {
            System.out.print(b + " ");
        }
        Set<Integer> treeset = new TreeSet<>(Arrays.asList(07, 1, 2, 3, 4, 5, 6, 3));
        System.out.println("\nНаш трисет: ");
        for (int c : treeset) {
            System.out.print(c + " ");
        }
    }

}
