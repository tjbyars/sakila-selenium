package com.sakila_selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ActorListTests extends SharedMethods {

    @Test
    public void readActorByNameTest() {
        System.out.println("\nStarting 'Read actor by name' test");
        checkLink("http://localhost:5173/actors",
                "PENELOPE GUINESS",
                "http://localhost:5173/actors/1",
                2);
    }

    @Test
    public void readActorByIdTest() {
        System.out.println("\nStarting 'Read actor by id' test");


    }
}
