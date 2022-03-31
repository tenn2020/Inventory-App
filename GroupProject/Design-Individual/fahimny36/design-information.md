#Assignment5

1.	As a user of the system I want to be able to see each store's offering and the amount of product in stock by square feet.
--This was implemented by creating a class called Stores which has the following methods respectively named to allow the user to see each store’s offering, amount of product in squarefeet, and select the floor’s category 
1.	SearchStoresOffering(ProductCategories) 
2.	SearchStoresStock(SquareFeet) 
3.	SelectFloorCategory()
2.	The application must allow employees to add new products to the system. As well as
delete and edit them.
--This was implemented by creating following methods in a class called FloorType which has the following methods respectively, this class allows the employee to add, edit and delete the new floor in the database.
1.	createFloorType(floorMaterial, FloorCharacteristics)
2.	addNewProduct() 
3.	EditProduct() 
4.	DeleteProduct()
3.	The different categories of floors available are tile, stone, wood, laminate and vinyl
--This was implemented by creating following methods in a class called FloorCategories which has the following methods respectively, based upon the material type of the floor the system specifies the floors into different types.
1.	createFloorCategory(FloorType) 
2.	SelectFloorType() 
3.	AddFloorType()
4.	The application must contain a database (DB) of floors.
--Implemented but not modeled as its not part of UML guidelines, a database of stores which supply the various categories of floors.

5.	Users must be able to search for products by picking from a hierarchical list, where the first level is the floor category, and the second level is the floor type.
--This was implemented by creating following methods in a class called FloorCategory, this method enables the user to select the specific product from the hierarchy. Method is given below.
SelectFloorType()
6.	Users must also be able to specify an item by typing its name (search functionality).
--This was implemented by creating following methods in a class called Floor, this method helps the user to search for the specific floor by its name. Method is given below.
1.	SearchFloor(byName)

7.	All floors regardless of their category have an associated color, size, brand, type and
Price
--This was implemented by creating following attributes in a class called FloorType.
1.	FloorColor: String
2.	FloorSize: Float 
3.	Type: String 
4.	Price: float
8.	Categories tile and stone have different materials they are made of, e.g. Tile - porcelain,ceramic, resin; Stone - marble, pebble, slate
--This was implemented by creating following attribute in a class called Floor, which specify the various characteristics elements of the floor other than their material.

floorMakeUpSubctance: string
9.	Wood floors have both a type (solid, engineered, bamboo, etc) and species (oak,
hickory, maple, etc.)
--This was implemented by creating following attributes in a class called Floor
FloorSpecie: string
10.	Laminate can be regular laminate or water resistant, whereas vinyl can be water
resistant or waterproof
--This was implemented by creating following attributes in a class called Floor, these are bool attributes which specify that whether a certain floor type is water resistant or waterproof.
isWaterResistant: bool
 isWaterProof: bool
11.	The User Interface (UI) must be intuitive and responsive.
--Not displayed or modeled in the UML as its a UI element however the goal is to adhere to the simplicity and structure of the Material Design guidelines.

