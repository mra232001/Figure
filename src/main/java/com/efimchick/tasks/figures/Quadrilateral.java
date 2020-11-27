package com.efimchick.tasks.figures;

//TODO
class Quadrilateral {
    public Point a, b, c, d;
    Quadrilateral(Point a, Point b, Point c, Point d){
        this.a = a; this.b = b; this.c = c; this.d = d;
    }
    public double area(){
        return Math.abs(area.dt(a, b) + area.dt(b, c) + area.dt(c, d) + area.dt(d, a))/2;
    }
    public Point centroid(){
        //TODO
        Segment k1 = new Segment(new Triangle(a, b, c).centroid(), new Triangle(a, c, d).centroid());
        Segment k2 = new Segment(new Triangle(a, b, d).centroid(), new Triangle(b, c, d).centroid());
        return k1.intersection(k2);
    }
    public String toString(){
        String s = "Quadrilateral" + "[(" + a.getX() + "," + a.getY() + ")(" + b.getX() + "," + b.getY() + ")(" + c.getX() + "," + c.getY() + ")(" + d.getX() + "," + d.getY() + ")]";
        return s;
    }
    public boolean isTheSame(Figure figure){
        if(this.toString()==figure.toString()) return true;
        return false;
    }
}
