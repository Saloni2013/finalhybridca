package com.mindtree.stepDefinations;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.exceptions.ReusableComponentException;
import com.mindtree.exceptions.UtilityException;

import com.mindtree.pageObject.BirthdayGifts;
import com.mindtree.reusableComponent.Base;
import com.mindtree.utilities.ExtentLogUtilities;
import com.mindtree.utilities.GetProperties;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class BithdayGiftStepDef extends Base {
	public WebDriver driver=null;
	BirthdayGifts bdgifts=null;
	public BithdayGiftStepDef() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	@Before("@BirthdayGifts")
	public void init() throws Exception
	{
		log = Logger.getLogger(BithdayGiftStepDef.class.getName());
		test = report.startTest("Birthday Gift");
		driver=initialize();
		System.out.println("All of it");
		bdgifts=new BirthdayGifts(driver, log, test);
	}
	@Given("Open Website URl for Birthday gifts")
	public void open_website_u_rl_for_birthday_gifts()throws Exception {
		driver.get(GetProperties.get.getProperty("url"));
		driver.manage().window().maximize();
		ExtentLogUtilities.pass(driver, test, "URL Opened", log);
	}

	@Then("Hover on  Birthday gifts drop down section")
	public void hover_on_birthday_gifts_drop_down_section() {
		bdgifts.hoverMenu();
	}

	@Then("Select {string} from dropdown from Birthday gifts menu")
	public void select_from_dropdown_from_birthday_gifts_menu(String menu) throws ReusableComponentException, Exception {
	    bdgifts.clickMenu(menu);
	}

	@Then("select {string} of your choice from dropdown Menu result for Birthday gifts")
	public void select_of_your_choice_from_dropdown_menu_result_for_birthday_gifts(String items) throws ReusableComponentException, Exception {
	   bdgifts.clickItem(items);
	}

	@Then("Select {string} and add to cart for Birthday gifts gift")
	public void select_and_add_to_cart_for_birthday_gifts_gift(String qunt) throws Exception {
	    bdgifts.setQuantity(qunt);
	    bdgifts.clickAddToCart();
	}

	@Then("If cart page is Displayed Close it from Birthday gifts gift page")
	public void if_cart_page_is_displayed_close_it_from_birthday_gifts_gift_page()throws Exception {
	    bdgifts.handelCart();
	}
	@After("@BirthdayGifts")
	public void setReport()
	{
		report.endTest(test);
		report.flush();
		driver.quit();
	}
}
