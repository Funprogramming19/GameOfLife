package model;

public class Ecosystem
{
    private int x;
    private int y;
    public Cell[][] cells;

    public Ecosystem(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.cells = new Cell[x][y];
    }

    public void populateEcosystem(int y, int x, boolean alive)
    {
        this.cells[x][y] = new Cell(alive);
    }

    public void updateEcosystem()
    {
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                cells[i][j].updateNextState(calculateNeighbours(i, j));
            }
        }
        for (Cell[] cellColumn : cells)
        {
            for (Cell cell : cellColumn)
            {
                cell.updateCell();
            }
        }
    }

    private int calculateNeighbours(int x, int y)
    {
        int newX, newY, ct = 0;
        for (Neighbours neighbour : Neighbours.values())
        {
            newX = x + neighbour.x;
            newY = y + neighbour.y;

            if (newX > 0 && newX < this.x && newY > 0 && newY < this.y)
            {
                if (cells[newX][newY].isAlive())
                    ct++;
            }
        }
        return ct;
    }

}
