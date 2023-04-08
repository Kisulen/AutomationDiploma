import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class Information {
    private Information(String s, String s1, String s2, String ivan_petrov, String s3) {
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

    private static Faker faker;

    public static String generateRandomCardInfo(String locale) {
        faker = new Faker(new Locale("ru"));
        String creditCard = faker.finance().creditCard();
        return creditCard;
    }





    /*public static long generateCardNumber(String locale, boolean strict){
        faker = new Faker(new Locale("ru"));
        long cardNumber = faker.number().randomNumber(16, strict);
        return cardNumber;
    }

    public static int generateMonth(String locale) {
        faker = new Faker(new Locale("ru"));
        int month = faker.number().numberBetween(1,12);
        return month;
    }

    public static int generateYear(String locale) {
        faker = new Faker(new Locale("ru"));
        int year = faker.number().numberBetween(23,30);
        return year;
    }

    public static String generateName(String locale) {
        faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName();
        return name;
    }

    public static int generateCvc(String locale, boolean strict) {
        faker = new Faker(new Locale("ru"));
        int cvc = (int) faker.number().randomNumber(3, strict);
        return cvc;
    }

    public static CardInfo getRandomCardInfo(String locale, boolean strict) {
        return new CardInfo
                (generateCardNumber("ru", strict), generateMonth("ru"), generateYear("ru"),
                        generateName("ru"), generateCvc("ru", strict));

    }*/

}
