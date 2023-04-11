import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CardDetailsPage {
    private SelenideElement cardNumber = $x("//*[@placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $x("//*[@placeholder='08']");
    private SelenideElement year = $x("//*[@placeholder='22']");
    private SelenideElement owner = $x("(//*[@class='input__control'])[4]");
    private SelenideElement cvc = $x("//*[@placeholder='999']");
    private SelenideElement paymentHeading = $x("//*[contains(text(), 'Оплата по карте')]");

    private SelenideElement okNotification = $x("(//*[@class='notification__icon'])[1]");
    private SelenideElement errorNotification = $x("(//*[@class='notification__icon'])[2]");
    private SelenideElement button = $x("(//*[@class='button__text'])[last()]");
    private SelenideElement cardNumberWrongFormatNotification = $x("(//*[contains(text(), 'Неверный формат')])[1]");
    private SelenideElement monthWrongFormatNotification = $x("(//*[contains(text(), 'Неверный формат')])[2]");
    private SelenideElement yearWrongFormatNotification = $x("(//*[contains(text(), 'Неверный формат')])[3]");
    private SelenideElement cvcWrongFormatNotification = $x("(//*[contains(text(), 'Неверный формат')])[4]");
    private SelenideElement fillInNameNotification = $x("//*[contains(text(), 'Поле')]");

    public CardDetailsPage() {
        paymentHeading.shouldBe(Condition.visible);
    }

    public CardDetailsPage fillInCardDetails(Information.CardInfo info) {
        cardNumber.setValue(info.getCardNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        owner.setValue(info.getOwner());
        cvc.setValue(info.getCvc());
        button.click();
        return new CardDetailsPage();
    }

    public CardDetailsPage fillInRandomCardDetails(Information.RandomInfo randomInfo) {
        cardNumber.setValue(randomInfo.getRandomCardNumber());
        month.setValue(randomInfo.getRandomMonth());
        year.setValue(randomInfo.getRandomYear());
        owner.setValue(randomInfo.getRandomOwner());
        cvc.setValue(randomInfo.getRandomCvc());
        button.click();
        return new CardDetailsPage();
    }

    public CardDetailsPage leaveFieldsBlank() {
        cardNumber.setValue("");
        month.setValue("");
        year.setValue("");
        owner.setValue("");
        cvc.setValue("");
        button.click();
        return new CardDetailsPage();
    }

    public CardDetailsPage fillInNoCardNumber(Information.RandomInfo noCardNumber) {
        cardNumber.setValue("");
        month.setValue(noCardNumber.getRandomMonth());
        year.setValue(noCardNumber.getRandomYear());
        owner.setValue(noCardNumber.getRandomOwner());
        cvc.setValue(noCardNumber.getRandomCvc());
        button.click();
        return new CardDetailsPage();
    }

    public void okNotificationVisible() {
        okNotification.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void errorNotificationVisible() {
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    public void cardNumberWrongFormat() {
        cardNumberWrongFormatNotification.shouldBe(Condition.visible);
    }

    public void allWrongNotificationsVisible() {
        cardNumberWrongFormatNotification.shouldBe(Condition.visible);
        monthWrongFormatNotification.shouldBe(Condition.visible);
        yearWrongFormatNotification.shouldBe(Condition.visible);
        fillInNameNotification.shouldBe(Condition.visible);
        cvcWrongFormatNotification.shouldBe(Condition.visible);
    }

}
