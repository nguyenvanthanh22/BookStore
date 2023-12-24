package datn.web.service;

import datn.web.model.EmployeeForm;

public interface GeneralService {

	EmployeeForm createEmployee(EmployeeForm employee);

	EmployeeForm getOneUserById(Integer id);

	EmployeeForm updateEmployee(EmployeeForm employeeForm);

}
