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
- Class "Report": a special Model type class, an abstract class for 2 specific type of Report: ReportLead and ReportInteraction.
  1. ReportLead will deal with Lead and ReportInteraction will deal with Interaction respectively. The actual data will be instances of ReportData class
  2. .getOutput() will return an arrayList of ReportData. The formation of ReportData arrayList depends on the command of the constructor.

## What to do?
- Finish the parts with the comment "implements" and your name next to it (Member: ...)

## I think this is wrong! I need help? I dont understand the system? Algorithm? Java knowledge?
- Ask Minh or Dat
