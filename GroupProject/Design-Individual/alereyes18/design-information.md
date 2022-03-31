##### Alejandra Reyes

##### CS370 Assignment 5 : Design Document

1. **As a user of the system I want to be able to see each store's offering and the amount of product in stock by square feet.**

  The User class represents a user of the system. Assume there is a username to identify the user. The User class includes two search functions, one to search by product name, and one to search by category and type. The search functions return 0 or more instances of Floors, depending on which floors a certain store has in stock, or which stores have a certain floor in stock

2. **The application must allow employees to add new products to the system. As well as delete and edit them.**

  The Employee class represents a single employee. Each Employee has functions to add a floor and quantity, edit a floor to change the quantity, and remove a floor and all quantities.

3. **The different categories of floors available are tile, stone, wood, laminate and vinyl**

   The superclass Floor will include attributes for the category of the floor.

4. **The application must contain a database (DB) of floors.**

   The AllFloors class stores an array list of Floors. This class will use a hashtable to store the name of a product as the key and the Floor object as a value. Using this database we can get a floor object by name, and also add a new floor to the database.

5. **Users must be able to search for products by picking from a hierarchical list, where the**
  **first level is the floor category, and the second level is the floor type.**

  The User class includes a method search(category, type) that searches all offerings, and returns a list of offerings that include the floor being searched for. If this function is true, 

6. **Users must also be able to specify an item by typing its name (search functionality).**

   The User class includes a method search(productName) that searches all offerings, and returns a list of offerings that include the floor being searched for.

7. **All floors regardless of their category have an associated color, size, brand, type and price**

  The Floor class has attributes for the name of the product, the category, color, brand, type, species (null if not wood category), price, width, height, and a method to calculate the size in sqft, and an attribute to store the size.

8. **Categories tile and stone have different materials they are made of, e.g. Tile - porcelain, ceramic, resin; Stone - marble, pebble, slate**

  The Floor class has a material attribute which would be null unless the floor category is tile or stone.

9. **Wood floors have both a type (solid, engineered, bamboo, etc) and species (oak,**
  **hickory, maple, etc.)**

  The Floor class has a type, and species attribute which would be null unless the floor category is wood.

10. **Laminate can be regular laminate or water resistant, whereas vinyl can be water**
    **resistant or waterproof**

    The Floor category has a type which for laminate and vinyl could be water-resistant, waterproof, or null.

11. **The User Interface (UI) must be intuitive and responsive.**

    The User Interface design is concerned with the front-end of the system, but for now we are focusing on what the system will do, and how.