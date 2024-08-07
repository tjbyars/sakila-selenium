package com.sakila_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FilmCreationTests extends SharedMethods {

    @Test
    public void filmsToAddFilmTest() {
        System.out.println("\nStarting 'Films to add film' test");
        checkLink("http://localhost:5173/films",
                "Add Film",
                "http://localhost:5173/create/film",
                2);
    }

    @Test
    public void formInputsTest() {
        System.out.println("\nStarting 'Title inputs' test");

        String url = "http://localhost:5173/create/film";
        driver.get(url);

        String[] fields = {"title", "description", "release_year",
        "language", "rental_duration", "rental_rate", "length",
        "replacement_cost", "rating", "behind_the_scenes", "deleted_scenes",
        "trailers", "commentaries", "cast", "submit"};
        for (String field : fields) {
            driver.findElement(By.id(field));
            System.out.println(field + " found");
        }
    }

    @Test
    public void formSubmissionTest() {

    }

}
//titleInput.clear();
//        String testString = "Hello";
//        titleInput.sendKeys(testString);
//        pause(2000);