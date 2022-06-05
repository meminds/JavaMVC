package etrade.business.concretes;

import java.util.ArrayList;
import java.util.List;

import etrade.business.abstracts.ProductService;
import etrade.dataAccess.abstracts.ProductRepository;
import etrade.entites.concretes.Product;

public class ProductManager implements ProductService {

	private ProductRepository productRepository;

	public ProductManager(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void add(Product product) {

		if (!checkIfProductNameExist(product.getName()) && checkIfProductByCategory(product.getCategoryId()) && checkIfProductPriceMines(product.getUnitPrice())) {
			this.productRepository.add(product);
		} else {
			System.out.println("Bu ürün eklenemez");
		}

	}

	
	@Override
	public void delete(Product product) {
		this.productRepository.delete(getById(product.getId()));
	}

	@Override
	public void update(Product product) {
		Product item = getById(product.getId());
		item.setName(product.getName());
		item.setDescription(product.getDescription());
		item.setCategoryId(product.getCategoryId());
		item.setUnitPrice(product.getUnitPrice());
		this.productRepository.update(item);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.getAll();
	}

	@Override
	public Product getById(int id) {
		Product productTo = null;
		
		for (Product item : productRepository.getAll()) {
			if (item.getId() == id) {
				productTo = item;
			}
		}
		return productTo;
	}
	
	private boolean checkIfProductNameExist(String productName) {
		boolean exist = false;
		for (Product product : productRepository.getAll()) {
			if (product.getName() == productName) {
				exist = true;
			}
		}
		return exist;
	}
	private boolean checkIfProductByCategory(int id) {
		boolean exist = false;
		int count=0;
		for (Product product : productRepository.getAll()) {
			if ((product.getCategoryId()== id) && count<5) {
				count++;
			}
		}
		if (count<5) {
			exist=true;
		} 
		return exist;
	}
	
	private boolean checkIfProductPriceMines(double price) {
		boolean exists = true;
		if (price <= 0) {
			exists = false;
		}
		return exists;
	}
	
	
	
	
}
