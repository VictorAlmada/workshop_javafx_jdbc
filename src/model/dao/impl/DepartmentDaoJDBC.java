package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	// attributes
	private Connection conn;

	// constructor
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	// methods
	@Override
	public void insert(Department obj) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO department (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, obj.getName());
			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(stmt);
		}

	}

	@Override
	public void update(Department obj) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?");
			stmt.setString(1, obj.getName());
			stmt.setInt(2, obj.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(stmt);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("DELETE FROM department WHERE Id = ?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Department dp = instantiateDepartment(rs);
				return dp;
			}
			return null;

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(stmt);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM department");
			rs = stmt.executeQuery();
			List<Department> listDep = new ArrayList<>();
			while (rs.next()) {
				Department dp = instantiateDepartment(rs);
				listDep.add(dp);
			}
			return listDep;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(stmt);
			DB.closeResultSet(rs);
		}
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		String name = rs.getString("Name");
		dep.setName(name != null ? name : ""); // Trata valores nulos
		return dep;
	}

}
