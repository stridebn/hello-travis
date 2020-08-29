import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class HelloTest {

	@Test
	public void testMain1() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Hello.main(null);
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		// Check for desired result
		String s = baos.toString();
		if (! "Hello, Jay.\n".equals(s))
			fail("Unexpected output:\n"+s+"\n");
	}
	
	@Test
	public void testMain2() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		String[] sarray = new String[1];
		sarray[0] = new String("Jayne");
		Hello.main(sarray);
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		// Check for desired result
		String s = baos.toString();
		if (! "Hello, Jayne.\n".equals(s))
			fail("Unexpected output:\n"+s+"\n");
	}

	@Test
	public void testDefaultMessage() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Hello.defaultMessage();
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		// Check for desired result
		String s = baos.toString();
		if (! "Hello, Jay.\n".equals(s))
			fail("Unexpected output:\n"+s+"\n");

	}
	
	@Test
	public void testPersonalizedMessage() {
		// Redirect System.out to a sring
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		
		// Prep done, call function of interest
		Hello.personalizedMessage("John");
		
		// Restore the stdout stream
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		
		// Check for desired result
		String s = baos.toString();
		if (! "Hello, John.\n".equals(s))
			fail("Unexpected output:\n"+s+"\n");

	}

}
