Feature: HomeDecor Gift Automate
@HomeDecor
Scenario Outline: Add HomeDecor Gift to Cart
	Given Open  Website with URL 
	Then Click on HomeDecor Gift section
	And  Click on "<item>" in HomeDecor result
	And  select "<Quantity>" of HomeDecor gift 
	Then Click on Add to Cart Button For HomeDecor Gift
	And  If cart page is Displayed for For HomeDecor Gift Close it
	
Examples:
|item                       |Quantity|
|3D Jewellery Holder Palette|3|