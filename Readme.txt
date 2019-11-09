Test 3:

There are two methods to POST information from rebels using two different endpoints.
/api/addRebel and /api/addRebelList
One of them accepts a List of Strings (as required) and I decided to implement another one
which -for me- makes more sense, that accepts a JSON format with name:-- , planet: -- 

!!Both endpoints works whatever you send (List or json) but make sure you choose the correct endpoint 
so it calls the correct method to read a list or a json format. Otherwise it will save rebels as null!!

Also, I decided to implement a method that read and return the information from Rebels... /api/getRebelInfo
since it would'nt be usefull at all if we can't do that...

Logs are working correctly, saving INFO, WARNING, ERRORS and creating a new file each day.

Both (Logs and Rebel info) are saved on the main project folder.

It's my first time setting up a Log workflow from scratch for a project so probably I've missed some 
configuration.


For the Unit Testing I started by doing some manual test, testing the methods I created,
but not as an API. I found out the MockMvc which seems a much better approach and I dived into it refactoring 
the testing methods. But it seems I'm missing something to make it work and I will need a few hours of study.

Since it's supposed to have an hour or two to complete the test, I think
it's fair to accept I did not solved the problem at 100% into that time.
I will check out deeper how to Mock an MVC these next days. I think It was pretty close!!
 