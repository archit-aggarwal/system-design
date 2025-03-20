package piece;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PieceFactory {
    private final Scanner scanner = new Scanner(System.in);
    private final Map<Character, Piece> pieces = new HashMap<>();

    public Piece getPiece() {
        while(true) {
            try {
                System.out.print("Enter Piece Symbol [1 Character] : ");
                String input = scanner.next();
                if(input.length() != 1) {
                    throw new Exception("Please enter only 1 character");
                }

                Character pieceType = input.charAt(0);
                if (pieces.containsKey(pieceType) || pieceType <= 32) {
                    throw new Exception("Symbol '" + pieceType + "' is invalid or already used");
                }

                Piece piece = new Piece(pieceType);
                pieces.put(pieceType, piece);
                return piece;
            }
            catch (Exception e) {
                System.out.println(e.getMessage() + ", Please Try Again!");
            }
        }
    }
}
