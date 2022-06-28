package saucelabsconnection;



public class SaucelabsConnection {
	
	    public	String sauceUserName = System.getenv("SAUCE_USERNAME");
		public String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
		public String sauceURL = "https://ondemand.us-west-1.saucelabs.com:443/wd/hub";
		
 }
