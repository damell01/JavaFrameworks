##  C. Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

<B>Changed Shop Name,Parts,and Products name in mainscreen.html on lines 14,19,21,<B>
Line 14 - <title>My Computer Shop</title>
Line 19-  <h1>My Computer Shop</h1>
Line 21- <h2>Software</h2>
Line 53-  <h2>Computer</h2>

Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the
“About” page and the main screen.
 <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ABOUT</title>
</head>
<body>

<a href="http://localhost:8080/">Link
to Main Screen</a>
</body>
</html><!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>About Us</title>
</head>
<body>
<h1>Welcome to Our Business!</h1>
<p>We are a cutting-edge company dedicated to delivering innovative solutions and exceptional services to our clients. With a focus on quality, integrity, and customer satisfaction, we strive to exceed expectations and drive success.</p>


</body>
</html>


D. Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the
“About” page and the main screen.

 Changed line  17 on mainscreen.html to add link to about page. Added About page and About Controller. Also added about info to about.html.
Line 17 (Mainscreen.html) <a th:href="@{/about}"> About Us</a>
Line 9-10 (About.html) <a href="http://localhost:8080/">Link
to Main Screen</a>

About Page addition : <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ABOUT</title>
</head>
<body>

<a href="http://localhost:8080/">Link
to Main Screen</a>
</body>
</html><!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>About Us</title>
</head>
<body>
<h1>Welcome to Our Business!</h1>
<p>We are a cutting-edge company dedicated to delivering innovative solutions and exceptional services to our clients. With a focus on quality, integrity, and customer satisfaction, we strive to exceed expectations and drive success.</p>


</body>
</html>

E. Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample
inventory and should not overwrite existing data in the database.
Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory
appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are
added, make a “multi-pack” part.

Line 80-90 BootStrapData.Java :
/*  Product Macbook= new Product("Macbook",100.0,15);
Product Windows= new Product("Windows",100.0,15);
Product MacbookPro= new Product("Macbook Pro",100.0,15);
Product WindowsPro= new Product("Windows Pro",100.0,15);
Product ThinkPad= new Product("ThinkPad",100.0,15);
productRepository.save(Macbook);
productRepository.save(Windows);
productRepository.save(MacbookPro);
productRepository.save(WindowsPro);
productRepository.save(ThinkPad);
*/

Line 28-62 Bootstrap.java
// Add 5 parts using the provided format
  OutsourcedPart part1 = new OutsourcedPart();
part1.setCompanyName("Western Governors University");
part1.setName("Windows 10");
part1.setInv(50);
part1.setPrice(25.0);
outsourcedPartRepository.save(part1);

        OutsourcedPart part2 = new OutsourcedPart();
        part2.setCompanyName("Western Governors University");
        part2.setName("Windows 11");
        part2.setInv(60);
        part2.setPrice(28.0);
        outsourcedPartRepository.save(part2);

        OutsourcedPart part3 = new OutsourcedPart();
        part3.setCompanyName("Western Governors University");
        part3.setName("Windows 12");
        part3.setInv(45);
        part3.setPrice(30.0);
        outsourcedPartRepository.save(part3);

        OutsourcedPart part4 = new OutsourcedPart();
        part4.setCompanyName("Western Governors University");
        part4.setName("Windows 13");
        part4.setInv(55);
        part4.setPrice(32.0);
        outsourcedPartRepository.save(part4);

        OutsourcedPart part5 = new OutsourcedPart();
        part5.setCompanyName("Western Governors University");
        part5.setName("Windows 15");
        part5.setInv(70);
        part5.setPrice(35.0);
        outsourcedPartRepository.save(part5); 

F. Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
• The “Buy Now” button must be next to the buttons that update and delete products.

• The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.

• Display a message that indicates the success or failure of a purchase.


Created ConfrirmBuy.html
< !DOCTYPE html >
< html lang="en" >
< head >
< meta charset="UTF-8" >
< title > Product Purchase Confirmation! < /title >
< /head >
< body >
< h1 > Your product has been purchased! < /h1 >

