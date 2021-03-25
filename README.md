# spenditTaskInterview

Spendit Interview task

For the BackEnd:
- I decomposed the architecture into 4 main logical components
    * Controller: All the requests pass through the controller component which dispatches the requests to the corresponding services.
    * Services: Responsible for implementing the business logic
    * Repositories: Responsible for persisting data using h2 memory and Hibernate ORM  
    * Models : Represents the abstraction of the real-world entities

For the FrontEnd:
- The Angular is based on the MVVM architecture and so we have also 3 main component
    * Views: Components that are responsible for rendering the UI 
    * Services: Responsible for sending requests to the BackEnd
    * Models: Represents the abstraction of the real-world entities
    * 
Each View has its corresponding TypeScript file where we can manage the input data and use the different services
