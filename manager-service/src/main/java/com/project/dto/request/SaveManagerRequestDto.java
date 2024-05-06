package com.project.dto.request;


import com.project.utility.enums.ERole;
import com.project.utility.enums.EStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class SaveManagerRequestDto {

    private Long id;
    private Long authId;
    private String token;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String phone;
    @NotNull
    private String address;
    @NotNull
    private String company;
    @NotNull
    private String taxNumber;
    private ERole role;
    private Long createAt;
    private EStatus status;

}