package HomeWork04;

import java.util.*;

public class HW4 {
    public static void main(String[] args) {
        stringRemember();
        invertedLinkedList();

    }

/*1. Реализовать консольное приложение, которое:
Принимает от пользователя и “запоминает” строки.
Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
Если введено revert, удаляет предыдущую введенную строку из памяти.*/

    private static void stringRemember() {
        Scanner scan = new Scanner(System.in);
        String instruction = "\nИнструкция:\nДля печати списка данных используйте команду \"print\".\n" +
                "Для удаления последней введенной строки используйте команду \"revert\".\n" +
                "Для завершения работы программы используйте команду \"stop\".\n" +
                "Введите данные: >_";
        System.out.println(instruction);
        String userStr = "";
        Deque<String> userData = new ArrayDeque<>();

        while (true) {
            userStr = scan.nextLine();

            if (userStr.toLowerCase().equals("print")) {
                if (userData.size() > 0) {
                    System.out.printf("Ваш список на данный момент: %s.\n", userData);
                } else {
                    System.out.println("Ваш список пуст.\n" + instruction);
                }
            } else if (userStr.toLowerCase().equals("revert")) {
                if (userData.size() > 0) {
                    userData.removeFirst();
                    System.out.printf("Ваш список после удаления предыдущей строки: %s.\n", userData);
                } else {
                    System.out.println("Ваш список пуст, дальнейшее удаление невозможно.\n" + instruction);
                }
            } else if (userStr.equals("stop")) {
                System.out.printf("Итоговый список: %s.\n", userData);
                break;
            } else {
                userData.offerFirst(userStr);
            }

        }

    }

    /*2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.*/

    private static void invertedLinkedList() {
        LinkedList<Integer> list = createLinkedList();
        System.out.println(list);
        invertList(list);

    }

    private static LinkedList<Integer> createLinkedList() {
        LinkedList<Integer> li = new LinkedList<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(5);
        li.add(6);
        li.add(7);
        li.add(8);
        return li;
    }

    private static void invertList(LinkedList<Integer> newList) {
        int temp = 0;
        for (int i = 0; i < newList.size() / 2; i++) {

            temp = newList.get(i);

            newList.remove(i);
            newList.add(i, newList.get(newList.size() - 1 - i));

            newList.remove(newList.size() - 1 - i);
            newList.add(newList.size() - i, temp);

        }
        System.out.println(newList);
    }

}
