package storm_falcon.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import storm_falcon.demo.domain.User;
import storm_falcon.demo.domain.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() {
		User user = userRepository.findByUsername("admin");
		System.out.println(user);
	}

}
