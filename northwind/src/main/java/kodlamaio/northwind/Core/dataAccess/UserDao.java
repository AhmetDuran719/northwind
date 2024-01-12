package kodlamaio.northwind.Core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.Core.Entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
