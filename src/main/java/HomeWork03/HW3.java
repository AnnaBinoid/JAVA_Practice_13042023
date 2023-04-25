package HomeWork03;

import java.util.*;

public class HW3 {
    public static void main(String[] args) {
//        deleteIntInArray();
//        bookShopCatalog();
        howMatchPlanetsInList();
    }


/*1. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
Пройти по списку, найти и удалить целые числа.
Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}*/

    private static void deleteIntInArray() {
        List<String> list = new ArrayList<>(
                Arrays.asList("Яблоко", "11", "13", "Апельсин", "Дыня", "17", "Почта20", "Лимон"));

        findAndDeleteInt (list);


    }

    private static void findAndDeleteInt(List<String> someList) {
        List<String> newList = new ArrayList<>();
        boolean isDigit = true;

        for (String s : someList) {

            for (char str : s.toCharArray()){
                if (Character.isDigit(str)){
                    isDigit = false;
                }
            }

            if (isDigit){
                newList.add(s);
            }
            else {
                System.out.printf("Ахтунг! В строке \"%s\" есть цифры! Долой цифры!\n", s);
            }

            isDigit = true;
        }
        System.out.printf("\nА вот и вывод - красивый лист без чисел: %s!", newList);
    }


/*2. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так, что
на 0й позиции каждого внутреннего списка содержится название жанра, а на остальных позициях - названия книг.
Напишите метод для заполнения данной структуры(можно через консоль).
    Пример:
            "Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
            "Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
            "Детектив", "Десять негритят".
            "Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".
            3. Доделать задание 2.2 участникам семинара*/

    private static void bookShopCatalog() {

        List<ArrayList<String>> catalog = new ArrayList<ArrayList<String>>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Заполните жанр. Для прекращения ввода наберите \"стоп\": >_");
            String genre = scan.nextLine();
            if (!(genre.equals("стоп"))){
                StringBuilder sb = new StringBuilder();
                String bookListInGenre = sb.append(genre).toString();
                bookListInGenre = addBooksInOneGenre(scan, genre, bookListInGenre, sb);

                catalog.add(new ArrayList<String>(Collections.singleton(bookListInGenre)));}
            else {
                System.out.println("/n Ознакомьтесь с нашим каталогом: ");
                printCatalog(catalog);
                break;
            }
        }
    }

    private static String addBooksInOneGenre(Scanner scanner, String thisGenre, String genreBooks, StringBuilder strBild){
        //add books of one genre
        while (true) {
            System.out.printf("Добавьте книгу в жанр %s. Для прекращения ввода наберите \"стоп\" >_\n", thisGenre);
            String bookName = scanner.nextLine();
            if (!(bookName.equals("стоп"))) {
                genreBooks = strBild.append("\", \"" + bookName).toString();
            } else {
                genreBooks = strBild.append("\".").toString().replaceFirst("\"", "");
                break;
            }
        }
        return genreBooks;
    }

    private static void printCatalog(List<ArrayList<String>> catalog) {

        for (int i = 0; i < catalog.size(); i++) {
            String bookList = catalog.get(i).toString();
            System.out.println(bookList.substring(1,bookList.length() - 1));
        }
    }

    /*2.1 Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями .
    Вывести название каждой планеты и кол-во его повторений в списке.
    2.2 Пройти по списку из предыдущего задания и удалить повторяющиеся эл-ты.*/

    private static void howMatchPlanetsInList() {
        List<String> planets = listOfPlanets();
        String planetsLikeString = planets.toString().substring(1, planets.toString().length() - 1);
        System.out.printf("№1 - Первоначальный список планет:          %s.\n", planetsLikeString);
        
        Collections.sort(planets);
        System.out.printf("№2 - Отсортированный список планет:         %s.\n", planetsLikeString);
        
        StringBuilder timesCallPlanets = timesOfCallPlanets(planets);
        System.out.printf("№3 - Планеты и количество вызовов каждой:   %s.\n", timesCallPlanets);

        String result22 = (deleteRepeatPlanets(planets)).toString();
        System.out.printf("№4 - Список №1 с удалением повторов:        %s.\n", result22.substring(1, result22.length() - 1));

    }

    private static List<String> listOfPlanets() {
        List<String> planetList = new ArrayList<>();
        planetList.add("Mercury");
        planetList.add("Venus");
        planetList.add("Earth");
        planetList.add("Mars");
        planetList.add("Jupiter");
        planetList.add("Saturn");
        planetList.add("Uranus");
        planetList.add("Mars");
        planetList.add("Neptune");
        planetList.add("Pluto");
        planetList.add("Mercury");
        planetList.add("Mercury");
        planetList.add("Mars");
        planetList.add("Mars");
        planetList.add("Mars");
        planetList.add("Venus");

        return planetList;
    }

    private static StringBuilder timesOfCallPlanets(List<String> planets) {

        StringBuilder sb = new StringBuilder();
        int count = 1;


        for (int i = 0; i < planets.size() - 1; i++) {

            String thisPlanet = planets.get(i);
            String thousePlanet = planets.get(i + 1);

            if (thisPlanet.equals(thousePlanet)) {
                count += 1;
            } else {
                sb.append(thisPlanet);
                sb.append(count);
                sb.append(", ");
                count = 1;
            }

        }
        sb.append(planets.get(planets.size()-1));
        sb.append(count);

        return sb;

    }

    private static List<String> deleteRepeatPlanets(List<String> planets) {
        for (int i = 0; i < planets.size() - 2; i++) {
            while (planets.get(i).equals(planets.get(i + 1))){
                planets.remove(planets.get(i));
            }
            if (planets.get(planets.size()-1).equals(planets.get(planets.size() - 2))){
                planets.remove(planets.get(planets.size()-1));
            }
        }
        return planets;
    }


}


