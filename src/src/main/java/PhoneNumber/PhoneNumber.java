package PhoneNumber;

public class PhoneNumber {
    /**
     * Префикс "8"
     */
    String internationalPrefix;
    /**
     * Три цифры после префикса
     */
    String areaCode;
    /**
     * Три цифры после кода зоны
     */
    String subscriber;
    /**
     * Четыре цыфры после номера абонента
     */
    String extension;

    public PhoneNumber() {
        internationalPrefix = "";
        areaCode = "";
        subscriber = "";
        extension = "";
    }

    /**
     * @return Строка с номером телефона
     */
    public String getPhoneNumber() {
        return internationalPrefix + areaCode + subscriber + extension;
    }

    /**
     * Метод раскладывающий номер телефона по полям класса
     *
     * @param phoneNumber Номер телефона
     */
    public void splitNumber(String phoneNumber) {
        for (char number : phoneNumber.toCharArray()) {
            if (internationalPrefix.length() == 0) {
                internationalPrefix += number;
            } else if (areaCode.length() < 3) {
                areaCode += number;
            } else if (subscriber.length() < 3) {
                subscriber += number;
            } else if (extension.length() < 4) {
                extension += number;
            }
        }

    }
}
