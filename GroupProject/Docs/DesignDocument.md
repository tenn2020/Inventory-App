# Design Document

**Author**: \<Tenzin Norsang, Alejandra Reyes, Abdul Wahab\>


## 1 Design Considerations

### 1.1 Assumptions

The software depends on user input and on managing the database to perform CRUD. The major project issue we are facing right now is how we are going to implement our UML design to functional code in a way that meets the requirements. We are also concerned with how we are going to implement the database into our system since we are uncertain about how our data will be stored.

### 1.2 Constraints

The main constraint on the system that has a significant impact on the design of the system is storing data in a hierarchical structure. The requirement asked for data to be stored and retrieved in a specific way. This impacts how we perform CRUD on the database. We have to store the data in key, value pairs in a way that it will be stored in a hierarchical structure. 

### 1.3 System Environment

The software runs on an Android Studio environment; hence, we are targeting the software to run on all Android operating system apps with API level 21 and above. 

## 2 Architectural Design

### 2.1 Component Diagram

![](images/component-diagram.png)

The component diagram closely follows the structure of the class diagram. This diagram provides information about the dependencies between components. For example, the lollipop between the Store Offerings and FloorDB components indicates that Store Offerings provides the interface required by the FloorDB, since a store offering object will contain a list of floors that will need to be added to the database. Similarly, the User component provides an Employee or User object which the Store Offerings requires, because there must be an employee who is able to edit the products list, and there must be a user who is requesting to view the store offerings. 

### 2.2 Deployment Diagram

![](images/deployment-diagram.png)

The deployment diagram shows how the components will be deployed on a mobile device. The application will be deployed on an Android Device, and the components within the application are part of the FloorIconManager Application. The database is stored locally within the android device.

## 3 Low-Level Design

### 3.1 Class Diagram

![](images/design-team.png)

### 3.2 Other Diagrams

*Describe some dynamic aspects of your system using one or more behavioral diagrams, such as sequence and state diagrams.*

![](images/state-diagram.png)

The state diagram shows how the system transitions between various states. This state diagram accounts for user login, view, search, and employee add/edit/delete. Update Store Offering is a composite state that exits when both the store offering is changed, and the database is updated. This ensures that the database is synchronized with the store offerings. Search, view and add/edit/delete loop back to view all products. The exit condition is that the user must exit the application. This diagram also accounts for viewing a detailed product description through the view product details class.

## 4 User Interface Design

![](images/gui-mock.png)





