package com.makoval.javaphonebook.Reader;

import com.makoval.javaphonebook.Formatter.UserList;
import com.makoval.javaphonebook.Users.User;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс содержащий метод чтения
 */
public interface IReader {
    /**
     * Метод реализуется классом в зависимости от ожидаемого поведения и способа чтения данных.
     *
     * @throws IOException Исключение возникающее если что-то пошло не так, при чтении.
     */
    List<User> read() throws IOException;
}
