package Machine;

public class Player {
    private int position, money;
    private String name;
    private boolean inPrison = false, getOutOfPrison = false, passedStart = false;

    public Player(String name) {
        this.name = name;
        money = 20;
        position = 0;

    }

    public int getPosition() {
        return position;
    }

    public void move(int diceRoll) {
        // When making movements: Use getNextSquare
        position += diceRoll;
        // Check for out of bounds and passedStart.
        if (position == 24){
            position = 0;
        } else if (position > 23) {
            position -= 24;
            passedStart = true;
        }

    }

    private int getNextSquare(){
        int nextPosition = position + 1;
        if (nextPosition == 24){
            nextPosition = 0;
        }
        return nextPosition;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int pay){
        this.money -= pay;
    }

    public boolean isBroke() {
        if (money <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isInPrison() {
        return inPrison;
    }

    public void setInPrison(boolean inPrison) { this.inPrison = inPrison; }

    public void setPosition(){ this.position = position; }

    public boolean hasGetOutOfPrison() {
        return getOutOfPrison;
    }

    public boolean hasPassedStart() {
        return passedStart;
    }

    public void setPassedStart(boolean passedStart) {
        this.passedStart = passedStart;
    }
}
