package Machine;

import java.util.HashMap;
import java.util.Map;

public class DanishText {

    public static String greeting ="Klar for en omgang Mata.. jeg mener Picador?";
    public static String choosePiece = "Klar for en omgang Mata.. jeg mener Picador? Vælg din favoritfigur, og klik derefter START!";
    public static String dog = "Hund";
    public static String cat = "Kat";
    public static String car = "Bil";
    public static String boat = "Båd";
    public static String player = "Spiller";
    public static String yourTurn = "Så er det din tur.";
    public static String rollDice = "Slå terningerne!";

    private String[] squareDescriptions = {
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

    private String[] squareTitles = {
            "Start",
            "Burgerbaren",
            "Pizzeria",
            "Chance",
            "Slikbutik",
            "Isbar",
            "Fængsel",
            "Museum",
            "Bibliotek",
            "Chance",
            "Skatepark",
            "Svømmehal",
            "Parkering",
            "Spillehal.",
            "Biograf!",
            "Chance",
            "Legetøjsbutik",
            "Dyrehandel",
            "Gå i fængsel",
            "Bowling",
            "Zoo.",
            "Chance",
            "Vandland",
            "Promenaden."
    };

    public String getSquareDescription(int x) {
        return squareDescriptions[x];
    }

    public String getSquareTitles(int x) {
        return squareTitles[x];
    }
}


