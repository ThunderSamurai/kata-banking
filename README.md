                                            Core Banking MicroService Kata
                                            
-----------------------------------------------------------------------------------------------------
    US Implemented

US 1:

In order to save money
As a bank client
I want to make a deposit in my account

US 2:

In order to retrieve some or all of my savings
As a bank client
I want to make a withdrawal from my account

US 3:

In order to check my operations
As a bank client
I want to see the history (operation, date, amount, balance) of my operations
------------------------------------------------------------------------------------------------------------
    Technical Stack
- Java 8,
- JavaMoney,
- Jackson JSON ,
- Spring Core,
- Spring Data JPA,
- Spring REST,
- Spring Boot,
- Mockito,
- JUnit.
------------------------------------------------------------------------------------------------------------
    Design
    
A layered design has been chosen as follows : Controller -> Process -> Service -> DAO
     
---------------------------------------------------------------------------

Further work :
 - Code Review ...,
 - Add Logging,
 - Add Continuous delivery solution (i.e BitBucket),
 - Add OpenAPI Description & Swagger,
 - Add Hibernate data validation on entities and views,
 - Add Security Layer with Spring security & Co.
 - Add Juridical Auditing