package com.shop.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.db.ConnectionFactory;
import com.shop.model.Product;

public class JdbcProductRepository implements ProductRepository {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.repository.ProductRepository#save(com.shop.model.Product)
	 */
	@Override
	public void save(Product product) {
		//
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "insert into shop.PRODUCTS values (?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setDate(4, Date.valueOf(product.getMakeDate()));
			ps.setString(5, product.getImage());
			ps.setString(6, product.getDescription());
			int r = ps.executeUpdate();
			if (r == 1)
				System.out.println("New product saved ");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.shop.repository.ProductRepository#findAll()
	 */
	@Override
	public List<Product> findAll() {
		//
		List<Product> products = new ArrayList<>();
		Connection connection = null;
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "select * from shop.PRODUCTS";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setMakeDate(null);
				product.setImage(rs.getString(5));
				product.setDescription(rs.getString(6));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return products;
	}

	@Override
	public Product find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(int id, double newPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
