package com.skg.jetm.service;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-web.xml" })
public class MyServiceImplTest {

	@Autowired
	MyService myService;
	
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		myService.completeSlowly();
		myService.completeQuickly();
		myService.completeSlowly();
		myService.completeQuickly();
	}

}
