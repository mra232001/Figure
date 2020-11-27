package com.efimchick.tasks.figures;

class Circle{
    public Point a;
    double r;
    Circle(Point a, double r){
        this.a = a; this.r = r;
    }
    public double area(){
        return Math.PI*Math.PI*r;
    }
    public Point centroid() {
        return a;
    }
    public String toString(){
        String s = "Cỉcle" + "[(" + a.getX() + "," + a.getY() + ")" + r + "]";
        return s;
    }
    public boolean isTheSame(Figure figure){
        if(this.toString()==figure.toString()) return true;
        return false;
    }
}
