package ru.job4j.condition;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PointTest {
    @Test
    void when00to20then2() {
        double expected = 2;
        Point point1 = new Point(0, 0);
        Point point2 = new Point(2, 0);
        double out = point1.distance(point2);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when44to44then0() {
        double expected = 0;
        Point point1 = new Point(4, 4);
        Point point2 = new Point(4, 4);
        double out = point1.distance(point2);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when12to21then1dot41() {
        double expected = 1.41;
        Point point1 = new Point(1, 2);
        Point point2 = new Point(2, 1);
        double out = point1.distance(point2);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

        @Test
        void when12to34then2dot82() {
            double expected = 2.83;
            Point point1 = new Point(1, 2);
            Point point2 = new Point(3, 4);
            double out = point1.distance(point2);
            assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when1015to2025then14dot14() {
        double expected = 14.14;
        Point point1 = new Point(10, 15);
        Point point2 = new Point(20, 25);
        double out = point1.distance(point2);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }
}