package com.efimchick.tasks.figures;

public class Segment {
    Point start, end;
    public Segment(Point start, Point end) {
        if(start.getX()==end.getX() && start.getY()==end.getY()){
            throw new RuntimeException();
        }
        /* TODO */
        this.start = start;
        this.end = end;
        if(start.getX() > end.getX()){
            Point t = start;
            this.start = this.end;
            this.end = t;
        }
    }

    double length() {
        //TODO
        double res = Math.pow(start.getX() - end.getX(), 2.0) + Math.pow(start.getY()  - end.getY(), 2.0);
        res = Math.sqrt(res);
        return res;
    }

    Point middle() {
        //TODO
        return new Point((start.getX() + end.getX())/2.0, (start.getY() + end.getY())/2.0);
    }

    Point intersection(Segment another) {
        //TODO
        double m1 = end.getX() - start.getX();
        double n1 = end.getY() - start.getY();
        double m2 = another.end.getX() - another.start.getX();
        double n2 = another.end.getY() - another.start.getY();
        double k1 = n1*start.getX() - m1*start.getY();
        double k2 = n2*another.start.getX() - m2*another.start.getY();
        double d = -n1*m2 + m1*n2;
        double dx = -k1*m2 + k2*m1;
        double dy = n1*k2 - k1*n2;
        if(d==0){
            if(dx == dy && dx==0){
                if(this.start.getX()==another.end.getX() && this.start.getY()==another.end.getY()){
                    return this.start;
                }
                if(this.end.getX()==another.start.getX() && this.end.getY()==another.start.getY()){
                    return this.end;
                }
            }
            return null;
        }
        double d1 = dx/d;
        double d2 = dy/d;
        if(d1 >= Math.min(start.getX(), end.getX()) && d1 <= Math.max(start.getX(), end.getX())){
            if(d1 >= Math.min(another.start.getX(), another.end.getX()) && d1 <= Math.max(another.start.getX(), another.end.getX())){
                if(d2 >= Math.min(start.getY(), end.getY()) && d2 <= Math.max(start.getY(), end.getY())){
                    if(d2 >= Math.min(another.start.getY(), another.end.getY()) && d2 <= Math.max(another.start.getY(), another.end.getY())){
                        return new Point(dx/d, dy/d);
                    }
                }
            }
        }
        return null;
    }

}
