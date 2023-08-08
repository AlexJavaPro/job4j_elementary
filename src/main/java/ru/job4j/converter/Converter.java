package ru.job4j.converter;

public class Converter {

    public static float rubleToEuro(float value) {
        float rsl = value / 70;
        return rsl;
    }

    public static float rubleToDollar(float value) {
        float rsl = value / 60;
        return rsl;
    }

    public static void main(String[] args) {
        float euro = Converter.rubleToEuro(140);
        System.out.println("140 rubles are " + euro + " euro.");
        float expectedEuro  = 2.0f;
        boolean passedEuro = expectedEuro == euro;
        System.out.println("140 rubles are 2. Test result : " + passedEuro);
        float dollar = rubleToDollar(180);
        System.out.println("180 rubles are " + dollar + " dollar.");
        float expectedDollar  = 3.0f;
        boolean passedDollar = expectedDollar == dollar;
        System.out.println("180 rubles are 3. Test result : " + passedDollar);
    }
}