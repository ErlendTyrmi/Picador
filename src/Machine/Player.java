package Machine;

public class Player {
    private int position, previousPos, money;
    private String name;
    private boolean inPrison = false, getOutOfPrison = false, passedStart = false;

    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        position = 0;

    }

    public int getPosition() {
        return position;
    }

    public void move(int diceRoll) {
        // Store old position
        previousPos = position;
        // When making movements: Use getNextSquareIndex
        position += diceRoll;
        // Check for out of bounds and passedStart.
        if (position == 24) {
            position = 0;
        } else if (position > 23) {
            position -= 24;
            passedStart = true;
        }

    }

    public int getNextSquareIndex() {
        int nextSquare = previousPos + 1;
        if (nextSquare == 24) {
            nextSquare = 0;
        }
        return nextSquare;
    }

    public int getPreviousPos() {
        return previousPos;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int pay) {
        this.money -= pay;
    }

    public boolean isBroke() {
        if (money <= 0) {
            money = 0;
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

    public void setInPrison(boolean inPrison) {
        this.inPrison = inPrison;
    }

    public void setPosition(int position) {
        this.position = position;
    }

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
