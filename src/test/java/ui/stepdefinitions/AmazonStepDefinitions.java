package ui.stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ui.pages.AmazonPage;
import ui.utulities.ConfigReader;
import ui.utulities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AmazonStepDefinitions {
  AmazonPage amazonPage=new AmazonPage();

    @When("Go to {string}")
    public void goTo(String testUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(testUrl));
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(ConfigReader.getProperty("expected_title")));
    }
    ///////////////////////////TC_002_Positive LOGIN STEPS  //////////////////////////////
    @Then("Click to Sign_in_Icon")
    public void clickToSign_in_Icon() {
        amazonPage.Signin_Icon.click();
    }

    @Then("Enter a valid_mail address in the mail box")
    public void enter_a_valid_mail_address_in_the_mail_box() {
        amazonPage.emailbox.sendKeys(ConfigReader.getProperty("valid_email")+ Keys.ENTER);
    }

    @Then("Click to Continue")
    public void click_to_continue() {

    }
    @Then("Enter a valid_ password in the password box")
    public void enter_a_valid_password_in_the_password_box() {
        amazonPage.passwordbox.sendKeys(ConfigReader.getProperty("valid_password"));
    }

    @When("Click to Sign_in")
    public void clik_to_sign_in() {
        amazonPage.sign_in_Button.click();
        Assert.assertTrue(amazonPage.MyAmazon_page.getText().toLowerCase().contains(ConfigReader.getProperty("my_Name")));
    }

    @And("Close the page")
    public void closeThePage() {
        Driver.closeDriver();
    }

    ///////////////////////////TC_003_Negative LOGIN STEPS  //////////////////////////////

    @Then("Enter a invalid_ password in the password box")
    public void enterAInvalid_PasswordInThePasswordBox() {
        amazonPage.passwordbox.sendKeys(ConfigReader.getProperty("invalid_password")+Keys.ENTER);
        Assert.assertTrue(amazonPage.unsuccesMessage.isDisplayed());

        ///////////////////////////TC_004_SubCategoryListing STEPS  //////////////////////////////
    }
    @When("Success Login")
    public void succes_login() {
      Driver.getDriver().get(ConfigReader.getProperty("testpage_Url"));
      amazonPage.Signin_Icon.click();
      amazonPage.emailbox.sendKeys(ConfigReader.getProperty("valid_email")+Keys.ENTER);
      amazonPage.passwordbox.sendKeys(ConfigReader.getProperty("valid_password")+Keys.ENTER);
    }

    @Then("Click to All tab")
    public void click_to_all_tab() {
       amazonPage.all_icon.click();
    }

    @Then("Click to any category")
    public void click_to_any_category() throws InterruptedException {
        amazonPage.seeAllİcon.click();
        System.out.println(amazonPage.shoppingItems().size());
        for (WebElement w: amazonPage.shoppingItems()) {
            System.out.println("Shooping Items==="+w.getText());
        }
        Random r = new Random();
        int randomValue = r.nextInt(amazonPage.shoppingItems().size());
            WebElement selectedItem=amazonPage.shoppingItems().get(randomValue);
            String expectededItemName=selectedItem.getText().toLowerCase();
        System.out.println("Seçiminiz "+expectededItemName);
        selectedItem.click();

        System.out.println(amazonPage.myItem(expectededItemName.toLowerCase()).getText().toLowerCase());

        Assert.assertEquals(expectededItemName.toLowerCase(),amazonPage.myItem(expectededItemName.toLowerCase()).getText().toLowerCase());
    }
    ///////////////////////////TC_005_Searching Product STEPS  //////////////////////////////
    @Given("Click to search box")
    public void click_to_search_box() {
        amazonPage.searchbox.click();
    }

    @Given("Search {string}")
    public void search(String product) {
        amazonPage.searchbox.sendKeys(ConfigReader.getProperty(product)+Keys.ENTER);

    }
    @Then("Test all listed products must contain {string}")
    public void testAllListedProductsMustContain(String myproduct) {
        List<String > productResultList=new ArrayList<>();
        for (WebElement each: amazonPage.searchList()) {
            productResultList.add(each.getText().toLowerCase());
           // System.out.println(each.getText());
        }
        System.out.println(productResultList.toString());
        System.out.println(ConfigReader.getProperty(myproduct));
        int count=0;
        for (String w:productResultList) {
            if (w.contains(ConfigReader.getProperty(myproduct.toLowerCase()))) {
                count++;
            }
        }
        System.out.println("There are " +count+ " results about  "+ConfigReader.getProperty(myproduct));
    }

