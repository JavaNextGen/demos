# Javalin

-   Javalin is a web framework for creating web severs in Java(or Kotlin)
    -   This is how we will process our HTTP requests in our backened(server) and send back HTTP responses to the frontend(client/webpage)
-   Javalin is **event driven**
    -   EACH HTTP request to your server is an event
    -   This event triggers a lambda function in response

## HTTP Hanlders

-   Javalin uses HTTP Hanlders to take in HTTP requests and return that HTTP response
    -   **4 Main Types of Handlers**
        -   **Endpoint Handlers**
            -   The most used handler
            -   pertains to a certain URL endpoint(URI) and HTTP Verb
        -   **Before Handler**
            -   Executes before every mathing HTTP request
        -   **After Handler**
            -   executes after every matching HTTP request
        -   **Exception/Error Handlers**
            -   Handles any error/exceptions thrown by your request
-   The Handler interface has void return type
    -   **WE NEED** is to use the Context(ctx) object to return data in the form of HTTP responses using ctx.result
        -   ctx also does a bunch of other useful stuff like setting status
        -   [Javalin Handler Documentation](https://javalin.io/archive/docs/v1.7.0.html#after-handlers)
    -   Error and Exception Handling in Javalin is very straightforward
        -   All Handlers can throw and exception and any subclass of Exception
    -   All Handlers can catch any HTTP status code

```java
app.exception(NullPointerException.class, (e, ctx) -> {
    // Handle null pointers
});

app.exception(Exception.class, (e, ctx) -> {
    // Handling general exceptions
    // will not trigger if a more specific exception-mapper is found
});

app.error(404, ctx -> {
    ctx.result("Generic 404 Message here! OH NO!");
});
```

# CORS

-   **Cross-Origins Resources Sharing**
    -   an HTTP-header mechanism that llows a server to indicate any origins other than its own from which a browser should permit loading a resource.
        -   Example:
            -   frontend JS code serverd on a https://domain-a.com use an HTTP request to make a requst from http://yourserver.com/employees.
-   Why do we need it?
    -   For security reasons, browsers restrict cross-origin http request by default intiated from scripts/programs/applications.
        -   Default fetch api, or some library(axios in js), focused on **same-origin** policy

# GSON

-   We have on other problem....
-   Java can't read JSON on it's own!
-   We need a way to parse JSON into JavaObjects and vice-versa
-   **GSON**
    -   is a Java library
    -   Allows us to convert Java objects into their JSON respresentations and back
    -   This is how we'll read data sent from the frontend and send data back to it
-   Two primary methods from the GSON libary
    -   .toJson()
        -   turns a Java object into a JSON String
    -   .fromJson()
        -   turns a JSON string into a Java Object

# How this all ties together!

-   **Problem**
    -   Internet is FULL of web servers
    -   All of them are writting in differernt programming languages
    -   We need to make sure they communicate with one another...
    -   BUT....
    -   Every programming language has different data types
        -   For instance,
            -   Javascript has number as its data type
            -   Java has a BUNCH oof types to represent numbers
-   **Solution**
    -   We need that universal format that any programming language can understand
        -   This where JSON enters the arena!!!!!!
            -   our frontend and backend will be taking via JSON
    -   We need to use Javalin to take in those HTTP requests and parse the JSON using the HTTP Handlers
