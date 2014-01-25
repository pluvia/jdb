package be.jdb.jaxb;

import static org.junit.Assert.assertEquals;

import javax.xml.bind.JAXBException;

import org.junit.BeforeClass;
import org.junit.Test;

import be.jdb.jaxb.model.Car;

public class UnmarshalHelperTest {

	public static String xml;

	@BeforeClass
	public static void setUpBeforeClass() {
		xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" "
				+ "standalone=\"yes\"?>"
				+ "<ns2:Car xmlns:ns2=\"be.jdb.jaxb.model\" id=\"ABC-123\">"
				+ "<make>Passat</make>"
				+ "<manufacturer>Volkswagen</manufacturer></ns2:Car>";
	}

	@Test
	public void testUnmarshal() throws JAXBException {
		Car car = UnmarshalHelper.Unmarshal(xml);
		assertEquals(car.toString(),
				"Car [make=Passat, manufacturer=Volkswagen, id=ABC-123]");
	}
}
