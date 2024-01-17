package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	public Logger logger; // for logs
	
	@BeforeClass
	public void setup() {
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
				logger= LogManager.getLogger(this.getClass());
				
				logger.debug("debugging.....");
	}
	
	@Test(priority=1)
	public void testPostUser() {
		logger.info("********** Creating user  ***************");
		Response res=UserEndPoints.createUser(userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("**********User is created  ***************");
	}
	
	@Test(priority=2)
	public void testGetUser() {
		logger.info("********** Reading User Info ***************");
		Response res=UserEndPoints.readUser(this.userPayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("**********User info  is displayed ***************");
	}
	
	@Test(priority=3)
	public void testPutUser() {
		logger.info("********** Updating User ***************");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("********** User updated ***************"); 	
		
		//checking data after update
		Response resAfterUpdate=UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(resAfterUpdate.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		logger.info("**********   Deleting User  ***************");
		Response res=UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
		logger.info("********** User deleted ***************");
	}
	
}
