package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var personList = phones.find("Petr");
        assertThat(personList.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenFindNull() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var personList = phones.find("ferfe");
        assertThat(personList.isEmpty()).isEqualTo(true);
    }
}