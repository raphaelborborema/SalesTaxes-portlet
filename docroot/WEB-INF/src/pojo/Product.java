package pojo;

public class Product {
	private String name;
	private ProductType type;
	private float price;
	private Boolean imported;
	
	
	public Product(){
		
	}
	
	public Product(String name , ProductType type,float price , Boolean imported ){
		setName(name);
		setType(type);
		setPrice(price);
		setImported(imported);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Boolean getImported() {
		return imported;
	}
	public void setImported(Boolean imported) {
		this.imported = imported;
	}
	

}
