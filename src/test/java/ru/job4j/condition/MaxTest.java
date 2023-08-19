package ru.job4j.condition;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MaxTest {
    @Test
    void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMax3To2Then3() {
        int left = 3;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMax1To1Then1() {
        int left = 1;
        int right = 1;
        int result = Max.max(left, right);
        int expected = 1;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMax1To2To3Then3() {
        int first = 1;
        int second = 2;
        int third = 3;
        int result = Max.max(first, second, third);
        int expected = 3;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMax4To2To3Then3() {
        int first = 4;
        int second = 2;
        int third = 3;
        int result = Max.max(first, second, third);
        int expected = 4;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMax4To2To3To5Then3() {
        int first = 4;
        int second = 2;
        int third = 3;
        int fourth = 5;
        int result = Max.max(first, second, third, fourth);
        int expected = 5;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMax4To2To3To3Then3() {
        int first = 4;
        int second = 2;
        int third = 3;
        int fourth = 3;
        int result = Max.max(first, second, third, fourth);
        int expected = 4;
        assertThat(result).isEqualTo(expected);
    }
}