package core;

import model.Cell;
import processing.core.PApplet;

import static core.Settings.*;

public class GOLView extends PApplet
{
    private int backgroundColor;
    private GOLController controller;
    private Cell[][] cells;
    private int cellDimX;
    private int cellDimY;

    public static void main(String[] args)
    {
        PApplet.main("core.GOLView", args);
    }

    @Override
    public void settings()
    {
        size(SIZE_X, SIZE_Y);
    }

    @Override
    public void setup()
    {
        backgroundColor = color(BACKGROUND_RED, BACKGROUND_GREEN, BACKGROUND_BLUE);

        controller = new GOLController(this);
        cells = controller.getCells();

        cellDimX = SIZE_X / CELL_NUMBER_X;
        cellDimY = SIZE_Y / CELL_NUMBER_Y;

        background(backgroundColor);
        fill(CELL_RED, CELL_GREEN, CELL_BLUE);
        noStroke();
    }

    @Override
    public void draw()
    {
        if (frameCount % SPEED != 0) return;
        background(backgroundColor);
        for (int i = 0; i < Settings.CELL_NUMBER_X; i++)
            for (int j = 0; j < Settings.CELL_NUMBER_Y; j++)
            {
                if (cells[i][j].isAlive())
                {
                    if (CIRCLES)
                        ellipse(i * cellDimX, j * cellDimY, cellDimX, cellDimY);
                    else
                        rect(i * cellDimX, j * cellDimY, cellDimX, cellDimY);
                }
            }
        controller.updateCells();
    }
    //TODO: leaf cell skin
    //TODO: background
}
