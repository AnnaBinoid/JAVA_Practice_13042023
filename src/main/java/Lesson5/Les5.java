package Lesson5;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Les5 {
    public static void main(String[] args) {
//        mapExample();
//        mapWithSize();
//        treeMap();
//        hashMap();
//        passpots();
        romanToArabic();

    }

    private static void mapExample() {
        Map<Integer,String> db = new HashMap<>();
        db.putIfAbsent(1, "один"); // с проверкой на наличие такого же ключа
        db.put(2, "два");
        db.put(null, "!null");
        System.out.println(db);
        System.out.println(db.get(44));
        db.remove(null);
        System.out.println(db);
        System.out.println(db.containsValue("один"));
        System.out.println(db.containsValue(1));
        System.out.println(db.containsKey(1));
        System.out.println(db.keySet());
        System.out.println(db.values());
        for (var item: db.entrySet()) {
            System.out.printf("[%d: %s]\n", item.getKey(), item.getValue());
        }
    }

    private static void mapWithSize() {
        Map<Integer, String> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>(9); // зная размер, ускорим
        Map<Integer, String> map3 = new HashMap<>(9, 1.0f); // второе знач в %соотношении -
        // сколько % хранилища дб заполнено, чтобы Мапа увеличилась
        //ПРОЙТИ ХЭШ-ФУНКЦИИ и ХЭШ-ТАБЛИЦЫ
        // ПРЯМОЕ СВЯЗЫВАНИЕ (ХЭШИРОВАНИЕ С ЦЕПОЧКАМИ)
        // ХЭШИРОВАНИЕ С ОТКРЫТОЙ АДРЕСАЦИЕЙ
        // ТЕОРИЯ АЛГОРИТМОВ - ТЕОРИЯ ГРАФОВ - ДИСКРЕТНАЯ МАТЕМАТИКА
    }

    private static void treeMap() { // Будут упорядочиваться по ключу ваще-то
        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(3, "tree");
        treeMap.put(10, "ass");
        System.out.println(treeMap);
        treeMap.remove(10);
        System.out.println(treeMap);
//        treeMap.descendingKeySet(V);
//        treeMap.descendingMap();
//        tailMap();
//        headMap();
//        lastEntry();
//        firstEntry();



    }

    private static void hashMap() { // помнит порядок добавления элементов, но работает медленнее
        // а hashTable не может хранить Null, но она устарела.
        // переопределил equals = переопредели хэшкод.
    }

    private static void passpots() {
        /*Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
123456 Иванов
321456 Васильев
234561 Петрова
234432 Иванов
654321 Петрова
345678 Иванов
Вывести данные по сотрудникам с фамилией Иванов.*/
        Map<String, String> employeeMap = new HashMap<>(20); // паспорта - не интежер, это неизменные данные
        employeeMap.put("1234", "Ivanov");
        employeeMap.put("4234", "Petrov");
        employeeMap.put("1254", "Sidorov");

        for (Map.Entry<String, String> entry : employeeMap.entrySet()){
            System.out.printf("%s\t->\t%s\n", entry.getKey(), entry.getValue());
        }

        for (String key : employeeMap.keySet()){
            System.out.printf("%s\t->\t%s%n", key, employeeMap.get(key));
        }

        employeeMap.forEach((key, value) -> {
            System.out.printf("%s\t->\t%s%n", key,value);
        });
        Map<Integer, String> testMap = Map.of(  // можно быстро создать Map но до 10 эл-тов и
                //неизменяемая. Добавлять можно, изменять - нет.
                12, "A",
                43, "B",
                10, "C"
        );
        Map<Integer, Integer> testMap2 = Map.ofEntries( // можно больше 10 эл-тов
                Map.entry(1, 001),
                Map.entry(2, 002),
                Map.entry(3, 003),
                Map.entry(4, 004),
                Map.entry(5, 005)
        );
    }

    private static void romanToArabic() {
        Map<Character, Integer> infoMap = new HashMap<>();
    }
}
