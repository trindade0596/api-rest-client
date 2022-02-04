# api-rest-client with authentication

# note
- The application is working only in memory, the data entered will be deleted if the system restarts, only the ADMIN user can DELETE data from the api, tests are incomplete.

# url
 Get, Post: localhost:8080/clientes,   
 Get by id, Put, Delete: localhost:8080/clientes/{id}

# Authenticated users:

 username: admin, password: java, 
 username: user, pasword: java

# example to post data:

{
	"name: Lucas,
	"cpf":618.243.840-17,
	"address": Wall Street
}

# Version:
  Java 1.8, 
  Maven 4.0.0, 
  Spring Boot 2.5.9


