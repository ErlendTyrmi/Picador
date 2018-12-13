package Machine;

public class ChanceCard {
    private String cardName;

    ChanceCard(String name){
        this.cardName = name;
    }

    public String getCardName() {
        return cardName;
    }

    public String getType(){
        // Because some cards may not need actions
        return "Type";
    }
}


