package com.efimchick.tasks.figures;

abstract class Figure{

    public abstract double area();

    public abstract Point centroid();

    public abstract boolean isTheSame(Figure figure);

    public String toString() {
        throw new UnsupportedOperationException();
    }
}
