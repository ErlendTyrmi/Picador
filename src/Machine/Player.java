package Machine;

public class Player {
    private int position, money;
    private String name;
    private boolean inPrison = false, getOutOfPrison = false;

    public Player(String name) {
        this.name = name;
        money = 20;
        position = 0;

    }

    public int getPosition() {
        return position;
    }

    public void move(int diceA, int diceB) {
        position += diceA + diceB;
        // Check for out of bounds.
        if (position > 23) {
            position -= 24;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {

        this.money = money;
    }

    public boolean isBroke() {
        if (money >= 0) {
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

    public boolean hasGetOutOfPrison() {
        return getOutOfPrison;
    }
}
