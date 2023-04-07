package Data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }
@Value
    public static class CardInfo{
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
        return new CardInfo("5555 6666 7777 8888", "12", "2026", "Vasiliy Pupkin", "000");
    }




}
