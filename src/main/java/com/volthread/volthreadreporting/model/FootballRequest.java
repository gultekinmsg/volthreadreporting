package com.volthread.volthreadreporting.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.volthread.volthreadreporting.entity.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


@Data
public class FootballRequest {
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
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9\\s]+$")
    @Size(max = 255)
    private String fanOf;
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
