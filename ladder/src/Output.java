import java.util.ArrayList;
import java.util.List;

public class Output {
    StringBuilder ladderString = new StringBuilder();
    private List<List<String>> ladder = new ArrayList<>();
    private final String BODY_BLANK = "    ";
    private final String COLUMN_LINE = "ㅣ";
    private final String ROW_LINE = "-----";

    public Output(List<List<String>> ladder) {
        this.ladder = ladder;
    }

    public void firstLineBuild() {
        List<String> playerList = ladder.get(0);
        ladderString.append(" ");
        for (int i = 0; i < playerList.size(); i++) {
            getPlayerLineBlank(playerList.get(i));
            checkPlayerNameLengthOdd(playerList.get(i));
            ladderString.append(playerList.get(i));
            getPlayerLineBlank(playerList.get(i));
            ladderString.append(" ");
        }
        ladderString.append("\n");
    }

    public void getPlayerLineBlank(String playerName) {
        int blankCount = ((6 - playerName.length()) / 2);
        for (int i = 0; i < blankCount; i++) {
            ladderString.append(" ");
        }
    }

    public void checkPlayerNameLengthOdd(String playerName) {
        if (playerName.length() % 2 == 1) {
            ladderString.append(" ");
        }
    }

    public void bodyLineBuild(){
        for(int i = 1; i < ladder.size(); i++){
            ladderLineBuild(ladder.get(i));
        }
    }
    public void ladderLineBuild(List<String> ladderLine){
        ladderString.append(BODY_BLANK);
        for(int i = 0; i < ladderLine.size(); i++){
            ladderString.append(COLUMN_LINE);
            ladderString.append(ladderLine.get(i));
        }
        ladderString.append(COLUMN_LINE + "\n");
    }

    public void testOutput() {
        System.out.println(ladderString);
    }
}
