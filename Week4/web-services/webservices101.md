# Web Services

-   A software system designed to support interoperable machine-to-machine interaction over network
    -   **In ENGLISH please**
        -   machiens tlake to one another
        -   More Specifically
            -   a collection of **open protocols** and **standards** used to exhange that data between applictions or systems
            -   This Connects:
                -   Soft applications that are written in various programming languages (polyglot)
                -   Can also be runnign on various platforms
                    -   ie Something on Google Cloud that needs to speak to a application on Microsoft Azure
-   Their **interoperablitiy**
    -   communication between differen programming languages
        -   Java & Python or Java & Javascript etc
    -   Windows & Linux
    -   due to the **open standards**
-   Web Services have two types of Architecture layout
    -   SOAP
        -   you've heard soap. That's all you need to know about SOAP
    -   **_REST_**
        -   THIS IS OUR FOCUS

## URI

-   **Uniform Resource Identifier**
    -   SUPERSET of URL
    -   Main aim is to find a resource and differentiate from other resources on your server
        -   Imagine filepath

## URL

-   **Uniform Resource Locator**
-   Subset of URI
-   Main aim is to get the location or address of a resource
-   URL is used to locate only web pages
-   ALL URLs can be URIs

# REST

-   Stands for **REpresentational State Transfer**
-   It's an architectural style/convention for wbe services that presents a server as a collection of resources
    -   Accessed via specific endpoints
    -   **_IT'S AN ARCHITECTURAL STYLE_**
        -   even though it lays our guidelines we CHOOSE what it follows
        -   **Endpoitns** are determined by the URI
-   In a nutshell, _Rest outlines how a client and server communicate over the web_
-   REST was designed by Roy Fielding in his disseration in 2000.
    -   He **claims** it's not limited to HTTP as it's protocol....
        -   There is alot debate around this

## 6 Guiding Principles to a RESTful API

-   **Client-server Architecture**
    -   separating user interface (front end) from our data storage (data base, is manipulated by your backend code)
    -   Allows for portability acorrss multiple platforms and abstraction in general
-   **Layered Architecture**
    -   The server should be desinged in a layered fashion so that the client is not aware of how the server is designed beyond that interaction layer.
-   **Stateless**
    -   Each request from a client to the server must contain all information necessary for the server to understand the complete request
    -   Server doesn't sotre any context information about the client (sessions or cookies)
-   **Cacheable**
    -   Our respons should be able to be saved by the client
    -   Because our responses are resousrces at particular endpoints you be able to save(cache) these resource to prevent repeat requests
-   **Uniform Interface**
    -   System architecture should be desinged in a way that mkaes finding resources highly logical
    -   URIs should proceed from the general to the collection to the specific resources.
        -   www.mycars.com/cars
            -   REturn all cars in the database
        -   www.mycars.com/cars/sportscars
            -   Return all cars that are type sportcars from the database
        -   www.mycars.com/cars/sportcars/bugatti-model2
            -   return specifically the bugatti-model2 that is stored in the database
-   **(Optional) Code on Demand**
    -   Allows client functionality to be expanded by downloading and executin code
        -   in the form of applets or scripts to use with resources
    -   It's not particularrly well defined or agreed upon wihtin the software development community at large

## Verbs/Methods

-   REST requires the use of HTTP verbs/methods in specific ways
    -   _GET_
        -   this is simply to request information
        -   Generally speaking it will have an empty body
        -   Analogous to a select statement in postgres
    -   _POST_
        -   This is used to create a new object/add completely new data entry into your database
        -   You NEED to provided information in the body
            -   Employee_name, employee_email, employee_dob etc etc
        -   Analogous to insert statements
    -   _PUT_
        -   used to update a complete resource
        -   Information should be in body
            -   generally speaking it's the whole of the record/class/models
            -   update every column the row has
        -   Analogous to updates in SQL
    -   _PATCH_
        -   Used to update a specific part of the resource
            -   single field for an object, not all of the components
            -   analogos to the update set column1,column2
        -   Requires a body (identifier and the columns you wish to update)
    -   **DELETE**
        -   removing the resources
        -   analogous to delete sql
        -   **use with caution** as with every delete
            -   for instance, you could constrain delte commands to your admin

