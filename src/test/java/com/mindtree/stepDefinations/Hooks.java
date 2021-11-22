package com.mindtree.stepDefinations;

import com.mindtree.exceptions.UtilityException;
import com.mindtree.reusableComponent.Base;
import io.cucumber.java.*;

public class Hooks extends Base{

	public Hooks() throws UtilityException, Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeAll
	public static void init() throws Exception
	{
		initializeReport();
	}

}
