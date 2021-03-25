# spenditTaskInterviewBackEnd

For the BackEnd:

I decomposed the architecture into 4 main logical components
  -Controller: All the requests pass through the controller component which dispatches the requests to the corresponding services.
  -Services: Responsible for implementing the business logic
  -Repositories: Responsible for persisting data using h2 memory and Hibernate ORM
  -Models : Represents the abstraction of the real-world entities