#### CRUD

-   CRUD operations generally make up the minimum requirements for a well designed user interface
    -   *C*reating
    -   *R*eading
    -   *U*pdating
    -   *D*eletion
-   You want to make sure that all CRUD operations are handle via your backend

## Requests & Responses

-   Requests
-   are made by clients/end-users
    -   Body
    -   Method/Verb
        -   GET PUT POST PATCH DELETE
    -   URL
    -   HTTP Version
    -   Headers
        -   meta-data to provide information about the request
-   Response
-   are made by the server/database
    -   Body
    -   Headers
    -   status code

# Status Codes

-   100's
    -   Information
-   200's
    -   Success!
    -   201 successfully created
-   300's
    -   Redirect
-   400's
    -   Client Error!
    -   404 Not Found
        -   say you provided ID 203, the highest ID is 200
    -   403 Forbidden
        -   meaning this user doesn't have the required permissions
    -   418 I'm a teapot
    -   451 unavailable due to government censorship
-   500's
    -   Server Error

# Safe vs Idempotent Verbs

-   Safe
    -   it should NEVER make any changes to the server
        -   GET
        -   should be able to run 1000s and it does nothing to the server
-   Idempotent
    -   same request will result in the same state of the server/database if you send multiple times
    -   No matter how many requests you send, the server will remain the same
        -   GET, DELETE, PUT, PATCH

## What exactly is a REST Resource

-   A REST resourse is in broad terms\
    -   any information can be named a resource
        -   a document
        -   image
        -   colleciton of other resource
        -   an object
    -   Resources are no views
        -   Displaying of the actual resource is the responsibilty of your webpage

## What on earth is being passed around in these bodys? from request and responses

-   **_JSON_**
    -   JavaScript Object Notation
    -   This was used for every language
        -   JavaScript is used on EVERY web page
    -   **Key-value pairs** for objects in JavaScript
        -   not specific for JS
        -   **_LANGUAGE AGNOSTIC_**
    -   At it's core!!!!!
        -   just text but it's formated in a way that allows computer programs to easily parse it
    -   Using all the time

```json
{"emp_id":1, "emp_name":"Charles", "emp_status":boolean, "emp_email": "charles.jester@revature.com"}
```

-   Values can of any type
    -   "String"
    -   Number
    -   JSON object
    -   Array
    -   Boolean
    -   Null
-   CANNOT RETURN
    -   function, date or undefined
-   JS has a built-in parser for JSON which makes it super easy for web communication
-   Javalin requires GSON
    -   this helps Java parse JSON

# Front Controller Design Pattern

-   Providing a single hanlder for incoming requests to an application
-   delegates the request to appropraite secondary handles
    -   You can think of it as an entrance for ALL requests
    -   Sending the requests to where they need
-   Provides centralized control for all requests which helps fo ruser tracking and security
    -   helps improve manageability, reusability and role separation

# Java Layered Architecture

-   3 Layers of Architcture
-   src/main/java
    -   your actual application
    -   each package that you specify holds the layer
-   **1st layer**
    -   should be composed of your controller,Javalin (MainDriver.java)
    -   generally speaking all about the connection to the front end
-   **2nd Layer**
    -   services layer
    -   **Business logic**
        -   logic is implemented
        -   verifying passwords/usernames
        -   verifying correct input
            -   i.e. age = "Fifty", we don't want this
                -   quick aside about the oddities of JS
                    -   something calculated on the front end
                        -   1 + "1" = 11
    -   Prevent any anomolies in your database
-   **3rd Layer**
    -   DAO - Data Access Object
    -   Thesea re the java objects that connect to and retrieve or add information to our server
-   OUTSIDE OF THESE LAYERS
    -   Other additional packages **models or utilities**

# Model-View-Controller Design Pattern

-   **Front-end** design patterned based on how we organize what we display to our end-users
-   Models
    -   of our data/information
    -   objects
    -   (alludes back to those models)
-   Views
    -   exactly what the client is seeing
    -   HTML/CSS/JS come into play
-   Controller
    -   Logic that is used to construct the view based on the models
