package HomeWork05;

import java.util.*;
import java.util.stream.Collectors;

public class HW5 {
    public static void main(String[] args) {
//        phoneBook();
        repeatNamesinPB();
    }

    private static void phoneBook() {
        /**1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
         Пусть дан список сотрудников:
         Иван Иванов
         Светлана Петрова
         Кристина Белова
         Анна Мусина
         Анна Крутова
         Иван Юрин
         Петр Лыков
         Павел Чернов
         Петр Чернышов
         Мария Федорова
         Марина Светлова
         Мария Савина
         Мария Рыкова
         Марина Лугова
         Анна Владимирова
         Иван Мечников
         Петр Петин
         Иван Ежов*/

        System.out.println("Спасибо, что выбрали наш справочник!");
        Map<String, ArrayList> phoneBook = new HashMap<>(100);
        createPhoneBook(phoneBook);
        String instruction = ("\nДобавить номер существующему сотруднику\t-\t1.\n" +
                "Cоздать карточку нового сотрудника\t-\t2.\n" +
                "Найти номер телефона по ФИ сотрудника\t-\t3.\n" +
                "Вывести справочник\t-\t4.\n" +
                "Удалить номер телефона сотрудника\t-\t5.\n" +
                "Удалить карточку сотрудника\t-\t6.\n" +
                "Закончить работу со справочником\t-\t7.\n");
        System.out.println(instruction);
        Scanner scan = new Scanner(System.in);

        boolean isTrue = true;
        while (isTrue) {
            String change = scan.nextLine();

            if (change.equals("1")) {
                System.out.println("Введите сотрудника, которому нужно добавить номер телефона: ");
                String nameFornum = scan.nextLine();
                if (!(findNumberBySN(phoneBook, nameFornum))) {
                    System.out.printf("Сотрудника с ФИ %s нет в справочнике.\n", nameFornum);
                } else {
                    System.out.printf("Введите номер телефона для %s:\n", nameFornum);
                    String number = scan.nextLine();
                    if (checkNumber(phoneBook, number)) {
                        addNumber(phoneBook, nameFornum, number);
                    } else {
                        System.out.printf("Номер %s уже cуществует или привязан к другому сотруднику! \n Введите Да, если все-таки хотите привязать его к %s,\n" +
                                " введите Нет, если хотите прервать операцию.\n", number, nameFornum);
                        String decision = scan.nextLine();
                        if (decision.equals("Да")) {
                            addNumber(phoneBook, nameFornum, number);
                        }
                    }
                }
            } else if (change.equals("2")) {
                System.out.println("Введите фамилию имя нового сотрудника: ");
                String addName = scan.nextLine();
                if (findNumberBySN(phoneBook, addName)) {
                    System.out.printf("Сотрудник с ФИ %s уже есть в справочнике и другого нам не надо!", addName);
                } else {
                    addEmploee(phoneBook, addName);
                }
            } else if (change.equals("3")) {
                System.out.println("Введите фамилию имя сотрудника для поиска: ");
                String name = scan.nextLine();
                if (!(findNumberBySN(phoneBook, name))) {
                    System.out.printf("Сотрудника %s нет в справочнике.\n", name);
                }
            } else if (change.equals("4")) {
                printPhoneBook(phoneBook);
            } else if (change.equals("5")) {
                System.out.println("Введите ФИ сотрудника для поиска: ");
                String name = scan.nextLine();
                if (!(findNumberBySN(phoneBook, name))) {
                    System.out.printf("Сотрудника %s нет в справочнике.\n", name);
                } else {
                    System.out.println("Введите номер телефона, который необходимо удалить: ");
                    String numDel = scan.nextLine();
                    deleteNumber(phoneBook, name, numDel);
                }
            } else if (change.equals("6")) {

                System.out.print("Введите ФИ сотрудника, карточку которого хотите удалить: ");
                String delname = scan.nextLine();
                if (!(findNumberBySN(phoneBook, delname))) {
                    System.out.printf("Сотрудника %s нет в справочнике.\n", delname);
                } else {
                    deleteEmploee(phoneBook, delname);
                }

            } else if (change.equals("7")) {
                System.out.println("Спасибо, что воспользовались нашим справочником!");
                break;
            } else {
                System.out.println("Команда не ясна. Попробуйте повторить ввод!");
            }
            System.out.println(instruction);
        }
    }


    private static Map<String, ArrayList> createPhoneBook(Map<String, ArrayList> phB) {
        phB.putIfAbsent("Иван Иванов", new ArrayList<>());
        phB.putIfAbsent("Светлана Петрова", new ArrayList());
        phB.putIfAbsent("Кристина Белова", new ArrayList());
        phB.putIfAbsent("Анна Мусина", new ArrayList());
        phB.putIfAbsent("Анна Крутова", new ArrayList());
        phB.putIfAbsent("Иван Юрин", new ArrayList());
        phB.putIfAbsent("Петр Лыков", new ArrayList());
        phB.putIfAbsent("Павел Чернов", new ArrayList());
        phB.putIfAbsent("Петр Чернышов", new ArrayList());
        phB.putIfAbsent("Мария Федорова", new ArrayList());
        phB.putIfAbsent("Марина Светлова", new ArrayList());
        phB.putIfAbsent("Мария Савина", new ArrayList());
        phB.putIfAbsent("Мария Рыкова", new ArrayList());
        phB.putIfAbsent("Марина Лугова", new ArrayList());
        phB.putIfAbsent("Анна Владимирова", new ArrayList());
        phB.putIfAbsent("Иван Мечников", new ArrayList());
        phB.putIfAbsent("Петр Петин", new ArrayList());
        phB.putIfAbsent("Иван Ежов", new ArrayList());
        phB.putIfAbsent("Иван Ежов", new ArrayList());
        phB.putIfAbsent("Павел Чернов", new ArrayList());


        return (phB);
    }

