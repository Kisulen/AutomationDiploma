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

    @Value
    public static class RandomInfo {
        private String randomCardNumber;
        private String randomMonth;
        private String randomYear;
        private String randomOwner;
        private String randomCvc;
    }

    private static Faker faker;

    public static String generateCardNumber(String locale) {
        faker = new Faker(new Locale("ru"));
        String randomCardNumber = faker.business().creditCardNumber();
        return randomCardNumber;
    }

    public static String generateMonth(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateYear(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateName(String locale) {
        faker = new Faker(new Locale("ru"));
        String randomName = faker.name().fullName();
        return randomName;
    }

    public static String generateCvc() {
        //faker = new Faker(new Locale("ru"));
        String randomCvc = faker.numerify("###");
        return randomCvc;
    }

    public static RandomInfo generateRandomCardInfo(String locale) {
        return new RandomInfo(generateCardNumber("ru"), generateMonth(Integer.parseInt("3")), generateYear(Integer.parseInt("3")),
                generateName("ru"), generateCvc());
    }
}
