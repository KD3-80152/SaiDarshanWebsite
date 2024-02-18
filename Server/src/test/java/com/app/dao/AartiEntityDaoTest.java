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

import com.app.entities.Aarti;
import com.app.entities.AartiType;
import com.app.entities.UserEntity;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false) 
public class AartiEntityDaoTest 
{
	
	@Autowired
	private AartiDao aartiRepo;
	
	@Test
	void testAddAarti()
	{
		List<Aarti> list = List.of(
				new Aarti(LocalDate.parse("2024-03-12"),AartiType.Kakad_Aarti,2,400.00,"Himanshu Rathore","146372983563"),
				new Aarti(LocalDate.parse("2024-03-12"),AartiType.Dhoop_Aarti,1,200.00,"Mugdha Moghe","146372983562"));
		
		
		
		List<Aarti>list2 = aartiRepo.saveAll(list);
		assertEquals(2, list2.size());
	}
	
}


//insert into aarti(adhar_no,amount,arti_date,no_of_men,no_of_women,aarti_type,primary_devotee_name,user_id) values('146372983561',400,'2024-02-13',2,2,'Kakad_Aarti','Unnati Joshi',3);
//
//
//insert into aarti(adhar_no,amount,arti_date,no_of_men,no_of_women,aarti_type,primary_devotee_name,user_id) values('146372983562',800,'2024-02-16',2,2,'Kakad_Aarti','Mugdha Moghe',2);
//
//insert into aarti(adhar_no,amount,arti_date,no_of_men,no_of_women,aarti_type,primary_devotee_name,user_id) values('146372983563',600,'2024-02-18',1,3,'Dhoop_Aarti','Himanshu Rathore',4)


