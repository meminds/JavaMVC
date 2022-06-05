package etrade.entites.concretes;

public class Product {
	private int id;
	private String name;
	private String description;
	private double unitPrice;
	private int categoryId;
	
	

	public Product() {
		super();
	}
	
	public Product(int id, String name, String description, double unitPrice, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.categoryId = categoryId;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
