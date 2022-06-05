package etrade.dataAccess.concretes.jdbcImpls;

import java.util.ArrayList;
import java.util.List;

import etrade.dataAccess.abstracts.ProductRepository;
import etrade.entites.concretes.Product;

public class JdbcProductRepository implements ProductRepository {

	
	List<Product> products = new ArrayList<Product>();
	
	@Override
	public void add(Product product) {
		products.add(product);
		System.out.println("Added with JDBC");
		
	}

	@Override
	public void delete(Product product) {
		products.remove(product);
		System.out.println("Deleted with JDBC");
	}

	@Override
	public void update(Product product) {
		Product productToUpdate = getById(product.getId());
		productToUpdate.setName(product.getName());
		productToUpdate.setDescription(product.getDescription());
		productToUpdate.setCategoryId(product.getCategoryId());
		productToUpdate.setUnitPrice(product.getUnitPrice());
		System.out.println("Updated with JDBC");
	}

	@Override
	public List<Product> getAll() {
		return products;
	}

	@Override
	public Product getById(int id) {
		Product productTo = null;
		for (Product item : products) {
			if (item.getId() == id) {
				productTo = item;
			}
		}
		return productTo;
	}

}