    private static void addNumber(Map<String, ArrayList> phoneBo, String nameForNum, String newNumber) {

        for (Map.Entry<String, ArrayList> entry : phoneBo.entrySet()) {
            if (entry.getKey().equals(nameForNum)) {
                entry.getValue().add(newNumber);
            }
        }
    }

    private static boolean checkNumber(Map<String, ArrayList> phoneBook, String number) {
        for (Map.Entry<String, ArrayList> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(number)) {
                return false;
            }
        }
        return true;
    }

    private static void addEmploee(Map<String, ArrayList> phoneB, String addEm) {
        if (findNumberBySN(phoneB, addEm)) {
            System.out.printf("Сотрудник с такими данными уже есть в справочнике.\n");
        } else {
            phoneB.putIfAbsent(addEm, new ArrayList());
            System.out.printf("Карточка сотрудника %s добавлена в справочник.\n", addEm);
        }
    }

    private static boolean findNumberBySN(Map<String, ArrayList> phoB, String nameEm) {
//проходит по мапе, ищет, есть ли введенный сотрудник. Если есть - тру, если нет - фолс
        for (Map.Entry<String, ArrayList> entry : phoB.entrySet()) {
            if (nameEm.equals(entry.getKey())) {
                System.out.printf("Сотрудник: %s\t->\t номер телефона: %s\n", nameEm, entry.getValue());
                return true;
            }
        }
        return false;
    }

    private static void printPhoneBook(Map<String, ArrayList> pB) {
        int index = 1;
        for (Map.Entry<String, ArrayList> entry : pB.entrySet()) {
            System.out.printf("%s.Сотрудник: %s\t->\t номер телефона: %s\n", index, entry.getKey(), entry.getValue());
            index += 1;
        }
    }

    private static void deleteNumber(Map<String, ArrayList> phoneBo, String nameNum, String numDel) {
        for (Map.Entry<String, ArrayList> entry : phoneBo.entrySet()) {
            if (nameNum.equals(entry.getKey())) {
                if (entry.getValue().contains(numDel)) {
                    {
                        entry.getValue().remove(numDel);
                    }
                    System.out.printf("Номер телефона %s сотрудника %s успешно удален. \n", numDel, nameNum);
                } else {
                    System.out.println("Данный номер телефона отсутствует. Попробуйте ещё раз.");
                }
            }
        }
    }

    private static Map<String, ArrayList> deleteEmploee(Map<String, ArrayList> phonB, String delName) {

        for (Map.Entry<String, ArrayList> entry : phonB.entrySet()) {
            if (delName.equals(entry.getKey())) {
                phonB.remove(delName);
                System.out.printf("Карточка сотрудника %s удалена.\n", entry.getKey());
                break;
            }
        }
        return phonB;
    }


    /* 2. Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
    Отсортировать по убыванию популярности.*/
    private static void repeatNamesinPB() {
        Map<String, ArrayList> phoneBook = new HashMap<>(20);
        createPhoneBook(phoneBook);

        List<String> popularNames = new ArrayList<>();

        for (Map.Entry<String, ArrayList> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            int iend = name.indexOf(" ");
            String subName = " ";
            if (iend != -1) {
                subName = name.substring(0, iend);
            }
            popularNames.add(subName);
        }
        Collections.sort(popularNames);
//        System.out.println(popularNames);

        Map<String, Integer> popularity = new HashMap<>();
        int count = 0;
        for (int i = 0; i < popularNames.size() - 1; i++) {
            if (popularNames.get(i).equals(popularNames.get(i + 1))) {
                count += 1;
                popularity.put(popularNames.get(i), count + 1);
            } else {
                popularity.put(popularNames.get(i + 1), 1);
                count = 0;
            }
        }
        System.out.println("Список имен с количеством повторений : " + popularity.toString()
                .substring(1, popularity.toString().length() - 1)
                .replace("=", " - "));

        popularity = popularity.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
//        System.out.println(popularity);  // по возрастанию

        List<String> sortedMap = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : popularity.entrySet()) {
            sortedMap.add(entry.toString());
        }

        List<String> reverse = new ArrayList<>(sortedMap);
        Collections.reverse(reverse);
        System.out.println("Имена в порядке убывания популярности: " + reverse.toString()
                .replace("=", " - ")
                .substring(1, reverse.toString().length() + 1));
    }

}



/*3**. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга (обратите внимание на алгоритм backtracking(поиск с возвратом)).*/

