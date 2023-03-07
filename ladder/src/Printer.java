
public class Printer {
    StringBuilder stringBuilder = new StringBuilder();

    public void oneLineStack(String[] line) {
        for (String s : line) {
            stringBuilder.append(s);
        }
        stringBuilder.append("\n");
    }

    public void printResult() {
        System.out.println(stringBuilder);
    }
}
