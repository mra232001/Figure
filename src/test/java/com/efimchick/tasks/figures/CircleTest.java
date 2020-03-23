package com.efimchick.tasks.figures;

import org.junit.Test;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CircleTest {

    @Test
    public void testConstructor() {
        new Circle(new Point(0, 0), 1);
        new Circle(new Point(1, 3), 1);
        new Circle(new Point(-23.5, 236), 56);
        new Circle(new Point(-28.5, -2), 0.001);
        new Circle(new Point(56, -87), 11.1235);
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorZeroRadius() {
        new Circle(new Point(0, 0), 0);
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorNegativeRadius() {
        new Circle(new Point(5, -6), -23);
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorNullCenter() {
        new Circle(null, 23);
    }

    @Test
    public void testArea() {
        assertEquals(3.14159265358979323846, new Circle(new Point(0, 0), 1).area(), 0.000001);
        assertEquals(3.14159265358979323846, new Circle(new Point(1, 3), 1).area(), 0.000001);
        assertEquals(9852.03456165759, new Circle(new Point(-23.5, 236), 56).area(), 0.000001);
        assertEquals(0.00000314159265358979323846, new Circle(new Point(-28.5, -2), 0.001).area(), 0.000001);
        assertEquals(388.71633468071917, new Circle(new Point(56, -87), 11.1235).area(), 0.000001);
    }

    @Test
    public void testCentroid() {
        assertEquals(0, new Circle(new Point(0, 0), 1).centroid().getX(), 0.0001);
        assertEquals(0, new Circle(new Point(0, 0), 1).centroid().getY(), 0.0001);
        assertEquals(1, new Circle(new Point(1, 3), 1).centroid().getX(), 0.0001);
        assertEquals(3, new Circle(new Point(1, 3), 1).centroid().getY(), 0.0001);
        assertEquals(-23.5, new Circle(new Point(-23.5, 236), 56).centroid().getX(), 0.0001);
        assertEquals(236, new Circle(new Point(-23.5, 236), 56).centroid().getY(), 0.0001);
        assertEquals(-28.5, new Circle(new Point(-28.5, -2), 0.001).centroid().getX(), 0.0001);
        assertEquals(-2, new Circle(new Point(-28.5, -2), 0.001).centroid().getY(), 0.0001);
        assertEquals(56, new Circle(new Point(56, -87), 11.1235).centroid().getX(), 0.0001);
        assertEquals(-87, new Circle(new Point(56, -87), 11.1235).centroid().getY(), 0.0001);
    }


    @Test
    public void testToString() {
        assertEquals("Circle[(0.0,0.0)1.0]", new Circle(new Point(0, 0), 1).toString());
        assertEquals("Circle[(1.0,3.0)1.0]", new Circle(new Point(1, 3), 1).toString());
        assertEquals("Circle[(-23.5,236.0)56.0]", new Circle(new Point(-23.5, 236), 56).toString());
        assertEquals("Circle[(-28.5,-2.0)0.001]", new Circle(new Point(-28.5, -2), 0.001).toString());
        assertEquals("Circle[(56.0,-87.0)11.1235]", new Circle(new Point(56, -87), 11.1235).toString());
    }

    @Test
    public void testisTheSame() {
        assertTrue(new Circle(new Point(0, 0), 1).isTheSame(new Circle(new Point(0, 0), 1)));
        assertTrue(new Circle(new Point(1 - (1d / 3 * 3), 3 - (30d / 10)), 1).isTheSame(new Circle(new Point(0, 0), 1)));
        assertTrue(new Circle(new Point(sqrt(2) * sqrt(2), 4 - sqrt(2) * sqrt(2)), sqrt(3) * sqrt(3)).isTheSame(new Circle(new Point(2, 2), 3)));

        assertFalse(new Circle(new Point(sqrt(2) * sqrt(2), 4 - sqrt(2) * sqrt(2)), sqrt(3) * sqrt(3)).isTheSame(new Circle(new Point(2.1, 2), 3)));
        assertFalse(new Circle(new Point(sqrt(2) * sqrt(2), 4 - sqrt(2) * sqrt(2)), sqrt(3) * sqrt(3)).isTheSame(new Circle(new Point(2, 2), 2.9)));
        assertFalse(new Circle(new Point(sqrt(2) * sqrt(2), 4 - sqrt(2) * sqrt(2)), sqrt(3) * sqrt(3)).isTheSame(new Circle(new Point(2, -2.0), 3)));

        assertFalse(new Circle(new Point(0, 0), 1).isTheSame(new Triangle(new Point(0, 1), new Point(1, 1), new Point(1, 0))));
        assertFalse(new Circle(new Point(0, 0), 1).isTheSame(new Quadrilateral(new Point(0, 1), new Point(1, 1), new Point(1, 0), new Point(0, 0))));
    }


}
