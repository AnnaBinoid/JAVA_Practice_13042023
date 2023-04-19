package Lection2;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // скопировать путь к файлу - на него - Copy Path/Reference или Ctrl + Shift + C

//        printMillionPluses();
//        printMillionPlusesStrBuilder();
//        apiStringTest();
//        FileSystemWorking();
//        tryCatchConstraction();
//        tryFileAPI();  // РАЗОБРАТЬСЯ С ФАЙЛАМИ
//        binaryFileFunctional();
        makingLog();
        



    }

    private static void printMillionPluses() {
        /* Вывести 1 млн "+" в строках*/
        String str = "+";
        for (int i = 0; i <= 10; i++) {
            str += "+";
        }
        System.out.println(str);
    }

    private static void printMillionPlusesStrBuilder() {
        /* Вывести 1 млн "+" в StringBuilder */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 10; i++){
            sb.append("+");
        }
        System.out.println(sb);
    }

    private static void apiStringTest() {
        String str1 = "IIILove ";
        String str2 = "Love ";
        String str3 = "JAVA!";
        String all = str1.concat(str2); // объединяет две строки
        all = all.concat(str3);
        System.out.println(all);
        all = String.join(str2, str1, str3); //String.join - Объед строки в одну с учетом разделителя?
        System.out.println(all);
        for (int i = 0; i < all.length() - 1; i++){
            System.out.println(all.charAt(i));
        }
        System.out.println(str1.charAt(1));
        System.out.println(all.lastIndexOf("ve")); //найти свою строку в существующей - указывается индекс первого символа подстроки
        System.out.println(all.startsWith("I L")); //начинается ли строка с подстроки
        System.out.println(all.endsWith("You")); //оканчивается ли
        all = all.replace("Love JAVA", "Hate Phyton"); //заменяет одну подстроку другой
        System.out.println(all);

        System.out.println(all.trim()); //удаляет пробелы в начале и конце строки
        System.out.println(all);
        System.out.println(all.substring(1, 5)); //возвращает подстроку по индексам
        System.out.println(all.toLowerCase().toUpperCase()); // в нижний - верхний регистр
        int result = str3.compareTo(str2); // как-то помогает при упорядочивании объектов
        System.out.println(result);
        boolean result1 = str1.equalsIgnoreCase(str1.toLowerCase()); //equals - с учетом регистра, equalsIgnoreCase - без учета регистра
        System.out.println(result1);
        boolean resultRegionMatches = str1.regionMatches(3, str2, 0, 2); //сравнивает указанные подстроки с указанного символа
        System.out.println(resultRegionMatches);
        System.out.println(String.join("x", "A", "N", "Y"));
        //Если оперируем готовыми строками - String, если часто меняем строковые данные - StringBuilder.
    }

    private static void FileSystemWorking() {
        File f1 = new File("file.txt");  // НИНАДА! По разному выглядят
        File f2 = new File("C:\\Users\\User\\IdeaProjects\\JAVA_Practice_13042023\\file2.txt"); // НИНАДА! Разные пути
    }

    private static void tryCatchConstraction() {
        // Важно при работе с файловой системой
        try {
            //Кусок кода для проверки
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("C:\\Users\\User\\IdeaProjects\\JAVA_Practice_13042023");
            File f3 = new File(pathFile);
            System.out.println("try");
        }
        catch (Exception e){
            // Как обработать, если ошибка
            System.out.println("catch");
        }
        finally {
            // Независимо от того, что выше, выполнится код:
            System.out.println("finally it's over");
        }
    }

    private static void tryFileAPI() throws IOException {
        String pathDir = "C:\\Users\\User\\IdeaProjects\\test.txt";
        File testFile = new File(pathDir);
        FileWriter fileWrite = new FileWriter("test.txt", StandardCharsets.UTF_8);
        System.out.println(testFile.isHidden()); // проверяет, скрыт ли файл/каталог true - если скрыт, false - если нет
        System.out.println(testFile.length());
        System.out.println(testFile.lastModified());
        System.out.println(testFile.list());
        String name = testFile.getName();
        System.out.println(name);
        long date = testFile.lastModified();
        System.out.println(date);
    }

    private static void binaryFileFunctional() {
        /* Основной функционал, загугли, милая.
        loadFile
        saveFile
        delete
        add
        find
        readInt
        writeInt
        при чтении и записи обязательны try catch
         */
    }

    private static void makingLog() throws IOException {
        // Это журнал чистой воды
        Logger logger = Logger.getLogger(Lection2.Main.class.getName()/*наименование класса, для которого логирование*/);
/*        // Вывод (cоздали хэндлер, указали в качестве аргумента для логера (куда отравлять сообщения
        ConsoleHandler info = new ConsoleHandler();
        logger.addHandler(info);
        // Формат вывода (куда и в каком формате) XMLFormatter, SimpleFormatter;
        XMLFormatter xml = new XMLFormatter(); //парсим логи, емана
//1        SimpleFormatter sFormat = new SimpleFormatter();
        info.setFormatter(xml);
//1        info.setFormatter(sFormat);
        logger.log(Level.WARNING, "Тестовое логирование 1"); // уровень сообщений, какое сообщение хотим указать.
        logger.info("Тестовое логирование 2"); // или без флажка с левел.варнинг*/
        // А если в файл?
        FileHandler info2 = new FileHandler("log.xml");
        logger.addHandler(info2);
        XMLFormatter xml = new XMLFormatter();
        info2.setFormatter(xml);
        logger.log(Level.WARNING, "Тестовое логирование 1"); // уровень сообщений, какое сообщение хотим указать.
        logger.info("Тестовое логирование 2");

    }
}
