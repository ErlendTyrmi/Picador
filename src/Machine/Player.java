package Machine;

public class Player {
    private int position, money;

    public Player() {

    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

}
