package Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CardDetailsPage {
    private SelenideElement cardNumber = $x("//*[@placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $x("//*[@placeholder='08']");
    private SelenideElement year = $x("//*[@placeholder='22']");
    private SelenideElement owner = $x("//*[contains(text(), 'Владелец')]");
    private SelenideElement cvc = $x("//*[@placeholder='999']");
    private SelenideElement paymentHeading = $x("//*[contains(text(), 'Оплата по карте')]");

    private SelenideElement notification = $x("//*[contains(text(), 'Операция одобрена Банком')]");
    private SelenideElement button = $x();

    public CardDetailsPage() {
        paymentHeading.shouldBe(Condition.visible);
    }

    public fillInCardDetails(DataHelper.CardInfo info) {
        cardNumber.setValue(info.getCardNumber);
        month.setValue();
        year.setValue();
        owner.setValue();
        cvc.setValue();

    }
}
