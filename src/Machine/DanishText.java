package Machine;

import java.util.HashMap;
import java.util.Map;

public class DanishText {

    public final static String greeting ="Klar for en omgang Mata.. jeg mener Picador?";
    public final static String choosePiece = "Klar for en omgang Mata.. jeg mener Picador? Vælg din favoritfigur, og klik derefter START!";
    public final static String dog = "Hund";
    public final static String cat = "Kat";
    public final static String car = "Bil";
    public final static String boat = "Båd";
    public final static String player = "Spiller";
    public final static String firstTurn = " starter. Det er afgjort på baggrund af aktiekursen og vejrforhold. Klik her eller på terningen, så ruller vi i gang!";
    public final static String yourTurn = ", så er det din tur. Klik på terningerne for at spille!";
    public static final String ok = "OK";
    public final static String rollDice = "Slå terningerne!";
    public final static String youBoughtStreet = "\nDu har lige købt ";
    public final static String youPaidRent = "\nDu betaler leje til ";
    public final static String youOwnStreet = "\nDu ejer allerede denne gade. Nyd det!";
    public final static String passedStart = ", du har passeret start og får 1M!";
    public final static String stillInPrison = "Du er havnet i fængsel og må stå over denne omgang! Bare rolig, du har en dyr og god advokat.";
    public final static String exit = "Afslut programmet";
    public final static String congratulations = "Tillykke, ";
    public final static String youWon = " du har vundet! Nu kan du trække dig tilbage og nyde dine ";

    public final static  String[] squareDescriptions = {
            "Start\n\nDu får 1M når du passerer Start! Det lønner sig at stå tidlig op.",
            "Burgerbaren\n\nGod burger, god pris.",
            "Pizzeria\n\nDen bedste pizza nord for Italien! Enkelt og godt!",
            "Chance\n\nTræk et kort i bunken!",
            "Slikbutik\n\nHver dag er fredag i denne butik!",
            "Isbar\n\nGammeldaws flødeis med guf og det hele.",
            "Fængsel\n\nSlap af, hvis du havner her, er du bare på besøg hos en god kollega.",
            "Museum\n\nEn flot gammel bygning, med stolte aner fra Tordenskjolds tid.",
            "Bibliotek\n\nHer kan man betale sine gebyrer, når man alligevel er forbi.",
            "Chance\n\nTræk et kort i bunken!",
            "Skatepark\n\nDen er gratis at bruge, men Colaen koster.",
            "Svømmehal\n\nSnup en svømmetur for 2M.",
            "Parkering\n\nGratis cykelparkering. Tag en velfortjent pause!",
            "Spillehal\n\nHer kan man spille de gamle klassikere, som Monopoly på PC.",
            "Biograf\n\nHer kan man se en god film. Køb dog lidt popcorn!",
            "Chance\n\nTræk et kort i bunken!",
            "Legetøjsbutik\n\nEt paradis for familiens mindste.",
            "Dyrehandel\n\nStort udvalg af kæledyr og dyrefoder",
            "Gå i fængsel\n\nSå klapper fælden! Ryk til fængsel, og stå over en omgang.",
            "Bowling\n\nBowling går aldri helt af mode.",
            "Zoo\n\nKøbenhavns berømte Zoo.",
            "Chance\n\nTræk et kort i bunken!",
            "Vandland\n\nByens populære vandland, med rutchebaner i alle størrelser.",
            "Promenaden\n\nByens fineste gade. Her kan man købe dyrt tøj og dyre smørrebrød."
    };

    public final static String[] squareTitles = {
            "Start",
            "Burgerbaren",
            "Pizzeriaet",
            "Chance",
            "Slikbutikken",
            "Isbaren",
            "Fængsel",
            "Museet",
            "Biblioteket",
            "Chance",
            "Skateparken",
            "Svømmehallen",
            "Parkering",
            "Spillehallen",
            "Biografen",
            "Chance",
            "Legetøjsbutikken",
            "Dyrehandelen",
            "Gå i fængsel",
            "Bowling",
            "Zooet",
            "Chance",
            "Vandlandet",
            "Promenaden."
    };


    // Used by Board
    public static String getSquareDescription(int x) {
        return squareDescriptions[x];
    }
    public static String getSquareTitles(int x){
        return squareTitles[x];
    }
}


