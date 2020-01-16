package com.turkcell.crm.ordermanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public abstract class BaseDTO implements Serializable {

    private String id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Timestamp creationDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Timestamp modificationDate;

}
