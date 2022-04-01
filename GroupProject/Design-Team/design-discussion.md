### CSCI 370-57 D1: Design Information

#### Design 1: Fahim

![Fahim's Design](/design-images/fahimny36.png)







###### Pros

* The classes had proper methods as described in the requirements. 
* The inclusion of a database for stores could allow us to track inventory for individual stores as well as the entire chain.

###### Cons

* No implementation for users of the system, including employees.
* The use of Floor in a majority of the classes causes confusion regarding the purpose of the classes.

#### Design 2: Marwan

![Marwan's Design](/design-images/MarwanAljawarneh.png)

###### Pros

* The essential classes include multiplicities which allow us to understand how many instances of one class can be linked to one instance of another.
* All essential classes, User, Employee, Store, Floor, FloorCategory were included.

###### Cons

* The use of subclasses for each floor type adds 5 additional classes that need to be defined. This could potentially be reduced so there are less classes to manage. 
* The search method in the Store class should be part of the User class because Search is an action performed by the user.

#### Design 3: Alejandra

![Alejandra's Design](/design-images/alereyes18.png)

###### Pros

* The inclusion of a Results class could allow us to instantiate an object that contains all of the information that would be necessary for the user to see when returning search results.
* Attribute types and method return types are included.

###### Cons

* Employee could be a subclass of User, and the Employee would inherit the search methods in User, but also have additional methods to edit, add, or delete products from a store's offerings.
* Misuse of relationship arrows. For instance, Result cannot exist without an instance of Search, but the arrow implies that Search cannot exist without an instance of Result.

#### Design 4: Abdul

![Abdul's Design](/design-images/wahab65.png)

###### Pros

* All essential classes, and a database of Floors are included in the design.
* Annotations are included, which makes it easier to read the diagram. For example, teh relationship between Employees and Store could be read as "Employee adds and deletes Products from Store".

###### Cons

* Misuse of relationship arrows.
* The database is accessed by the Floor and Store classes, but we could potentially restructure the design to minimize the amount of times the database is accessed.

#### Design 5: Tenzin

![Tenzin's Design](/design-images/flushingkbbq.png)

###### Pros

* Employee is a subclass of User
* Appropriate usage of relationship arrows between classes, which clearly defines how the classes interact with each other.

###### Cons

* Some methods are misplaced, the search methods in ProductView should be a part of the User class, and the edit product methods in Products should be under the Employees class.
* Products and ProductsView could be merged into a single floor class. If the methods within those classes were moved to the appropriate class, then the need for a Products and ProductsView class becomes unnecessary. 

#### Team Design

![Team Design](/design-images/design-team.png)

###### Commonalities 

*What the individual designs had in common*

* All designs have the essential classes such as User, Store/Product, and Floor.
* All designs have relationship arrows that indicate how the classes interact with each other.
* All designs implemented a majority of the requirements.

###### Differences

*What was different across the individual designs*

* Some designs included a database, FloorType, and FloorSpecies classes.
* Some designs included the multiplicities between classes.
* Some designs included an annotation for the relationship between classes. 
* Every design has different relationships between classes, and some were misused.
* Some designs included the visibility for attributes and methods of a class.

######  Design Decisions

*After the discussion, the design decisions we implemented in the team design*

* Attributes and classes have the appropriate visibility symbols. We used private attributes and public methods.
* We decided on the appropriate relationship arrows between two classes according to how they would be used in the application. Our design includes association, generalization, composition, and aggregation relationships.
* We added annotations to the relationships so it would be clear how the classes interact.
* We included multiplicities between classes. 
* We added a ChainManager class that can search and edit offerings across all stores. 
* We made the Floor class an abstraction so that FloorCategory can inherit all the Floor class attributes and methods.

#### Summary

*Lessons learned throughout the design process*

The design discussion process taught us how to communicate effectively and critique each others work productively. We were able to utilize our collective knowledge and understanding of the requirements to reach an agreement on how the final design should look. We also became more comfortable using Git to collaborate on the project. A key takeaway was the importance of creating a UML diagram before beginning the programming. Since we have agreed on a class diagram, each team member has a clear understanding of how different parts of the application will be programmed. This will allow us to divide the work between members while working towards a functioning application that meets all of the requirements.