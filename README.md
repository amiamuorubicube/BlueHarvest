Instructions:

-The index page contains 3 links: create a secondary account – Review customer’s information – make a transaction.
1-In order to create a secondary account, the user needs to enter a client id and an initial credit then click on “Create” button, the system displays a success message in case the account was created successfully, and it displays an error message in case no client with the id exists or in case one of the fields is empty.
2-To review a customer’s information, the user should enter the client’s id and click on “Search” button, the system returns the client’s info in case the client exists and an error message in case he doesn’t or in case the field is empty.
3-In order to make a transaction, the user should enter a clientId, an accountId and the amount, then he clicks on “Create” button. The system returns a success or an error message.
 Errors: One of the fields is empty, the amount is inferior or equal to zero, no client with the clientId exists, no account with the accountId exists.
The system allow transactions made by a customer to another customer’s account.

Tools used:

-Springboot, RESTful Api, h2 database, thymeleaf, maven, jsp, jquery, ajax, bootstrap.
