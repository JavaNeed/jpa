/*import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.model.Goal;
import com.journaldev.spring.repository.GoalRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:servlet-context.xml")
public class QueryDSLTest {

	@Autowired
	private GoalRepository goalRepository;
	
	@Test
	public void testQueryDSLByStatus() {
		System.out.println(" TEST QUERY DSL ");
		
		List<Goal> goals = goalRepository.findByStatus();
		for (Goal goal : goals) {
			System.out.println("------------");
			System.out.println(goal.getStatus());
			System.out.println(goal.getEndOn());
			System.out.println(goal.getStartOn());
		}
	}

}
*/