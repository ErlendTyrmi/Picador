package Machine;

public class Board {
    // Is an array of squares
    // Types:
    // start, chance, prison, parking, toPrison,
    // brown, lightBlue, purple, orange, red, yellow, green, blue
    private Player bank = new Player("Banken");
    DanishText text = new DanishText();

    Square[] squares = {
            new Square(-1, text.getSquareTitles(0), text.getSquareDescription(0), "start", bank),
            new Square(1, text.getSquareTitles(1), text.getSquareDescription(1), "brown", bank),
            new Square(1, text.getSquareTitles(2), text.getSquareDescription(2),"brown", bank),
            new Square(0, text.getSquareTitles(3), text.getSquareDescription(3), "chance", bank),
            new Square(1, text.getSquareTitles(4), text.getSquareDescription(4), "lightBlue", bank),
            new Square(1, text.getSquareTitles(5), text.getSquareDescription(5), "lightBlue", bank),
            new Square(0, text.getSquareTitles(6), text.getSquareDescription(6), "prison", bank),
            new Square(2, text.getSquareTitles(7), text.getSquareDescription(7), "purple", bank),
            new Square(2, text.getSquareTitles(8), text.getSquareDescription(8), "purple", bank),
            new Square(0, text.getSquareTitles(9), text.getSquareDescription(9), "chance", bank),
            new Square(2, text.getSquareTitles(10), text.getSquareDescription(10), "orange", bank),
            new Square(2, text.getSquareTitles(11), text.getSquareDescription(11), "orange", bank),
            new Square(0, text.getSquareTitles(12), text.getSquareDescription(12), "parking", bank),
            new Square(3, text.getSquareTitles(13), text.getSquareDescription(13), "red", bank),
            new Square(3, text.getSquareTitles(14), text.getSquareDescription(14), "red", bank),
            new Square(0, text.getSquareTitles(15), text.getSquareDescription(15), "chance", bank),
            new Square(3, text.getSquareTitles(16), text.getSquareDescription(16), "yellow", bank),
            new Square(3, text.getSquareTitles(17), text.getSquareDescription(17), "yellow", bank),
            new Square(0, text.getSquareTitles(18), text.getSquareDescription(18), "toPrison", bank),
            new Square(4, text.getSquareTitles(19), text.getSquareDescription(19), "green", bank),
            new Square(4, text.getSquareTitles(20), text.getSquareDescription(20), "green", bank),
            new Square(0, text.getSquareTitles(21), text.getSquareDescription(21), "chance", bank),
            new Square(5, text.getSquareTitles(22), text.getSquareDescription(22), "blue", bank),
            new Square(5, text.getSquareTitles(23), text.getSquareDescription(23), "blue", bank)
    };

    public Square getSquares(int id) {
        return squares[id];

    }
}
