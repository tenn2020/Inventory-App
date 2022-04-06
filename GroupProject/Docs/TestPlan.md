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

**System Testing: **Once we have an initial version of the application, we will revise the test plan to include system testing. During this phase of testing, we will check if the application compiles without errors, as well as find and document defects in the system, and monitor the performance of the application

**Acceptance Testing:** During this phase of the test plan, we will ensure that the application meets all of the requirements, and functions properly.

### 1.2 Test Selection

**Black-box Testing**: The black-box tests will allow us to examine the application by checking if the actual and expected output match, given valid and invalid inputs. We will identify flaws, fix them, and retest.

**White-box Testing**: The white-box tests will allow us to examine the internal structure of the application. During these tests, we will be observing the actual code as we run inputs through various modules. 

### 1.3 Adequacy Criterion

To assess the quality of the test cases, we will assess the results of functional and structural test cases. For functional coverage, we will use unit testing to ensure that each component functions as intended. For structural coverage, we will use system testing to see how the application performs when given invalid inputs or stress (for example, repeatedly pressing the search button). We will also perform a variety of activities, such as adding multiple floors in succession, and searching for different floors and see if the application responds correctly.

### 1.4 Bug Tracking

When performing unit tests, we will document methods that result in errors, and log the result of the test case, as well as how the error can be replicated. When performing integration tests, if a test results in an error, we will individually test the group components with the same input to identify which module is causing the error. All bugs encountered will be recorded in a text file, with steps to replicate it, and the bug fix. 

### 1.5 Technology

We will use JUnit to provide inputs and expected outputs to different methods, and record their actual outputs. We will also manually test the application as users. 

### 2 Test Cases


|User Type|    Test Description    |Test Case ID|Test Case Description|Pre-condition|Test data|Post-condition|Expected Result|Actual Result|Status|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|Employee|Add product	|000001|We will add a new product and check whether it is added or not|Enter floor category and floor type in text field|Stone, Tile,     	|Press Add button    	||||
|Employee|Add product	|000002|We will add a new product and check whether it is added or not|Enter floor category, floor type and floor species in text field  	|Real Marble, Tile, Oak     	|Press Add button    	||||
|Employee|Delete Product|000003|We will try to delete the product by category and floor type and check whether it is deleted or not|Enter floor category and floor type in text field|Stone Wall, Brick Floor|Press Delete Button    	||||
|Employee|Edit Product|000004|We will try to Edit the product by category and floor type and check whether it is Editable or not|Enter floor category and floor type in text field|Stone Wall, Brick Floor     	|Press Save Button    	||||
|Customer|Search Product   |000005|We will test the search function by product whether it give us right result or not|Enter the product name in the search bar  	|Marble, Laminate|Press Search button||||
|Customer|Search Category   |000006|We will test the search function by category whether it give us right result or not|Enter the category in the search bar  |Stone Wall     	|Press Search button||||
|Customer|Search Type   |000007|We will test the search function by floor type whether it give us right result or not|Enter the floor type in the search bar  	|Tile|Press Search button||||
|Customer|Search Stock   |000008|| We will test the search function for stock whether it give us right result or not|Enter the floor type in the search bar  	|Marble|                 |||
|Customer & Employee|In Stock   |000009|Check the inStock function whether it returns the right value|Enter floor category  	|Real Marble|Enter the button||||
| Customer & Employee |In Stock   |0000010|Check the inStock function whether it returns the right value|Enter floor category, Floor type|Real Marble, Tile, oak     	|Enter the button||||
|Customer & Employee|In Stock   |0000011|Check the inStock function whether it returns the right value|Enter floor category and Floor Species  	|Real Marble, Oak, Vinyl  |Enter the button||||
|Employee|Add Store offerings   |0000012|Check the function store offering|Enter floor offering|Name|Enter the add button   ||||
|Employee|Search Store Offerings   |0000013|check the store offering function|Enter name 	|                  Name                  |press search button    	||||
|Customer|Search Product   |0000014|We will test the search function by product whether it give us right result or not|Enter the product name in the search bar  |11111  |Press Search button    	||||
|Customer|Search Category   |0000015|We will test the search function by category whether it give us right result or not|Enter the category in the search bar  |6788  |Press Search button    	||||
|Customer|Search Type   |0000016|We will test the search function by floor type whether it give us right result or not|Enter the floor type in the search bar 	|4564|Press Search button    	||||
|Customer|Search Stock   |0000017|We will test the search function for stock whether it give us right result or not|Enter the store offerings in the search bar  	|34343|Press Search button    	||||



