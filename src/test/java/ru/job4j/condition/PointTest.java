package ru.job4j.condition;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PointTest {
    @Test
    void when00to20then2() {
        double expected = 2;
        int x1 = 0;
        int y1 = 0;
        int x2 = 2;
        int y2 = 0;
        double out = Point.distance(x1, y1, x2, y2);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when44to44then0() {
        double expected = 0;
        int x1 = 4;
        int y1 = 4;
        int x2 = 4;
        int y2 = 4;
        double out = Point.distance(x1, y1, x2, y2);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when12to21then1dot41() {
        double expected = 1.41;
        int x1 = 1;
        int y1 = 2;
        int x2 = 2;
        int y2 = 1;
        double out = Point.distance(x1, y1, x2, y2);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

        @Test
        void when12to34then2dot82() {
            double expected = 2.82;
            int x1 = 1;
            int y1 = 2;
            int x2 = 3;
            int y2 = 4;
            double out = Point.distance(x1, y1, x2, y2);
            assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when1015to2025then14dot14() {
        double expected = 14.14;
        int x1 = 10;
        int y1 = 15;
        int x2 = 20;
        int y2 = 25;
        double out = Point.distance(x1, y1, x2, y2);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }
}