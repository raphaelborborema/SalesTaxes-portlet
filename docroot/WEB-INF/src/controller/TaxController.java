package controller;

import java.math.BigDecimal;
import java.util.List;

import pojo.Product;
import pojo.ProductType;

/**
 * This class consists in all purchase tax business rules.
 * @author raphaelborborema
 *
 */
public class TaxController {
	/**
	 * Base round constant
	 */
	private static final float ROUND=0.05f;
	/**
	 * Imported tax constant
	 */
	private static final float IMPORTAD_TAX = 5.0f / 100;
	/**
	 * Basic tax constant
	 */
	private static final float BASIC_TAX = 10.0f / 100;
	
	
	
	
	/**
	 * @param product
	 * @return The complete tax of the product
	 */
	public  float getTaxByProduct(Product product){
		if(product.getImported() && !isExempt(product.getType())){
			return IMPORTAD_TAX + BASIC_TAX;
		}else if(product.getImported() && isExempt(product.getType())){
			return IMPORTAD_TAX;
		}else if(!product.getImported() && !isExempt(product.getType())){
			return BASIC_TAX;
		}
		return 0;
	}
	
	/**
	 * @param product
	 * @return the amount that should be added to the product price.
	 */
	public float calculateTax(Product product) {
		return roundTax(getTaxByProduct(product) * product.getPrice());
	}
	
	/**
	 * @param product
	 * @return product price + product tax
	 */
	public float calculateTotalValue(Product product) {
		return  product.getPrice() + roundTax(getTaxByProduct(product) * product.getPrice()); 
	}
	
	/**
	 * @param productList
	 * @return the receipt total cost 
	 */
	public float calculateTotal(List<Product> productList){
		float totalCost = 0.00f ;
		for (Product product : productList) {
			totalCost += (product.getPrice() + calculateTax(product));
		}
		return totalCost;
		
	}
	/**
	 * @param productList
	 * @return the receipt total tax
	 */
	public float calculateSalesTax(List<Product> productList){
		float saleTax = 0.00f;
		for (Product product : productList) {
			saleTax += calculateTax(product);
		}
		return saleTax;
		
	}
	
	
	private float roundTax(float tax){
		return (float) new BigDecimal(String.valueOf(Math.ceil(tax/ROUND))).multiply(new BigDecimal(String.valueOf(ROUND))).floatValue();
	}
	
	
	public boolean isExempt(ProductType type){
		if(type.equals(ProductType.Book) ||type.equals(ProductType.Food) || type.equals(ProductType.Medical)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
}
