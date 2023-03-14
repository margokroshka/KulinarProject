package com.tms.kulinar.controller;

import com.tms.kulinar.domain.Products;
import com.tms.kulinar.domain.Recipe;
import com.tms.kulinar.repository.ProductsRepository;
import com.tms.kulinar.repository.RecipeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Operation(description = "Ищет юзера по ID", summary = "Ищет юзера")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Все ОК! Улыбаемся и машем"),
            @ApiResponse(responseCode = "404", description = "Куда ты жмал?!!? Ничего не нашел")
    })

    @GetMapping("/{id}")
    @Tag(name = "byID", description = "ищём по id")
    public ResponseEntity<Recipe> getRecipesById(@PathVariable int id)  {
        Recipe recipe = recipeRepository.getRecipeById(id);
        return  new ResponseEntity<>(recipe,  HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Recipe>> getAllRecipes() {
        return new ResponseEntity<>(recipeRepository.getAllRecipe(), HttpStatus.OK);
    }
}
