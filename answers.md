Q1: The purpose of .gitignore is to let
git know which files it can ignore. This prevents
things such as temporary files to be updated
into the project.

Q2: The gradle build the program. Build.gradle define tasks and dependency.

Q3: The purpose of Travis-CI is to allow for continuous integration. Instead of merging a large change at the end of development, this allows us to merge small pieces of code more frequently.
It run the test and build automatically. It sends the result of test to all developer.

Q4: The route is request of client.
EX "http://localhost/4567/hello" lead to "Hello World" message.

Q5: umm3601 server class get request from client by route function, then return the information (response) that client requested. 
The purpose of the umm3601.user.UserController class is to handle user requests and return a JsonObject depending on the the arguements given.

users: Returns the users.html page with a input box for age to return the users that are that old.

api/users: Returns users.json as a webpage

api/users?age=25: Returns users.json with the arguements age=25 applied. This gives the JsonObject with two people.

api/users/588935f5de613130e931ffd5: Return users.json with "588935f5de613130e931ffd5" ID person data.

