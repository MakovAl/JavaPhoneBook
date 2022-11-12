package com.makoval.javaphonebook;

import com.makoval.javaphonebook.Formatter.UserList;
import com.makoval.javaphonebook.Reader.IReader;
import com.makoval.javaphonebook.Reader.ReadFromFile;
import com.makoval.javaphonebook.Reader.ReadFromJson;
import com.makoval.javaphonebook.Users.LegalPerson;
import com.makoval.javaphonebook.Users.PhysicalPerson;
import com.makoval.javaphonebook.Users.User;
import com.makoval.javaphonebook.Writer.IWriter;
import com.makoval.javaphonebook.Writer.WriteToFile;
import com.makoval.javaphonebook.Writer.WriteToJson;

import java.io.IOException;
import java.util.List;


/**
 * Основной класс программы,
 */
public class Main {


    private static List<User> writeAndReadToFile(IWriter writer, IReader reader) throws IOException {
        writer.write();
        List<User> userList;
        userList = reader.read();
        return userList;
    }



    private static void viewUserList(List<User> userList){
        for(User userOut : userList) {
            System.out.println(userOut.getUserData());
        }
    }


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
        String pathFile = "src/main/resources/Data.txt";
        String pathFileJson = "src/main/resources/Data.json";
        User user = new User(1, "User", "89333933333", "TRE");

        PhysicalPerson physicalPerson = new PhysicalPerson(2, "physicalPerson", "Ivan", "Ivanov",
                "890503211231", "INV");
        LegalPerson legalPerson = new LegalPerson(3, "legalPerson", "All Work World",
                "All time", "Any works", "89888888888", "ANY");

        //Подготовка к записи в файл
        String data = user.getUserData() + "\n" + physicalPerson.getUserData() + "\n" + legalPerson.getUserData();
        IWriter writerTxt = new WriteToFile(pathFile, data);

        UserList userList = new UserList();
        userList.add(user);
        userList.add(physicalPerson);
        userList.add(legalPerson);

        IWriter writerJson = new WriteToJson(pathFileJson, userList);


        //Подготовка чтения из файла
        IReader readerTxt = new ReadFromFile(pathFile);
        IReader readerJson = new ReadFromJson(pathFileJson);

        List<User> userListTxt;
        List<User> userListJson;

        userListTxt = writeAndReadToFile(writerTxt, readerTxt);
        viewUserList(userListTxt);

        userListJson = writeAndReadToFile(writerJson, readerJson);
        viewUserList(userListJson);

    }
}
