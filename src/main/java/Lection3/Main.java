package Lection3;

import com.sun.source.doctree.SummaryTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Коллекции
//        ObjectType();
//        ObjectForDiffTypes();
//        ObjectInArrays(); // можно взять чуть-чуть побольше, чтобы быть уверенными, при каждом добавлении даже 1
//        элемента, массив увеличивается в 2 раза.
//        collectionTestDrive();
//        arrayOfDates();
        ourIterator();


    }

    private static void ObjectType() {
        // Object - тот еще ТИП данных, всей JAVA голова, т.е.он в иерархии ВЫШЕ всех типов, кстати. Туда можно ЗАПАКОВАТЬ что угодно.
        Object o = 1;
        GetType(o);
        o = "1.2";
        GetType(o);
    }

    private static void GetType(Object obj) {
        System.out.println(obj.getClass().getName()); // getName() - то же без class
    }

    private static void ObjectForDiffTypes() {
        System.out.println(Sum(1, 2));
        System.out.println(Sum(1.0, 2));
        System.out.println(Sum(1, 2.0));
        System.out.println(Sum(1.0, 2.0));
        System.out.println(Sum("Пихну-ка я", "the String"));
    }

    static Object Sum(Object a, Object b) {
        if (a instanceof Double && b instanceof Double) {
            return (Object) ((Double) a + (Double) b); // возвращаем Object не обязательно, но так грамотней.
        } else if (a instanceof Integer && b instanceof Integer) {
            return (Object) ((Integer) a + (Integer) b);
        } else if (a instanceof String && b instanceof String) {
            String s = "Ты ещё сюда верблюда запихай!";
            return (Object) (s);
        } else return 0;
    }



    // Два варианта решения
    static int[] AddItem(int[] array, int item) {
        int length = array.length;
        int[] temp = new int[length + 1];
        System.arraycopy(array, 0, temp, 0, length);
        temp[length] = item;
        return temp;
    }

    private static void ObjectInArrays() {
        //Есть массив из 2 элементов. Как увеличить размер массива?
        /*int[] a = new int[]{1, 9};
        int[] b = new int[3];
        System.arraycopy(a, 0, b, 0, a.length); // копируем массив
        for (int i: a) { System.out.printf("%d", i);}
        System.out.println("\n");
        for (int j: b) { System.out.printf("%d", j);}*/
        int[] arr = new int[]{1, 2};
        int num = 5;
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
        arr = AddItem(arr, 2);
        System.out.println("\n");
        for (int k : arr) {
            System.out.printf("%d ", k);}
        arr = AddItem(arr, 3);
        System.out.println("\n");
        for (int j : arr) {
            System.out.printf("%d ", j);
        }
    }
    private static void collectionTestDrive() {
        //ArrayList, LinkedList (Vector, Stack - устаревшие) <это обобщение>
        //ArrayList<Integer> list1 = new ArrayList<Integer>();
        //ArrayList<Integer> list2 = new ArrayList<>();
       //ArrayList<Integer> list3 = new ArrayList<>(10); // изначально выделено место под 10 эл-тов
        //ArrayList<Integer> list4 = new ArrayList<>(list3);
        ArrayList<Integer> arrList = new ArrayList<>(); // new - не только оператор, но и конструктор
        arrList.add(10); // сырые типы - это неявное преобразование к Object, мы же не задали конкретно int
        arrList.add(20);
        arrList.add(0,30);
        arrList.add(40);
        arrList.add(50);
        arrList.add(60);
        arrList.add(70);
        arrList.add(50);
//        System.out.println(arrList.size());
//        System.out.println("\n");
//        System.out.println(arrList.get(3));
//        System.out.println(arrList.indexOf(80)); // первое вхождение или -1
//        System.out.println(arrList.lastIndexOf(50)); // последнее вхождение или -1
//        arrList.remove(6);  // удаление по индексу
        arrList.set(0,100);  // помещает на индекс значение

        arrList.sort(Comparator.naturalOrder());
        System.out.println(arrList.subList(1, 5)); // получение от позиции старт до финиш

        for (Object i: arrList) {
            System.out.println(i);
        }

    }

    private static void arrayOfDates() {
        int day = 27;
        int month = 3;
        int year = 1986;
//        Integer[] date = {day, month, year};
//        List<Integer> d = Arrays.asList(date);  // на основе массива формируем коллекцию
//        System.out.println(d);
        StringBuilder sb = new StringBuilder();
        StringBuilder dateStr = new StringBuilder("27");
        StringBuilder monthStr = new StringBuilder("3");
        StringBuilder yearStr = new StringBuilder("1986");
        StringBuilder[] dateNew = new StringBuilder[]{dateStr, monthStr, yearStr};
        List<StringBuilder> ourDate = Arrays.asList(dateNew);
        System.out.println(ourDate);
        dateNew[2] = new StringBuilder("2015");
        System.out.println(ourDate);
//        dateStr.append(" 28");
//        monthStr.append(" 02");
        yearStr.append(" 2020");
        System.out.println(ourDate);
//        ourDate.clear(); // очистка списка
        System.out.println(ourDate);
        String arrMonth = monthStr.toString(); //список в строку
        System.out.println(arrMonth);
        System.out.println(ourDate);
        System.out.println(ourDate.contains(dateStr)); // есть ли в одной коллекции другая
    }

    private static void ourIterator() {

    }
}
