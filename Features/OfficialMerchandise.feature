Feature: Official Merchandise DropDown Automate
@OfficeMerchandise
Scenario Outline: Add Official Merchandise Gift to Cart
	Given Open Website URL for Official Merchandise
	Then  Hover on  Official Merchandise drop down section 
	And   Select "<type>" from dropdown from Official Merchandise menu
	And   select "<product>" of your choice from dropdown Menu result for Official Merchandise
	Then  Select "<quantity>" and add to cart for Official Merchandise gift
	And   If cart page is Displayed Close it from Official Merchandise gift page
	
Examples:
|type| product|quantity|
|Official DC Merchandise|Bat Signal LED Lamp - Batman|3|