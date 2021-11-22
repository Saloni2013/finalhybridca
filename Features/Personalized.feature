Feature: Personalized Gift Automate
@Personalized
Scenario Outline: Add Personalized Gift to Cart
	Given Open  Website URL for personalized gifts
	Then Click on Peronalized Gift section
	And  Click on desired "<item>"
	And  select "<Quantity>" and add "<customised Name>"
	Then Click on Add to Cart Button in personalized gift cart
	And  If cart page is Displayed Close it after personalized gift
	
Examples:
|item|Quantity|customised Name|
|Personalized Metallic Keychain I COD Not Available|3|Biren|