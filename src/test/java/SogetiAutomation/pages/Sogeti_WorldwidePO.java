package SogetiAutomation.pages;

import SogetiAutomation.utilities.BrowserUtils;
import SogetiAutomation.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sogeti_WorldwidePO {


    public Sogeti_WorldwidePO () {PageFactory.initElements(Driver.getDriver(), this);}


    @FindBy(css = "#country-list-id ul li")
    public static List<WebElement> worlwideCountryList;



    public static void verifyCountriesNamesAndCount() {

        ArrayList<String> Cityliste = new ArrayList<>();
        Cityliste.add("BELGIUM");
        Cityliste.add("FINLAND");
        Cityliste.add("FRANCE");
        Cityliste.add("GERMANY");
        Cityliste.add("IRELAND");
        Cityliste.add("LUXEMBOURG");
        Cityliste.add("NETHERLANDS");
        Cityliste.add("NORWAY");
        Cityliste.add("SPAIN");
        Cityliste.add("SWEDEN");
        Cityliste.add("UK");
        Cityliste.add("USA");

        if (worlwideCountryList.size() == 12) {
            Assert.assertTrue("Total countries are same!", true);
            System.out.println("Total countries number as expected found!");
        }

        for (int i = 0; i < worlwideCountryList.size(); i++) {
            String foundCountry = worlwideCountryList.get(i).getText();
            String expectedCounty = Cityliste.get(i).toUpperCase();
            Assert.assertEquals(expectedCounty, foundCountry);
        }
    }

    public static void verifyCountryLinks() {

        ArrayList<String> Cityliste = new ArrayList<>();
        Cityliste.add("https://www.sogeti.be/");
        Cityliste.add("https://www.sogeti.fi/");
        Cityliste.add("https://www.fr.sogeti.com/");
        Cityliste.add("https://www.sogeti.de/");
        Cityliste.add("sogeti.ie");
        Cityliste.add("https://www.sogeti.lu/");
        Cityliste.add("https://www.sogeti.nl/");
        Cityliste.add("https://www.sogeti.no/");
        Cityliste.add("https://www.sogeti.es/");
        Cityliste.add("https://www.sogeti.se/");
        Cityliste.add("https://www.uk.sogeti.com/");
        Cityliste.add("https://www.us.sogeti.com/");
        

        for (int i = 0; i < worlwideCountryList.size(); i++) {

            String foundCountry = worlwideCountryList.get(i).getText();
            String expectedCounty = Cityliste.get(Cityliste.size());

            if (expectedCounty.equalsIgnoreCase(foundCountry)) {
                String currentUrl = Driver.getDriver().getCurrentUrl();
                BrowserUtils.waitForClickablility((By) worlwideCountryList.get(i), 2).click();
                BrowserUtils.waitFor(5);

                String firstWindows = Driver.getDriver().getWindowHandle();
                System.out.println(firstWindows + " Thi is first windows id!");

                Set<String> allWindows = Driver.getDriver().getWindowHandles();
                System.out.println("All windows ids! : " + allWindows);

                String secondWindows = "";
                for (String each : allWindows) {
                    if (!each.equals(currentUrl)) {
                        secondWindows = each;
                    }
                }

                System.out.println("Second windows id! : " + secondWindows);

                Driver.getDriver().switchTo().window(secondWindows);

                String actualNewTitle = Driver.getDriver().getTitle();
                System.out.println("Second page title  : "+actualNewTitle);
                String expectedTitle = Cityliste.get(0);
                Assert.assertEquals("Link is not correct! ",actualNewTitle,expectedTitle);

            }


        }
    }
}
