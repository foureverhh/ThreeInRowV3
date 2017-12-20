import java.util.InputMismatchException;
import java.util.Scanner;

public class Game
{
    public static void main(String[] args)
    {
        String winner="";
        int blockAmount;
        int rowAndCol;
        boolean playerIsMachine = false;

        //Create a game board
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create a board first, how many rows do you want?(Should larger or equals to 3)");
        rowAndCol=getRangedInteger(scanner);
        Board board = new Board(rowAndCol);
        blockAmount = rowAndCol*rowAndCol;

        //Create two players
        Player p1 = new HumanPlayer(rowAndCol);
        Player p2;
        //Set player1's name and chess label
        p1.setName();
        p1.setChessLabel();
        //Initialize player2
        System.out.println("Do you want to play with a machine?(Y/N)");
        scanner = new Scanner(System.in);
        if(scanner.nextLine().toLowerCase().equals("y"))
            playerIsMachine=true;

        if(playerIsMachine)
        {
            p2 = new MachinePlayer(rowAndCol);
        }else
        {
            p2 = new HumanPlayer(rowAndCol);
        }
        p2.setName();
        p2.setChessLabel();

        while(p2.getChessLabel().equals(p1.getChessLabel()))
        {
            System.out.println("Player 2 has same chess label to Player 1, input again");
            p2.setChessLabel();;
        }

        //Game begins
        while(winner.equals(""))
        {
            //print a brand new board
           board.newBoard();
           board.printBoard();

           while(blockAmount!=0) {
            //Player1' move
               //Get chess from player1
               board.getChess(p1);
               //Print chess from player1
               board.printBoard();
               //Check whether player1 is winner
               winner=getWinner(p1, board.getBoard());
               //If player1 is winner, stop this round.
               if (winner.equals(p1.getName())) {
                   winnerResult(p1, p2);
                   break;
               }
               //After player1 lain his/her own chess, block amount minus one
               blockAmount--;
               //if block amount equals 0, this round stops.
               if (blockAmount == 0) {
                   evenResult(p1, p2);
                   break;
               }
            //Player2's move
               //check player2
               board.getChess(p2);
               board.printBoard();
               winner=getWinner(p2, board.getBoard());
               if (winner.equals(p2.getName())) {
                   winnerResult(p2, p1);
                   break;
               }
               blockAmount--;
               if (blockAmount == 0) {
                   evenResult(p1, p2);
                   break;
               }
           }
           //If game would restart set winner to be "" and block amount to be original amount.
           winner=restartGame(p1,p2);
           blockAmount=rowAndCol*rowAndCol;
        }

    }

     private static int getRangedInteger(Scanner sc)
    {
        int inputValue = 0;
        while(true)
        {
            try
            {
                String s = sc.nextLine();
                inputValue = Integer.parseInt(s);
                if(inputValue >=3)
                {
                    return inputValue;
                }else
                {
                    throw new Exception();
                }
            }
            catch(InputMismatchException e1)
            {
                System.out.println("Only a number is accepted.");
            }
            catch (Exception e2)
            {
                System.out.println("Create a board larger than 3 rows.");
            }

        }
    }

    private static String restartGame(Player player,Player otherPlayer)
    {
        System.out.println("Game continues?(Y/N)");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.toLowerCase().equals("y"))
        {
            return "";

        }else
        {

            System.out.println("Game is over!" +"\n"+
                    player.getName()+" won "+player.getPoint()+" times."+"\n"+
                    otherPlayer.getName()+" won "+otherPlayer.getPoint()+" times."+"\n");
            return "Game over!";
        }
    }

    private static void winnerResult(Player winnerPlayer,Player otherPlayer)
    {
        System.out.println("Winner is "+winnerPlayer.getName()+" !\n"+
            winnerPlayer.getName()+" wins "+winnerPlayer.getPoint()+" times."+"\n"+
            otherPlayer.getName()+" wins "+otherPlayer.getPoint()+" times."+"\n");
    }


    private static void evenResult(Player player,Player otherPlayer)
    {
        System.out.println("No winner this round !" +"\n"+
                player.getName()+" wins "+player.getPoint()+" times."+"\n"+
                otherPlayer.getName()+" wins "+otherPlayer.getPoint()+" times."+"\n");
    }

    //Get winner
    private static String getWinner(Player player,String[][] board)
    {
        checkWinnerDiagonallyBackslash(player,board);
        if (checkWinnerDiagonallyBackslash(player,board).equals(player.getName())) {
            player.setPoint();
            return checkWinnerDiagonallyBackslash(player,board);
        }

        checkWinnerDiagonallySlash(player,board);
        if (checkWinnerDiagonallySlash(player,board).equals(player.getName())) {
            player.setPoint();
            return checkWinnerDiagonallySlash(player,board);
        }

        checkWinnerHorizontally(player, board);
        if (checkWinnerHorizontally(player, board).equals(player.getName()))
        {
            player.setPoint();
            return checkWinnerHorizontally(player, board);
        }

        checkWinnerVertically(player,board);
        if (checkWinnerVertically(player, board).equals(player.getName()))
        {
            player.setPoint();
            return checkWinnerVertically(player, board);
        }

        return "";
    }

    //Check horizontally
    private static String checkWinnerHorizontally(Player p,String[][] board)
    {
        int i=0;
        while(i<board.length)
        {
            int k=0;
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j].equals(p.getChessLabel()))
                {
                    k++;
                }else
                {
                    break;
                }
            }
            if(k==board.length)
            {
                return p.getName();
            }
            i++;
        }
        return "";
    }


    //Check winner vertically
    private static String checkWinnerVertically(Player p,String[][] board)
    {
        int j=0;
        while(j<board.length)
        {
            int k=0;
            for(int i=0;i<board.length;i++)
            {
                if(board[i][j].equals(p.getChessLabel()))
                {
                    k++;
                }else
                {
                    break;
                }
            }
            if(k==board.length)
            {
                return p.getName();
            }
            j++;
        }
        return "";
    }

    //Check winner diagonally-Backslash
    private static String checkWinnerDiagonallyBackslash(Player p,String[][] board)
    {
        int k=0;
        for(int i=0;i<board.length;i++)
        {
            if(board[i][i].equals(p.getChessLabel()))
            {
                k++;
            }else {
                break;
            }

            if(k==board.length)
            {
                return p.getName();
            }
        }
        return "";
    }

    //Check winner diagonally-slash
    private static String checkWinnerDiagonallySlash(Player p,String[][] board)
    {
        int k=0;
        for(int i=0;i<board.length;i++)
        {
            if(board[i][board.length-i-1].equals(p.getChessLabel()))
            {
                k++;
            }else {
                break;
            }
            if(k==board.length)
            {
                return p.getName();

            }
        }
        return "";
    }


}
