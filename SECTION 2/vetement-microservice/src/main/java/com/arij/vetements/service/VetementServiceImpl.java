package com.arij.vetements.service;

import com.arij.vetements.dto.VetementDTO;
import com.arij.vetements.entities.Vetement;
import com.arij.vetements.repos.VetementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetementServiceImpl implements VetementService{
    @Autowired
    private  VetementRepository vetementRepository;
    private WebClient webClient;

    @Override
    public VetementDTO getVetementById(Long id) {
        Vetement vetement = vetementRepository.findById(id).get();
        return new
                VetementDTO(
                vetement.getId(),
                vetement.getName(),
                vetement.getMarque()
                );
    }
    @Override
    public APIResponseDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" +
                        teacher.getDepCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        TeacherDto teacherDto = new TeacherDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getDepCode()
        );
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setTeacherDto(teacherDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }




}
