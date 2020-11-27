package com.efimchick.tasks.figures;

public class area {
    public static double dt(Point a, Point b){
        return (b.getX() - a.getX())*(a.getY() + b.getY());
    }
}
