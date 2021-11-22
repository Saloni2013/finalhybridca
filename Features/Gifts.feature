Feature: Gift DropDown Automate
@Gifts
Scenario Outline: Add Gift to Cart
	Given Open Website URL for Gifts
	Then  Hover on  Gift drop down section 
	And   Select "<type>" from dropdown from gifts menu
	And   select "<product>" of your choice from dropdown Menu result
	Then  Select "<quantity>" and add to cart for gift
	And   If cart page is Displayed Close it from gift page
	
Examples:
|type| product|quantity|
|Gifts for Kids|Panda Wooden LED Lamp|3|