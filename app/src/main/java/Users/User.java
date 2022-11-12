package Users;

import PhoneNumber.PhoneNumber;

/**
 * Базовый класс пользователя
 */
public class User {
    /**
     * ID Пользователя
     */
    private int id;
    /**
     * Телефоонный номер пользователя
     */
    private final PhoneNumber phoneNumber;
    /**
     * Адрес пользователя
     */
    private final String address;

    /**
     * Тип пользователя
     */
    private final String type;

    /**
     * Конструктор
     * @param type Тип пользователя
     * @param phoneNumber Телефоонный номер пользователя
     * @param address Адрес пользователя
     */
    public User(int id, String type, String phoneNumber, String address) {
        this.phoneNumber = new PhoneNumber();
        this.phoneNumber.splitNumber(phoneNumber);
        this.address = address;
        this.type = type;
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    /**
     * @return Строка содержащая все поля класса в формате Поле:{данные}.
     */
    public String getUserData() {
        return "ID:{" + id  + "} Type:{" + type + "} PhoneNumber:{" + getUserPhoneNumber() + "} Address:{" + address + "}";
    }

    public String getUserPhoneNumber() {
        return phoneNumber.getPhoneNumber();
    }


    public String getType() {
        return type;
    }
}
