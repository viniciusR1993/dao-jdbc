package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("===== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println();
		
		System.out.println("===== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartmet(department);
		for(Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("===== TEST 3: seller findAll =====");
		list = sellerDao.findAll();
		for(Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println();
		
		System.out.println("===== TEST 4: seller insert =====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		System.out.println();
		
		System.out.println("===== TEST 5: seller update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		System.out.println();
		
		System.out.println("===== TEST 5: seller delete =====");
		System.out.println("Enter id for delete test: ");
		/*Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		sc.close();
		sellerDao.delete(id);*/
		sellerDao.delete(newSeller.getId());	//Deleta a inserção acima
		System.out.println("Deleted completed!");
		System.out.println();
		
		System.out.println();
		System.out.println("==================================================================================");
		System.out.println();
		
		System.out.println("===== TEST 6: department insert =====");
		Department newDepartment = new Department(null, "Estatistc");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		System.out.println();
		
		System.out.println("===== TEST 7: seller findById =====");
		Department department2 = departmentDao.findById(2);
		System.out.println(department2);
		System.out.println();
		
		System.out.println("===== TEST 8: department update =====");
		department2 = departmentDao.findById(1);
		department2.setName("Computer");
		departmentDao.update(department2);
		System.out.println("Update completed!");
		System.out.println();
		
		System.out.println("===== TEST 9: department delete =====");
		System.out.println("Enter id for delete test: ");
		/*Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		sc.close();
		departmentDao.delete(id);*/
		departmentDao.delete(newDepartment.getId());	//Deleta a inserção acima
		System.out.println("Deleted completed!");
		System.out.println();
		
		System.out.println("===== TEST 10: department findAll =====");
		List<Department> listD = departmentDao.findAll();
		for(Department obj: listD) {
			System.out.println(obj);
		}
		System.out.println();
	}
}
