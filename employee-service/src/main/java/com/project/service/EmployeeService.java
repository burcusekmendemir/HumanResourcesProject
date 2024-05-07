package com.project.service;

import com.project.dto.request.SaveEmployeeRequestDto;
import com.project.entity.Employee;
import com.project.exception.EmployeeServiceException;
import com.project.exception.ErrorType;
import com.project.mapper.EmployeeMapper;
import com.project.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public Employee save(SaveEmployeeRequestDto dto) {
        Optional<Employee> employee = employeeRepository.findOptionalByIdientityNumber(dto.getIdentityNumber());
        if (employee.isPresent()) {
            throw new EmployeeServiceException(ErrorType.EMPLOYEE_IS_ALREADY_REGISTERED);
        }

        return employeeRepository.save(EmployeeMapper.INSTANCE.fromSaveEmployeeRequestDtoToEmployee(dto));
    }


//TODO
    /**
     *  String companyEmail = "manager" + dto.getName() + "@" + dto.getCompanyName() + ".com";
     *         auth.setCompanyEmail(companyEmail.toLowerCase());
     *         auth.setUserType(EUserType.MANAGER);
     *         auth.setCompanyName(auth.getCompanyName().toLowerCase());
     *         save(auth);
     */
}
