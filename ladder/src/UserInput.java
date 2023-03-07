import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    public ArrayList<String> getPlayerList() {
        boolean isFlag = false;
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> playerList = new ArrayList<>();
        while (!isFlag) {
            String playerString = scanner.nextLine();
            playerList = (ArrayList<String>) Arrays.asList(playerString.split(","));
            isFlag = isValidPlayerInput(playerList);
        }
        scanner.close();
        return playerList;
    }

    public boolean isValidPlayerInput(ArrayList<String> playerString) {
        if (playerString.size() == 0) {
            return false;
        }
        boolean isValid = true;
        for (String player : playerString) {
            isValid = isCorrectNameLength(player, isValid);
        }
        return isValid;
    }

    public boolean isCorrectNameLength(String playerName, boolean isValid) {
        return playerName.length() <= 5 && isValid;
    }

    public int getLadderHeight() {
        boolean isFlag = false;
        int ladderHeight = 0;
        while (!isFlag) {
            ladderHeight = inputLadderHeight();
            isFlag = isValidLadderHeight(ladderHeight);
        }
        return ladderHeight;

    }

    public int inputLadderHeight() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            return 0;
        }
    }

    public boolean isValidLadderHeight(int ladderHeight){
        return ladderHeight > 0;
    }
}
