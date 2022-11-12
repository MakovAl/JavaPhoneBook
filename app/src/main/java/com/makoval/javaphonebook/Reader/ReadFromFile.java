package com.makoval.javaphonebook.Reader;

import com.makoval.javaphonebook.Formatter.FormatUser;
import com.makoval.javaphonebook.Users.User;
import lombok.NoArgsConstructor;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Класс реализующий интерфейс IReader для записи в текстовый файл
 * @see IReader
 */
@NoArgsConstructor
public class ReadFromFile implements IReader {

    /**
     * Путь к файлу для чтения
     */
    private String pathFile;

    public ReadFromFile(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     * Метод считывает данные из файла и помещает в список
     *
     * @return Список пользоватей считаных из файла
     * @throws IOException Если при чтении из файл что-то пошло не так, вызывается исключение
     */
    @Override
    public  List<User> read() throws IOException {
        StringBuilder dataFromFile = new StringBuilder();
        List<User> userList;

        FileReader fr = new FileReader(pathFile);
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()) {
            dataFromFile.append(scan.nextLine()).append("\n");
        }

        fr.close();

        FormatUser formatUser = new FormatUser(Arrays.stream(dataFromFile.toString().split("\n")).toList());
        userList = formatUser.format();
        return userList;
    }
}
