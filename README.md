I have automated different functionalities of the demo testing website Luma Fashion using TestNG and listeners that create an HTML report.

On Eclipse, I created 3 packages with 1 class on each package:

● com.utils package
○ POMRepo class 
Repository with all of the string variables and locators.

● com.test.exec package 
○ LumaFashion TestNG class 
The browser is initiated, and eight tests are created to: open the web app (starts the browser and connects to the URL page), for the registration flow (fills in all the registration fields for a fake email), for invalid logins with respective error messages on the console (incorrect password, blank password, unregistered email, blank email), for the search product flow (searches for a yoga hoodie), and for the add to cart automation (selects the size and color of the chosen product, adds it to cart and inspects it on the checkout page, when it prints out that the add to cart flow has been successful).

● com.listener package 
○ MyListener class I implemented the interface ITestListener to this class, in order to define the listener events from start to finish of my test script. On the method onStart, I created my reporter instance through ExetentsparkReporter. Then I created a new instance of my ExtentReports, and finally attached my reporter to my extent report object with the help of attachReporter.

Moving forward to the onTestStart method, which on the start of each test creates a new ExtentTest object, with the help of my ExtentReports object along with the createTest method. It then prints out the test name that was just created.

From here on, the methods will be called according to the test result (pass, fail or skip). The onTestSuccess method calls my ExtentTest object with the pass method, and prints it out. The onTestFailure method calls my ExtentTest object with the fail method, and prints it out. And the onTestSkipped method calls my ExtentTest object with the skip method, and prints it out.

Finally, the onFinish method flushes the results into the html report.
