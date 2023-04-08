import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class NegativeTests {

    @Test

    void shouldFailWithDeclinedCard() {
        open("http://localhost:8080");
        var initialPage = new InitialPage();
        var cardDetailsPage = initialPage.shouldOpenCardDetails();
        var cardInfo = Information.getDeclinedCardInfo();
        cardDetailsPage.fillInCardDetails(cardInfo);
        cardDetailsPage.errorNotificationVisible();
    }
}
