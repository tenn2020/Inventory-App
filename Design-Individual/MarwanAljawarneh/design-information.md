1. As a user of the system I want to be able to see each store's offering and the amount of
   product in stock by square feet.

To realize this requiremnet I created a store class that contain two methods seeOffering() and amountOfProduct() that let the user see each store's offering and the amount of product in stock by square feet.

2. The application must allow employees to add new products to the system. As well as
   delete and edit them.

For this requiremnet I created a class called employee that has different kind of methods that let the employee add, edit and delete products.

3. The different categories of floors available are tile, stone, wood, laminate and vinyl.

A seprate class have been created for each type of floor listed in the requirement.

4. Users must be able to search for products by picking from a hierarchical list, where the
   first level is the floor category, and the second level is the floor type.

After calling seeOffering() in class Store, this gives the user options to choose from one of the categories. After selecting a specific category the user can select the type.

5. Users must also be able to specify an item by typing its name (search functionality).

After invokation the search method in the class Store, it will give the ability to the user to search by name.

6. All floors regardless of their category have an associated color, size, brand, type and
   price.

To realize this requirement I created a class called Floor that contain all of these five attributes (color, size, brand, type and prices) and connected each type of the floors to this class.

7. Categories tile and stone have different materials they are made of, e.g. Tile - porcelain,
   ceramic, resin; Stone - marble, pebble, slate

For tile and stone I created a class for each of them that contain a method which specify what type of materials have been used.

8. Wood floors have both a type (solid, engineered, bamboo, etc) and species (oak,
   hickory, maple, etc.)

This was implemented by creating a class for wood that contain both attributes type and species that specifies which one is going to be.

9. Laminate can be regular laminate or water resistant, whereas vinyl can be water
   resistant or waterproof.

To realize this requirement I created a class for each laminate and vinyl where i created a boolean method that lets you decide whether its a regular laminate or water resistant for the laimant floor. And for the vinyl floor if its water resistent or waterproof.

10. The User Interface (UI) must be intuitive and responsive.

Not considered because it does not affect the design directly.