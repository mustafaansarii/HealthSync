package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDTO toDTO(Patient parient){
        PatientResponseDTO patientDTO = new PatientResponseDTO();
        patientDTO.setId(parient.getId().toString());
        patientDTO.setEmail(parient.getEmail());
        patientDTO.setName(parient.getName());
        patientDTO.setDateOfBirth(parient.getDateOfBirth().toString());
        patientDTO.setAddress(parient.getAddress());
        return patientDTO;
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setRegisteredDate(LocalDate.parse(patientRequestDTO.getRegisterDate()));
        return patient;
    }
}
