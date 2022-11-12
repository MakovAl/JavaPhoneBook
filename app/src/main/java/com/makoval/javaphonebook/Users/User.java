package com.makoval.javaphonebook.Users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.makoval.javaphonebook.PhoneNumber.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Базовый класс пользователя
 */

@NoArgsConstructor
@Setter
@Getter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PhysicalPerson.class),
        @JsonSubTypes.Type(value = LegalPerson.class)
})
public class User {

    /**
     * ID Пользователя
     */
    private int id;
    /**
     * Тип пользователя
     */
    private String type;

    /**
     * Телефоонный номер пользователя
     */
    @JsonUnwrapped
    private PhoneNumber phoneNumber;

    /**
     * Адрес пользователя
     */
    private String address;

    /**
     * Конструктор
     *
     * @param type        Тип пользователя
     * @param phoneNumber Телефоонный номер пользователя
     * @param address     Адрес пользователя
     */
    public User(int id, String type, String phoneNumber, String address) {
        this.phoneNumber = new PhoneNumber();
        this.phoneNumber.splitNumber(phoneNumber);
        this.address = address;
        this.type = type;
        this.id = id;
    }

    /**
     * @return Строка содержащая все поля класса в формате Поле:{данные}.
     */
    @JsonIgnore
    public String getUserData() {
        return "ID:{" + id + "} Type:{" + type + "} PhoneNumber:{" + getUserPhoneNumber() + "} Address:{" + address + "}";
    }

    @JsonIgnore
    public String getUserPhoneNumber() {
        return phoneNumber.getPhoneNumber();
    }

}
