
package datn.web.service;

import java.util.List;

import datn.web.entity.Employee;
import datn.web.model.EmployeeModel;

/**
 * Class cung cap cac dich vu thao tac voi table Employee trong database
 */
public interface EmployeeService {

	List<EmployeeModel> getListEmployee();

	void save(Employee employee);
	
}
