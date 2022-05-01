# Test Plan

**Author**: <Fahim Ahmed, Alejandra Reyes>

## 1 Testing Strategy

### 1.1 Overall strategy

Our testing strategy will include unit testing, integration testing, system testing, and acceptance testing. 

**Unit Testing**: We will individually test the methods within the application and verify that they function as intended by comparing the actual results to the expected results. We will individually test the following methods: 

1.Add product

​	Check if it is added

2.Delete product

​	Check if it is deleted

3.Edit product

​	Check if it is edited

4.Search product

​	Check if it searches for the products

5.Search category

​	Check if it searches for the category

6.Search Type

​	Check if it searches for the Type

7.Search stock

​	Check if it searches for the stock

8.Add store offering

​	Check if it can add store offering

9.Search store offering

​	Check if it searches for the store offerings

10.Remove store offering

​	Check if it can remove store offerings

11.Edit store offering

​	Check if it edits store offerings

12.Get floor Type

​	Check if it returns the type of the floor

13.In stock

​	Check if it is in stock



**Integration Testing**: Once we have an initial version of the application, we will revise the test plan to include integration tests. For example, we will have a test for the log in process for a customer.

**System Testing:** Once we have an initial version of the application, we will revise the test plan to include system testing. During this phase of testing, we will check if the application compiles without errors, as well as find and document defects in the system, and monitor the performance of the application

**Acceptance Testing:** During this phase of the test plan, we will ensure that the application meets all of the requirements, and functions properly.

### 1.2 Test Selection

**Black-box Testing**: The black-box tests will allow us to examine the application by checking if the actual and expected output match, given valid and invalid inputs. We will identify flaws, fix them, and retest.

**White-box Testing**: The white-box tests will allow us to examine the internal structure of the application. During these tests, we will be observing the actual code as we run inputs through various modules. 

### 1.3 Adequacy Criterion

To assess the quality of the test cases, we will assess the results of functional and structural test cases. For functional coverage, we will use unit testing to ensure that each component functions as intended. For structural coverage, we will use system testing to see how the application performs when given invalid inputs or stress (for example, repeatedly pressing the search button). We will also perform a variety of activities, such as adding multiple floors in succession, and searching for different floors and see if the application responds correctly.

### 1.4 Bug Tracking

When performing unit tests, we will document methods that result in errors, and log the result of the test case, as well as how the error can be replicated. When performing integration tests, if a test results in an error, we will individually test the group components with the same input to identify which module is causing the error. All bugs encountered will be recorded in a text file, with steps to replicate it, and the bug fix. 

### 1.5 Technology

As a team we will be testing the app manually where we check each function and mention each result in the chart below. By doing this we determine if each function passed our expected result or not. 

### 2 Test Cases




