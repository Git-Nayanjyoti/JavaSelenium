package Basic;

public class XpathDemo {

	/*
	 * XPath:
	 * XML path used for navigation throught the DOM
	 * or HTML Structure
	 * its a syntax used to find an element
	 * 
	 * Syntax:
	 * xpath = //tagName[@attribute = 'value']
	 * 
	 * Types of XPath:
	 * Absolute: 
	 * direct way to find an element
	 * 
	 *	/body/div[2]/input
	 * body
	 * 	div
	 * 	div
	 * 		input 2
	 * 	div
	 * 		input 1
	 * 	div
	 * 
	 * Relative
	 * starts with 2// and finds anywhere
	 * 
	 * Basic Xpath://tagName[@attribute = 'value']
	 *	username = //input[@id = 'email']
	 *
	 *Contains
	 *	//input[contains(@name, 'txt')]
	 *
	 *	tagName
	 *	By.tagname("a")
	 *
	 *	get all the links on the page and print the text
	 *
	 *	AndOR
	 *	QA" displayed as txtUsername
	 *	prod displayed as username 
	 *
	 *
	 *	//input[@name = 'txtUsername']]
 	*	//input[@name = 'txtUsername' or @name = 'userName']
	 *	
	 *
	 *Starts with
	 *	//input[starts-with(@id,'txt')]
	 * 
	 * text()
	 * 
	 * //button[text() = 'Log In']
	 * 
	 * XPATh Axes
	 * 
	 * 	1	A
	 * 	2	B
	 * 	3	D
	 * 	4	E
	 * select 3 checkbox and delete >> D
	 * 1	A
	 * 	2	B
	 * 	3	C
	 * 	4	D
	 * 	5	E
	 * select 3 checkbox and delete >> c
	 * 
	 * first identify the user to be deleted
	 * then select the corresponding checkbox
	 * 
	 * XPATh Axes
	 * 
	 * Parent
	 * to go to parent //a[text()='Ananya']//parent::td
	 * Child //a[text()='Ananya']//parent::td//parent::tr/td[2]
	 * //a[text()='Ananya']//parent::td//parent::tr//child::td[1]
	 * Siblings
	 * 	Preceding //a[text()='Ananya']//parent::td//preceding-sibling::td/input
	 * 	following //
	 * 
	 * Ancestor
	 * //a[text()='Ananya']//ancestor::tr/td[1]
	 * 
	 * 
	 * Task 1:
	 * get all the links on the page and print the text
	 * delete a user where name is ananya
	 */
}