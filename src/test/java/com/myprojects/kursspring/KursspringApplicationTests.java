package com.myprojects.kursspring;

import com.myprojects.kursspring.domain.Castle;
import com.myprojects.kursspring.domain.Knight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KursspringApplicationTests {

	@Autowired
	Knight knight;

	@Autowired
	Castle castle;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCastle() {
		String  except = "Znajduje się tu zamek King's Landing. Zamieszkały przez rycerza Rycerz o imieniu Lancelot ( 29 ). Zadanie: Save princess";
		assertEquals(except, castle.toString());
	}

}
