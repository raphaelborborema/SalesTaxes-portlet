package dao;

import java.util.ArrayList;
import java.util.List;

import pojo.Product;
import pojo.ProductType;
/**
 * This class consists exclusively to return the lists of products of each receipt.
 * @author raphaelborborema
 *
 */
public class ProductProducer {

	/**
	 * List products of receipt1
	 */
	private List<Product> productList1;
	/**
	 * List products of receipt2
	 */
	private List<Product> productList2;
	/**
	 * List products of receipt3
	 */
	private List<Product> productList3;


	/**
	 * Constructor
	 */
	public ProductProducer(){  
		initProductList1();
		initProductList2();
		initProductList3();
	}




	/**
	 *  Initialize and add the products to receipt1
	 */
	public void initProductList1(){
		this.productList1 = new ArrayList<Product>();
		this.productList1.add(new Product("book",ProductType.Book,12.49f,false));
		this.productList1.add(new Product("music CD",ProductType.Others,14.99f,false));
		this.productList1.add(new Product("chocolate bar",ProductType.Food,0.85f,false));
	}
	/**
	 *  Initialize and add the products to receipt2
	 */
	public void initProductList2(){
		this.productList2 = new ArrayList<Product>();
		this.productList2.add(new Product("imported box of chocolates",ProductType.Food,10.00f,true));
		this.productList2.add(new Product("imported bottle of perfume",ProductType.Others,47.50f,true));

	}
	/**
	 *  Initialize and add the products to receipt3
	 */
	public void initProductList3(){
		this.productList3 = new ArrayList<Product>();
		this.productList3.add(new Product("imported bottle of perfume",ProductType.Others,27.99f,true));
		this.productList3.add(new Product("bottle of perfume",ProductType.Others,18.99f,false));
		this.productList3.add(new Product("packet of headache pills",ProductType.Medical,9.75f,false));
		this.productList3.add(new Product("imported box of chocolates",ProductType.Food,11.25f,true));

	}

	
	public List<Product> getProductList1() {
		return productList1;
	}

	
	public void setProductList1(List<Product> productList1) {
		this.productList1 = productList1;
	}

	
	public List<Product> getProductList2() {
		return productList2;
	}

	
	public void setProductList2(List<Product> productList2) {
		this.productList2 = productList2;
	}

	
	public List<Product> getProductList3() {
		return productList3;
	}

	
	public void setProductList3(List<Product> productList3) {
		this.productList3 = productList3;
	}
}

