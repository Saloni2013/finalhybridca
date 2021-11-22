Feature: Home And Lifestyle DropDown Automate
@HomeAndLifestyle
Scenario Outline: Add Birthday gifts Gift to Cart
	Given Open Website URL for Home And Lifestyle
	Then  Hover on  Home And Lifestyle drop down section 
	And   Select "<type>" from dropdown from Home And Lifestyle menu
	And   select "<product>" of your choice from dropdown Menu result for Home And Lifestyle
	Then  Select "<quantity>" and add to cart for Home And Lifestyle gift
	And   If cart page is Displayed Close it from Home And Lifestyle gift page
	
Examples:
 |type| product|quantity|
 |Water Bottles|Bigsmall Water Bottle|3|