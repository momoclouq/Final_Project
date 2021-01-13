## How to work
1. Pull the new changes (Git -> Pull)
2. Working on the project
3. Once finish, Create a pull request (Git - > Github -> Create a Pull request)
4. Message Minh to inform the Pull request

## Explanation
- Class "Controller": control the system, contains the Models (Lead, Interaction, Report) and uses helping classes (Validation, FileControl, View) for managing the system.
  Based on the current location:
  1. Use view (Class View) to show initial words explaining the situation
  2. Use validate (Class Validation) to get the processed input from the user (looping if necessary)
  3. Turn the processed input to proper data 
     -> executes proper methods (including saving the input to the data stored in the Controller and update the file using FileControl)
  4. move to the next location
- Models: Class "Lead", class "Interaction" and "Report" are the data and will be updated during the program's execution
- Class "View": Show the output to the console and return required input (validated by "Validation" class), which will be moved to the Controller for processing
- Class "Validation": check the String input from the console and return the processed data from the input
- Class "FileControl": update the file based on the data stored in the Controller, initialize the data in the Controller at the start of the program
- Interface "Data": to indicate polymorphism with Lead and Interaction class for the method "toFileFormat": write the Data to the file

## What to do?
- Finish the parts with the comment "implements" and your name next to it (Member: ...)

### What is the basic flow? What should I do in class A,B,C? What do you mean implement method ABC in class D?
**Basic flow:**
1. method start() in Controller will start the program -> run a loop, the loop will continuously change the current "location" of the program to indicate what to do
2. In each location, the Controller then will ask/inform the user of what to do and ask for input from the user (using the methods in View class) 
3. In the method in the View class, The method will first show the texts needed (instructions for the user to follow) and use Validation class's methods to get the "correct" input (input in correct format, if incorrect -> ask the user to enter the input again)
4. After getting the required data (String, int, Calendar, etc) from the method of the View class, the Controller will process that data using its database (the lists of Leads and Interaction stored inside Controller itself)
5. After the data in the Controller is updated, that updated data (list) will be written to the file using FileControl
6. We now can decide to show a "successfully done" message using methods in the View class or just continue to the next operation
7. change the location and repeat this process

**What methods in ... class do?**
- Controller: use the methods in View, update the data, use methods in FileControl to update the file
- View: ask the user for input, showing correct format for input, use methods in Validation, show output if necessary
- Validation: get input from user, check if input is correct, ask the input again if not, return the "correct" input
- FileControl: update the changes in the data to the file (write the whole list of Data to the file)

## I think this is wrong! I need help? I still dont understand the system? Algorithm? Java knowledge?
- Ask Minh or Dat