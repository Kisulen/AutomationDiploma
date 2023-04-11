import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class NegativeTests {

    @Test
    void shouldFailWithRandomCard() {
        open("http://localhost:8080");
        var initialPage = new InitialPage();
        var cardDetailsPage = initialPage.shouldOpenCardDetails();
        var randomInfo = Information.generateRandomCardInfo("ru");
        cardDetailsPage.fillInRandomCardDetails(randomInfo);
        cardDetailsPage.errorNotificationVisible();
        SQLHelper.returnStatusOfTransaction().equals("DECLINED");
    }

    @Test
    void shouldFailIfNoCardNumber() {
        open("http://localhost:8080");
        var initialPage = new InitialPage();
        var cardDetailsPage = initialPage.shouldOpenCardDetails();
        var randomInfo = Information.generateRandomCardInfo("en");
        cardDetailsPage.fillInNoCardNumber(randomInfo);
        cardDetailsPage.cardNumberWrongFormat();
        SQLHelper.returnStatusOfTransaction().equals("DECLINED");
    }

    @Test
    void shouldFailIfAllFieldsEmpty() {
        open("http://localhost:8080");
        var initialPage = new InitialPage();
        var cardDetailsPage = initialPage.shouldOpenCardDetails();
        cardDetailsPage.leaveFieldsBlank();
        cardDetailsPage.allWrongNotificationsVisible();
        SQLHelper.returnStatusOfTransaction().equals("DECLINED");
    }
}
