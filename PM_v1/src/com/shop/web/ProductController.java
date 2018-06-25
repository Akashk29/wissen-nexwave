package com.shop.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.Product;
import com.shop.repoistory.JdbcProductRepository;
import com.shop.repoistory.ProductRepository;

@WebServlet(urlPatterns = { "/pm", "/save" })
public class ProductController extends HttpServlet {

	private ProductRepository productRepo;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.productRepo = new JdbcProductRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> products = this.productRepo.findAll();
		req.setAttribute("products", products);
		req.getRequestDispatcher("pm.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Input
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String date = req.getParameter("date");
		String description = req.getParameter("description");

		// validation & type-conversion
		// map req-params to model
		Product product = new Product();
		product.setName(name);
		product.setPrice(Double.parseDouble(price));
		product.setDescription(description);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			product.setDate(df.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		productRepo.save(product);

		resp.sendRedirect("pm");

	}

}
