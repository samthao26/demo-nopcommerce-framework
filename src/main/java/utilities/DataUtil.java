package utilities;

import com.github.javafaker.Faker;

public class DataUtil {
	private Faker faker;
	
	public static DataUtil getData() {
		return new DataUtil();
	}
	
	public DataUtil() {
		faker = new Faker();
	}
	
	public String getFirstName() {
		return faker.name().firstName();
	}
	
	public String getLastName() {
		return faker.name().lastName();
	}
	public String getEditFirstName() {
		return faker.name().firstName();
	}
	public String getEditLastName() {
		return faker.name().lastName();
	}
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	public String getEditEmailAddress() {
		return faker.internet().emailAddress();
	}
	public String getCompanyName() {
		return faker.company().name();
	}
	public String getEditCompanyName() {
		return faker.company().name();
	}
	public String getCityName() {
		return faker.address().city();
	}
	public String getFristAddress() {
		return faker.address().streetAddress();
	}
	public String getSecondAddress() {
		return faker.address().streetAddress();
	}
	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
	
	public String getZipCode() {
		return faker.address().zipCode();
	}
	public String getFaxNumber() {
		return faker.phoneNumber().cellPhone();
	}
	public String getPassword() {
		return faker.internet().password();
	}
	public String getEditPassword() {
		return faker.internet().password();
	}
	
	
	

}
