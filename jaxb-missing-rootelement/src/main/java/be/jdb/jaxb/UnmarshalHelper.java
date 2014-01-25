package be.jdb.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.jdb.jaxb.model.Car;

public class UnmarshalHelper {

	private static final Logger logger = LoggerFactory
			.getLogger(UnmarshalHelper.class);

	public static Car UnmarshalError(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		Car car = (Car) jaxbUnmarshaller.unmarshal(file);

		logger.info(car.toString());
		return car;
	}

	public static Car Unmarshal(File file) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Car.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		JAXBElement<Car> root = jaxbUnmarshaller.unmarshal(new StreamSource(
				file), Car.class);
		Car car = root.getValue();

		logger.info(car.toString());
		return car;
	}
}
