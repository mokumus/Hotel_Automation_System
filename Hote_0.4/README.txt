-Implemented some features of the ManagementSystem class.
-Resolved csv file issue.



Possible Problem
-If this system was an online service we could run into some issues like two different users booking the same room at
the same time because we only save the new data after user is done.

-A guest should be able to book 2 different rooms. This can be implemented but i approached this project as a mock-up to
show OOP design concepts so i don't think it's necessary for that purpose.


Flaws In Design
-Data fields of ManagementSystem class needs to be accessed by Guest and Receptionist classes, no problem here. But they
can't be inherit the ManSys. class because they are already children of User class. This caused some crowded arguments
in bookRoom() function etc.