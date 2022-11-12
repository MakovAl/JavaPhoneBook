package Formatter;

import Users.LegalPerson;
import Users.PhysicalPerson;
import Users.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержащий методы преобразования строки в класс User или его наследников
 */
public class FormatUser {

    /**
     * Пользователи полученные из файла в списке строк, в каждой строке по одному пользователю.
     */
    private final List<String> users;

    public FormatUser(List<String> dataList) {
        users = dataList;
    }

    /**
     * Метод получает по одной строке из списка и передает в метод getFields
     * после получение полей создается новый объект класса User в методе createUser
     * полученный результат помещается в список, с типом объектов User.
     *
     * @return Список классов с пользователями
     * @see FormatUser#getFields(String)
     * @see FormatUser#createUser(Map)
     */
    public List<User> format() {
        List<User> userList = new ArrayList<User>();
        for (String user : users) {
            User userFromFile = createUser(getFields(user));
            userList.add(userFromFile);
        }
        return userList;
    }

    /**
     * Метод разделяющий строку на массив строк по символу }
     * После разделения в цикле из строки убираются символы "{" и пробелы до этого символа.
     * Далее полученые строки разделяются по символу ":" и помещаются в Map<String, String>
     *
     * @param user Строка с полями пользователя в формате: "Название поля:{значение поля}"
     * @return Map с полями пользователя в формате:
     * Ключ - название поля, значение - значение поля.
     */
    private Map<String, String> getFields(String user) {

        String[] fields = user.split("}");
        Map<String, String> mapFields = new HashMap<>();

        for (String field : fields) {
            String replacingString = "";
            char[] charArrayField = field.toCharArray();
            for (char symbol : charArrayField) {
                if (symbol != '{') {
                    replacingString += symbol;
                } else {
                    replacingString = replacingString.replaceAll(" ", "");
                }
            }
            String[] keyAndValue = replacingString.split(":");
            mapFields.put(keyAndValue[0], keyAndValue[1]);
        }
        return mapFields;
    }

    /**
     * Создает объект User в зависимости от типа объекта "Физическое лицо, Юридическое лицо...".
     *
     * @param mapFields Map<Название поля, значение поля>
     * @return объект типа User
     */
    private User createUser(Map<String, String> mapFields) {
        User userFromFile = null;
        if (mapFields.get("Type").equals("user")) {
            userFromFile = new User(Integer.parseInt(mapFields.get("ID")), mapFields.get("Type"),
                    mapFields.get("PhoneNumber"), mapFields.get("Address"));
        }
        if (mapFields.get("Type").equals("physicalPerson")) {
            userFromFile = new PhysicalPerson(Integer.parseInt(mapFields.get("ID")), mapFields.get("Type"),
                    mapFields.get("Name"), mapFields.get("Surname"), mapFields.get("PhoneNumber"),
                    mapFields.get("Address"));
        }
        if (mapFields.get("Type").equals("legalPerson")) {
            userFromFile = new LegalPerson(Integer.parseInt(mapFields.get("ID")), mapFields.get("Type"),
                    mapFields.get("NameOrganization"), mapFields.get("WorkingHours"), mapFields.get("Services"),
                    mapFields.get("PhoneNumber"), mapFields.get("Address"));
        }
        return userFromFile;
    }

}
