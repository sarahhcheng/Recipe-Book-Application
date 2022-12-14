package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecipeTest {
    private Recipe newRecipe;

    @BeforeEach
    public void setup() {
        newRecipe = new Recipe("blueberry scone", 2, 5, "Bakery" );
    }

    @Test
    public void testGetName() {
        assertEquals("blueberry scone", newRecipe.getName());
    }

    @Test
    public void testGetInstructions() {
        Instructions stepOne = new Instructions();
        stepOne.addStep("Preheat oven");
        stepOne.addStep("");
        newRecipe.setInstructions(stepOne);
        assertEquals(stepOne, newRecipe.getInstructions());
    }

    @Test
    public void testGetIngredients() {
        Ingredient flour = new Ingredient("flour", 20, "mL");
        newRecipe.addIngredient(flour);
        assertEquals(flour, newRecipe.getIngredients().get(0));
    }

    @Test
    public void testGetDurationMinutes() {
        assertEquals(2, newRecipe.getDurationMinutes());
    }

    @Test
    public void testSetDurationMinutes() {
        assertEquals(2, newRecipe.getDurationMinutes());
        newRecipe.setDurationMinutes(5);
        assertEquals(5, newRecipe.getDurationMinutes());
    }

    @Test
    public void testGetServes() {
        assertEquals(5, newRecipe.getServes());
    }

    @Test
    public void testSetServes() {
        assertEquals(5, newRecipe.getServes());
        newRecipe.setServes(10);
        assertEquals(10, newRecipe.getServes());
    }

    @Test
    public void testSetCategory() {
        assertEquals("Bakery", newRecipe.getCategory());
        newRecipe.setCategory("Chinese food");
        assertEquals("Chinese food", newRecipe.getCategory());
    }

    @Test
    public void testToString() {
        Instructions howTo = new Instructions();
        howTo.addStep("Preheat oven to 180 degrees");
        assertEquals("1) Preheat oven to 180 degrees\n", howTo.toString());
        howTo.addStep("Add one cup of flour into bowl");
        assertEquals("1) Preheat oven to 180 degrees\n2) Add one cup of flour into bowl\n", howTo.toString());

        newRecipe.setInstructions(howTo);
        assertEquals("blueberry scone: Serves 5. Takes 2 minutes to cook\n\n1) Preheat oven to 180 degrees\n2) Add one cup of flour into bowl\n", newRecipe.toString());
    }

}
