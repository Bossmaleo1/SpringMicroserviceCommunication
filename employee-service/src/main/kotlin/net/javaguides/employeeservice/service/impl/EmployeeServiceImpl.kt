package net.javaguides.employeeservice.service.impl

import net.javaguides.employeeservice.dto.APIResponseDto
import net.javaguides.employeeservice.dto.DepartmentDto
import net.javaguides.employeeservice.dto.EmployeeDto
import net.javaguides.employeeservice.entity.Employee
import net.javaguides.employeeservice.repository.EmployeeRepository
import net.javaguides.employeeservice.service.APIClient
import net.javaguides.employeeservice.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono

@Service
class EmployeeServiceImpl(
    val employeeRepository: EmployeeRepository,
    //val restTemplate: RestTemplate
    //val webClient: WebClient
    val apiClient: APIClient
): EmployeeService {

    override fun saveEmployee(employeeDto: EmployeeDto): EmployeeDto {
        val employee = Employee(
            employeeDto.id,
            employeeDto.firstName,
            employeeDto.lastName,
            employeeDto.email,
            employeeDto.departmentCode
        )

        val saveDEmployee = employeeRepository.save(employee)

        return EmployeeDto(
            saveDEmployee.id,
            saveDEmployee.firstName,
            saveDEmployee.lastName,
            saveDEmployee.email,
            saveDEmployee.departmentCode
        )
    }

    override fun getEmployeeById(employeeId: Long): APIResponseDto? {
       val employee = employeeRepository.findById(employeeId).get()

       /*val responseEntity: ResponseEntity<DepartmentDto> = restTemplate.getForEntity("http://localhost:8080/api/departments/${employee.departmentCode}",
            DepartmentDto::class.java)

       val departmentDto = responseEntity.body*/

       /*val departmentDto: DepartmentDto? = webClient.get()
            .uri("http://localhost:8080/api/departments/${employee.departmentCode}")
            .retrieve()
            .bodyToMono<DepartmentDto>( DepartmentDto::class.java)
            .block()*/
        val departmentDto: DepartmentDto = apiClient.getDepartment(employee.departmentCode)

        val employeeDto = EmployeeDto(
            employee.id,
            employee.firstName,
            employee.lastName,
            employee.email,
            employee.departmentCode
        )

        val apiResponseDto: APIResponseDto = APIResponseDto(
                employee = employeeDto,
                department = departmentDto
            )


        return apiResponseDto
    }
}