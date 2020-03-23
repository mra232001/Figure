package com.efimchick.tasks.figures;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertSame;

public class ComparatorsCollectionTest {

    private List<Figure> figures;
    private Circle c1;
    private Circle c2;
    private Circle c3;
    private Triangle t1;
    private Triangle t2;
    private Triangle t3;
    private Quadrilateral q1;
    private Quadrilateral q2;
    private Quadrilateral q3;

    @Before
    public void setup() {
        c1 = new Circle(new Point(0, 9), 7);
        c2 = new Circle(new Point(1, 9), 10);
        c3 = new Circle(new Point(-1, 9), 9.5);
        t1 = new Triangle(new Point(0, 20), new Point(20, 0), new Point(-20, 0));
        t2 = new Triangle(new Point(-15, 0), new Point(-10, 20), new Point(-5, 0));
        t3 = new Triangle(new Point(-14, 0), new Point(-10, 10), new Point(-5, 0));
        q1 = new Quadrilateral(new Point(-30, -30), new Point(-30, 30), new Point(30, 30), new Point(30, -30));
        q2 = new Quadrilateral(new Point(-20, -100), new Point(-20, 100), new Point(30, 30), new Point(30, -30));
        q3 = new Quadrilateral(new Point(-10, -10), new Point(-10, 10), new Point(10, 30), new Point(30, -10));


        figures = Arrays.asList(c1, c2, c3, t1, t2, t3, q1, q2, q3);
    }

    @Test
    public void compareByArea() {

        final Comparator<Figure> comparator = ComparatorsCollection::compareByArea;

        testCaseMin(t3, Figure.class, comparator);
        testCaseMax(q2, Figure.class, comparator);
        testCaseMin(c1, Circle.class, comparator);
        testCaseMax(c2, Circle.class, comparator);
        testCaseMin(t3, Triangle.class, comparator);
        testCaseMax(t1, Triangle.class, comparator);
        testCaseMin(q3, Quadrilateral.class, comparator);
        testCaseMax(q2, Quadrilateral.class, comparator);
    }

    @Test
    public void compareByHorizontalStartPosition() {
        final Comparator<Figure> comparator = ComparatorsCollection::compareByHorizontalStartPosition;

        testCaseMin(t2, Figure.class, comparator);
        testCaseMax(q3, Figure.class, comparator);
        testCaseMin(c3, Circle.class, comparator);
        testCaseMax(c2, Circle.class, comparator);
        testCaseMin(t2, Triangle.class, comparator);
        testCaseMax(t1, Triangle.class, comparator);
        testCaseMin(q1, Quadrilateral.class, comparator);
        testCaseMax(q3, Quadrilateral.class, comparator);
    }

    @Test
    public void compareByHorizontalCenterPosition() {
        final Comparator<Figure> comparator = ComparatorsCollection::compareByHorizontalCenterPosition;

        testCaseMin(q1, Figure.class, comparator);
        testCaseMax(c1, Figure.class, comparator);
        testCaseMin(c3, Circle.class, comparator);
        testCaseMax(c1, Circle.class, comparator);
        testCaseMin(t1, Triangle.class, comparator);
        testCaseMax(t3, Triangle.class, comparator);
        testCaseMin(q1, Quadrilateral.class, comparator);
        testCaseMax(q3, Quadrilateral.class, comparator);
    }

    private <T extends Figure> void testCaseMin(final T expected, final Class<T> figureClass, final Comparator<Figure> comparator) {
        assertSame(expected, figures.stream().filter(figureClass::isInstance).min(comparator).get());
    }

    private <T extends Figure> void testCaseMax(final T expected, final Class<T> figureClass, final Comparator<Figure> comparator) {
        assertSame(expected, figures.stream().filter(figureClass::isInstance).max(comparator).get());
    }
}