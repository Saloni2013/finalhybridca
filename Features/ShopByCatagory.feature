Feature: Shop By Catagory DropDown Automate
@ShopByCatagory
Scenario Outline: Add Shop By Catagory Gift to Cart
	Given Open Website URL for Shop By Catagory
	Then  Hover on  Shop By Catagory drop down section 
	And   Select "<type>" from dropdown from Shop By Catagory menu
	And   select "<product>" of your choice from dropdown Menu result for Shop By Catagory
	Then  Select "<quantity>" and add to cart for Shop By Catagory gift
	And   If cart page is Displayed Close it from Shop By Catagory gift page
	
Examples:
|type| product|quantity|
|3D Mugs|Golf Coffee Mug|3|