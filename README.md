#  Client Scheduling Application

## Description

Client scheduling application for consultant use. Each user will have a login ID and password. Use your login ID and password to gain access to the application.
The login screen supports multiple languages, currently English and French, with ability to add more.

Upon login, user will be greeted by the main menu view, where you can view/modify/delete all appointments, view appointments upcoming in the next week or month, all customers, as well as generate all reports.
If there are any appointments within 15 minutes of the users login, an alert will appear notifying the user of the time, Appointment ID, and date.

Operations to the Customer and Appointment database can be completed using the "ADD", "MODIFY", and "DELETE" buttons for their respective operations.

The first is an appointment report by month and type. A count for all appointments of each type will appear, sorted by month.
The second is an appointment report by contact ID. A dropdown menu will appear with each Contacts ID, and upon selection the table will populate with the applicable appointments.
The third is an appointment report by customer name. A dropdown menu will appear with each Customer Name, and upon selection the table will populate with the applicable appointments.

User can exit the application with the logout button.

Both successful and failed user activity is logged to login_activity.txt.



### Dependencies

Java SE 17.0.5
OpenJFX 11.0
MySQL 8.0.25

### Installing

Clone the repository, make sure you're using the relevant Java SDK, JavaFX, and MySQL versions, then go to the Controllers folder and open JDBC. Change
the connection strings below to match your own MySQL database.
```
private static final String protocol = "jdbc";
     private static final String vendor = ":mysql:";
         private static final String location = "LOCATION";
             private static final String databaseName = "DATABASE_NAME";
                 private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
        private static final String driver = "DRIVER"; // Driver reference
        private static final String userName = "USER"; // Username
        private static String password = "PASSWORD"; // Password
        private static Connection connection = null;  // Connection Interface
```


## Authors
Zak Smith

## Version History
* 1.0
    * Initial Release











