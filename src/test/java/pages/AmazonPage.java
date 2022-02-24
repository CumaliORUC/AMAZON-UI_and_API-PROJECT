package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utulities.Driver;

import java.util.List;

public class AmazonPage {
    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="nav-link-accountList")
    public WebElement Signin_Icon;

    @FindBy (id="ap_email")
    public WebElement emailbox;

    @FindBy (id="ap_password")
    public WebElement passwordbox;

    @FindBy (id="signInSubmit")
    public WebElement sign_in_Button;

    @FindBy (xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    public WebElement MyAmazon_page;

    @FindBy (xpath = "//span[@class='a-list-item']")
    public WebElement unsuccesMessage;

    @FindBy (id= "nav-hamburger-menu")
    public WebElement all_icon;

    @FindBy (xpath = "(//div[@class='hmenu-item hmenu-title '])[1] ")
    public WebElement selectItemTitle;

    @FindBy (tagName = "data-menu-id")
    public WebElement allshopinglist;

    @FindBy (xpath = "//*[text()='see all']")
    public WebElement seeAllİcon;

    @FindBy (css = "div.hmenu-item.hmenu-title ")
    public WebElement selectedItemWebElement;

    @FindBy (id= "twotabsearchtextbox")
    public WebElement searchbox;

    @FindBy (id = "a-autoid-0-announce")
    public WebElement sortbox;

    @FindBy (id = "a-autoid-2-announce")
    public WebElement mySortFeature;

    @FindBy (id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy (css = "div.a-section.a-spacing-micro")
    public WebElement priceProduct;

    @FindBy (id = "nav-cart-count")
    public WebElement cartIcon;

    @FindBy (xpath = "//div[@data-name='Subtotals']")
    public WebElement totalPrice;


    public List<WebElement> shoppingItems () {
        List<WebElement> shoopingItems=Driver.getDriver().findElements(By.xpath("//a[@data-menu-id]"));
        return shoopingItems;
    }
    public List<WebElement> selectedItemTitleList () {
        List<WebElement> titleList=Driver.getDriver().findElements(By.cssSelector("div.hmenu-item.hmenu-title "));
        return titleList;
    }

    public WebElement myItem(String name) {
        WebElement myItem=Driver.getDriver().findElement(By.xpath("//*[text()='"+name+"']"));
        return myItem;
    }

    public List<WebElement> searchList() {
        List<WebElement> searchproductList=Driver.getDriver().findElements(By.xpath("//h2//a"));
        return searchproductList;
    }

    public List<WebElement> filterList() {
        List<WebElement> filters=Driver.getDriver().findElements(By.xpath("//li[@role='option']"));
        return filters;
    }

}