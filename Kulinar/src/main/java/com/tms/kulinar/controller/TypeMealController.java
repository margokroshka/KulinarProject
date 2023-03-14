package com.tms.kulinar.controller;

import com.tms.kulinar.domain.Recipe;
import com.tms.kulinar.domain.TypeMeal;
import com.tms.kulinar.repository.RecipeRepository;
import com.tms.kulinar.repository.TypeMealRepository;
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
@RequestMapping("/type")
public class TypeMealController {
    private final TypeMealRepository mealRepository;

    @Autowired
    public TypeMealController(TypeMealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Operation(description = "Ищет тип блюда по ID", summary = "Ищет тип блюда")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Все ОК! Улыбаемся и машем"),
            @ApiResponse(responseCode = "404", description = "Куда ты жмал?!!? Ничего не нашел")
    })

    @GetMapping("/{id}")
    @Tag(name = "byID", description = "ищём по id")
    public ResponseEntity<TypeMeal> getTypeMealById(@PathVariable int id)  {
        TypeMeal typeMeal = mealRepository.getTypeMealById(id);
        return  new ResponseEntity<>(typeMeal,  HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ArrayList<TypeMeal>> getAllTypeMeal() {
        return new ResponseEntity<>(mealRepository.getAllTypeMeal(), HttpStatus.OK);
    }
}
