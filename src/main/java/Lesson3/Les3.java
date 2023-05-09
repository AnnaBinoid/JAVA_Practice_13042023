package Lesson3;

import java.util.*;

public class Les3 {
    public static void main(String[] args) {
//        apiString();
//        createAndSortRandList();
        howMatchPlanetsInList();



    }

    private static void apiString() {
        String s1 = "hello";
        String s2 = "Hello";
        String s3 = null;//"h" + "e" + "l" + "l" + "o";
        String s4 = new String("hello");

        System.out.println(s1.equals(s2));
        System.out.println(Objects.equals(s1, s3)); // Обертка Objects так все проверится на null значение. Более безопасно.
// Можно почитать Optional<User> - способ в продакшн

// Пустая ли строка или содержатся пробелы, табы, знаки переноса строки и тд
        String space = "    ";
        System.out.println(space.isEmpty()); // true О-оу... Заменим на
        System.out.println(space.isBlank());
        System.out.println(space.trim().length() == 0); // или предварительно убрать все пробелы
    }

    /*1. Заполнить список 10 случайными числами.
        Отсортировать список методом sort() и вывести его на экран*/

    private static void createAndSortRandList() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }

    /*2.1 Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями .
    Вывести название каждой планеты и кол-во его повторений в списке.
    2.2 Пройти по списку из предыдущего задания и удалить повторяющиеся эл-ты.*/

    private static void howMatchPlanetsInList() {
        List<String> planets = new ArrayList<>();

        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Mars");
        planets.add("Neptune");
        planets.add("Pluto");
        planets.add("Mercury");
        planets.add("Mercury");
        planets.add("Mars");
        planets.add("Mars");
        planets.add("Mars");
        planets.add("Venus");

        System.out.println(planets);
        Collections.sort(planets);
        System.out.println(planets);
        System.out.println(planets.size());
        StringBuilder sb = new StringBuilder();
        int count = 1;


        for (int i = 0; i < planets.size() - 1 ; i++) {

            String thisPlanet = planets.get(i);
            String thousePlanet = planets.get(i + 1);

            if (thisPlanet.equals(thousePlanet)) {
                count += 1;
            } else {
                sb.append(thisPlanet);
                sb.append(count);
                sb.append(" ");
                count = 1;
            }
        }

        System.out.println(sb);

    }

}
