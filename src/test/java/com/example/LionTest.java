package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
   @Mock
   Feline feline;

    @Test
    public void doesHaveManeTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertTrue(actualHasMane);

    }
    @Test
    public void doesHaveManeFalse() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertFalse(actualHasMane);
    }
//Тест обработка исключения
    @Test
    public void doesHaveManeException() throws Exception {
        try {
            Lion lion = new Lion("", feline);
            boolean actualHasMane = lion.doesHaveMane();
            Assert.fail("Exception");
        } catch (Exception thrown) {
            Assert.assertNotEquals("", "Используйте допустимые значения пола животного - самей или самка");
        }
    }
    @Test
    public void getKittensForLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittens = lion.getKittens();
        Assert.assertEquals(1,actualKittens);
    }

    @Test
    public void getFoodForLion() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),actualFood);

    }
}