///////////////////////////TC_006_Filter And SORT STEPS  /////////////////////////////////////////////////////////

    @Then("Click to filter and sort box")
    public void clickToFilterAndSortBox() {
        amazonPage.sortbox.click();

    }

    @And("Select any filter")
    public void selectAnyFilter() {
        for (WebElement each:amazonPage.filterList()) {
            System.out.println("Sort LIST =="+each.getText());
        }
        Random r=new Random();
        WebElement sortedFeature=amazonPage.filterList().get(r.nextInt(amazonPage.filterList().size()));
        String sortedFeatureName=sortedFeature.getText();
        sortedFeature.click();
        System.out.println("Expected Data  = "+sortedFeatureName);
        System.out.println("Actual Data = "+amazonPage.mySortFeature.getText());

        Assert.assertTrue(amazonPage.mySortFeature.getText().toLowerCase().contains(sortedFeatureName.toLowerCase()));
    }

    ///////////////////////////       TC_007_Add TO CART  STEPS   /////////////////////////////////////////////////////
    @Given("Select a products random")
    public void select_a_products_random() {
        Random r=new Random();
        amazonPage.searchList().get(r.nextInt(amazonPage.searchList().size())).click(); //random choose from searchList

    }

    @Then("Click to Add Cart")
    public void click_to_add_cart() {
        String priceOfProduct=amazonPage.priceProduct.getText();
        amazonPage.addToCartButton.click();
        amazonPage.cartIcon.click();

        System.out.println("Price Of Product "+priceOfProduct);
        System.out.println("Total of Cart "+amazonPage.totalPrice.getText());
        Assert.assertTrue(amazonPage.totalPrice.getText().toLowerCase().contains(priceOfProduct.toLowerCase()));
    }
    ///////////////////////////       TC_008_FOOTER WEB TABLES  STEPS   /////////////////////////////////////////////////////
    @And("Go to bottom of page")
    public void goToBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    @Then("Click the footer row no {string} and data no {string}")
    public void clickTheFooterRowNoAndDataNo(String row, String data) {
       WebElement cell_data=Driver.getDriver().
               findElement(By.xpath("//tr["+ConfigReader.getProperty(row)+"]//td["+ConfigReader.getProperty(data)+"]"));

       String cellDatatext=cell_data.getText();
        System.out.println("My cell link is ==>"+cellDatatext);
        String[] firstWord = cellDatatext.split(" ", 2);

        System.out.println("My first keyword is===>"+firstWord[0]);
        cell_data.click();
        System.out.println("The link title is ==>"+Driver.getDriver().getTitle());

        Assert.assertTrue(Driver.getDriver().getTitle().contains(firstWord[0]));
    }
    //////////////   XXXXXXXXX       TC_009_CREATE SHOPPING LIST STEPS   XXXXXXXXXXXXXXXXXXX ///////////////////////////
    @Then("Hold on the Sign in box")
    public void hold_on_the_sign_in_box() {
        Actions action=new Actions(Driver.getDriver());
        action.moveToElement(amazonPage.Signin_Icon).perform();
    }

    @And("Click to Creat a List")
    public void clickToCreatAList() {
        amazonPage.createListButton.click();
    }


    @When("Click to Creat a List  at Your List page")
    public void clickToCreatAListAtYourListPage() {
        amazonPage.createListatYourList.click();
    }

    @Then("Write the nameList at the name Lİst box")
    public void writeTheNameListAtTheNameLİstBox() {
        Actions action=new Actions(Driver.getDriver());
        amazonPage.listName_Box.clear();
        action.sendKeys(amazonPage.listName_Box,"")
                .keyDown(Keys.SHIFT).sendKeys("a")
                .keyUp(Keys.SHIFT).sendKeys("li")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB,Keys.ENTER)
                .perform();
        String expectedListName="Ali";
        Assert.assertEquals(expectedListName,amazonPage.mylistName.getText());
    }
    //////////////   XXXXXXXXX       TC_0010_DELETE PRODUCT FROM LIST STEPS   XXXXXXXXXXXXXXXXXXX ///////////////////////////
    @And("Go to your shoopping list")
    public void goToYourShooppingList() {
        amazonPage.ali_List.click();
    }

    @Then("Delete {string} product")
    public void deleteProduct(String productNum) {
        Driver.getDriver().
                findElement(By.xpath("(//input[@name='submit.deleteItem'])["+ConfigReader.getProperty(productNum)+"]")).click();

        Assert.assertTrue(amazonPage.deletedMessage.isDisplayed());
    }
}