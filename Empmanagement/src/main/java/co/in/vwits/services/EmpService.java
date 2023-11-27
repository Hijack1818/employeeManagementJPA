package co.in.vwits.services;

import java.util.List;
import java.util.Optional;

import co.in.vwits.model.Emp;

public interface EmpService {

	List<Emp> findAll();

	void save(Emp e);

	Optional<Emp> findByEmpID(int rollno);

	void deleteByEmpId(int empId);

	void updateByEmpId(int empId, double modifiedSalary);

	List<Emp> findAllOrderBySalary();

	List<Emp> findAllOrderByName();

}
