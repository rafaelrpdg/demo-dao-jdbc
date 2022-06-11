package application;
import java.util.Date;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
//		System.out.println("=== Test FindById ===");
		Seller seller = sellerDao.findById(3);
//		
//		System.out.println(seller);
//
//		System.out.println("=== Test2 FindByDeparment ===");
		Department department = new Department(1,null);
//		List<Seller> list = sellerDao.findByDepartment(department);
//		for (Seller seller2 : list) {
//			System.out.println(seller2);
//		}
//		
//		System.out.println("=== Test2 Findall ===");
//		list = sellerDao.findAll();
//		for (Seller seller2 : list) {
//			System.out.println(seller2); 
//		}
		//Seller newSeller = new Seller(9,"Tafarel", "taferel2000@gmail.com", new Date(), 90000.0, department);
		
		seller = sellerDao.findById(9);
		
		seller.setName("Anita");
		sellerDao.update(seller);
		System.out.println("update complete!");
		
		
		
	}

}
