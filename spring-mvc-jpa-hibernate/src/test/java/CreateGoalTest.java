/*import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.journaldev.spring.model.Goal;
import com.journaldev.spring.repository.GoalRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:servlet-context.xml")
public class CreateGoalTest {

	@Autowired
	private GoalRepository goalRepository;


	@Test
	public void testAddGoals() {
		System.out.println("--- Add Goals ---");

		Goal goal1 = new Goal();
		goal1.setGoal("Goal Alias");
		goal1.setStatus("NEW");
		goal1.setStartOn(new Date());
		goal1.setEndOn(new Date());

		Goal goal2 = new Goal();
		goal2.setGoal("HRA GOAL");
		goal2.setStatus("IN PROGRESS");
		goal2.setStartOn(new Date());
		goal2.setEndOn(new Date());

		Goal goal3 = new Goal();
		goal3.setGoal("TCS GOAL");
		goal3.setStatus("TASK COMPLETED");
		goal3.setStartOn(new Date());
		goal3.setEndOn(new Date());


		Goal goal4 = new Goal();
		goal4.setGoal("Accenture GOAL");
		goal4.setStatus("PENDING");
		goal4.setStartOn(new Date());
		goal4.setEndOn(new Date());


		Goal goal5 = new Goal();
		goal5.setGoal("Goal Alias");
		goal5.setStatus("NEW");
		goal5.setStartOn(new Date());
		goal5.setEndOn(new Date());

		Goal goal6 = new Goal();
		goal6.setStatus("IN PROGRESS");
		goal6.setGoal("Amdocs GOAL");
		goal6.setStartOn(new Date());
		goal6.setEndOn(new Date());

		Goal goal7 = new Goal();
		goal7.setGoal("IBM GOAL");
		goal7.setStatus("TASK COMPLETED");
		goal7.setStartOn(new Date());
		goal7.setEndOn(new Date());


		Goal goal8 = new Goal();
		goal8.setGoal("HP GOAL");
		goal8.setStatus("PENDING");
		goal8.setStartOn(new Date());
		goal8.setEndOn(new Date());

		goalRepository.save(goal1);
		goalRepository.save(goal2);
		goalRepository.save(goal3);
		goalRepository.save(goal4);
		goalRepository.save(goal5);
		goalRepository.save(goal6);
		goalRepository.save(goal7);
		goalRepository.save(goal8);
	}

}
*/