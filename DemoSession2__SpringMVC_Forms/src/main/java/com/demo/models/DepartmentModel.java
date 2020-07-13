package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Department;

public class DepartmentModel {

	public List<Department> findAll() {
		List<Department> departments = new ArrayList<Department>();
		departments.add(new Department("d1", "Department 1"));
		departments.add(new Department("d2", "Department 2"));
		departments.add(new Department("d3", "Department 3"));
		departments.add(new Department("d4", "Department 4"));
		departments.add(new Department("d5", "Department 5"));
		return departments;
	}

}
