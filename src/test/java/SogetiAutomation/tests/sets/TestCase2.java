package SogetiAutomation.tests.sets;

import SogetiAutomation.pages.BasePage;
import org.testng.annotations.Test;
import static SogetiAutomation.pages.Sogeti_AutomationPO.*;
import static SogetiAutomation.pages.Sogeti_AutomationPO.worldwideLink;
import static SogetiAutomation.pages.Sogeti_WorldwidePO.verifyCountriesNamesAndCount;
import static SogetiAutomation.pages.Sogeti_WorldwidePO.verifyCountryLinks;


public class TestCase2 extends BasePage {


        @Test
        public void TestCase() {

            navigateToUrl();
            handleCookies();
            worldwideLink.click();
            verifyCountriesNamesAndCount();
            verifyCountryLinks();

        }
}
