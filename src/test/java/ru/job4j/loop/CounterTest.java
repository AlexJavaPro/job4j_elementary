package ru.job4j.loop;

import org.junit.jupiter.api.Test;
import ru.job4j.loop.Counter;

import static org.assertj.core.api.Assertions.assertThat;

class CounterTest {
    @Test
    void whenSumEvenNumbersFromOneToTenThenThirty() {
        int start = 1;
        int finish = 10;
        int result = Counter.sumByEven(start, finish);
        int expected = 30;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenSumEvenNumbersFromMinus2To10Then28() {
        int start = -2;
        int finish = 10;
        int result = Counter.sumByEven(start, finish);
        int expected = 28;
        assertThat(result).isEqualTo(expected);
    }
}