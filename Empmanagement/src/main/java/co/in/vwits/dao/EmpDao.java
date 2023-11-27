package co.in.vwits.dao;

import java.util.List;
import java.util.Optional;

import co.in.vwits.model.Emp;

public interface EmpDao {

	List<Emp> findAll();

	void save(Emp e);

	Optional<Emp> findById(int empId);

	void deleteByEmpId(int empId);

	void updateByEmpId(int empId, double modifiedSalary);
	
}
