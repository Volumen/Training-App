# Training-App
This is my biggest project - training management application. 
I had two goals when creating this application.

First - create a working application in which the user can conduct training together with the application.

Second - make the most of Spring Boot related issues to learn as much as possible and gain experience.

## Technologies used: 
  - Spring Boot 
  - Spring Security - responsible for logging in, logging out and access to application resources. An unlogged person has access to specific subpages
  - JPA and Hibernate - responsible for object mapping and sending queries to the database
  - MVP - an architectural model that was used in the application with the help of vaadin
  - HTTP client - is responsible for downloading several "workout" themes and randomly displays one each time you enter the home page
  - AOP - responsible for sending an email after training
  - Vaadin - the appearance of the application
  - MySQL - database
## Application:
**Home Page** - there are 3 buttons available for a non-logged user and a random "workout" photo.

<img src="https://i.imgur.com/0NACxAY.jpg" width="80%">

**Registration**

<img src="https://i.imgur.com/yboSdEK.jpg" width="80%">

**Login**

<img src="https://i.imgur.com/Hcr04xE.jpg" width="40%">


**Main Page as an Admin** - more available buttons.

<img src="https://i.imgur.com/53yU6ZP.jpg" width="80%">

**Admin Panel** - Admin can manage all users

<img src="https://i.imgur.com/AmqGwZQ.jpg" width="80%">

**User profil seen as Admin and User** 

<img src="https://i.imgur.com/Y81OWFD.jpg" width="300"> <img src="https://i.imgur.com/HWeHgAL.jpg" width="300">

**Training** 

<img src="https://i.imgur.com/oWumjJG.jpg" width="80%">

After choosing a workout you will see detailed information about it:

<img src="https://i.imgur.com/G9QSGeY.jpg" width="60%">

Training has started, here is the first exercise:
<img src="https://i.imgur.com/abzft21.jpg" width="80%">

As you can see, you can choose training, all information about it is posted.
After choosing the workout, we see the first exercise that is described and illustrated with a gif. After completing the exercise, press "ok" and another one appears until the end of the workout. After the training, an email is sent to the address where the user has registered with congratulations and training summary.

## Summary
I realize that a lot of things may not work well or it may be done better. I created this project to improve my skills, in my free time I try to improve the functionality of this application. I have a lot of ideas for expanding this project.
