package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderInf implements Serializable {
    private String recipeName;
    private Integer orderRecipeNumber;
}
