Feature: WhatsNew Gift Automate
@WhatsNew
Scenario Outline: Add WhatsNew Gift to Cart
	Given Open Website URL for WhatsNew
	Then click on WhatsNew  Gift section
	And  Click on "<product>" from list of products shown for WhatsNew
	And  select "<quantity>" of product for WhatsNew item
	Then Click on Add to Cart Button for WhatsNew Operation
	And  If cart page is Displayed Close it for WhatsNew Page
	
Examples:
|product|quantity|
|Dice Keeper 3D Puzzle|3|