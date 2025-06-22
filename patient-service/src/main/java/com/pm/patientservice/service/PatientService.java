package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.Exception.EmailAlreadyExistException;
import com.pm.patientservice.Exception.PatientNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;

@Service
public class PatientService {
    private PatientRepository patientRepository;
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return patients.stream()
                .map(PatientMapper::toDTO).toList();
    }

    public PatientResponseDTO getPatientById(UUID id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        return PatientMapper.toDTO(patient);
    }
 
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
            logger.warn("Email already exists {}", patientRequestDTO.getEmail());
            throw new EmailAlreadyExistException("Email already exists");
        }
        Patient newPatient = PatientMapper.toModel(patientRequestDTO);
        newPatient = patientRepository.save(newPatient);
        return PatientMapper.toDTO(newPatient);
    }

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        if(patientRepository.existsByEmailAndIdNot(patientRequestDTO.getEmail(), id)){
            logger.warn("Email already exists {}", patientRequestDTO.getEmail());
            throw new EmailAlreadyExistException("Email already exists");
        }
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        Patient updatePatient = patientRepository.save(patient);
        return PatientMapper.toDTO(updatePatient);
    }

    public PatientResponseDTO deletePatient(UUID id){
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        patientRepository.deleteById(id);
        return PatientMapper.toDTO(patient);
    }




}