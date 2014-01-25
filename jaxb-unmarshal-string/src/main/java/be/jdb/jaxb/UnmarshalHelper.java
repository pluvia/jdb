package be.jdb.jaxb;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.jdb.jaxb.model.Car;

public class UnmarshalHelper {

	private static final Logger logger = LoggerFactory
			.getLogger(UnmarshalHelper.class);

	public static Car Unmarshal(String xml) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(xml);
		Car car = (Car) jaxbUnmarshaller.unmarshal(reader);

		logger.info(car.toString());
		return car;
	}
}