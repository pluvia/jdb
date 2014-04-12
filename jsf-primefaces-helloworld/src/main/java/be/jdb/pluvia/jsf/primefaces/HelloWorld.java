package be.jdb.pluvia.jsf.primefaces;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
public class HelloWorld {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloWorld.class);

	private String firstName = "John";
	private String lastName = "Doe";
	private String greeting;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGreeting() {
		String result = "Hello" + " " + firstName + " " + lastName + "!";
		logger.info(result);
		return result;
	}
}