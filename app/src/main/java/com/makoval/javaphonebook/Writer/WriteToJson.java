package com.makoval.javaphonebook.Writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.makoval.javaphonebook.Users.User;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Класс реализующий интерфейс
 * @see IWriter
 */
public class WriteToJson implements IWriter {

    /**
     * Список пользователей
     */
    List<User> users;
    /**
     * Путь к файлу
     */
    String path;

    public WriteToJson(String path, List<User> users) {
        this.path = path;
        this.users = users;
    }


    /**
     * Метод интерфейса IWriter записывающий данные в json файл
     * @throws IOException Если при записи в файл что-то пошло не так, вызывается исключение
     */
    @Override
    public void write() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(path), users);
    }
}
