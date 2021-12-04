package com.example;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void getFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood("Травоядное");
        assertEquals(List.of("Трава", "Различные растения"), actualFood);
    }

    @Test
    public void getFoodForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> actualFood = animal.getFood("Хищник");
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }

    @Test
    public void getFamilyForAnimal() {
        Animal animal = new Animal();
        String actualFamily = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actualFamily);
    }
    //Тест обработка исключения
    @Test
    public void getFoodForPredatorWithNull() throws Exception {
        Animal animal = new Animal();
        try {
            List<String> actualFood = animal.getFood("");
            Assert.fail("Exception");
        } catch (Exception thrown) {
            Assert.assertNotEquals("", "Неизвестный вид животного, используйте значение Травоядное или Хищник");
            }
    }

}