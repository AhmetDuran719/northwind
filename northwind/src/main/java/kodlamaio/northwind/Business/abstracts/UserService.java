package kodlamaio.northwind.Business.abstracts;

import kodlamaio.northwind.Core.Entities.User;
import kodlamaio.northwind.Core.utilities.results.DataResult;
import kodlamaio.northwind.Core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

public interface UserService {

	Result add(User user);
	
	DataResult<User> findByEmail(String email);

}
