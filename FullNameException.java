public class FullNameException extends Exception {

    String data;

    public FullNameException(String inputData) {
        this.data = inputData;
    }

    @Override
    public String getMessage() {
        return "Неверный формат ФИО '" + data + "'.\n" +
                "Вводите ФИО только из букв!\n";
    }
}
