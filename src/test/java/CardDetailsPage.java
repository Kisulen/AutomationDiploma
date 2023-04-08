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
 public void okNotificationVisible(){
        okNotification.shouldBe(Condition.visible, Duration.ofSeconds(10));
 }

 public void errorNotificationVisible(){
        errorNotification.shouldBe(Condition.visible, Duration.ofSeconds(10));
 }
}
