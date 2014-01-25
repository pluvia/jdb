package be.jdb.jaxb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.jdb.jaxb.model.Car;

public class UnmarshalHelperTest {

	private static final Logger logger = LoggerFactory
			.getLogger(UnmarshalHelperTest.class);

	public static File file;

	@BeforeClass
	public static void setUpBeforeClass() {
		file = new File("./src/main/resources/xml/golf.xml");
	}

	@Test
	public void testUnmarshalError() {
		try {
			UnmarshalHelper.UnmarshalError(file);
			fail("no exception thrown");
		} catch (Exception e) {
			logger.error("MarshalException", e);
			assertTrue(e.toString().contains("unexpected element (uri:"));
		}
	}

	@Test
	public void testUnmarshal() throws JAXBException {
		Car car = UnmarshalHelper.Unmarshal(file);
		assertEquals(car.toString(), "Car [make=Golf, manufacturer=Volkswagen, id=DEF-456]");
	}
}
