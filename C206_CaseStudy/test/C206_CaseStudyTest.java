import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Activities a1;
	private Activities a2;
	private RegisterActivity r1;
	private RegisterActivity r2;
	private TimeSlot t1;
	private TimeSlot t2;
	private Users u1;
	private Users u2;
	private Users u3;
	private Users u4;
	
	private ArrayList<Activities> actList;
	private ArrayList<RegisterActivity> regList;
	private ArrayList<TimeSlot> tsList;
	private ArrayList<Users> userList;
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		a1 = new Activities("Soccer", "Soccer is fun");
		a2 = new Activities("Tennis", "Tennis is fun");
		r1 = new RegisterActivity("Soccer", "Tom", "1000 - 1200");
		r1 = new RegisterActivity("Tennis", "Jerry", "1300 - 1500");
		t1 = new TimeSlot("Soccer", "1000 - 1200");
		t2 = new TimeSlot("Tennis", "1300 - 1500");
		u1 = new Users("Tom", "Student", "1111");
		u2 = new Users("Jerry", "Student", "2222");
		u3 = new Users("teacher", "Teacher", "6969");
		u4 = new Users("admin", "Administrator", "4200");
		
		actList = new ArrayList<Activities>();
		regList = new ArrayList<RegisterActivity>();
		tsList = new ArrayList<TimeSlot>();
		userList = new ArrayList<Users>();
		
	}
	
	@Test
	public void testAddCamcorder() {
		// Item list is not null and it is empty
		assertNotNull("Test if there is valid Camcorder arraylist to add to", camcorderList);
		assertEquals("Test that the Camcorder arraylist is empty.", 0, camcorderList.size());
		
		
		// Given an empty list, after adding 1 item, the size of the list is 1
		ResourceCentre.addCamcorder(camcorderList, cc1);
		assertEquals("Test that the Camcorder arraylist size is 1.", 1, camcorderList.size());

		
		// Add an item
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that the Camcorder arraylist size is now 2.", 2, camcorderList.size());
		
		
		// The item just added is as same as the last item in the list
		assertSame("Test that Camcorder is added to the end of the list.", cc2, camcorderList.get(1));

		
		// Add an item that already exists in the list
		ResourceCentre.addCamcorder(camcorderList, cc2);
		assertEquals("Test that the Camcorder arraylist size is unchange.", 2, camcorderList.size());

		
		// Add an item that has missing detail
		Camcorder cc_missing = new Camcorder("CC0014", "", 60);
		ResourceCentre.addCamcorder(camcorderList, cc_missing);
		assertEquals("Test that the Camcorder arraylist size is unchange.", 2, camcorderList.size());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
