package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection connection) {
		this.conn = connection;
	}

	
	
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("INSERT INTO `cousejdbc`.`department` (`Name`) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			
			int arrows = st.executeUpdate();
			
			if(arrows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
					
					System.out.println("ID: " + obj.getId() + "\n" + "Nome: " + obj.getName());
					
				}
				DB.closeResultSet(rs);
			}else {
				throw new DbException("Erro inesperado!");
			}
			
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatament(st);
		}
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			
			st = conn.prepareStatement("UPDATE `cousejdbc`.`department` SET `Name` = ? WHERE (`Id` = ? )", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
			System.out.println("Feito!");
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatament(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM `cousejdbc`.`department` WHERE (`Id` = ?)");
			
			st.setInt(1, id);
			
			int tst = st.executeUpdate();
			if(tst > 0 ) {
				System.out.println("Feito!");
			}else {
				System.out.println("Deu errado");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM cousejdbc.department WHERE Id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department obj = instanciaDp(rs);
				return obj;
			}
			return null;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatament(st);
		}
	}
	
	private Department instanciaDp(ResultSet rs) throws SQLException{
		Department dp = new Department();
		
		dp.setId(rs.getInt("Id"));
		dp.setName(rs.getString("Name"));
		return dp;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
