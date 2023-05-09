/*package Lection4; // + семинар4

import java.util.*;
import java.util.regex.Pattern;
// package com.gbjava.seminar04;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Lect4 {
    public static void main(String[] args) {
//  ПРИОРИТЕТНЫЕ КОЛЛЕКЦИИ

//        linkedListCollection();
//        queueCollection();
//        stackColl();
        // Collections.addAll(напихай все, что угодно)
        // new ArrayList(Arrays.asList([])
        // ArrayList<>(List.of( - создание неизменяемой коллекции в принципе
//        ex(0);
//        collectionFromString();

    }

    private static void linkedListCollection() {
        // если больше удалений/добавлений, чем чтений - нужен LinkedList
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
    }

    private static void queueCollection() {
//        java.util.NoSuchElementException;
        //first in first out = очередь в магазе
/*        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(4);
        int item = queue.remove(); // удаляется первый добавленный
        Priority Queue:
        */
/*        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(123);
        pq.add(3);
        pq.add(13);
        pq.add(1);
        System.out.println(pq); // высший приоритет у наименьшего значения

        //DEQUEUE

        Deque<Integer> deque = new ArrayDeque<>();
//        deque.addFirst();
        deque.removeFirst();
//        deque.offerFirst();
//        deque.offerFirst();
        deque.pollFirst();
        deque.getFirst();
        deque.peekFirst();
        // и ласт

    }

    private static void stackColl() {
//        Первый пришел - последним вышел
        // Вычислить значение выражения в постфиксной форме записи
        // Обратная польская запись - ?
//        1+2*3 (1+2)*3
//        123*+    12+3*
    }

    private static void ex(int i) {
        final int SIZE = 100_000;
        Random random = new Random();

        List<Integer> linkedList = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int j = 0; j < SIZE; j++) {
            linkedList.add(0, random.nextInt());
        }
        System.out.println("Linked: " + (System.currentTimeMillis() - start));

        List<Integer> arrayList = new ArrayList<>(SIZE);
        start = System.currentTimeMillis();
        for (int k = 0; k < SIZE; k++) {
            arrayList.add(0, random.nextInt());
        }
        System.out.println("ArrayList: " + +(System.currentTimeMillis() - start));
        // Практически всегда используйте ArrayList
    }

    private static void collectionFromString() {
/*        Реализовать консольное приложение, которое:
        1. Принимает от пользователя строку вида text~num
        2. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
        3. Если введено print~num, выводит строку из позиции num в связном списке
        и удаляет её из списка.
        4. Продумать систему добавления элементов на индексы, превышающие размер
        5. Добавить проверки ввода
        6. Добавить еще команд на выбор */



 /*       public class Examples {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                LinkedList<String> linkedList = new LinkedList<>();
                //#6 - filter input
                //SSSS~NNN - true
                //SSS#~NNN - true
                //NNN~NNN - true
                //SSSS~SSS - fase
                //SSS~~NNN
                //^[A-Z]{.}~\d{.} - true$
//        String regex = "^(?i)[A-Z]{3,}~\\d{3,} - true$";
//        boolean matches = Pattern.matches(regex, tmpValue);
//        System.out.println(matches);
                boolean isNotCorrect = true;
                String tmpValue;
                int index = 0;
                int tildaPosition = 0;
                do {
                    System.out.print(">_");
                    tmpValue = scanner.nextLine();
                    if (tmpValue.equals("stop")) {
                        break;
                    }
                    tildaPosition = tmpValue.indexOf('~');
                    //System.out.println(tildaPosition);

                    //check input
                    try {
                        index = Integer.parseInt(tmpValue.substring(tildaPosition + 1));
                    } catch (NumberFormatException e) {
                        System.out.println("Wrong input: " + " position: " + e.getMessage());
                        isNotCorrect = true;
                    }
                    //Если введено print~num, выводит строку из позиции num в связном списке
                    // и удаляет её из списка
                    //print~num

                    if ("print".equals(tmpValue.substring(0,tildaPosition))) {
                        printAndRemove(linkedList,index);
                    } else {
                        if (index > linkedList.size()) {
                            insertNulls(linkedList, index);
                        }
                        linkedList.add(index, tmpValue.substring(0, tildaPosition));
                    }
                } while (isNotCorrect);

                printLinkedList(linkedList);
            }

            private static void printAndRemove(LinkedList<String> linkedList, int index) {
                if (index < linkedList.size()){
                    System.out.printf("[%n]%s",index,linkedList.get(index));
                    linkedList.remove(index);
                }
            }

            private static void insertNulls(LinkedList<String> linkedList, int index) {
                for (int i = linkedList.size(); i < index; i++) {
                    linkedList.add(i,null);
                }
            }

            private static void printLinkedList(LinkedList<String> linkedList) {
                for (int i = 0; i < linkedList.size(); i++) {
                    System.out.printf("[%d]:%s%n",i,linkedList.get(i));

                }
            }
        }

    }
}*/
