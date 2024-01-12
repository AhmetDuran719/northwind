package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;


public interface ProductDao extends JpaRepository<Product, Integer>{

	Product getByProductName(String productName);
	
	//product name i getir (where = and) nerdeki kategori id si şu olan!!
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	//product name i getir (yada) nerdeki kategori id si şu olan!!
	 List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
	
	//select * from products where category_id in(1,2,3,4)
	 List<Product> getByCategoryIn(List<Integer> categories);
	
	//container example
	 List<Product> getByProductNameContains(String productName);
	
	//ürün ismi verilen pathle başlayan
	 List<Product> getByProductNameStartsWith(String productName);
	
	//query sorgusunda veritabanı isimlerini değil entity clasımızdaki yazım şekline göre yazıyoruz
	//: gelen parametreyi yazmak için yazılır
	 @Query("From Product where productName=:productName and category.categoryId=:categoryId")
	  List<Product> getByNameAndCategory(String productName, int categoryId);
	 
	 
	 @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
		  		+ "(p.id, p.productName, c.categoryName) "
		  		+ "From Category c Inner Join c.products p")
		  List<ProductWithCategoryDto> getProductWithCategoryDetails();
	 //select p.productName,p.productId,c.categoryName from Category c inner join Product p
	 //on c.categoryId = p.categoryId
}
