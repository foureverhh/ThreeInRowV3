import java.util.Random;

public class MachinePlayer extends Player
{
    private int x,y;
    private int range;


    public MachinePlayer(int range)
    {
        super(range);
        this.range = range;
    }

    @Override
    void setX(int range) {
        Random random = new Random();
        this.x = random.nextInt(range);
    }

    @Override
    void setY(int range) {
        Random random = new Random();
        this.y = random.nextInt(range);
    }


    @Override
    public void setName() {
        System.out.println("Input a name for the machine player.");
        super.setName();
    }

    @Override
    public void setChessLabel() {
        System.out.println("Input a chess label for the machine player.");
        super.setChessLabel();
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
