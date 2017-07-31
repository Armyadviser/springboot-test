package storm_falcon.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @author gewp
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
