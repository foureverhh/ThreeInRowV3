import java.util.*;

public class HumanPlayer extends Player
{
    private int x,y;
    private int range;

    public HumanPlayer(int range)
    {
        super(range);
        this.range = range;
    }

    @Override
    void setX(int range) {
        System.out.println(this.getName()+" , input your X coordinate please: ");
        Scanner scanner = new Scanner(System.in);
        int a = getRangedInteger(scanner,range);
        this.x = a-1;
    }

    @Override
    void setY(int range) {
        System.out.println(this.getName()+" , input your Y coordinate please: ");
        Scanner scanner = new Scanner(System.in);
        int a = getRangedInteger(scanner,range);
        this.y = a-1;
    }

    @Override
    public void setName() {
        System.out.println("Player, input your name here please: ");
        super.setName();
    }

    @Override
    public void setChessLabel() {
        System.out.println("Input your chess label please: ");
        super.setChessLabel();
    }

    private int getRangedInteger(Scanner sc,int range)
    {
        int inputValue = 0;
        while(true)
        {
            try
            {
                String s = sc.nextLine();
                inputValue = Integer.parseInt(s);
                if(inputValue >= 1 && inputValue <= range)
                {
                    return inputValue;
                }else
                {
                    throw new Exception();
                }
            } catch (InputMismatchException e1)
            {
                System.out.println("Only a number is accepted, try again.");
            } catch (Exception e2) {
                System.out.println("Do not input 0 or a number bigger than row number.");
            }
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
