package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;
    @Test
    public void getFoodForCat() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"),actualFood);
    }

    @Test
    public void getSoundForCat() {
        Cat cat = new Cat(feline);
        String actualSound = cat.getSound();
        assertEquals("Мяу", actualSound);
    }
}
