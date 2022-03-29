
1.	As a user of the system I want to be able to see each store's offering and the amount of product in stock by square feet.
To realize this requirement, I created a Store class which has a few methods and attributes. There are two attributes, one is called getOfferings which would store the products that the store offers. Another attribute is productQuantiy which would store the quantity of each product in the store. To return the offerings and quantity I created a method which returns the offerings and another method which returns the quantity.

2.	The application must allow employees to add new products to the system. As well as delete and edit them.
In the same class as the previous one, I will implement three methods. One method would be called addProduct which adds the product, one called deleteProduct which would delete a product and one called editProduct which would edit the product. By edit a product, the method could edit the quantity number of the product. 

3.	The different categories of floors available are tile, stone, wood, laminate and vinyl. 
To realize this requirement, I created a class called floorCategories which has the types of floor in it. This class lets is connected to the Floor class.

4.	The application must contain a database (DB) of floors. 
To realize this requirement, I made a database called inventoryDB that has the information for each of the product. The database contains the product information and the quantity of each product. This DB is a cloud-based database with CRUD principles to allow persistent storage and save features for users. I did not model the DB due to said guidelines in the Assignment.

5.	Users must be able to search for products by picking from a hierarchical list, where the first level is the floor category, and the second level is the floor type. 
To realize this requirement, I made a User class that first selects as product category using the selectFloorCategory method. Once it has selected the floor category it then selects the type for that specific category. For that I have made a selectFloorType method.

6.	Users must also be able to specify an item by typing its name (search functionality). 
To realize this requirement, I have created a method called searchProduct which takes in a product parameter in the User class. The User can search for that product and see its information.

7.	All floors regardless of their category have an associated color, size, brand, type and price 
To realize this requirement, I have created a class called Floor. This class stores the basic information such as color, size, brand, type and price as parameters. When a user selects a floor, all of this information is just parsed from the database.

8.	Categories tile and stone have different materials they are made of, e.g. Tile - porcelain, ceramic, resin; Stone - marble, pebble, slate 
I have made additional attributes in the Floor class. One of them is materials. When a user selects tile or stone and the selects the type, this information is parsed in the floor class from our inventoryDB. I also made additional class for the Floortype so that it can return value to floor class

9.	Wood floors have both a type (solid, engineered, bamboo, etc) and species (oak, hickory, maple, etc.) 
Type and species are additional attributes I have included in the floor class. Type is initially initialized as Null but once the User selects the category, different types of that category can be selected. Once it is selected, it adds the type to the floor class. Then same thing happens for the species. Once the type is selected, the species will also appear. I have also made a species class returns the species to floor class.

10.	Laminate can be regular laminate or water resistant, whereas vinyl can be water resistant or waterproof 
I have added these attributes to the Floor class and have made them a Boolean. When the User selects Laminate or Vinyl, it can also select water resistant, water proof or regular laminate.

11.	The User Interface (UI) must be intuitive and responsive.
Since the UML diagram does not model for UI/UX elements this has not been specified in the diagram. However, the end goal of the Reminders app would be to include a simple, intuitive, and responsive UI/UX that would fulfill requirements and exceed expectations of a beautiful, intuitive and responsive UI.

