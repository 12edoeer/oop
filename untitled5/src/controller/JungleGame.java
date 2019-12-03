package controller;

import model.GameBoard;
import model.Player;
import view.JungleView;

public class JungleGame {
    private GameBoard jungleBoard;
    private Player x = new Player();
    private Player y = new Player();


    //Store the character into the jungleBoard Array
    JungleGame() {
        jungleBoard = new GameBoard();

        jungleBoard.Insert(x.traps, 2, 0);
        jungleBoard.Insert(x.traps, 4, 0);
        jungleBoard.Insert(x.traps, 3, 1);
        jungleBoard.Insert(x.den, 3, 0);
        jungleBoard.Insert(y.traps, 2, 8);
        jungleBoard.Insert(y.traps, 4, 8);
        jungleBoard.Insert(y.traps, 3, 7);
        jungleBoard.Insert(y.den, 3, 8);
    }

    //Get the name of Players
    void getName() {
        JungleView.message("Please input player 1 name:");
        x.SetName(GetInput.Input());
        JungleView.message("Please input player 2 name:");
        y.SetName(GetInput.Input());
    }

    // The function print the jungleBoard and user name
    String getPlayer1Name() {
        return x.GetName();
    }

    String getPlayer2Name() {
        return y.GetName();
    }

    void boardPrint() {
        JungleView.PrintBoard(x.GetName(), y.GetName(), jungleBoard.getJungleBoard());
    }

    //Create the chess in first time
    void ChessInsert() {

        x.ChessCreator(0, 0, 6);
        jungleBoard.Insert(x.GetChess(6), x.GetX(6), x.GetY(6));

        x.ChessCreator(6, 0, 5);
        jungleBoard.Insert(x.GetChess(5), x.GetX(5), x.GetY(5));

        x.ChessCreator(1, 1, 2);
        jungleBoard.Insert(x.GetChess(2), x.GetX(2), x.GetY(2));

        x.ChessCreator(5, 1, 1);
        jungleBoard.Insert(x.GetChess(1), x.GetX(1), x.GetY(1));

        x.ChessCreator(0, 2, 0);
        jungleBoard.Insert(x.GetChess(0), x.GetX(0), x.GetY(0));

        x.ChessCreator(2, 2, 4);
        jungleBoard.Insert(x.GetChess(4), x.GetX(4), x.GetY(4));

        x.ChessCreator(4, 2, 3);
        jungleBoard.Insert(x.GetChess(3), x.GetX(3), x.GetY(3));

        x.ChessCreator(6, 2, 7);
        jungleBoard.Insert(x.GetChess(7), x.GetX(7), x.GetY(7));
        ////////////////////////////////////
        ////////////////////////////////////
        ///////////////////////////////
        y.ChessCreator(0, 8, 5);
        jungleBoard.Insert(x.GetChess(5), y.GetX(5), y.GetY(5));

        y.ChessCreator(6, 8, 6);
        jungleBoard.Insert(x.GetChess(6), y.GetX(6), y.GetY(6));

        y.ChessCreator(1, 7, 1);
        jungleBoard.Insert(x.GetChess(1), y.GetX(1), y.GetY(1));

        y.ChessCreator(5, 7, 2);
        jungleBoard.Insert(x.GetChess(2), y.GetX(2), y.GetY(2));

        y.ChessCreator(0, 6, 7);
        jungleBoard.Insert(x.GetChess(7), y.GetX(7), y.GetY(7));

        y.ChessCreator(2, 6, 3);
        jungleBoard.Insert(x.GetChess(3), y.GetX(3), y.GetY(3));

        y.ChessCreator(4, 6, 4);
        jungleBoard.Insert(x.GetChess(4), y.GetX(4), y.GetY(4));

        y.ChessCreator(6, 6, 0);
        jungleBoard.Insert(x.GetChess(0), y.GetX(0), y.GetY(0));
    }

    //Build the board with no chess


    public boolean UserMove(int OriX, int OriY, int targetX, int targetY, int player) {

        ////////////////////////////////////////////////////////////////////////////
        // One space move only else you are tiger or lion can jump over the river //
        ////////////////////////////////////////////////////////////////////////////
        if (targetX - OriX + targetY - OriY > 1 && jungleBoard.getChessChar(OriX, OriY) != 'L' &&
                jungleBoard.getChessChar(OriX, OriY) != 't') {
            JungleView.messageWithNextLine("Invalid input, you can only move vertically or horizontally with one space");
            return false;
        }

        /////////////////////////////////
        // Only rat can get into river //
        /////////////////////////////////
        if (jungleBoard.getChessChar(targetX, targetY) == 'W') {
            if (jungleBoard.getChessChar(OriX, OriY) != 'r') {
                JungleView.messageWithNextLine("You cant get into river");
                return false;
            }
        }

        if (player == 1) {
            if (!x.isYourOwnChess(OriX, OriY)) {
                JungleView.messageWithNextLine("It is not your chess");
                return false;
            }
            if (x.isYourOwnChess(OriX, OriY) && x.isYourOwnChess(targetX, targetY)) {
                JungleView.messageWithNextLine("Same player chess, not a valid move");
                return false;
            }
            x.chessCoordinateUpdate(OriX, OriY, targetX, targetY);
        }

        if (player == 2) {
            if (!y.isYourOwnChess(OriX, OriY)) {
                JungleView.messageWithNextLine("It is not your chess");
                return false;
            }
            if (y.isYourOwnChess(OriX, OriY) && y.isYourOwnChess(targetX, targetY)) {
                JungleView.messageWithNextLine("Same player chess, not a valid move");
                return false;
            }
            y.chessCoordinateUpdate(OriX, OriY, targetX, targetY);
        }


        jungleBoard.Insert(jungleBoard.getChessChar(OriX, OriY), targetX, targetY);
        jungleBoard.Insert(' ', OriX, OriY);

/*
        if (WaterBoard[OriY][OriX] == 1) {
            jungleBoard.Insert(, OriY, OriX, 10);
            jungleBoard.getChessChar(OriX, OriY) = 'W';
        }
*/
        JungleView.messageWithNextLine("Moved");
        return true;
    }


    public void Fight() {

    }
}