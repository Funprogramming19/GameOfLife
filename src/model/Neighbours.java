package model;

enum Neighbours
{
    TOP_LEFT(-1,-1),    TOP(0,-1),      TOP_RIGHT(1,-1),

    LEFT(-1,0),                         RIGHT(1,0),

    BOTTOM_LEFT(-1,1),  BOTTOM(0,1),    BOTTOM_RIGHT(1,1);

    int x;
    int y;

    Neighbours(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
