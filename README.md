# Vehicle Management System
A vehicle management system to enable better interaction between Customers and Dealers. Designed using Eclipse WindowBuilder in Java. Part of my Semester 3 OOPM Project. Made in October 2019.

### About:
Dealers can add and delete their own vehicles and also manage requests sent by Customers for a particular Vehicle. Customers on the other hand can view and find vehicles and then choose to order any vehicle they want. If order is accepted by Dealer then they can purchase the vehicle. Normal users can also view all the vehicles in the system. Dealer and Customer can delete or view their account at anytime using login and signup system. Current implementation does not include any database or file based storing system, so all data added will be closed when application is closed.

### Implementation Details:
*	We implement Java Applets and packages to design the system.
*	We implement 2 separate files Dealer and Customer which consist of their information (InfoDealer, InfoCustomer) and vectors to store them.
*	We also create file Vehicle to store vehicle information (InfoVehicle), status and ownership in vectors as well.
*	We have implemented Admin control system to manage all these vectors properly.
*	We use login and signup system to create and manage the dealer and customers.
*	Details class is created as parent class for InfoDealer and InfoCustomer to inherit attributes of information.
*	We use JPanels in the applet to switch between different functions in the same window.
*	We use JTables to display all the information is a neat format.
*	Sorting system in vehicle table to find desired vehicle easily.

#### Default User
```
username: admin
password: admin
```

### Screenshots:
![Main-menu](Screenshots/Main%20Menu.png?raw=true)

![Login-menu](Screenshots/Login%20Menu.png?raw=true)

![View-vehicles](Screenshots/View%20and%20Order%20Vehicles.png?raw=true)

![Dealer-menu](Screenshots/Dealer%20Menu.png?raw=true)
