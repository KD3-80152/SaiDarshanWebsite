package com.app.dao;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false) 
public class AartiEntityDaoTest {

	
}


//insert into aarti(adhar_no,amount,arti_date,no_of_men,no_of_women,aarti_type,primary_devotee_name,user_id) values('146372983561',400,'2024-02-13',2,2,'Kakad_Aarti','Unnati Joshi',3);
//
//
//insert into aarti(adhar_no,amount,arti_date,no_of_men,no_of_women,aarti_type,primary_devotee_name,user_id) values('146372983562',800,'2024-02-16',2,2,'Kakad_Aarti','Mugdha Moghe',2);
//
//insert into aarti(adhar_no,amount,arti_date,no_of_men,no_of_women,aarti_type,primary_devotee_name,user_id) values('146372983563',600,'2024-02-18',1,3,'Dhoop_Aarti','Himanshu Rathore',4)