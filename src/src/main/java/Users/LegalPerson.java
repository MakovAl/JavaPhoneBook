package Users;

/**
 * Наследник класса User дополняющий класс так, чтобы иметь возможность хранить и обрабатывать данные юридических лицо
 * в телефонной книге
 */
public class LegalPerson extends User {
    /**
     * Название организации
     */
    private final String nameOrganization;
    /**
     * Часы работы
     */
    private final String workingHours;
    /**
     * Услуги предоставляемые юридическим лицом
     */
    private final String services;


    public LegalPerson(int id, String type, String nameOrganization, String workingHours, String service, String phoneNumber,
                       String address) {
        super(id, type, phoneNumber, address);
        this.nameOrganization = nameOrganization;
        this.workingHours = workingHours;
        this.services = service;
    }

    /**
     * @return Строка содержащая все поля класса в формате Поле:{данные}.
     */
    @Override
    public String getUserData() {
        return super.getUserData() + " NameOrganization:{" + nameOrganization + "} WorkingHours:{" + workingHours +
                "} Services:{" + services + "}";
    }
}
