
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class PositiveTests {
    @Test
    void shouldSuccessfullyPayForTour() {
        open("http://localhost:8080");
        var initialPage = new InitialPage();
        var cardDetailsPage = initialPage.shouldOpenCardDetails();
        var cardInfo = Information.getApprovedCardInfo();
        cardDetailsPage.fillInCardDetails(cardInfo);
        cardDetailsPage.okNotificationVisible();
    }

}
