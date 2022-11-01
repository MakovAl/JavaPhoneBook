package Reader;

import java.io.IOException;

/**
 * Интерфейс содержащий метод чтения
 */
public interface IReader {
    /**
     * Метод реализуется классом в зависимости от ожидаемого поведения и способа чтения данных.
     *
     * @throws IOException Исключение возникающее если что-то пошло не так, при чтении.
     */
    String read() throws IOException;
}
