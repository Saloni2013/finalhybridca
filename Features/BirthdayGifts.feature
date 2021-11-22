Feature: Birthday gifts DropDown Automate
@BirthdayGifts
Scenario Outline: Add Birthday gifts Gift to Cart
	Given Open Website URl for Birthday gifts
	Then  Hover on  Birthday gifts drop down section 
	And   Select "<type>" from dropdown from Birthday gifts menu
	And   select "<product>" of your choice from dropdown Menu result for Birthday gifts
	Then  Select "<quantity>" and add to cart for Birthday gifts gift
	And   If cart page is Displayed Close it from Birthday gifts gift page
	
Examples:
 |type| product|quantity|
|18th Birthday Gifts|Unicorn Touch Silicone Lamp|3|