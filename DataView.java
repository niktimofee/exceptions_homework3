import java.util.Scanner;

public class DataView implements View {

    private Scanner in = new Scanner(System.in, "IBM866");

    @Override
    public void printOutputData(String message) {
        System.out.printf("%s", message);
    }

    @Override
    public String getInputData(String message) {
        System.out.printf("%s", message);
        return in.nextLine();
    }
}
