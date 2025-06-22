package com.pm.patientservice.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import com.pm.patientservice.dto.Validator.CreatePatientValidationGroup;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(max=100, message = "Name must be less than 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    private String email;

    @NotBlank(message = "Address is required") 
    @Size(max=100, message = "Address must be less than 100 characters")
    private String address;

    @NotBlank(message = "Date of birth is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Date of birth must be in the format YYYY-MM-DD")
    private String dateOfBirth;

    @NotBlank(groups = CreatePatientValidationGroup.class, message = "Register date is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Register date must be in the format YYYY-MM-DD")
    private String registerDate;
    
}