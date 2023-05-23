package HomeWork06;

import java.util.*;
import java.util.Map.Entry;

public class Main {

    /*  Подумать над структурой класса Ноутбук для магазина техники — выделить поля и методы.
        Реализовать в Java.
        Создать множество ноутбуков.

        Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
        и выведет ноутбуки, отвечающие фильтру.
        Критерии фильтрации можно хранить в Map. Например:
                “Введите цифру, соответствующую необходимому критерию:
                1 - ОЗУ
                2 - Объём ЖД
                3 - Операционная система
                4 - Цвет …

        Далее нужно запросить минимальные значения для указанных критериев — сохранить параметры фильтрации можно также в Map.
        Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
        Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ и номером группы.*/

    public static void main(String[] args) {
        HashSet<Notebook> ourNotes = createNotesBase();
        System.out.println(ourNotes);
        Scanner scan = new Scanner(System.in);
        Map<String, Object> findNote = createSeekList(scan);
//        System.out.println(findNote);
        HashSet<Notebook> requestNotes = requestSet(ourNotes, findNote);
        System.out.println(requestNotes);

    }

    public static HashSet<Notebook> createNotesBase() {
        Notebook note1 = new Notebook("Huawei", "MateBook D 16 RLEF-X", "Китай", 16,
                14, "1920х1200", "Intel", "Core i7 12700H",
                2.3, 16, "Intel Iris Xe graphics", 512,
                "Windows 11 Home", "кириллица/латиница", true, "серый", 99000);
//        System.out.println(note1.toString());
        Notebook note2 = new Notebook("Acer", "A114-33-P7VD", "Китай", 14,
                14, "1366х768", "Intel", "Pentium Silver N6000",
                0.06, 8, "Intel UHD Graphics", 128, "Eshell",
                "кириллица/латиница", false, "черный", 200000);
//        System.out.println(note2.toString());
        Notebook note3 = new Notebook("Apple", "MacBook Air A2337", "США", 13.3,
                8, "2560х1600", "Apple", "M1 8 core", 3.2,
                8, "интегрированный", 256, "Mac OS", "латиница",
                true, "белый", 30000);
//        System.out.println(note3.toString());

        HashSet<Notebook> notes = new HashSet<>(Arrays.asList(note1, note2, note3));
//        System.out.println(notes);
        return notes;
    }

    public static Map<String, Object> createSeekList(Scanner sc) {

        String instruction = "Введите критерий фильтрации: \n1: Бренд, \n2: Диагональ, " +
                "\n3: Количесто ядер, \n4: Модель процессора, " +
                "\n5: Тактовая частота процессора, \n6: ОЗУ, \n7: SSD, \n8: Операционная система," +
                " \n9: Цвет ноутбука, \n10: Цена. \n";


        System.out.println("Добро пожаловать!\nВведите цифру, соответствующую необходимому критерию:" + instruction);

        Integer request = sc.nextInt();
        sc.nextLine();
        Map<String, Object> ourFindNote = new HashMap<>();


        if (request == 1) {
            System.out.println("Введите бренд: ");
            String temp = sc.nextLine();
            ourFindNote.put("Бренд", temp);
        }
        if (request == 2) {
            System.out.println("Введите минимальную диагональ: ");
            double temp = sc.nextDouble();
            sc.nextLine();
            ourFindNote.put("Диагональ", temp);
        }
        if (request == 3) {
            System.out.println("Введите минимальное количество ядер: ");
            int temp = sc.nextInt();
            sc.nextLine();
            ourFindNote.put("Ядер", temp);
        }
        if (request == 4) {
            System.out.println("Введите модель процессора: ");
            String temp = sc.nextLine();
            ourFindNote.put("Модель", temp);
        }
        if (request == 5) {
            System.out.println("Введите минимальную частоту процессора: ");
            double temp = sc.nextDouble();
            sc.nextLine();
            ourFindNote.put("Частота", temp);
        }
        if (request == 6) {
            System.out.println("Введите минимальный размер ОЗУ: ");
            int temp = sc.nextInt();
            sc.nextLine();
            ourFindNote.put("ОЗУ", temp);
        }
        if (request == 7) {
            System.out.println("Введите минимальный размер SSD: ");
            int temp = sc.nextInt();
            sc.nextLine();
            ourFindNote.put("SSD", temp);
        }
        if (request == 8) {
            System.out.println("Введите желаемую операционную систему: ");
            String temp = sc.nextLine();
            ourFindNote.put("Операционка", temp);
        }
        if (request == 9) {
            System.out.println("Введите желаемый цвет ноутбука: ");
            String temp = sc.nextLine();
            ourFindNote.put("Цвет", temp);
        }
        if (request == 10) {
            System.out.println("Введите минимальную цену ноутбука: ");
            int temp = sc.nextInt();
            sc.nextLine();
            ourFindNote.put("Цена", temp);
        }
        return ourFindNote;
    }

    public static HashSet<Notebook> requestSet(HashSet<Notebook> thisNotes, Map<String, Object> thisFindNote) {
        HashSet<Notebook> filteredNotes = new HashSet<>();


        Iterator it = thisNotes.iterator();


        for (Entry<String, Object> entry : thisFindNote.entrySet()) {  // для каждого критерия поиска
            if (entry.getKey().equals("Бренд")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.brand.equals(entry.getValue())) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Диагональ")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.diagonal >= (Double) entry.getValue()) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Ядер")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.coresCount >= (Integer) entry.getValue()) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Модель")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.processorType.contains((CharSequence) entry.getValue())) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Частота")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.processorFrequency >= (Double) entry.getValue()) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("ОЗУ")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.ozu >= (Integer) entry.getValue()) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("SSD")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.diskSize >= (Integer) entry.getValue()) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Операционка")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.operationSystem.contains((CharSequence) entry.getValue())) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Цвет")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.colour.equals(entry.getValue())) {
                        filteredNotes.add(note);
                    }
                }
            }
            if (entry.getKey().equals("Цена")) {
                while (it.hasNext()) {
                    Notebook note = (Notebook) it.next();
                    if (note.price >= (Integer) entry.getValue()) {
                        filteredNotes.add(note);
                    }
                }
            }
        }

        return filteredNotes;
    }

}
