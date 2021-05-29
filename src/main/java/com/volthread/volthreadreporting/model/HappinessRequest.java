package com.volthread.volthreadreporting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volthread.volthreadreporting.entity.Gender;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class HappinessRequest {
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$")
    @Size(max = 255)
    private String name;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$")
    @Size(max = 255)
    private String surname;
    @NotNull
    private Gender gender;
    @NotNull
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;
    @NotNull
    @Min(1)
    @Max(10)
    private Integer happiness;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$")
    @Size(max = 255)
    private String mostHappy;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$")
    @Size(max = 255)
    private String mostUnHappy;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$")
    @Size(max = 255)
    private String explanation;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$")
    @Size(max = 255)
    private String pollsterName;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$")
    @Size(max = 255)
    private String pollsterSurname;
}
