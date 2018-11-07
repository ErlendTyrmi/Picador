package Machine;

import java.util.HashMap;
import java.util.Map;

public class DanishText {

    private String[] squareDescriptions = {
            "Start\n\nDu får 1M når du passerer Start! Det lønner sig at stå tidlig op.",
            "Burgerbaren\n\nGod burger, god pris.",
            "Pizzeria\n\nDen bedste pizza nord for Italien! Enkelt og godt!",
            "Chance\n\nTræk et kort i bunken!",
            "Slikbutik\n\nHver dag er fredag i denne butik!",
            "Isbar\\Gammeldaws frødeis med guf og det hele.",
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
            "Legetøjsbutik\n\nEt paradis for familiens mindste.",
            "Dyrehandel\n\nStort udvalg af kæledyr og dyrefoder",
            "Gå i fængsel\n\nSå klapper fælden! Ryk til fængsel, og stå over en omgang.",
            "Bowling\n\nBowling går aldri helt af mode.",
            "Zoo\n\nKøbenhavns berømte Zoo.",
            "Chance\n\nTræk et kort i bunken!",
            "Vandland\n\nByens populære vandland, med rutchebaner i alle størrelser.",
            "Promenaden\n\nByens fineste gade. Her kan man købe dyrt tøj og dyre smørrebrød."
    };

    DanishText() {

        //Creating map of Books
        Map<String, String> map = new HashMap<String, String>();
        //Creating Books
        map.put("Greeting", "Klar for en omgang Monopoly? Vælg din favoritfigur!");
        map.put("Player", "Spiller");
        map.put("Your Turn", "Så er det din tur.");
        map.put("Roll Dice", "Slå terningerne!");
    }

    public String getSquareDescription(int x) {
        return squareDescriptions[x];
    }

    public String getSquareTitles(int x) {
        return squareTitles[x];
    }
}


