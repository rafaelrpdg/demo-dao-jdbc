package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDois {

	public static void main(String[] args) {
		DepartmentDao dpDao = DaoFactory.createDepartmentDao();
		Department dp = new Department(12, "Pops");
//		dpDao.insert(dp);
//		dpDao.update(dp);
//		dpDao.deleteById(11);
		dp = dpDao.findById(2);
		System.out.println(dp);
		
		
	}

}
