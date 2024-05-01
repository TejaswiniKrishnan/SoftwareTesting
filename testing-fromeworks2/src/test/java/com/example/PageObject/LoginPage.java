package com.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    By searchBox = By.id("search-box");
    By goButton = By.id("go-button");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void searchProduct(String productName) {
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(goButton).click();
    }

    public void navigateToCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'navigateToCart'");
    }

    public void addProductToCart() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProductToCart'");
    }

    public void selectCategory(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectCategory'");
    }

    public void navigateToGroceriesPage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'navigateToGroceriesPage'");
    }

    public void applyCategoryFilter(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyCategoryFilter'");
    }

    public void openLoginPage() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'openLoginPage'");
    }

    public void enterInvalidCredentials(String string, String string2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterInvalidCredentials'");
    }
}