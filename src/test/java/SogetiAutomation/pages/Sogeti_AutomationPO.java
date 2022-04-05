package SogetiAutomation.pages;


import SogetiAutomation.ResultColor;
import SogetiAutomation.utilities.BrowserUtils;
import SogetiAutomation.utilities.ConfigurationReader;
import SogetiAutomation.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.NoSuchElementException;


public class Sogeti_AutomationPO  {


    public Sogeti_AutomationPO() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//*[@class=\"acceptCookie\"]")
    public static WebElement acceptCookie;

    @FindBy(xpath = "(//span[contains(text(),'Services')])[1]")
    public WebElement services;

    @FindBy(xpath = "(//a[normalize-space()='Automation'])[1]")
    public WebElement automationLink;

    @FindBy(css = "#hero-header img")
    public WebElement automationScreen;

    @FindBy(css = "#primary_content div h1 span")
    public WebElement automationScreenText;

    @FindBy(xpath = "//input[@id='4ff2ed4d-4861-4914-86eb-87dfa65876d8']")
    public static WebElement fNameBox;

    @FindBy(xpath = "//input[@id='11ce8b49-5298-491a-aebe-d0900d6f49a7']")
    public static WebElement lNameBox;

    @FindBy(xpath = "//input[@id='056d8435-4d06-44f3-896a-d7b0bf4d37b2']")
    public static WebElement emailBox;

    @FindBy(xpath = "//input[@id='755aa064-7be2-432b-b8a2-805b5f4f9384']")
    public static WebElement phoneBox;

    @FindBy(xpath = "//input[@id='703dedb1-a413-4e71-9785-586d609def60']")
    public static WebElement companyBox;

    @FindBy(xpath = "//select[@id='e74d82fb-949d-40e5-8fd2-4a876319c45a']")
    public static WebElement countryListDropdown;

    @FindBy(xpath = "//textarea[@id='88459d00-b812-459a-99e4-5dc6eff2aa19']")
    public static WebElement messageBox;

    @FindBy(id = "//input[@name='__field_123935']")
    public static WebElement agreeBox;

    @FindBy(css = "#recaptcha-anchor")
    public static WebElement captcha;

    @FindBy(xpath = "//img[@alt='Submit']")
    public static WebElement submitButton;

    @FindBy(css = "div.Form__Status p")
    public static WebElement successMessage;

    @FindBy(xpath = "//span[@aria-label='Worldwide']")
    public static WebElement worldwideLink;


    public static void completeform(){

        fNameBox.sendKeys("Recep");
        lNameBox.sendKeys("Alioglu");
        emailBox.sendKeys("recepalioglu1@gmail.com");
        phoneBox.sendKeys("01728859763");
        companyBox.sendKeys("Sogeti GmbH");
        selectAnItemFromDropdown();
        messageBox.sendKeys("I want to work with you guys :)");
        BrowserUtils.clickWithTimeOut(agreeBox, 2);
        reCaptcha_click();
        BrowserUtils.clickWithTimeOut(submitButton, 2);


    }

    public static void selectAnItemFromDropdown() {Select objSelect =new Select(countryListDropdown);objSelect.selectByVisibleText("Germany");}

    public static void navigateToUrl() {Driver.getDriver().get(ConfigurationReader.get("url"));;}

    public static void handleCookies() {acceptCookie.click();}

    public void hoverServiceMenu() {BrowserUtils.hover(services);}

    public void clickON() {if (automationLink.isDisplayed()) {automationLink.click();}}

    public void verifyAutomationScreenInPage() {
        String foundAttribute = automationScreenText.getText();
        System.out.println(foundAttribute);
        if (automationScreen.isDisplayed()) {
            Assert.assertEquals("Expected screen nof found! ", "Automation", foundAttribute);
        }
    }

    public void verifyServiceAndAutomationLink() {
        BrowserUtils.hover(services);
        String serviceFoundColour = BrowserUtils.parseColor(services.getCssValue("color"));
        String automationFoundColour = BrowserUtils.parseColor(automationLink.getCssValue("color"));
        Assert.assertTrue("Wrong color found! ", ResultColor.RED.matchesCode(serviceFoundColour));
        Assert.assertTrue("Wrong color found!", ResultColor.RED.matchesCode(automationFoundColour));

    }


    public  static void reCaptcha_click() {

        try {
            BrowserUtils.clickWithTimeOut(captcha, 2);
        } catch (NoSuchElementException e) {
            submitButton.click();
        }

    }

}

