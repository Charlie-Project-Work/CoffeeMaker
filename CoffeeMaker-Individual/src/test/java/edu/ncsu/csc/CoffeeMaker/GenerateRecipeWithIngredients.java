
package edu.ncsu.csc.CoffeeMaker;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.ncsu.csc.CoffeeMaker.models.DomainObject;
import edu.ncsu.csc.CoffeeMaker.models.Ingredient;
import edu.ncsu.csc.CoffeeMaker.models.Recipe;
import edu.ncsu.csc.CoffeeMaker.services.RecipeService;

/**
 * Test class to test the creation of recipes with ingredients
 */
@RunWith ( SpringRunner.class )
@EnableAutoConfiguration
@SpringBootTest ( classes = TestConfig.class )
public class GenerateRecipeWithIngredients {

    /**
     * RecipeService object, to be autowired in by Spring to allow for
     * manipulating the Recipe model
     */
    @Autowired
    private RecipeService recipeService;

    /**
     * Sets up the each test by clearing the database
     */
    @Before
    public void setup () {
        recipeService.deleteAll();
    }

    /**
     * Creates recipes and tests that ingredients can be added to them
     */
    @Test
    @Transactional
    public void createRecipe () {
        final Recipe r1 = new Recipe();
        r1.setName( "Delicious Coffee" );

        r1.setPrice( 50 );

        assertTrue( r1.addIngredient( new Ingredient( "Coffee", 10 ) ) );
        assertTrue( r1.addIngredient( new Ingredient( "Pumpkin Spice", 3 ) ) );
        assertTrue( r1.addIngredient( new Ingredient( "Milk", 2 ) ) );

        final Recipe r2 = new Recipe();
        r2.setName( "Recipe2" );

        r2.setPrice( 30 );

        assertTrue( r2.addIngredient( new Ingredient( "Coffee", 5 ) ) );
        assertTrue( r2.addIngredient( new Ingredient( "Caramel", 1 ) ) );
        assertTrue( r2.addIngredient( new Ingredient( "Pumpkin Spice", 7 ) ) );
        assertTrue( r2.addIngredient( new Ingredient( "Milk", 2 ) ) );

        recipeService.save( r1 );
        recipeService.save( r2 );

        printRecipes();
    }

    private void printRecipes () {
        for ( final DomainObject r : recipeService.findAll() ) {
            System.out.println( r );
        }
    }

}
