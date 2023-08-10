import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	private Activities a1;
	private RegisterActivity r1;
	private TimeSlot t1;
	private Users u1;

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
		r1 = new RegisterActivity("Soccer", "Tom", "1000 - 1200");
		t1 = new TimeSlot("Soccer", "1000 - 1200");
		u1 = new Users("Tom", "Student", "1111");

		actList = new ArrayList<Activities>();
		regList = new ArrayList<RegisterActivity>();
		tsList = new ArrayList<TimeSlot>();
		userList = new ArrayList<Users>();

	}

	@Test
	public void testEmptyActivityList() {
		assertTrue(!actList.isEmpty());
	}

	@Test
	public void testEmptyRegisterActivityList() {
		assertTrue(!regList.isEmpty());
	}

	@Test
	public void testEmptyTimeslotList() {
		assertTrue(!tsList.isEmpty());
	}

	@Test
	public void testEmptyUserList() {
		assertTrue(!userList.isEmpty());
	}

	@Test
	public void testAddActivity() {
		//test case 1
		assertTrue(!actList.isEmpty());
		actList.add(a1);
		assertEquals("Test that activity has been added into activity arraylist", actList.size(), 1);
		
		//test case 2
		assertFalse(actList.add(null));
		assertEquals("Test that null will not be added into activity arraylist", actList.size(), 1);
	}

	@Test
	public void testAddRegisterActivity() {
		//test case 1
		assertTrue(!regList.isEmpty());
		regList.add(r1);
		assertEquals("Test that registered activity has been added into registered activity arraylist", regList.size(),
				1);
		
		//test case 2
		assertFalse(regList.add(null));
		assertEquals("Test that null will not be added into registered activity arraylist", regList.size(),
				1);
	}

	@Test
	public void testAddTimeslot() {
		//test case 1
		assertTrue(!tsList.isEmpty());
		tsList.add(t1);
		assertEquals("Test that timeslot has been added into timeslot arraylist", tsList.size(), 1);
		
		//test case 2
		assertFalse(tsList.add(null));
		assertEquals("Test that null will not be added into timeslot arraylist", tsList.size(), 1);
	}

	@Test
	public void testAddUser() {
		//test case 1
		assertTrue(!userList.isEmpty());
		userList.add(u1);
		assertEquals("Test that user has been added into user arraylist", userList.size(), 1);
		
		//test case 2
		assertFalse(userList.add(null));
		assertEquals("Test that null will not be added into user arraylist", userList.size(), 1);
	}

	@Test
	public void testViewActivity() {
		assertTrue(!actList.isEmpty());
		actList.add(a1);
		assertEquals("Test that activity has been added into activity arraylist", actList.size(), 1);
		assertTrue(actList.get(0).getaName().equalsIgnoreCase("Soccer"));
		assertTrue(actList.get(0).getDescription().equalsIgnoreCase("Soccer is fun"));
	}
	
	@Test
	public void testViewRegisterActivity() {
		assertTrue(!regList.isEmpty());
		regList.add(r1);
		assertEquals("Test that registered activity has been added into registered activity arraylist", regList.size(), 1);
		assertTrue(regList.get(0).getActivityName().equalsIgnoreCase("Soccer"));
		assertTrue(regList.get(0).getUsername().equalsIgnoreCase("Tom"));
		assertTrue(regList.get(0).getTimeSlot().equalsIgnoreCase("1000 - 1200"));
	}
	
	@Test
	public void testViewTimeslot() {
		assertTrue(!tsList.isEmpty());
		tsList.add(t1);
		assertEquals("Test that timeslot has been added into timeslot arraylist", tsList.size(), 1);
		assertTrue(tsList.get(0).getAname().equalsIgnoreCase("Soccer"));
		assertTrue(tsList.get(0).getTimeslot().equalsIgnoreCase("1000 - 1200"));
	}
	
	@Test
	public void testViewUser() {
		assertTrue(!userList.isEmpty());
		userList.add(u1);
		assertEquals("Test that user has been added into user arraylist", userList.size(), 1);
		assertTrue(userList.get(0).getName().equalsIgnoreCase("Tom"));
		assertTrue(userList.get(0).getRole().equalsIgnoreCase("Student"));
		assertTrue(userList.get(0).getContact().equalsIgnoreCase("1111"));
	}
	
	@Test
	public void testDeleteActivity() {
		assertTrue(!actList.isEmpty());
		actList.add(a1);
		assertEquals("Test that activity has been added into activity arraylist", actList.size(), 1);
		actList.remove(0);
		assertTrue(!actList.isEmpty());
		
		assertFalse(actList.remove(a1));
	}

	@Test
	public void testDeleteRegisteredActivity() {
		//test case 1
		assertTrue(!regList.isEmpty());
		regList.add(r1);
		assertEquals("Test that registered activity has been added into registered activity arraylist", regList.size(),
				1);
		regList.remove(0);
		assertTrue(!regList.isEmpty());
		
		//test case 2
		assertFalse(regList.remove(r1));
	}

	@Test
	public void testDeleteTimeslot() {
		//test case 1
		assertTrue(!tsList.isEmpty());
		tsList.add(t1);
		assertEquals("Test that timeslot has been added into timeslot arraylist", tsList.size(), 1);
		tsList.remove(0);
		assertTrue(!tsList.isEmpty());
		
		//test case 2
		assertFalse(tsList.remove(t1));
	}

	@Test
	public void testDeleteUser() {
		//test case 1
		assertTrue(!userList.isEmpty());
		userList.add(u1);
		assertEquals("Test that user has been added into user arraylist", userList.size(), 1);
		userList.remove(0);
		assertTrue(!userList.isEmpty());
		
		//test case 2
		assertFalse(userList.remove(u1));
	}

	@After
	public void tearDown() throws Exception {
		a1 = null;
		r1 = null;
		u1 = null;
		t1 = null;
		actList = null;
		regList = null;
		tsList = null;
		userList = null;
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

}
