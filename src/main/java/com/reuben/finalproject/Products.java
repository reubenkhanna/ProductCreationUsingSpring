package com.reuben.finalproject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
//@RequiredArgsConstructor(onConstructor = @_(@JsonCreator))
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Integer id;

    @NotNull
    @Size(min=2, max=20)
    private  String name;

    @NotNull
    @Size(min=10, max=200)
    private  String description;

    @NotNull

    private  Integer quantity;

    @JsonCreator
    public  Products(@JsonProperty("name") String name,
                     @JsonProperty("description") String description,
                     @JsonProperty("quantity") Integer quantity){
                    this.name = name;
                    this.description = description;
                    this.quantity = quantity;
                }

}