| ***User Type*** |          ***Test Description***          | ***Test Case ID*** |                 ***Test Case Description***                  |                     ***Pre-condition***                      |                       ***Test data***                        |        ***Post-condition***        |                    ***Expected Result***                     |                     ***Actual Result***                      | ***Status*** |
| :-------------: | :--------------------------------------: | :----------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :--------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: | :----------: |
|   *Employee*    |              *Add product*               |      *000001*      | *We will add a new product and check whether it is added or not* | *Select floor category, floor type, floor color and Enter Quantity* |                  *Wood, solid, Oak, red,2*                   |         *Press Add button*         |             *Product will be added in the list*              |                *Product is added in the list*                |    *Pass*    |
|   *Employee*    |              *Add product*               |      *000002*      | *We will add a new product and check whether it is added or not* | *Select floor category, floor type, floor color and Enter Quantity* |                  *Tile, Porcelain, brown,4*                  |         *Press Add button*         |             *Product will be added in the list*              |                *Product is added in the list*                |    *Pass*    |
|   *Employee*    |              *Add product*               |      *000003*      | *We will add a new product and check whether it is added or not* | *Select floor category, floor type, floor color and Enter Quantity* |                    *Stone, Slate, Blue,7*                    |       *Press Delete Button*        |             *Product will be added in the list*              |                *Product is added in the list*                |    *Pass*    |
|   *Employee*    |              *Add product*               |      *000004*      | *We will add a new product and check whether it is added or not* | *Select floor category, floor type, floor color and Enter Quantity* |               *Vinyl, Wateresistant, White,8*                |         *Press Add Button*         |             *Product will be added in the list*              |                *Product is added in the list*                |    *Pass*    |
|   *Employee*    |              *Add Product*               |      *000005*      |   *We will try to add product without selecting the Color*   |                *Add product screen must open*                |                       *Unselect Color*                       |       *Press the Add button*       |    *App will show message “Please Select a valid Color”*     |     *App  showed message “Please Select a valid Color”*      |    *Pass*    |
|   *Employee*    |              *Delete Floor*              |      *000006*      |       *We will try to delete the floor from the list*        |                 *Flooring Details must open*                 |                  *Enter the Delete Button*                   |     *Enter the Delete Button*      |        *Floor will be deleted from the flooring list*        |          *Floor is deleted from the flooring list*           |    *Pass*    |
|   *Employee*    |               *Edit Floor*               |      *000007*      |      *We will try to edit floor once we added a floor*       |        *Flooring Details must open with edit button*         | *Change floor category,type,species,color and quantity by valid input* |     *Enter the update button*      |        *Floor details will be updated as it changed*         |           *Floor details is updated as it chnaged*           |    *Pass*    |
|   *Employee*    |          *Back button checking*          |      *000008*      |  *We will test if the back button working properly or not*   |                *Click on the employee button*                |                      *Select any floor*                      |     *Click on the back button*     |          *The list of all product will show again*           |             *The list of all products is showed*             |    *Pass*    |
|   *Employee*    |           *Search by category*           |      *000009*      | *We will test the search function by category whether it give us right result or not* |           *Enter the floor category in search bar*           |                            *Wood*                            |       *Press Search button*        | *It will give us list of flooring related to the category entered* |  *It gave list of flooring related to the category entered*  |    *Pass*    |
|   *Employee*    |       *Search by applying filter*        |     *0000010*      | *We will test the search function by selecting category and its type whether it give us right result or not* |                *Select the category and type*                |                        *Tile, Resin*                         |       *Press Submit button*        | *It will give us list of flooring related to the category and type* | *It gave list of flooring related to the category and type*  |    *Pass*    |
|  ` `*Employee*  |         *Flooring Serial Number*         |     *0000011*      | *Check flooring serial number updated or not after deleting the floor from list* |                        *Delete Floor*                        |                        *Delete floor*                        |       *Press Delete button*        |        *Flooring list serial number must be updated*         |           *Flooring list serial number is updated*           |    *Pass*    |
|   *Employee*    |         *Search Store Offerings*         |     *0000012*      |            *check the store offering by integer*             |                       *Enter integer*                        |                             *22*                             |       *press search button*        |                *Nothing supposed to show up*                 |                     *Nothing showed up*                      |    *Pass*    |
|   *Employee*    |        *Quantity text field test*        |     *0000013*      | *We will test Quantity text field in add product screen will input greater than 100* |                *Add Product Screen must open*                |                            *101*                             |       *Enter the add button*       | *App will show message “Please Enter a Quantity between 1 and 100”* | *App showed message “Please Enter a Quantity between 1 and 100”* |  ` `*Pass*   |
|   *Employee*    |              *Add Product*               |     *0000014*      | *We will try to add product without selecting the Category*  |                *Add product screen must open*                |                     *Unselect Category*                      |       *Press the Add button*       |   *App will show message “Please Select a valid category”*   |    *App  showed message “Please Select a valid category”*    |    *Pass*    |
|   *Employee*    |              *Add Product*               |     *0000015*      |   *We will try to add product without selecting the Type*    |                *Add product screen must open*                |                       *Unselect type*                        |       *Press the Add button*       |     *App will show message “Please Select a valid Type”*     |      *App  showed message “Please Select a valid Type”*      |    *Pass*    |
|   *Employee*    |              *Add Product*               |     *0000016*      |  *We will try to add product without selecting the Species*  |                *Add product screen must open*                |                      *Unselect Species*                      |       *Press the Add button*       |   *App will show message “Please Select a valid Species”*    |     *App showed message “Please Select a valid Species”*     |    *Pass*    |
|   *Employee*    |        *Quantity text field test*        |     *0000017*      | *We will test Quantity text field in add product screen with input less than 1* |                *Add Product Screen must open*                |                             *-1*                             |       *Enter the add button*       | *App will show message “Please Enter a Quantity between 1 and 100”* | *App showed message “Please Enter a Quantity between 1 and 100”* |    *Pass*    |
|   *Employee*    |              *Add product*               |     *0000018*      | *We will add a new product and check whether it is added or not* | *Select floor category, floor type and floor color, Enter Quantity* |                 *Laminate, Regular, Beige,9*                 |         *Press Add Button*         |             *Product will be added in the list*              |                *Product is added in the list*                |    *Pass*    |
|   *Employee*    | *Employee Button Testing on Home Screen* |     *0000019*      |      *User will access the application as an Employee*       |              *Application is in running state*               |                 *Enter the customer button*                  |    *Enter the customer button*     | *Application’s Flooring Managing Screen will appear as a customer* | *Application’s Flooring Managing Screen appeared as a customer* |    *Pass*    |
|   *Employee*    |             *Add a product*              |     *0000020*      | *We will add a product and check if it shows the details before adding it* | *Select floor category, floor type, floor color and Enter Quantity* |                    *Stone, Slate, Blue,7*                    |         *Press Add button*         | *A pop up will come asking confirmation as “Are you sure you want to add this floor?”* |  *Popped up as “Are you sure you want to add this floor?”*   |    *Pass*    |
|   *Customer*    |        *Customer Button Testing*         |     *0000021*      |       *User will access the application as a customer*       |              *Application is in running state*               |                 *Enter the customer button*                  |    *Enter the customer button*     | *Application’s Flooring Managing Screen will appear as a customer* | *Application’s Flooring Managing Screen appeared as a customer* |    *Pass*    |
|   *Customer*    |           *Search by category*           |     *0000022*      | *We will test the search function by category whether it give us right result or not* |           *Enter the floor category in search bar*           |                            *Wood*                            |       *Press Search button*        | *It will give us list of flooring related to the category entered* |  *It gave list of flooring related to the category entered*  |    *Pass*    |
|   *Customer*    |       *Search by applying filter*        |     *0000023*      | *We will test the search function by selecting category and its type  whether it give us right result or not* |                *Select the category and type*                |                      *Tile, Porcelain*                       |       *Press Submit button*        | *It will give us list of flooring related to the category and type* | *It gave list of flooring related to the category and type*  |    *Pass*    |
|   *Customer*    |             *Search Product*             |     *0000024*      | *We will test the search function by product whether it give us right result or not* |          *Enter the product name in the search bar*          |                           *11111*                            |       *Press Search button*        |                 *It will show No data found*                 |                  *It showed No data found*                   |    *Pass*    |
|   *Customer*    |     <p>*Customer page* description*      |     *0000025*      | *We will test if a customer can edit the product details or not* |                *Click on a existing Product*                 |              *Check for edit and delete button*              | *Check for edit and delete button* |         *There will be no option as edit or delete*          |           *There is no option for edit and delete*           |    *Pass*    |
|   *Customer*    |          *Back button checking*          |     *0000026*      |  *We will test if the back button working properly or not*   |                *Click on the customer button*                |                      *Select any floor*                      |     *Click on the back button*     |          *The list of all product will show again*           |                                                              |              |

