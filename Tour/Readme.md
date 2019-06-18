# Automation testing of a flight_booking demo site
  * The aim of this testing is to check all the UI elements are visible and to get the count of those elements present in all the pages.<br/>
   * Then login credentials  should be entered in the page through an excel(i.e login_dataset.xlsx)

## Built with
  1. Apache poi 3.10 
  2. selenium jar 
  3. selenium chrome driver
  4. JAVA

## What this script does?

 * The selenium script ,initially starts the chrome driver and launches the url and the script checks the launched URL is correct or not and checks .

 * And then a count of images and input boxes will printed in console.

 * Then the by using Apache POI the username and password will be obtained from the login_dataset.xlsx file.

 * when it enters the second page it gets the title of the page and its length,URL,no of  dropdowns,no of radiobuttons,no of link-text,no of images
and prints the page tilte,source code with its length.

 * Then it gets all the options  in the dropdowns and prints those options in the console.

 * Next it goes to the select flight details and it goes to the Book a Flight page then it enters the details in all the UI elements and then again it gets all the options  in the dropdowns and prints those options in the console,no of radiobuttons,no of link-text,no of images and prints the page tilte,source code with its length.
 
 * Finally it closes the browser.
