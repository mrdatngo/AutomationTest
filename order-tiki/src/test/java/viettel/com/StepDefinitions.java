package viettel.com;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class StepDefinitions {
    WebDriver driver;
    String productName = "";
    public StepDefinitions() {
        this.driver = Hook.driver;
    }
    @Given("^Tiki homepage showing home page$")
    public void tiki_homepage_showing_home_page() throws Throwable {
        this.driver.get("https://tiki.vn/dien-thoai-may-tinh-bang");
    }

    @When("^User click on product image$")
    public void user_click_on_product_image() throws Throwable {
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement productImage = this.driver.findElement(By.cssSelector(".content .product-image"));
        productImage.click();
    }

    @When("^User click to buy a item$")
    public void user_click_to_buy_a_item() throws Throwable {
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement buyItem = this.driver.findElement(By.cssSelector("button.btn-add-to-cart"));
        buyItem.click();
    }

    @Then("^Item added is displayed on cart$")
    public void item_added_is_displayed_on_cart() throws Throwable {
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement productName = this.driver.findElement(By.cssSelector("a.cart-products__name"));
        String txt = productName.getText();
        assertEquals(this.productName, txt);
    }

    @And("^User go to cart$")
    public void user_go_to_cart() throws Throwable {
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement productName = this.driver.findElement(By.cssSelector("h1[itemprop=\"name\"]"));
        this.productName = productName.getText();
        WebElement viewCart = this.driver.findElement(By.cssSelector("i.icon-cart"));
        viewCart.click();
    }
}
