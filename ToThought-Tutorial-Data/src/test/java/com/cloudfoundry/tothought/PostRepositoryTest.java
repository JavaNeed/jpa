package com.cloudfoundry.tothought;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cloudfoundry.tothought.entities.Post;
import com.cloudfoundry.tothought.repositories.PostRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class PostRepositoryTest {
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); 

	@Autowired
	PostRepository repository;
	
	@Test
	public void test() throws ParseException {
		Post post = new Post();
		post.setPostDate(formatter.parse("7-Jan-2016"));
		post.setTitle("First Post");
		
		Post post2 = new Post();
		post2.setPostDate(formatter.parse("15-Jan-2016"));
		post2.setTitle("Second Post");
		
		repository.save(post);
		repository.save(post2);
		
		// Find by PostId
		Post dbpost = repository.findOne(post.getPostId());
		assertNotNull(dbpost);
		System.out.println(dbpost.getTitle());
	}

}
