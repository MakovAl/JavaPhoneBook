package Users;


/**
 * Наследник класса User дополняющий класс так, чтобы иметь возможность хранить и обрабатывать данные физических лиц
 * в телефонной книге
 */
public class PhysicalPerson extends User {

    /**
     * Имя физического лица
     */
    private final String name;
    /**
     * Фамилия физического лица
     */
    private final String surname;


    public PhysicalPerson(int id, String type, String name, String surname, String phoneNumber, String address) {
        super(id, type, phoneNumber, address);
        this.name = name;
        this.surname = surname;
    }

    /**
     * @return Строка содержащая все поля класса в формате Поле:{данные}.
     */
    @Override
    public String getUserData() {
        return super.getUserData() + " Name:{" + name + "} Surname:{" + surname + "}";
    }
}
