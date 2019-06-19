# Automation Test Script for newtours demo site
  * The aim of this test is to count and check all the webelements present in the webpages.<br/>
   * Then login credentials  will be entered in the page through an excel file(i.e login_dataset.xlsx).

## Built with
  1. Apache poi 3.10 
  2. selenium 3.9.1
  3. selenium chrome driver 75.0
  4. eclipse ide 2018-09
  5. JAVA

## What the script does?

 * The selenium script initially launches the browser and opens the URL. 
 * The script checks whether the launched URL is correct or not.

 * It counts number of images, input boxes and it will be printed in console.

 * Then by using Apache POI the username and password will be obtained from the login_dataset.xlsx file and enters into that particular text boxes.

 * when it enters the second page it gets the title of the page and its length,URL,no of  dropdowns,no of radiobuttons,no of link-text,no of images
and prints the page tilte,source code with its length.

* Next it identifies each webelements and sends the data.  

 * Then it gets all the options  in the dropdowns and prints those options in the console.

 * Next it goes to the select flight details webpage and it will click on the continue button and goes to Book a Flight page then it enters the details in all the UI elements and then again it gets all the options  in the dropdowns , no of radiobuttons, no of link-text, no of images, the page tilte,source code with its length and prints in the console.
 
 * Finally it closes the browser.
