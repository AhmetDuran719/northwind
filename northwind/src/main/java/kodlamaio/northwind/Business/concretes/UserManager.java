package kodlamaio.northwind.Business.concretes;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.northwind.Business.abstracts.UserService;
import kodlamaio.northwind.Core.Entities.User;
import kodlamaio.northwind.Core.dataAccess.UserDao;
import kodlamaio.northwind.Core.utilities.results.DataResult;
import kodlamaio.northwind.Core.utilities.results.Result;
import kodlamaio.northwind.Core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.Core.utilities.results.SuccessResult;

public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("kullanıcı eklendi");
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"kullanıcı bulundu");
	}

}
