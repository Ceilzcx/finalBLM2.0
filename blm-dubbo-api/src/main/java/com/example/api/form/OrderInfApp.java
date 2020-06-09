package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderInfApp implements Serializable {
    String recipeName;
    Integer orderRecipeNumber;
    Double money;
}
