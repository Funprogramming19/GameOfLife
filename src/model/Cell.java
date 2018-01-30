package model;

public class Cell
{
    private boolean alive;
    private boolean nextState;

    Cell(boolean alive)
    {
        this.alive = alive;
        this.nextState = alive;
    }

    public void updateNextState(int neighbours)
    {
        if (isAlive())
        {
            nextState = (neighbours >= 2 && neighbours <= 3);
        }
        else
            if (neighbours == 3) nextState = true;
    }

    public void updateCell()
    {
        alive = nextState;
    }

    public boolean isAlive()
    {
        return alive;
    }
}
