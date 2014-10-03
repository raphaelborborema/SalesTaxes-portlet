package test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.TaxController;
import dao.ProductProducer;
import pojo.Product;

public class SalesTaxTest extends TestCase {
	private ProductProducer productProducer;
	private TaxController taxControler ;

	public ProductProducer getProductProducer() {
		if(productProducer==null){
			return new ProductProducer();
		}
		return productProducer;
	}

	public TaxController getTaxControler() {
		if(taxControler==null){
			return new TaxController();
		}
		return taxControler;
	}

	@Before
	protected void setUp() {

		System.out.println("STARTING TEST");

	}

	@After
	protected void tearDown() throws Exception {
		System.out.println("END OF TEST");
	}

	@Test
	public void testCheckReceipt1(){
		try {
		List<Product> productList = getProductProducer().getProductList1();
		float total = 0.00f ;
		float tax = 0.00f;
		for (Product product : productList) {
			total += (product.getPrice() + getTaxControler().calculateTax(product));
			tax += getTaxControler().calculateTax(product);
		}
		
			assertEquals("[Receipt1] - Testing the total cost",total, 29.83f);
			assertEquals("[Receipt1] - Testing the the total amounts of sales taxes",tax, 1.50f);
		}catch (Exception e) {
            e.printStackTrace();
            fail("Problem on receipt 1");
        }

	}
	
	@Test
	public void testCheckReceipt2(){
		try {
		List<Product> productList = getProductProducer().getProductList2();
		float total = 0.00f ;
		float tax = 0.00f;
		for (Product product : productList) {
			total += (product.getPrice() + getTaxControler().calculateTax(product));
			tax += getTaxControler().calculateTax(product);
		}
			
			assertEquals("[Receipt2] - Testing the total cost",total, 65.15f);
			assertEquals("[Receipt2] - Testing the the total amounts of sales taxes",tax, 7.65f);
		}catch (Exception e) {
            e.printStackTrace();
            fail("Problem on receipt 2");
        }

	}
	
	@Test
	public void testCheckReceipt3(){
		try {
		List<Product> productList = getProductProducer().getProductList3();
		float total = 0.00f ;
		float tax = 0.00f;
		for (Product product : productList) {
			total += (product.getPrice() + getTaxControler().calculateTax(product));
			tax += getTaxControler().calculateTax(product);
		}
		
			assertEquals("[Receipt3] - Testing the total cost",total, 74.68f,0.0f );
			assertEquals("[Receipt3] - Testing the the total amounts of sales taxes",tax, 6.70f,0.0f );
		}catch (Exception e) {
            e.printStackTrace();
            fail("Problem on receipt 3");
        }

	}
}