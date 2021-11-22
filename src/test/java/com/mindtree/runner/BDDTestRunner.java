package com.mindtree.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//@RunWith(Cucumber.class)
@CucumberOptions(features ="features",
//dryRun = true,
glue = {"com.mindtree.stepDefinations"})
public class BDDTestRunner extends AbstractTestNGCucumberTests {
	
}
