package kodlamaio.northwind.Business.abstracts;

import java.util.List;


import kodlamaio.northwind.Core.utilities.results.DataResult;
import kodlamaio.northwind.Core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAll(int pageNo, int pageSize);
	
	DataResult<List<Product>> getAllSorted();
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	  
    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	  
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
	  
    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	  
    DataResult<List<Product>> getByProductNameContains(String productName);
	  
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
	
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
}
