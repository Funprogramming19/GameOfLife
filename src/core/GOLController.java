package core;

import model.Cell;
import model.Ecosystem;
import processing.core.PApplet;

import static core.Settings.*;

public class GOLController
{
    public Ecosystem model;
    PApplet p;


    public GOLController(PApplet applet)
    {
        this.p = applet;
        model = new Ecosystem(CELL_NUMBER_X, CELL_NUMBER_Y);
        for (int i = 0; i < CELL_NUMBER_X; i++)
            for (int j = 0; j < CELL_NUMBER_Y; j++)
            {
                boolean alive = (int) p.random(0, 2) == 1;
                model.populateEcosystem(j, i, alive);
            }
    }

    public Cell[][] getCells()
    {
        return model.cells;
    }

    public void updateCells()
    {
        model.updateEcosystem();
    }
}