< a href="http://localhost:8080/" > Link to Main Screen < /a >
< /body >
< /html >

Created errorbuy.html
< !DOCTYPE html >
< html lang="en" >
< head >
< meta charset="UTF-8" >
< title > Error purchasing product. < /title >
< /head >
< body >
< h1 > Error purchasing product. Confirm current inventory. < /h1 >

         < a href="http://localhost:8080/" > Link to Main Screen < /a > 
        
         < /body > 
         < /html > 

Inserted Line 83 (Mainscreen.html) 
  <td> < a th:href="@{/buyproduct(productID=${tempProduct.id})}" class="btn btn-primary btn-sm mb-3"
                onclick="if(!(confirm('Are you sure you want to purchase this product?')))return false" > Buy Now < /a >


Inserted Line 108 (Product.Java)


        // Instruction F: buyProduct function to decrement inventory
        // Uses a simple test to ensure product exists before decrementing
        public boolean buyProduct() {
            if (this.inv >= 1 ) {
                this.inv--;
                return true;
            } else {
                return false;
            }
        
        }

Insert line 172 Addproductcontroller.Java

@GetMapping("/buyproduct")
public String buyProduct(@RequestParam("productID") int theId, Model theModel ) {
ProductService productService = context.getBean(ProductServiceImpl.class);
Product product2 = productService.findById(theId);

        boolean purchaseConfirmation = product2.buyProduct();
        if ( purchaseConfirmation ) {
            productService.save(product2);
            return "confirmbuy";
        }

        return "errorbuy";

G. Modify the parts to track maximum and minimum inventory by doing the following:
• Add additional fields to the part entity for maximum and minimum inventory.

INSERT - mainscreen.html, LINES 38-39 AND LINES 48-49
< th > Minimum < /th >
< th > Maximum < /th >

        < td th:text="${tempPart.minimum}" > 1 < /td > 
        < td th:text="${tempPart.maximum}" > 1 < /td >

Modify the sample inventory to include the maximum and minimum fields.
 Line 36-38 (Part.Java) Inserted 
@Min (value = 0, message = "Minimum inventory must be > 0")
int minimum;
int maximum;

Line 113-117 (Part.Java) Inserted
public void setMinimum(int minimum) { this.minimum = minimum; }
public int getMinimum() { return this.minimum; }

        public void setMaximum(int maximum) { this.maximum = maximum; }
        public int getMaximum() { return this.maximum; }

Inserted - InhousePart.java AND OutsourcedPart.java, LINES 18-19
// Adding default values for maximum and minimum;
this.minimum = 0;Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.

Inserted - InhousePartForm.html AND OutsourcedPartForm.html, LINES 25-35

        < p >  < input type="text" th:field="*{minimum}" placeholder="Minimum" class="form-control mb-4 col-4"/ >  < /p > 
             
        < p >  < input type="text" th:field="*{maximum}" placeholder="Maximum" class="form-control mb-4 col-4"/ >  < /p > 
             
        < p >  < input type="text" th:field="*{partId}" placeholder="Part ID" class="form-control mb-4 col-4"/ >  < /p > 
    
        < p > 
        < div th:if="${#fields.hasAnyErrors()}" > 
            < ul >  < li th:each="err: ${#fields.allErrors()}" th:text="${err}" >  < /li >  < /ul > 
        < /div > 
        < /p > 
Line 6 Change on Appplication.Properties File
Rename the file the persistent storage is saved to.
CHANGE - application.properties

spring.datasource.url=jdbc:h2:file:~/spring-boot-h2-db102
TO
spring.datasource.url=jdbc:h2:file:~/src/main/resources/spring-boot-h2-db102

• Modify the code to enforce that the inventory is between or at the minimum and maximum value.

Inserted - Part.java LINES 97-103
public void validateLimits() {
if (this.inv < this.minimum) {
this.inv = this.minimum;
} else if (this.inv > this.maximum ) {
this.inv = this.maximum;
}
}

Inserted (InhousePartServiceImpl.java AND OutsourcedPartServiceImpl.java) LINE 53
partRepository.save(thePart);

H. Add validation for between or at the maximum and minimum fields. The validation must include the following:
Inserted  - Part.java, LINES 21-22
@ValidPartInventory
@ValidPartInventoryMinimum


Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
Created - PartInventoryMinimumValidator.java

        package com.example.demo.validators;
        
        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        
        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;
        
        /**
         *
         *
         *
         *
         */
        public class PartInventoryMinimumValidator implements ConstraintValidator < ValidPartInventoryMinimum, Part > {
            @Autowired
            private ApplicationContext context;
        
            public static  ApplicationContext myContext;
        
            @Override
            public void initialize(ValidPartInventoryMinimum constraintAnnotation) {
                ConstraintValidator.super.initialize(constraintAnnotation);
            }
        
            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
                return part.getInv() > part.getMinimum();
            }
        }

    Created ValidPartInventoryMinimum.java

        package com.example.demo.validators;
        
        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        
        /**
         *
         *
         *
         *
         */
        @Constraint(validatedBy = {PartInventoryMinimumValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ValidPartInventoryMinimum {
            String message() default "Inventory cannot be lower than required minimum";
            Class [] groups() default {};
            Class [] payload() default {};
        }
Display error messages when adding and updating parts if the inventory is greater than the maximum.
Created - PartInventoryValidator.java

        package com.example.demo.validators;
        
        import com.example.demo.domain.Part;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationContext;
        
        import javax.validation.ConstraintValidator;
        import javax.validation.ConstraintValidatorContext;
        
        /**
         *
         *
         *
         *
         */
        public class PartInventoryValidator implements ConstraintValidator < ValidPartInventory, Part > {
            @Autowired
            private ApplicationContext context;
        
            public static  ApplicationContext myContext;
        
            @Override
            public void initialize(ValidPartInventory constraintAnnotation) {
                ConstraintValidator.super.initialize(constraintAnnotation);
            }
        
            @Override
            public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
                return part.getInv() <= part.getMaximum();
            }
        }

    Created - ValidPartInventory.java

        package com.example.demo.validators;
        
        import javax.validation.Constraint;
        import javax.validation.Payload;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        
        /**
         *
         *
         *
         *
         */
        @Constraint(validatedBy = {PartInventoryValidator.class})
        @Target({ElementType.TYPE})
        @Retention(RetentionPolicy.RUNTIME)
        public @interface ValidPartInventory {
            String message() default "Inventory cannot exceed maximum value";
            Class [] groups() default {};
            Class [] payload() default {};
        }

I. Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
Insertef - PartTest.java, LINES 160-176
@Test
void getMinimum() {
int minimum=5;
partIn.setMinimum(minimum);
assertEquals(minimum, partIn.getMinimum());
partOut.setMinimum(minimum);
assertEquals(minimum, partOut.getMinimum());
}

        @Test
        void getMaximum() {
            int maximum=5;
            partIn.setMaximum(maximum);
            assertEquals(maximum, partIn.getMaximum());
            partOut.setMaximum(maximum);
            assertEquals(maximum, partOut.getMaximum());
        }

J. Remove the class files for any unused validators in order to clean your code.
Unused validators review:
ValidDeletePart (DeletePartValidator) - Used in Part.java
Prevents parts from being deleted if they're associated with a product

    ValidEnufParts (EnufPartsValidator) - Used in Product.java
        Prevents adding additional product inventory if there isn't enough associated parts inventory

    ValidPartInventory (PartInventoryValidator) - Used in Part.java
        Prevents adding additional part inventory if it exceeds the specified max

    ValidPartInventoryMinimum (PartInventoryMinimumValidator) - Used in Part.java
        Prevents modifying part inventory if it the changes puts it below the min threshold

    ValidProductPrice (PriceProductValidator) - Used in Product.java
        Prevents charging less for the product than the sum cost of its associated parts

All 5 validators  are being used. 


