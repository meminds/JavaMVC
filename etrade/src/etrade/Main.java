package etrade;

import etrade.business.abstracts.ProductService;
import etrade.business.concretes.ProductManager;
import etrade.dataAccess.concretes.hibernateImpls.HibernateProductRepository;
import etrade.dataAccess.concretes.jdbcImpls.JdbcProductRepository;
import etrade.entites.concretes.Product;

public class Main {

	public static void main(String[] args) {
		ProductService productService = new ProductManager(new JdbcProductRepository());
		Product product1 = new Product(1, "Telefon", "Sarı", 5000,1);
		Product product2 = new Product(2, "Telef", "Saglam", 5500,1);
		Product product3 = new Product(3, "Tablet", "Innova", 5600,1);
		Product product4 = new Product(4, "Te", "Lenova", 7000,1);
		Product product5 = new Product(5, "Tel", "Lenova", 1030,1);
		Product product6 = new Product(6, "Tele", "Apple", 5050,2);
		Product product7 = new Product(7, "Bil", "Samsung", 6000,2);
		Product product8 = new Product(8, "Bilgi", "Marksa", 3000,2);
		Product product9 = new Product(9, "sayar", "Tekno", 10000,2);
		Product product10 = new Product(10, "Bilişim", "Macbook", 9450,5);
		Product product11 = new Product(11, "Bilgisayar", "Lenova", 5540,3);
		
		productService.add(product1);
		productService.add(product2);
		productService.add(product3);
		productService.add(product4);
		productService.add(product5);
		productService.add(product6);
		productService.add(product7);
		productService.add(product8);
		productService.add(product9);
		productService.add(product10);
		productService.add(product11);


		productService.delete(product4);
		productService.delete(product7);
		productService.delete(product10);
		
		
		productService.update(new Product(1, "Oyuncak", "Gri", 1, 5));
		
		for (Product product : productService.getAll()) {
			System.out.println(product.getId() + " / " + product.getName() + " / " + product.getDescription() + " / " + 
								product.getUnitPrice() + " / " + product.getCategoryId());
		}
	}

}
