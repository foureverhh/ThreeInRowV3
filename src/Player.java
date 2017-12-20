import java.util.Scanner;

public abstract class Player
{
    private int x,y;
    private String name,chessLabel;
    private int range;
    private int point;



    public Player(int range)
    {
        this.range =range;
    }


    abstract void setX(int range);

    abstract void setY(int range);

    public void setRange(int range) {
        this.range = range;
    }

    public void setName()
    {
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
    }

    public void setChessLabel()
    {
        Scanner sc = new Scanner(System.in);
        this.chessLabel = sc.nextLine();
    }

    public int getPoint() {
        return point;
    }

    public void setPoint() {
        this.point++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public String getChessLabel() {
        return chessLabel;
    }

    public int getRange() {
        return range;
    }
}
