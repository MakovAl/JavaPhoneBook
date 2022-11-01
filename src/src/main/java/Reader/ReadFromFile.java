package Reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromFile implements IReader {

    /**
     * Путь к файлу для чтения
     */
    private final String pathFile;

    public ReadFromFile(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     * Метод считывает данные из фала и помещает в строку
     * Открывает и закрывает файл для чтения.
     *
     * @return Строка одержащая данные из файла
     * @throws IOException Если при чтении из файл что-то пошло не так, вызывается исключение
     */
    @Override
    public String read() throws IOException {
        StringBuilder dataFromFile = new StringBuilder();

        FileReader fr = new FileReader(pathFile);
        Scanner scan = new Scanner(fr);

        while (scan.hasNextLine()) {
            dataFromFile.append(scan.nextLine()).append("\n");
        }

        fr.close();
        return dataFromFile.toString();
    }
}
