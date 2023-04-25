package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Information {
    private Information(String s, String m, String y, String ivan_petrov, String s3) {
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvc;

    }

    public static CardInfo getApprovedCardInfo() {
        return new CardInfo("1111 2222 3333 4444", "04", "25", "Ivan Petrov", "123");
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo("5555 6666 7777 8888", "12", "26", "Vasiliy Pupkin", "000");
    }

    public static CardInfo getRandomCardInfo() {
        return new CardInfo(generateCardNumber(), generateMonth(4), generateYear(3), generateName("en"), generateCvc());
    }

    private static Faker faker;

    public static String generateCardNumber() {
        faker = new Faker();
        String randomCardNumber = faker.business().creditCardNumber();
        return randomCardNumber;
    }

    public static String generateMonth(int shift) {
        return LocalDate.now().plusMonths(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear(int shift) {
        return LocalDate.now().plusYears(shift).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateName(String locale) {
        faker = new Faker(new Locale("en"));
        String randomName = faker.name().fullName();
        return randomName;
    }

    public static String generateCvc() {
        String randomCvc = faker.numerify("###");
        return randomCvc;
    }

}
