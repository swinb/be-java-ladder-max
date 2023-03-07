import java.util.Random;
import java.util.Scanner;

public class ladderController {

    private String[][] ladder;

    public void createLadder() {
        System.out.println("플레이어의 수를 입력해주세요");
        int ladderX = integerInput();
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        int ladderY = integerInput();
        ladder = new String[ladderY][ladderX * 2 - 1];
        drawLadder();
    }

    public void drawLadder() {
        for (int i = 0; i < ladder.length; i++) {
            ladderDrawColumn(i);
            ladderDrawLine(i);
        }
    }

    public void ladderDrawColumn(int ladderYNumber) {
        for (int i = 0; i < ladder[ladderYNumber].length; i += 2) {
            ladder[ladderYNumber][i] = "ㅣ";
        }
    }

    public void ladderDrawLine(int ladderYNumber) {
        for (int i = 1; i < ladder[ladderYNumber].length; i += 2) {
            ladder[ladderYNumber][i] = randomSetLine();
        }
    }

    public String randomSetLine() {
        if (randomBoolean())
            return " ";
        return "-";
    }

    public boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }


    public void printLadder() {
        Printer printer = new Printer();
        for (int i = 0; i < ladder.length; i++) {
            printer.oneLineStack(ladder[i]);
        }
        printer.printResult();
    }

    public int integerInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}