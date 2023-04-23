package HomeWork02;


import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.IOException;

public class HW2 {
    public static void main(String[] args) throws IOException {
//        parseRequestStringByMap();
//        parseRequestString();
        fileExtentional();


    }


    /*1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя
        StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
       Если значение null, то параметр не должен попадать в запрос.
               Пример 1:
       Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
       Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';
               Пример 2:
       Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
       Результат: SELECT * FROM USER;

       > Sasha Karpenko:
       Вам дана строка в формате JSON. В том смысле, что все параметры заключены в фигурные скобки, между собой разделены
       запятой, каждый отдельно взят в ковычки, имя параметра от значения отделено точкой с запятой. Но это все равно
       тестовая СТРОКА. А вот вы из нее должны сделать СТРОКУ запроса.

       То есть вы должны распарсить вашу строку на отдельные параметры, проверить, что значение не null и добавить
        стрингбилдером к вашему запросу.
   */

    private static void parseRequestString() {
        String SQLRequest = "SELECT * FROM USER";
        String where = " WHERE";
        String JASONParse = "\'name:Ivanov\', \'country:Russia\', \'city:Moscow\', \'age:19\'";

        String updateString = JASONParse.substring(1, JASONParse.length() - 1);
        System.out.println(updateString);
        String[] first = updateString.split("', \'");

        StringBuilder requestAnswer = new StringBuilder(SQLRequest);

        for (String i : first) {
            if (!(i.contains("null"))) {
                requestAnswer.append(" and ");
                requestAnswer.append(i + "'");
            }
        }
        requestAnswer.append(";");
        System.out.println(requestAnswer.toString().replace(":", " = '")
                .replaceFirst(" and ", " WHERE "));

    }
    private static void parseRequestStringByMap() {
        String request = "SELECT * FROM USER WHERE";
        StringBuilder sb = new StringBuilder(request);

        Map<String, String> map = new HashMap<>(); // формируем строку .json
        map.put("name", "Ivanov");
        map.put("country", "Russia");
        map.put("city", null);
        map.put("age", null);
        String person = map.toString().replace("=", ":");
        System.out.println(person);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey(); // get value
            String value = entry.getValue();
            if (value != null) {
                sb.append(" '" + key + "'='");
                sb.append(value + "' and");
            }
        }
        String result = sb.toString();
        String lastResult = (result.substring(0, result.length() - 5) + ";");

        System.out.println(lastResult);
    }


/* 2.Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
    1 Расширение файла: txt
    2 Расширение файла: pdf
    3 Расширение файла:
    4 Расширение файла: jpg*/


    private static void fileExtentional() throws IOException {
        //Creating a File object for directory
        File directoryPath = new File("C:\\Users\\User\\IdeaProjects\\JAVA_Practice_13042023");
        //List of all files and directories
        String contents[] = directoryPath.list();
        System.out.println("Список файлов и папок в указанной папке:");
        for(int i=0; i<contents.length; i++) {
            if (contents[i].toString().contains(".")){
                String contentsString = contents[i].toString();
                System.out.printf("%s Расширение файла: %s\n", i + 1, contentsString.substring(contentsString.indexOf(".")));
            }
            else {
                System.out.printf("%s Расширение файла: \n", i + 1);
            }
        }
    }

}
