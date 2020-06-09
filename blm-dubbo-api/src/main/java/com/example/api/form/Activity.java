package com.example.api.form;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Activity implements Serializable {
    int activityId;
    Double activityCondition;
    Double activityReduce;
    Integer isActive;
}
