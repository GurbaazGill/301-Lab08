package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);

        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));
    }
    public void testDeleteCity() {
        CustomList list = new CustomList();
        City edmonton = new City("Edmonton", "AB");
        list.addCity(edmonton);

        list.deleteCity(edmonton);

        assertFalse(list.hasCity(edmonton));
    }


    public void testDeleteCityNotInList() {
        CustomList list = new CustomList();
        City vancouver = new City("Vancouver", "BC");

        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(vancouver);
        });
    }

    @Test
    public void testCountCitiesEmpty() {
        CustomList list = new CustomList();
        assertEquals(0, list.countCities());
    }

    @Test
    public void testCountCitiesOne() {
        CustomList list = new CustomList();
        City toronto = new City("Toronto", "ON");
        list.addCity(toronto);
        assertEquals(1, list.countCities());
    }

    @Test
    public void testCountCitiesMultiple() {
        CustomList list = new CustomList();
        City toronto = new City("Toronto", "ON");
        City montreal = new City("Montreal", "QC");
        City vancouver = new City("Vancouver", "BC");

        list.addCity(toronto);
        list.addCity(montreal);
        list.addCity(vancouver);

        assertEquals(3, list.countCities());
    }
}
