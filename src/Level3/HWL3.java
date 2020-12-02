package Level3;
import Level3.lesson3.*;

import java.io.IOException;

public class HWL3 {

    /**
     * 1. Создать логгер локальной истории в текстовый файл. Считываем данные введенные из консоли и добавляем в файл с новой строки.
     * 2. После загрузки клиента показывать ему последние 100 строк чата.
     * 3. * Не использовать сканер в процессе считывания данных из консоли
     *
     * @param args any console data
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Start Home Work for Lesson 3");

        Logger starter = new Logger();
        starter.getMeLastMessages();

        starter.setMessageIntoLogFile();

    }
}
