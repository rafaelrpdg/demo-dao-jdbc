package application;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(1, "book");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(obj);
		
		//seller = new Seller(21,"Bob", "Bob@gmail.com", new Date(), 3000.0, obj);
		System.out.println(seller);

	}

}
