public class DataCheck {
    public static int dataCount = 4;

    private String firstName;
    private String lastName;
    private String patronymic;
    private int phone;

    public DataCheck() {
    }

    public void CheckData(String[] splitedString) throws ParseInputDataException {
        if (splitedString == null) {
            throw new NullPointerException("Нет данных");
        }

        StringBuilder fullErrorsMessages = new StringBuilder();
        for (String string : splitedString) {
            if (Character.isLetter(string.charAt(0))) {
                if (string.length() == 1) {
                    if (this.lastName == null) {
                        try {
                            this.lastName = checkFullName(string);
                        } catch (FullNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.firstName == null) {
                        try {
                            this.firstName = checkFullName(string);
                        } catch (FullNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else if (this.patronymic == null) {
                        try {
                            this.patronymic = checkFullName(string);
                        } catch (FullNameException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Неверно указаны ФИО!\n");
                    }
                }
            } else {

                if (string.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                    if (this.phone == 0) {
                        try {
                            this.phone = (int) checkPhone(string);
                        } catch (PhoneException e) {
                            fullErrorsMessages.append(e.getMessage());
                        }
                    } else {
                        fullErrorsMessages.append("Должен быть только один телефонный номер: '"
                                + this.phone + "','" + string + "'\n");
                    }
                }
            }
        }
        if (!fullErrorsMessages.isEmpty()) {
            throw new ParseInputDataException(fullErrorsMessages.toString());
        }
    }

    public String getLastName() {
        return lastName;
    }

    private String checkFullName(String inputString) throws FullNameException {
        if (inputString.toLowerCase().matches("^[a-zа-яё]*$")) {
            return inputString;
        } else {
            throw new FullNameException(inputString);
        }
    }

    private long checkPhone(String inputString) throws PhoneException {
        if (inputString.length() == 10) {
            try {
                return Long.parseLong(inputString);
            } catch (NumberFormatException e) {
                throw new PhoneException(inputString);
            }
        } else {
            throw new PhoneException(inputString);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(lastName).append(">")
                .append("<").append(firstName).append(">")
                .append("<").append(patronymic).append(">")
                .append("<").append(phone).append(">");
        return sb.toString();
    }
}
