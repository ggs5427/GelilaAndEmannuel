import java.util.Scanner;

public class GamePlay {

    public GamePlay(){

    }


    void intro(Spot board[][]){
        //initialize array
        for(int i = 0; i < 8;i++){
            for(int j = 0; j < 8;j++){
                board[i][j] = new Spot(false,false,false,null);
            }
        }
        System.out.print("Welcome to Reversi \nTo quit press 'q' to start press any other key: ");
        Scanner sc = new Scanner(System.in);
        if(sc.next().equals("q")){
            quit();
        }
        else{
            play(board);
        }
    }

    void blackMoveMade(Spot board[][], String move, boolean validMove){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 8; i++ ){
            for(int j = 0; j < 8; j++){
                if(move.equals(board[i][j].getPos()) && !board[i][j].isOccupied()
                        && !board[i+1][j].isByBlack() && !board[i][j+1].isByBlack()
                        && !board[i-1][j].isByBlack() && !board[i][j-1].isByBlack()
                        && !board[i+1][j+1].isByBlack() && !board[i-1][j-1].isByBlack()){
                    board[i][j].setOccupied(true);
                    board[i][j].setByBlack(true);
                    validMove = true;
                }
                else{
                    validMove = false;
                    System.out.println("Invalid Move!!");
                }
            }
        }

        printArray(board);
    }

    void whiteMoveMade(Spot board[][], String move, boolean validMove){
        for(int i = 0; i < 8; i++ ){
            for(int j = 0; j < 8; j++){
                if(move.equals(board[i][j].getPos()) && !board[i][j].isOccupied()
                        && !board[i+1][j].isByWhite() && !board[i][j+1].isByWhite()
                        && !board[i-1][j].isByWhite() && !board[i][j-1].isByWhite()
                        && !board[i+1][j+1].isByWhite() && !board[i-1][j-1].isByWhite()){
                    board[i][j].setOccupied(true);
                    board[i][j].setByWhite(true);
                    validMove = true;
                }
                else{
                    validMove = false;
                    System.out.println("Invalid Move!!");
                }
            }
        }

        printArray(board);
    }
    void play(Spot board[][]){
        Scanner sc = new Scanner(System.in);
        System.out.println("The board has been rendered as follows");
        //setting the initial four positions
        board[3][3].setOccupied(true);
        board[3][4].setOccupied(true);
        board[4][3].setOccupied(true);
        board[4][4].setOccupied(true);

        board[3][3].setByWhite(true);
        board[3][4].setByBlack(true);
        board[4][3].setByBlack(true);
        board[4][4].setByWhite(true);

        printArray(assignPos(board));

        boolean occCheck = false;
        for(int i = 0; i < 8; i++ ) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].isOccupied()){
                    occCheck = true;
                }
                if(!board[i][j].isOccupied()){
                    occCheck =  false;
                }
            }
        }
        System.out.println(occCheck);
        int moveCheck = 0;
        boolean validMove = false;

        while(!occCheck){
            if(moveCheck == 0){
                System.out.println("Black makes move: ");
                blackMoveMade(board, sc.next(), validMove);
                moveCheck = 1;
                System.out.println("Valoid move : " + validMove);
            }
            if(moveCheck == 1){
                System.out.println("White makes move: ");
                whiteMoveMade(board, sc.next(), validMove);
                System.out.println("Valoid move : " + validMove);
                moveCheck = 0;
            }
        }

    }

    static void quit(){

    }

    static Spot[][] assignPos(Spot board[][]){
        board[0][0].setPos("A1");
        board[0][1].setPos("B1");
        board[0][2].setPos("C1");
        board[0][3].setPos("D1");
        board[0][4].setPos("E1");
        board[0][5].setPos("F1");
        board[0][6].setPos("G1");
        board[0][7].setPos("H1");
        board[1][0].setPos("A2");
        board[1][1].setPos("B2");
        board[1][2].setPos("C2");
        board[1][3].setPos("D2");
        board[1][4].setPos("E2");
        board[1][5].setPos("F2");
        board[1][6].setPos("G2");
        board[1][7].setPos("H2");
        board[2][0].setPos("A3");
        board[2][1].setPos("B3");
        board[2][2].setPos("C3");
        board[2][3].setPos("D3");
        board[2][4].setPos("E3");
        board[2][5].setPos("F3");
        board[2][6].setPos("G3");
        board[2][7].setPos("H3");
        board[3][0].setPos("A4");
        board[3][1].setPos("B4");
        board[3][2].setPos("C4");
        board[3][3].setPos("D4");
        board[3][4].setPos("E4");
        board[3][5].setPos("F4");
        board[3][6].setPos("G4");
        board[3][7].setPos("H4");
        board[4][0].setPos("A5");
        board[4][1].setPos("B5");
        board[4][2].setPos("C5");
        board[4][3].setPos("D5");
        board[4][4].setPos("E5");
        board[4][5].setPos("F5");
        board[4][6].setPos("G5");
        board[4][7].setPos("H5");
        board[5][0].setPos("A6");
        board[5][1].setPos("B6");
        board[5][2].setPos("C6");
        board[5][3].setPos("D6");
        board[5][4].setPos("E6");
        board[5][5].setPos("F6");
        board[5][6].setPos("G6");
        board[5][7].setPos("H6");
        board[6][0].setPos("A7");
        board[6][1].setPos("B7");
        board[6][2].setPos("C7");
        board[6][3].setPos("D7");
        board[6][4].setPos("E7");
        board[6][5].setPos("F7");
        board[6][6].setPos("G7");
        board[6][7].setPos("H7");
        board[7][0].setPos("A8");
        board[7][1].setPos("B7");
        board[7][2].setPos("C8");
        board[7][3].setPos("D8");
        board[7][4].setPos("E8");
        board[7][5].setPos("F8");
        board[7][6].setPos("G8");
        board[7][7].setPos("H8");

        return board;

    }

    void printArray(Spot board[][]){
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].isOccupied() + " ");
            }
            System.out.println("   ");
        }
    }

    public static void main(String[] args){
        GamePlay p = new GamePlay();
        Spot board[][] = new Spot[8][8];
        p.intro(board);
    }
}
