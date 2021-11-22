Feature: All of it Gift Automate
@AllOfIt
Scenario Outline: Add  All of it  Gift to Cart
	Given Open  Website with URl  All of it  
	Then Click on  All of it  Gift section
	And  Click on "<item>" in  All of it  result
	And  select "<Quantity>" of  All of it  gift 
	Then Click on Add to Cart Button For  All of it  Gift
	And  If cart page is Displayed for For  All of it  Gift Close it
	
Examples:
     |item                       |Quantity|
|Astronaut Mobile Stand|2|