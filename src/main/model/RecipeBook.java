package model;

import java.util.ArrayList;
import java.util.Random;

public class RecipeBook {
    private ArrayList<Recipe> myRecipes;
    private String title;
    private String author;

    public RecipeBook(String title, String author) {
        myRecipes = new ArrayList<>();
        this.title = title;
        this.author = author;
    }

    // EFFECTS: returns the title of the recipe book
    public String getTitle() {
        return title;
    }

    // EFFECTS: returns the name of the author
    public String getAuthor() {
        return author;
    }

    // REQUIRES: size >= 0
    // EFFECTS: returns number of recipes in the recipe book
    public int getNumberOfRecipes() {
        return myRecipes.size();
    }

    // MODIFIES: this
    // EFFECTS: adds a recipe to the recipe book
    public void addRecipe(Recipe r) {
        myRecipes.add(r);

    }

    // MODIFIES: this
    // EFFECTS: removes the given recipe from the recipe book and returns true, false otherwise
    public boolean removeRecipe(Recipe r) {
        return myRecipes.remove(r);
    }

    // MODIFIES: this
    // EFFECTS: removes all the recipes with the given recipe name
    //          from the recipe book and returns true, false otherwise
    public boolean removeRecipe(String recipeName) {
        for (Recipe r:myRecipes) {
            if (recipeName.equals(r.getName())) {
                myRecipes.remove(r);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: searches for the given recipe name, and returns the recipes that contains the given name
    public ArrayList<Recipe> searchRecipe(String recipeName) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        for (Recipe r:myRecipes) {
            if (r.getName().contains(recipeName)) {
                recipes.add(r);
            }
        }
        return recipes;
    }

    // EFFECTS: searches for the recipes with the given category name and returns them
    public ArrayList<Recipe> searchCategory(String recipeName) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        for (Recipe r:myRecipes) {
            if (recipeName.contains(r.getCategory())) {
                recipes.add(r);
            }
        }
        return recipes;
    }

    // EFFECTS: returns a random recipe from the recipe book
    public Recipe getRandomRecipe() {
        Random r = new Random();
        return myRecipes.get(r.nextInt(myRecipes.size()));
    }
}