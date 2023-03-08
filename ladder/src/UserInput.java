import java.util.*;

public class UserInput {

    Scanner scanner = new Scanner(System.in);

    public List<String> getPlayerList() {
        boolean isFlag = false;;
        List<String> playerList = new ArrayList<>();
        while (!isFlag) {
            System.out.println("플레이어들의 이름을 입력해주세요 ex) a,b,c");
            String playerString = scanner.nextLine();
            playerList = Arrays.asList(playerString.split(","));
            isFlag = isValidPlayerInput(playerList);
        }
        return playerList;
    }

    public boolean isValidPlayerInput(List<String> playerString) {
        if (playerString.size() <= 1) {
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
            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            ladderHeight = inputLadderHeight();
            isFlag = isValidLadderHeight(ladderHeight);
        }
        return ladderHeight;

    }

    public int inputLadderHeight() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            scanner.next();
            return 0;
        }
    }

    public boolean isValidLadderHeight(int ladderHeight){
        return ladderHeight > 0;
    }
}
