As a user of the system I want to be able to see each store's offering and the amount of product in stock by square feet.
- This requirement was implemented by creating a ProductsView class that contains instock boolean attribute, which gives yes or no. It also contain methods searchProducts(), searchProductsByName(), and searchProductsInStock(). The searchProducts() method searches for products without taking inputs. The searchProductsByName() method takes an input of productName and returns the string. The searchProductsInStock() method searches for products that are in the stock, this is only achieved if the boolean attribute instock is set to yes. If it is set to No, then the product is not in Stock.

The application must allow employees to add new products to the system. As well as delete and edit them.
- This requirement was implemented by creating a Products class that contains productName string attribute. It also contain methods addProducts(), editProducts(), deleteProducts(). These three methods allows employees to add new products to the system.

The different categories of floors available are tile, stone, wood, laminate and vinyl
- This requirement was implemented by creating a FloorCategory class that contains floorCategory string attribute. It also contain a method setFloorCategory() that assigns a name or sets the Floor Category.

The application must contain a database (DB) of floors.
- The whole thing is the database of Floors. We cannot implemented database in UML diagram.

Users must be able to search for products by picking from a hierarchical list, where the first level is the floor category, and the second level is the floor type.
- This requirement was implemented by creating FloorCategory class and FloorType class. Floor Category inherits the Floor class and Floor class inherits Products class. Floor Category contains all the attributes and methods of the Products class and Floor class. User can search for products by going through the ProductsView class which will take it to Floor Category then to Floor Type or Floor Species.

Users must also be able to specify an item by typing its name (search functionality).
- This requirement was implemented by creating a searchByName(productName) method in the ProductsView class. This method takes in an input of productName and searches for that productName in the Products class.

All floors regardless of their category have an associated color, size, brand, type and price
- This requirement was implemented by creating a Floor clas that contains all these attributes: color, size, brand, type, price. It also contains methods to set those attributes, such as setColor(), setSize(), and so on.

Categories tile and stone have different materials they are made of, e.g. Tile - porcelain, ceramic, resin; Stone - marble, pebble, slate
- This requirement was implemented by creating FloorTypes class that has attribute of this floor material called floorType. It also contain methods to add, edit, delete the floor types. The Floor Type class is an aggregated relationship of Floor Category class because it can exist without Floor Category.

Wood floors have both a type (solid, engineered, bamboo, etc) and species (oak, hickory, maple, etc.)
- This requirement was implemented by creating a FloorType and FloorSpecies classes. FloorSpecies class has an attribute floorSpecies. It also contain methods to add, edit, delete the floorSpecies. FloorSpecies class is an aggregated relationship to FloorCategory because it can exist without Floor Category.

Laminate can be regular laminate or water resistant, whereas vinyl can be water resistant or waterproof
- This requirement was implemented by creating the FloorType class. The floorType class includes these properties of floorCategory.

The User Interface (UI) must be intuitive and responsive.
- Cannot implement UI with UML diagram.