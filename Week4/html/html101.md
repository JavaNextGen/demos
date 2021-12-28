# Client Side WebSite Technologies

## 1. **HTML**

-   contetnt and structure

## 2. CSS

-   styling

## 3. JavaScript

-   logic (programming)

# HTML

-   **\*HyperText Markup Language**
    -   used to create webpages (front end)
    -   desrcriptive not programmatic
    -   HyperText refers to that baility of HTML easily "link" other pages
    -   HTML is standard for displaying webpages to the internet
    -   HTML syntax is broken down into two subsets:
        -   Elements
        -   Attributes

## Syntax

### Elements

-   provide the structure to the documente and defined by tages
    -   \<tagname>content\</tagname>
    -   \<div>This is a div element\</div>
-   Like XML, HTML must have is tags properly nexted to be valid
    -   Correct: \<div>\<p>\</p>\</div>
    -   Incorrect: \<div>\<p>\</div>\</p>

```html
<!-- This is a comment -->
<!-- This is appropriate format for html elements nested -->
<div>
	<h1></h1>
	<p></p>
</div>
```

-   Two Categories
    -   **Block Element**
        -   These elements will render as block on the page, meaning any element after will start on a new
    -   **Inline Element**
        -   these can sit next to one another and require you to insert a linebreak in order for the element to start on the next line
-   Common HTML Elements:
    -   \<div>
        -   defined as a dvision of the page
        -   often contains other elmenets within it
        -   block elment
    -   \<h1>
        -   1 - 6, the higher the number the smaller the text
        -   block element
    -   \<p>
        -   defines a paragraph which is also block scope
        -   block
    -   \<span>
        -   standard inline element
    -   \<img>
        -   displays an image to the webpage
        -   doesn't need a closing tag (**Self-closing tag**)
        -   inline

```html
<img src="http://google.com/image_of_cat" />
```

-   \<a>
    -   anchor tag
    -   used to make hyperlinks
    -   inline

### Attributes

-   Are the meta data use to described the elements
    -   you can think as paramaters definite the specific tag
-   Defined with a key/value pairs

```html
<img src="http://google.com/image_of_cat" />
```

#### Example of HTML in markdown

<img class="football" src="https://a4.espncdn.com/combiner/i?img=%2Fphoto%2F2021%2F1227%2Fr955426_1296x518_5%2D2.jpg&w=660&h=264&scale=crop&cquality=80&location=center&format=jpg">

-   Global Attributes
    -   These can be applied to any tag
        -   class
        -   id
        -   hideen
        -   style
        -   title

## HTML Doctype Declaration & Root Tags

-   <!DOCTYPE html>
    -   this is at the top of everything html file
    -   Informs the browser what type of document we are displaying
    -   This above syntax actually defiens a HTML5 document
-   The root tag
    -   \<html>\</html>
    -   everything on your webpage has to be contained with this element
        -   Within your html tag you have two other tags
            -   \<head>
                -   meta data, titles
                -   styling
            -   \<body>
                -   actual content is

```html
<!-- Minimum Requirements for HTML -->
<!DOCTYPE html>
<html>
	<head> </head>
	<body></body>
</html>
```

## Document Object Model (DOM)

-   Defining the standard access for documents
-   3 Types of DOM:
    -   Core DOM:
        -   everything document follows
    -   XML DOM:
        -   standard the CML documents
    -   HTML DOM:
        -   stand all HTML elements
-   **HTML** DOM
    -   Defines:
        -   HTML elmeent as **object**
        -   **properties** all html elmeents
        -   **methods** to access the html elments
        -   **events** for html elements
-   Logical tree representation of our html

## HTML Tables

-   Tables are just very easy way to structure our html pages and display information
    -   There was a time where HTML pages were alll just giant
-   Create a table we begin with the \<table> tag.
    -   Two "Sub-elements"
    -   \<thead>
        -   \<tr> - table row
        -   \<th> - table header (example: Column Names)
    -   \<tbody>
        -   \<tr>
        -   \<td> - table data - filling our information in a particular column

```html
<!-- General table structure -->
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Hobby</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Charles</td>
			<td>28</td>
			<td>Cooking</td>
		</tr>
		<tr>
			<td>Charles</td>
			<td>28</td>
			<td>Cooking</td>
		</tr>
		<tr>
			<td>Charles</td>
			<td>28</td>
			<td>Cooking</td>
		</tr>
		<tr>
			<td>Charles</td>
			<td>28</td>
			<td>Cooking</td>
		</tr>
		<tr>
			<td>Charles</td>
			<td>28</td>
			<td>Cooking</td>
		</tr>
		<tr>
			<td>Charles</td>
			<td>28</td>
			<td>Cooking</td>
		</tr>
		<tr>
			<td>Charles</td>
			<td>28</td>
			<td>Cooking</td>
		</tr>
	</tbody>
</table>
```

## MD Contains the above table

<table>
    <thead>
        <tr><th>Name</th><th>Age</th><th>Hobby</th></tr>
    </thead>
    <tbody>
        <tr><td>Charles</td><td>28</td><td>Cooking</td></tr>   
        <tr><td>Charles</td><td>28</td><td>Cooking</td></tr>   
        <tr><td>Charles</td><td>28</td><td>Cooking</td></tr>   
        <tr><td>Charles</td><td>28</td><td>Cooking</td></tr>   
        <tr><td>Charles</td><td>28</td><td>Cooking</td></tr>   
        <tr><td>Charles</td><td>28</td><td>Cooking</td></tr>   
        <tr><td>Charles</td><td>28</td><td>Cooking</td></tr>   
    </tbody>
</table>

## HTML Lists

-   Two types of lists
-   **Ordered Lists**
    -   has a form of progression (1,2,3,4,5...)
    -   uses the \<ol>
-   **Unordereed Lists**
    -   doesn't have any progression (bullet)
    -   uses \<ul> tag
-   If you want to store elements in your list, use the \<li>
-   **NOTE**: You can nest lists

```html
<h1>To DO:</h1>
<ol>
	<li>Clean my room</li>
	<ul>
		<li>Make your bed</li>
		<li>Vacuum</li>
	</ul>
	<li>Make Dinner</li>
	<li>Keep everyone Sane for the week</li>
</ol>

<ul>
	<li>Clean my room</li>
	<li>Make Dinner</li>
	<li>Keep everyone Sane for the week</li>
</ul>
```

<h1>To DO:</h1>
<ol>
    <li>Clean my room</li>
    <ul>
            <li>Make your bed</li>
            <li>Vacuum</li>
        </ul>
    <li>Make Dinner</li>
    <li>Keep everyone Sane for the week</li>
</ol>

<ul>
    <li>Clean my room</li>
    <li>Make Dinner</li>
    <li>Keep everyone Sane for the week</li>
</ul>

## Semantic Elements

-   HTML5 added many semantic elements beyond what already exist
-   Elements tags are descriptive of what that tages is intended to do
-   Semantic Tags:
    -   \<section>
    -   \<article>
    -   \<header>
    -   \<footer>
    -   \<summary>
-   Non-Semantic Tags:
    -   \<div>
    -   \<span
    -   \<a>
-   HTML5
    -   \<video>
    -   \<audio>

## HTML Forms:

-   HTML has built in functionality for forms
    -   Forms take various inputs and the submit them tto a server or handle them via javascript
-   Input attributes
    -   text field
    -   password - prevents that input from being display
    -   checkboxes - select mul;tiple options for a field
    -   submit buttons
    -   actions
    -   targets
-   \<label> that can be used to give a text label to the input
    -   in a form you can have multiple inputs, use labels to separate them.
