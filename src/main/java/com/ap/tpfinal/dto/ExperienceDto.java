package com.ap.tpfinal.dto;

import javax.validation.constraints.NotBlank;

public class ExperienceDto {


    @NotBlank
    private String name;
    private String description;


    // constructors
    public ExperienceDto() {
    }

    public ExperienceDto(String name, String description) {
        this.name = name;
        this.description = description;
    }


    //    getters-setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
