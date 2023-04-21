package ru.netology.tests;

import org.junit.jupiter.api.Test;
import ru.netology.data.Information;
import ru.netology.data.SQLHelper;
import ru.netology.pages.InitialPage;

import static com.codeborne.selenide.Selenide.open;

public class NegativeTests {

    @Test
    void shouldFailWithRandomCard() {
        open("http://localhost:8080");
        var initialPage = new InitialPage();
        var cardDetailsPage = initialPage.shouldOpenCardDetails();
        var randomInfo = Information.getRandomCardInfo();
        cardDetailsPage.fillInCardDetails(randomInfo);
        cardDetailsPage.errorNotificationVisible();
        SQLHelper.returnStatusOfTransaction().equals("DECLINED");
    }

    /*@Test
    void shouldFailIfNoCardNumber() {
        open("http://localhost:8080");
        var initialPage = new InitialPage();
        var cardDetailsPage = initialPage.shouldOpenCardDetails();
        var cardInfo = Information.generateRandomCardInfo("en");
        cardDetailsPage.fillInCardDetails(cardInfo);
        cardDetailsPage.cardNumberWrongFormat();
        SQLHelper.returnStatusOfTransaction().equals("DECLINED");
    }*/

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
