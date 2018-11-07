package Machine;

public class Board {
    // Is an array of squares
    // Types:
    // start, chance, prison, parking, toPrison,
    // brown, lightBlue, purple, orange, red, yellow, green, blue
    DanishText text = new DanishText();
    Square[] squares = {
            new Square(-1, text.getSquareTitles(0), text.getSquareDescription(0), "start"),
            new Square(1, text.getSquareTitles(1), text.getSquareDescription(1), "brown"),
            new Square(1, text.getSquareTitles(2), text.getSquareDescription(2),"brown"),
            new Square(0, text.getSquareTitles(3), text.getSquareDescription(3), "chance"),
            new Square(1, text.getSquareTitles(4), text.getSquareDescription(4), "lightBlue"),
            new Square(1, text.getSquareTitles(5), text.getSquareDescription(5), "lightBlue"),
            new Square(0, text.getSquareTitles(6), text.getSquareDescription(6), "prison"),
            new Square(2, text.getSquareTitles(7), text.getSquareDescription(7), "purple"),
            new Square(2, text.getSquareTitles(8), text.getSquareDescription(8), "purple"),
            new Square(0, text.getSquareTitles(9), text.getSquareDescription(9), "chance"),
            new Square(2, text.getSquareTitles(10), text.getSquareDescription(10), "orange"),
            new Square(2, text.getSquareTitles(11), text.getSquareDescription(11), "orange"),
            new Square(0, text.getSquareTitles(12), text.getSquareDescription(12), "parking"),
            new Square(3, text.getSquareTitles(13), text.getSquareDescription(13), "red"),
            new Square(3, text.getSquareTitles(14), text.getSquareDescription(14), "red"),
            new Square(0, text.getSquareTitles(15), text.getSquareDescription(15), "chance"),
            new Square(3, text.getSquareTitles(16), text.getSquareDescription(16), "yellow"),
            new Square(3, text.getSquareTitles(17), text.getSquareDescription(17), "yellow"),
            new Square(0, text.getSquareTitles(18), text.getSquareDescription(18), "toPrison"),
            new Square(4, text.getSquareTitles(19), text.getSquareDescription(19), "green"),
            new Square(4, text.getSquareTitles(20), text.getSquareDescription(20), "green"),
            new Square(0, text.getSquareTitles(21), text.getSquareDescription(21), "chance"),
            new Square(5, text.getSquareTitles(22), text.getSquareDescription(22), "blue"),
            new Square(5, text.getSquareTitles(23), text.getSquareDescription(23), "blue")
    };

    public Square getSquares(int id) {
        return squares[id];

    }
}
