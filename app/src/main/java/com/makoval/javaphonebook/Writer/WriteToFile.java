package com.makoval.javaphonebook.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс реализующий интерфейс
 * @see IWriter
 */
public class WriteToFile implements IWriter {

    /**
     * Путь к файлу для записи
     */
    private final String pathFile;
    /**
     * Данные для записи в файл
     */
    private final String data;

    /**
     * Конструктор задающий значение для полей
     *
     * @param pathFile Путь к файлу для записи
     * @param data     Данные для записи в файл
     */
    public WriteToFile(String pathFile, String data) {
        this.pathFile = pathFile;
        this.data = data;
    }

    /**
     * Метод интерфейса IWriter окрывающий файл для записи, записывающий данные и закрывающий файл.
     *
     * @throws IOException Если при записи в файл что-то пошло не так, вызывается исключение
     */
    @Override
    public void write() throws IOException {
        FileWriter fw = new FileWriter(pathFile);

        fw.write(data);

        fw.close();
    }
}
