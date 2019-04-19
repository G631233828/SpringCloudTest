package gjb.springcloud.service;

import java.util.List;

import gjb.springcloud.entities.Dept;

public interface DeptService {
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
