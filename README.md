<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS

<strong>Devika Prasanth</strong>

B.  Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.
>file: README.md. Created a README file including notes describing changes to code. 
>
C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
> mainscreen.html
>- line 13-19: main screen style changes
>- line 14: title changed 
>- line 19: changed header
>- line 21: changed header
>- line 53: changed header
> 
D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
>about.html
>- creation of new file
>- line 1-12: formatted file
>- line 13-49: added style 
>- line 50: add title 'About'
>- line 53-66: addition of title and paragraph about business
>- line 67:added button to main screen
>
>mainscreen.html
>- a button called 'About Us' was added to mainscreen
>- line 44: addition of link button to about.html with use of controller
>
>AboutController.java
>- line 1 -12: utilize Controller and RequestMapping
>- created New controller and url /about linked using Request Mapping 


E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
>BootStrapData.java
>- line 42 and line 98: if else statement created to ensure if there are no existing parts listed, a sample inventory would be created. 
>- line 43-89: added 6 parts and saved them to the part repository. Only shown if there is no inventory. 
>- line 107: created an if statement to ensure a sample inventory of products will be present if there is no existing product. 
>- line 108-121: added 5 products and saved them to the product repository. Only shown if there is no existing inventory upon boot. 
> 

F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
- The “Buy Now” button must be next to the buttons that update and delete products.
- The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
- Display a message that indicates the success or failure of a purchase.
>mainscreen.html
>- line 113-114 : created another button using href next to update and delete buttons. I then mapped it to /buyProduct url created a hidden input field to pass tempProduct.id to controller. 
>- 
>BuyProductController.java
>- created a new Java file in /controllers called BuyProductController. 
>- line 12 set it as a Controller 
>- line 15-16: added Product Repository object and annotated with Autowired
>- line 19-20: used GetMapping to map to /buyProduct and made public string method, buyProduct. used @RequestParam to get the hidden input from mainscreen.html, and use as input param. 
>- line 21: created theIdl to change theID to a long instead of int so it can be used as an input in next line. 
>- line 22: created an Optional<Product>result which return if a product is present or not in the database, and set it to search the productrepository using findbyID for the product.
>- line 23-38: created a Product object called theProduct and set it to null, then used a if then statement to determine if the product exists in the data base or does not. If it doesnt exist it throws an exception
>- line 27- 34: if it does exist, a nested ifthen statement is used to determine if there is inventory of it or not. if there is the inventory is decremented by 1 and the user is directed confirmation html page.if not a a error page. 
>
> cannotpurchase.html
>- simple html page users are redirected to if the product they seek has no inventory. 
>- line 47: link mapped to mainscreen.
>- 
> confirmationofpurchase.html
>- simple html page users are redirected to if the product they seek has enough inventory and has been "purchased"(inv - 1).
>- line 50: link mapped to mainscreen.
> 
G.  Modify the parts to track maximum and minimum inventory by doing the following:
- Add additional fields to the part entity for maximum and minimum inventory.
- Modify the sample inventory to include the maximum and minimum fields.
- Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
- Rename the file the persistent storage is saved to.
- Modify the code to enforce that the inventory is between or at the minimum and maximum value.
>Part.java
>- line 23: added validation annotation. 
>- line 34-37: added additional min and maxInv fields. 
>- line 58-65: added new constructor including new fields. 
>- line 95-102: added new getter and setters for new fields. 
>- line 114-123: added new isInvValid method to check if inv is in min max range.
>
> BootStrapData.java
>- line 49-100: Added max and min Inventory to all sample inventory.
>ValidInventoryParts.java
>- new interface to define new annotation 
>- line 10-17: used Constraint annotation and defined the class that will validate the field. 
>- line 14: defined error message that will show in user interface. 
>
>InventoryPartsValidator.java
>- created a validator class to enforce rules of the @ValidInventoryParts validator. 
>- line 15-20: implements ConstraintValidator interface
>- line 25-34: implements the isValid method and define validation rules which state it is valid only in inv > minInv and inv<maxInv. 
>
> InhousePartForm.html 
>- line 8-12: css to show error in red
>- line 28-33: addition of minInv and maxInv input and error display
>- line 36-43: decision to list all errors in one place below in red. 
>
>OutSourcedPartForm.html
>- line 8-12: css to show error in red
>- line 30-35: addition of minInv and maxInv input and error display
>- line 38-46: decision to list all errors in one place below in red.
>- 
>application.properties
> - changed db file name to on local directory and here to d287-java-frameworks-h2-db.
> mainscreen.html
> - line 63-64: addition of min and max inventory fields on table
> - line 73-74: addition of min and max inventory data in table. 

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
- Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
- Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
- Display error messages when adding and updating parts if the inventory is greater than the maximum.
> ValidMaxInventoryParts.java
> - new annotation file created for evaluating whether part inv. is below min inventory. 
> ValidMinInventoryParts.java
> - new annotation file created for evaluating whether part inv. is above max inventory.
> MaxInventoryValidator.java 
> - created a validator class to enforce rules of the @ValidMaxInventoryParts validator.
> - line 26: logic to return false if inventory is greater than the max inventory parameter. 
> MinInventoryValidator.java
> - created a validator class to enforce rules of the @ValidMinInventoryParts validator.
> - line 26: logic to return false if inventory is greater than the max inventory parameter.
> Part.java
> - line 26-27: addition of @ValidMaxInventoryParts and @ValidMinInventoryParts class validators. 
> EnufPartsValidator.java
> - line 36: addition to logic. Will return false if a decrease of one in the parts inventory results in a value less than the minimum inventory parameter.
> ValidEnufParts.java
> - line 20: added to message to clarify error.  

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
>PartTest.java 
> line 159-194: created unit test for setMin, setMax, getMin, and getMax. All tests passesd. 
> 
J.  Remove the class files for any unused validators in order to clean your code.
>DeletePartValidator.java 
> - deleted validator due to lack of use.
> ValidDeletePart.java
> - deleted annotation due to lack of use.
> Part.java
> - deleted DeltePartValidator import due to lack of use. 
> 
L.  Demonstrate professional communication in the content and presentation of your submission.
