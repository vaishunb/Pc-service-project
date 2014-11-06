package test;

import java.time.LocalTime;
import java.util.List;

import models.Form;
import models.User;

import org.junit.Test;
import static org.junit.Assert.*;


public class ETest {
	
	@Test
	public void findFormsByUser() {
        User testUser = new User("Alex", "email@email.com", "secret", "225415", "Baranovichi", "Koszewogo", "11");
        Form.create("email@email.com", LocalTime.now(), Form.DeviceType.Laptop, "HP-11", "Burned", false, Form.Priority.Low);
        Form.create("email@email.com", LocalTime.MIDNIGHT, Form.DeviceType.Smartphone, "HTC Mozart", "Cracked", true, Form.Priority.Middle);
        
        List<Form> results = Form.findFormsRequested(testUser.email);
        assertEquals(22, results.size());
        assertEquals("HP-10", results.get(0).model);
	}
	
}
