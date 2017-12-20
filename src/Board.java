public class Board
{
    private int x,y;
    private String[][] board;
    private int rolAndCol;
    private boolean playerIsMachine;

    public Board(int rolNumber)
    {
        this.rolAndCol= rolNumber;
        this.board = new String[rolAndCol][rolAndCol];
    }

    public void newBoard()
    {
        for(int i = 0;i<rolAndCol;i++)
            for(int j = 0; j<rolAndCol;j++)
                board[i][j]=" ";
    }

    public void printBoard()
    {
        System.out.println("Enjoy your game,and good luck!");
        System.out.println();
        System.out.print("    ");
        for(int i=0;i<board.length;i++)
        {
            System.out.print("  "+(i+1)+"  ");
        }
        System.out.println();

        System.out.print("    ");
        for(int i=0;i<board.length;i++)
        {
            System.out.print(" ----");
        }
        System.out.println();

        for(int i=0;i<board.length;i++)
        {

            System.out.print("  "+(i+1)+" ");
            for(int j=0;j<board.length;j++)
            {
                System.out.print("| "+board[i][j]+"  ");
            }
            System.out.println("|  ");
            System.out.print("    ");
            for(int k=0;k<board.length;k++)
            {
                System.out.print(" ----");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void getChess(Player p)
    {
        p.setX(rolAndCol);
        p.setY(rolAndCol);

        while(!board[p.getX()][p.getY()].equals(" ") && !board[p.getX()][p.getY()].isEmpty())
        {
            if(!playerIsMachine) {
                System.out.println("The place you chose is taken, choose again");
            }
            p.setX(rolAndCol);
            p.setY(rolAndCol);
        }
        board[p.getX()][p.getY()]=p.getChessLabel();
    }

    public String[][] getBoard()
    {
        return board;
    }
}
