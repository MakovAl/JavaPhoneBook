import Formatter.FormatUser;
import Reader.IReader;
import Reader.ReadFromFile;
import Users.LegalPerson;
import Users.PhysicalPerson;
import Users.User;
import Writer.IWriter;
import Writer.WriteToFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Основной класс программы,
 */
public class Main {

    /**
     * Метод в котором создаются объекты пользователей, запускается чтение и запись в файл, а также создание объектов
     * с помощью данных полученых из файла.
     * Вывод информации о пользователях в консоль.
     *
     * @param args аргументы из консоли.
     * @throws IOException Исключение полученое при чтение или записи в файл возвращается в главнный класс.
     */
    public static void main(String[] args) throws IOException {

        //Задаются входные данные
        String pathFile = "src/src/main/resources/Data.txt";
        User user = new User(1, "user", "89333933333", "TRE");

        PhysicalPerson physicalPerson = new PhysicalPerson(2, "physicalPerson", "Ivan", "Ivanov",
                "890503211231", "INV");
        LegalPerson legalPerson = new LegalPerson(3, "legalPerson", "All Work World",
                "All time", "Any works", "89888888888", "ANY");

        //Подготовка к записи в файл и запись
        String data = user.getUserData() + "\n" + physicalPerson.getUserData() + "\n" + legalPerson.getUserData();
        IWriter writer = new WriteToFile(pathFile, data);
        writer.write();

        //Подготовка чтения из файла и чтение
        String fileData;
        IReader reader = new ReadFromFile(pathFile);
        fileData = reader.read();

        //Обработка полученных данных
        String[] fileDataArray = fileData.split("\n");
        List<String> dataList = Arrays.stream(fileDataArray).toList();
        List<User> userList;

        //Создание объектов по полученым из файла данным
        FormatUser formatUser = new FormatUser(dataList);
        userList = formatUser.format();

        //Вывод на экран объектов созданых из файла
        for (User userFromList : userList) {
            if (userFromList.getType().equals("physicalPerson")) {
                PhysicalPerson pp = (PhysicalPerson) userFromList;
                System.out.println(pp.getUserData());
            } else if (userFromList.getType().equals("legalPerson")) {
                LegalPerson lp = (LegalPerson) userFromList;
                System.out.println(lp.getUserData());
            } else if (userFromList.getType().equals("user")) {
                System.out.println(userFromList.getUserData());
            }
        }
    }
}
