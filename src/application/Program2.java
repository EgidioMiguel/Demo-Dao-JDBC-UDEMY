package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao dep = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== TEST 1: deparment insert ===");
		Department newDepartment = new Department(null, "BoardGame");
		dep.insert(newDepartment);
		System.out.println("Inserted! New Id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 2: department findById ===");
		Department department = dep.findById(3);
		System.out.println(department);
		
		System.out.println("\n=== TEST 3: department update ===");
		department = dep.findById(1);
		department.setName("Automóveis");
		dep.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 4: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		dep.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println("\n=== TEST 5: department findAll ===");
		List<Department> list = dep.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
