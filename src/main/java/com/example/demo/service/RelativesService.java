package com.example.demo.service;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.Relatives;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.RelativesRepository;
import com.example.demo.service.dto.RelativesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesService {
    private final RelativesRepository relativesRepository;
    private final EmployeeRepository employeeRepository;

    public List<Relatives> getAllRelatives(){
        return relativesRepository.findAll();
    }
    public Relatives createRelatives (RelativesDTO relativesDTO, Long employeesId) {
        Optional<Employee> employee = employeeRepository.findById(employeesId);

        Relatives relatives = new Relatives();

        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());

        if(employee.isPresent())
            relatives.setEmployee(employee.get());
        return relativesRepository.save(relatives);
    }

    public Relatives getRelativesById(Long relativesId) {
        return relativesRepository.findById(relativesId).get();
    }

    public Relatives updateRelativesById(Long relativesId, RelativesDTO relativesDTO) {
        Relatives updateRelativesById = relativesRepository.findById(relativesId).get();
        updateRelativesById.setFullName(relativesDTO.getFullName());
        updateRelativesById.setGender(relativesDTO.getGender());
        updateRelativesById.setPhoneNumber(relativesDTO.getPhoneNumber());
        updateRelativesById.setRelationship(relativesDTO.getRelationship());
        return relativesRepository.save(updateRelativesById);
    }

    public void deleteRelativesById(Long relativesId) {
        relativesRepository.deleteById(relativesId);
    }
}
