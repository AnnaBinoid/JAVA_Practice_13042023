package Lection6;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class LectLes6 {


    public static void main(String[] args) {
        /* Set - только ключ без значения
    isEmpty() - пустой или нет
    add(V) - добавить эл-т
    remove(V) - удалить эл-т
    contains(V) - содержится ли эл-т в коллекции
    clear()- удалить все эл-ты
    size() - кол-во эл-тов
     */
    //    testSet();
        /* Работа с множествами.
         * addAll(Coll) - объединить множества
         * retainAll(Coll) - пересечение множества
         * removeAll(Coll) - разность множеств
         */
    //    testSetOperation();
        /*
        * first() - получить первый эл-т
        * last() - получить последний эл-т
        * headSet(E) - новый set, в котором эл-ты до заданного значения, не включая эл-т
        * tailSet(E) - новый set, в котором эл-ты больше или равны заданному значению
        * subSet(E1, E2) - новый set с эл-тами больше или равно 1й параметр и меньше 2 параметра
        * */
    //    testTreeSet(); // в основе HashMap, упорядочен по возр, не может содеражть null
                       // -- LinkesHashSet - сохраняется порядок добавления
        // Клиентский код будет вызывать, менять, работать с классом Worker
        Worker w1 = new Worker(); //(правая часть - конструктор)
        w1.firstname = "Name_1";
        w1.lastname = "Lastname_1";
        w1.salary = 100;
        w1.id = 1_000;

        Worker w4 = new Worker();
        w4.firstname = "Name_1";
        w4.lastname = "Lastname_1";
        w4.salary = 100;
        w4.id = 1_000;

        Worker w2 = new Worker();
        w2.firstname = "Name_2";
        w2.lastname = "Lastname_2";
        w4.salary = 200;
        w4.id = 1_000;

        Worker w3 = new Worker();
        w3.firstname = "Name_3";
        w3.lastname = "Lastname_3";
        w3.salary = 300;
        w3.id = 3_000;

        System.out.println(w1.equals(w1));
        System.out.println(w1 == w4);
        System.out.println(w3);

        var workers = new HashSet<Worker>(Arrays.asList(w1, w2, w3));
        System.out.println(workers.contains(w4));

        System.out.println(w1.toString());
        System.out.println(w4.toString());

        System.out.println(w1.equals(w4));  //да, т.к. переопредилили
        System.out.println(w1 == w4);  //нет


    }

    private static void testSet() {
        Set<Integer> set = new HashSet<>();
        set.add(1);set.add(12);set.add(123);set.add(1234);set.add(1234);
        System.out.println(set);
        set.remove(1234);
        System.out.println(set);
        System.out.println(set.contains(13));
        System.out.println(set.size());
        set.add(null);
        System.out.println(set.isEmpty());
        System.out.println(set);
        for (var item:set) {
            System.out.println(item);
        }
        set.clear();
        System.out.println(set);

    }


    /* Работа с множествами.
    * addAll(Coll) - объединить множества
    * retainAll(Coll) - пересечение множества
    * removeAll(Coll) - разность множеств
    */
    private static void testSetOperation() {
        var a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        var b = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17));
        var u = new HashSet<>(a);
        u.addAll(b);
        var r = new HashSet<Integer>(a);
        r.retainAll(b);
        var s = new HashSet<Integer>(a);
        s.removeAll(b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(u);
        System.out.println(r);
        System.out.println(s);
        boolean res = a.addAll(b);
        System.out.println(res);
    }

    private static void testTreeSet() {


    }

}
