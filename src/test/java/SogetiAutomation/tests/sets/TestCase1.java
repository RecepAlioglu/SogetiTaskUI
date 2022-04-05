package SogetiAutomation.tests.sets;

import SogetiAutomation.pages.BasePage;
import SogetiAutomation.pages.*;
import SogetiAutomation.utilities.Driver;
import org.junit.Assert;
import org.testng.annotations.Test;
import static SogetiAutomation.pages.Sogeti_AutomationPO.*;



public class TestCase1 extends BasePage {


    Sogeti_AutomationPO Sogeti =new Sogeti_AutomationPO();



    @Test
    public void TestCase(){

        navigateToUrl();
        handleCookies();
        Assert.assertEquals( Driver.getDriver().getCurrentUrl(),"https://www.sogeti.com/");
        Sogeti.hoverServiceMenu();
        Sogeti.clickON();
        Sogeti.verifyAutomationScreenInPage();
        Sogeti.verifyServiceAndAutomationLink();
        Sogeti.hoverServiceMenu();
        Sogeti.clickON();
        completeform();
        Assert.assertEquals("Register is not successful!", successMessage.getText());

    }

}
