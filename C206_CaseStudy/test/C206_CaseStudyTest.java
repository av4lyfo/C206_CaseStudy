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
	public void testEmptyList() {
		// Item list is not null and it is empty
		assertTrue(!actList.isEmpty());
		assertTrue(!regList.isEmpty());
		assertTrue(!tsList.isEmpty());
		assertTrue(!userList.isEmpty());
	}
	
	@Test
	public void testAdd() {
		assertTrue(!actList.isEmpty());
		actList.add(a1);
		assertEquals("Test that activity has been added into activity arraylist", actList.size(), 1);
		
		assertTrue(!regList.isEmpty());
		regList.add(r1);
		assertEquals("Test that registered activity has been added into registered activity arraylist", regList.size(), 1);
		
		assertTrue(!tsList.isEmpty());
		tsList.add(t1);
		assertEquals("Test that timeslot has been added into timeslot arraylist", tsList.size(), 1);
		
		assertTrue(!userList.isEmpty());
		userList.add(u1);
		assertEquals("Test that user has been added into user arraylist", userList.size(), 1);
	}
	
	@Test
	public void testDelete() {
		assertTrue(!actList.isEmpty());
		actList.add(a1);
		assertEquals("Test that activity has been added into activity arraylist", actList.size(), 1);
		actList.remove(0);
		assertTrue(!actList.isEmpty());
		
		assertTrue(!regList.isEmpty());
		regList.add(r1);
		assertEquals("Test that registered activity has been added into registered activity arraylist", regList.size(), 1);
		regList.remove(0);
		assertTrue(!regList.isEmpty());
		
		assertTrue(!tsList.isEmpty());
		tsList.add(t1);
		assertEquals("Test that timeslot has been added into timeslot arraylist", tsList.size(), 1);
		tsList.remove(0);
		assertTrue(!tsList.isEmpty());
		
		assertTrue(!userList.isEmpty());
		userList.add(u1);
		assertEquals("Test that user has been added into user arraylist", userList.size(), 1);
		userList.remove(0);
		assertTrue(!userList.isEmpty());
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
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
