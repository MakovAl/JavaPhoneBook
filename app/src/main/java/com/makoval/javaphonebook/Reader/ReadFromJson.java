package com.makoval.javaphonebook.Reader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makoval.javaphonebook.Users.User;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Класс реализующий интерфейс IReader для записи в json файл
 * @see IReader
 */
@NoArgsConstructor
public class ReadFromJson implements IReader {

    /**
     * Путь к файлу json
     */
    String pathFile;

    public ReadFromJson(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     *
     * Метод считывает данные из json файла и помещает в список
     * Открывает и закрывает файл для чтения.
     * @return Список пользоватей считаных из файла
     * @throws IOException Если при чтении из файл что-то пошло не так, вызывается исключение
     */
    @Override
    public  List<User> read() throws IOException {
        List<User> users;
        ObjectMapper mapper = new ObjectMapper();
        users = Arrays.asList(mapper.readValue(new File(pathFile), User[].class));
        return users;
    }
}
