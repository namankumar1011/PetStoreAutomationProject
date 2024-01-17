package api.endpoints;

//swagger url = https://petstore.swagger.io/
//create user post = https://petstore.swagger.io/v2/user
//get user= https://petstore.swagger.io/v2/user/{username}
//put user = https://petstore.swagger.io/v2/user/{username}
//delete user= https://petstore.swagger.io/v2/user/{username}

public class Routes {
	public static String base_url="https://petstore.swagger.io/v2";
	//user module
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String put_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	//other modules
	//here we will have variables to different modules like pet, store, etc 
	
}
