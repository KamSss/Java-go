import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByPhone(String phone);
    void deleteByPhone(String phone);
}