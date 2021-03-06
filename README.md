[![Build Status](https://travis-ci.com/rafael-pieri/event-management-api.svg?branch=master)](https://travis-ci.com/rafael-pieri/event-management-api)

## Event Management Service

### Description
It is an application for event management.

### ERD
![alt text](https://github.com/rafael-pieri/event-management-api/blob/master/erd.png)

### How to run the application
Execute the following command to provide the database:

`docker-compose up`

Once the database is up and working, execute the command below:

`mvn spring-boot:run`

### HAL Browser
JSON Hypertext Application Language, or HAL, is a simple format that gives a consistent and easy way to hyperlink between resources in our API. Including HAL within our REST API makes it much more explorable to users as well as being essentially self-documenting.
It works by returning data in JSON format which outlines relevant information about the API.

The HAL model revolves around two simple concepts.

Resources, which contain:
- Links to relevant URIs
- Embedded Resources
- State

Links:
- A target URI
- A relation, or rel, to the link
- A few other optional properties to help with depreciation, content negotiation, etc

The HAL browser was created by the same person who developed HAL and provides an in-browser GUI to traverse your REST API.

Access the HAL browser at: `http://localhost:8080`

### Postman Collections
There is a collection in postman to call the APIs. Import from: `../postman/event_management_service.postman_collection.json`

### Concepts
- Hypermedia
- Paging and sorting
- Projections and Excerpts
- HAL Browser

### Stack
- Spring (JPA, Data REST, Security)
- Lombok project
