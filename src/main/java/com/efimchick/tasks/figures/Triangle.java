package com.efimchick.tasks.figures;

//TODO
class Triangle {
    public Point a, b, c;
    Triangle (Point a, Point b, Point c){
        this.a = a; this.b = b; this.c = c;
    }
    public double area(){
        return Math.abs(area.dt(a, b) + area.dt(b, c) + area.dt(c, a))/2;
    }
    public Point centroid(){
        //TODO
        return new Point((a.getX() + b.getX() + c.getX())/3, (a.getY() + b.getY() + c.getY())/3);
    }

    public String toString(){
        String s = "Triangle" + "[(" + a.getX() + "," + a.getY() + ")(" + b.getX() + "," + b.getY() + ")(" + c.getX() + "," + c.getY() + ")]";
        return s;
    }
    public boolean isTheSame(Figure figure){
        if(this.toString()==figure.toString()) return true;
        return false;
    }
}
