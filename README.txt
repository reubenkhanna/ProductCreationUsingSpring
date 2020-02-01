This is ReadMe for Final Project Java by 
Author: Utkarsh Reuben Khanna
Cno: C0750077

#---------Requirements--------------------------------------------------------------#

- A page with a form where users have to input information
   - must have atleast 3 fields for the user to fill out [5] ----------------------- Productlist.html 
     
   - form must be validated on the server side (for every field) [5]-----------------ProductClass

   - contents from the form should be persisted if it passes validation [8]--------- ProductRepository.html Saved to AWS-RDS

- A page that users can go to that lists the items created from the form in requirement 1 using Templates/Thymeleaf [8]--------productlist.html
   - must take an optional get param to filter the list by an attribute (should also use streams) [4]--------------------------ProductController (/ Mapping)
- There must be an API that returns the number of page hits since the server was online----------------------------------------ProductRestContoller,PageCounter,PageConfig
   - This api should be called asynchronously every 3 seconds and the results displayed on every  page [8] --------Is displayed on every page
- There must be at-least 1 dependency injected into two different locations in the project [7]-------------------- PageCounter is Included in ProductRestController and ProductController Classes


Bonus

- Aesthetically pleasing website (e.x using css/frameworks) (bonus up to 4 points)---------------------Uses Bootstrap for website
- Use of lombok / Jackson on data classes (bonus up to 3 points)---------------------------------------Lombok and Jackson uses whereever necessary 


#--------Class Details--------------------------------------------------------------#
Products Class:
- Products class which has validation for each and every field 
- Has a constructor which uses Jackson to fill Json property
- Uses @Data by lombok to create necessary getters and setters 

PageCounter Class: 
- A class created for counting Page hits 
- Has Increament and get page count methods

PageCountConfig: 
- Bean Config Class for Page Counter 

ProductsRepository: 
- A CrudRespository Interface for products to find,save products to AWS RDS database 

ProductsController: 
- Has two dependency Injected productRepository and PageCounter 
- Has GetMapping for /addproduct to show the addproduct template
- Has POSTMapping for /add/product to show successproducts template if the form is validated 
- Has GetMapping for / to show list of products (Takes optional parameter name for filter)

ProductsResContoller:
- Has Page Counter Dependecy Injected 
- Has GetMapping for /currentcount to get page count

addproducts.html:
-Has form to fill for adding products validated by Thymeleaf 

productlist.html:
- Shows product list, and page hits 
- Filter based on search 

successproducts.html: 
-Shows after succesfull products insertion in Database