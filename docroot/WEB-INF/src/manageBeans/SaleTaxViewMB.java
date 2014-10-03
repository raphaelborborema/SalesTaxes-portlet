package manageBeans;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import pojo.Product;
import controller.TaxController;
import dao.ProductProducer;


@ManagedBean(name ="saleTaxViewMB")
@ViewScoped
public class SaleTaxViewMB implements Serializable{

	private static final long serialVersionUID = -2653055197059240828L;
	private ProductProducer productProducer;
	private TaxController taxControler ;
	private List<Product> dinamicProductList;
	private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

	
	
	
	
	
	


	@PostConstruct
	private void initParameters(){
		
		printReceiptWithTax(getProductProducer().getProductList1());
		printReceiptWithTax(getProductProducer().getProductList2());
		printReceiptWithTax(getProductProducer().getProductList3());

	}

	
	
	
	public void printReceiptWithTax(List<Product> productList) {
		
		StringBuilder receipt = new StringBuilder("\n");
		float totalCost = 0.00f ;
		float saleTax = 0.00f;
		float product_real_price = 0.00f;
		for (Product product : productList) {
			
			product_real_price = (product.getPrice() + getTaxControler().calculateTax(product));
			totalCost += product_real_price;
			saleTax += getTaxControler().calculateTax(product);
			receipt.append("\n").append(product.getName() + ":" + String.valueOf(product_real_price));
		}
		receipt.append("\nSales Tax:" + decimalFormat.format(saleTax));
		receipt.append("\nTotal :" + decimalFormat.format(totalCost));
		System.out.println(receipt.toString());
	}

	

	public List<Product> getDinamicProductList() {
		return dinamicProductList;
	}

	public void setDinamicProductList(List<Product> dinamicProductList) {
		this.dinamicProductList = dinamicProductList;
	}




	public ProductProducer getProductProducer() {
		if(productProducer==null){
			return new ProductProducer();
		}
		return productProducer;
	}


	public String calculateTotalValue(Product product){
	   return String.valueOf(getTaxControler().calculateTotalValue(product));
	}


	public TaxController getTaxControler() {
		if(taxControler==null){
			return new TaxController();
		}
		return taxControler;
	}




}