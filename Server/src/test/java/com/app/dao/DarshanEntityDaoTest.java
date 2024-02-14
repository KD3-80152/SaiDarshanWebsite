package com.app.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Darshan;
import com.app.entities.Gender;
import com.app.entities.UserEntity;
import com.app.entities.UserRole;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class DarshanEntityDaoTest {

	
	
		// dep
		@Autowired
		private DarshanDao darshanDao;

		

//		@Test
//		void testAddUsers() {
//
//			List<Darshan> list = List.of(
//					new Darshan("Prashant", "Kumar", "prashant@gmail.com", enc.encode("prashant"),"9465823452", UserRole.ROLE_ADMIN,LocalDate.parse("2000-11-04"),Gender.MALE,"146372983563"),
//					new Darshan("Mugdha", "Moghe", "mugdha@gmail.com", enc.encode("mugdha"),"9465823451", UserRole.ROLE_USER,LocalDate.parse("1999-10-28"),Gender.FEMALE,"146372983562"),
//					new Darshan("Unnati", "Joshi", "unnati@gmail.com", enc.encode("unnati"), "9465823453",UserRole.ROLE_USER,LocalDate.parse("1999-08-17"),Gender.FEMALE,"146372983561"),
//					new Darshan("Himanshu", "Rathore", "himanshu@gmail.com", enc.encode("himanshu"), "9465823454",UserRole.ROLE_USER,LocalDate.parse("1999-08-04"),Gender.MALE,"146372983567"));
//
//			List<UserEntity> list2 = darshanDao.saveAll(list);
//			assertEquals(4, list2.size());
//
//
//		}

}
