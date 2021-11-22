package com.mindtree.stepDefinations;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.PageObjectException;
import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.exceptions.UtilityException;
import com.mindtree.pageObject.HomePageLogIn;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class HomePageLoginStepDef extends Base{
	WebDriver driver=null;
	HomePageLogIn hmlog=null;
	public HomePageLoginStepDef() throws UtilityException, Exception {
		super();
	}
	@Before("@HomePageLogin")
	public void init() throws Exception
	{
		log = Logger.getLogger(HomePageLoginStepDef.class.getName());
		test = report.startTest("Log in");
		driver=initialize();
		System.out.println("Home Decor");
		hmlog=new HomePageLogIn(driver, log, test);
	}

	@Given("URl opened with URL for login")
	public void u_rl_opened_with_url_for_login() throws IOException {
			driver.get(GetProperties.get.getProperty("url"));
			driver.manage().window().maximize();
			ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	    }

    @Then("^Clicked one Sign in button$")
    public void clicked_one_sign_in_button() throws Exception{
       hmlog.clickLoginButton();
    }

    @Then("^Enter Valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enter_valid_something_and_something(String uname, String pwd ) throws Exception  {
        hmlog.loginForm(uname, pwd);
    }

    @Then("^user will redirect to my account page$")
    public void user_will_redirect_to_my_account_page() throws PageObjectException {
       hmlog.validate();
    }

    @And("^click one log in button$")
    public void click_one_log_in_button() throws ReusableComponentException, Exception  {
        hmlog.clickLoginButton();
    }
    @After("@HomePageLogin")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
