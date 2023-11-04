package net.javaguides.employeeservice.service.impl

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import io.github.resilience4j.retry.annotation.Retry
import net.javaguides.employeeservice.dto.APIResponseDto
import net.javaguides.employeeservice.dto.DepartmentDto
import net.javaguides.employeeservice.dto.EmployeeDto
import net.javaguides.employeeservice.entity.Employee
import net.javaguides.employeeservice.mapper.EmployeeMapper.Companion.mapToEmployee
import net.javaguides.employeeservice.mapper.EmployeeMapper.Companion.mapToEmployeeDto
import net.javaguides.employeeservice.repository.EmployeeRepository
import net.javaguides.employeeservice.service.APIClient
import net.javaguides.employeeservice.service.EmployeeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import java.lang.Exception

@Service
class EmployeeServiceImpl(
    val employeeRepository: EmployeeRepository,
    //val restTemplate: RestTemplate
    val webClient: WebClient
    //val apiClient: APIClient
): EmployeeService {

    companion object {
        var LOGGER: Logger = LoggerFactory.getLogger(EmployeeServiceImpl::class.java)
    }



    override fun saveEmployee(employeeDto: EmployeeDto): EmployeeDto {
        val employee = mapToEmployee(employeeDto)

        val saveDEmployee = employeeRepository.save(employee)

        return mapToEmployeeDto(saveDEmployee)
    }

    //@CircuitBreaker(name = "EMPLOYEE-SERVICE", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "EMPLOYEE-SERVICE", fallbackMethod = "getDefaultDepartment")
    override fun getEmployeeById(employeeId: Long): APIResponseDto? {

        LOGGER.info("inside getDefaultDepartment() method")
       val employee = employeeRepository.findById(employeeId).get()

       /*val responseEntity: ResponseEntity<DepartmentDto> = restTemplate.getForEntity("http://localhost:8080/api/departments/${employee.departmentCode}",
            DepartmentDto::class.java)

       val departmentDto = responseEntity.body*/

       val departmentDto: DepartmentDto? = webClient.get()
            .uri("http://localhost:8080/api/departments/${employee.departmentCode}")
            .retrieve()
            .bodyToMono<DepartmentDto>( DepartmentDto::class.java)
            .block()
        //val departmentDto: DepartmentDto = apiClient.getDepartment(employee.departmentCode)

        val employeeDto = mapToEmployeeDto(employee)

        val apiResponseDto: APIResponseDto? = departmentDto?.let {
            APIResponseDto(
                employee = employeeDto,
                department = it
            )
        }


        return apiResponseDto
    }

    fun getDefaultDepartment(employeeId: Long, exception: Exception): APIResponseDto {

        LOGGER.info("inside getEmployeeById() method")
        val employee = employeeRepository.findById(employeeId).get()

        val departmentDto: DepartmentDto = DepartmentDto(
            departmentName = "R&D Department",
            departmentDescription = "Research and Development Department",
            departmentCode = "RD001",
            id = 100
        )

        val employeeDto = mapToEmployeeDto(employee)


        return APIResponseDto(
            employee = employeeDto,
            department = departmentDto
        )
    }
}