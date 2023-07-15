public class PhoneException extends Exception {
    String data;

    public PhoneException(String inputData) {
        this.data = inputData;
    }

    @Override
    public String getMessage() {
        return "Не удалось преобразовать " + data + " в телефонный номер.\n" +
                "Формат ввода номера телефона - 10 цифр: 1234567890";
    }
}
