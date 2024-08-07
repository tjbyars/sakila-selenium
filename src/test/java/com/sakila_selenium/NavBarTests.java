package com.sakila_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavBarTests extends SharedMethods {

    @Test
    public void actorsToHomeClickTest() {
        System.out.println("\nStarting 'Actors to home' test");
        checkLink("http://localhost:5173/actors",
        "Home",
                "http://localhost:5173/");
    }

    @Test
    public void filmsToHomeClickTest() {
        System.out.println("\nStarting 'Films to home' test");
        checkLink("http://localhost:5173/films",
                "Home",
                "http://localhost:5173/");
    }

    @Test
    public void actorsToFilmsClickTest() {
        System.out.println("\nStarting 'Actors to films' test");
        checkLink("http://localhost:5173/actors",
                "Films",
                "http://localhost:5173/films");
    }

    @Test
    public void filmsToActorsClickTest() {
        System.out.println("\nStarting 'Films to actors' test");
        checkLink("http://localhost:5173/films",
                "Actors",
                "http://localhost:5173/actors");
    }
}
