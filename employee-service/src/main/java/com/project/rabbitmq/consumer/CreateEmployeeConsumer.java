package com.project.rabbitmq.consumer;

import com.project.dto.request.SaveEmployeeRequestDto;
import com.project.rabbitmq.model.CreateEmployeeModel;
import com.project.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmployeeConsumer {
    private final EmployeeService employeeService;

    @RabbitListener(queues = "auth-create-employee-queue")
    public void createUserListener(CreateEmployeeModel model){
        System.out.println("Kuyruk gelen mesaj: " + model);
        employeeService.saveEmployee(SaveEmployeeRequestDto.builder()
                        .authId(model.getAuthId())
                        .name(model.getName())
                        .surname(model.getSurname())
                        .identityNumber(model.getIdentityNumber())
                        .phoneNumber(model.getPhoneNumber())
                        .email(model.getEmail())
                        .address(model.getAddress())
                        .position(model.getPosition())
                        .department(model.getDepartment())
                        .occupation(model.getOccupation())
                        .companyName(model.getCompanyName())
                        .status(model.getStatus())
                .build());
    }
}
