import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ladderController {

    private List<List> ladder = new ArrayList<>();
    private int ladderHeight;
    private int playerSize;

    public void startLadderGame(){
        loadInput(new UserInput());
    }

    public void loadInput(UserInput userInput) {
        List<String> playerList = userInput.getPlayerList();
        playerSize = playerList.size();
        ladder.add(playerList);
        ladderHeight = userInput.getLadderHeight();
        createLadder();
    }

    public void createLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new ArrayList<String>());
        }
        drawLadder();
    }

    public void drawLadder() {
        for (int i = 1; i <= ladderHeight; i++) {
            ladderDrawLine(i);
        }
        testPrintList();
    }

    public void ladderDrawLine(int ladderYNumber) {
        for (int i = 0; i < playerSize; i++) {
            randomSetLine(ladderYNumber, i);
        }
    }

    public void randomSetLine(int ladderYNumber, int index) {
        if(index != 0 && ladder.get(ladderYNumber).get(index - 1).equals("-----")){
            ladder.get(ladderYNumber).add("     ");
            return;
        }
        if(randomBoolean()){
            ladder.get(ladderYNumber).add("-----");
            return;
        }
        ladder.get(ladderYNumber).add("     ");
    }

    public void testPrintList(){
        for(int i = 0; i< ladder.size(); i++){
            for(int j = 0; j<ladder.get(i).size(); j++){
                System.out.print(ladder.get(i).get(j));
            }
            System.out.println();
        }
    }

    public boolean randomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
