---
title: Exercise 3 - Creating forms
---

## Goal

The goal of this exercise is to provide user friendly forms for the execution of the process.

## Instructions overview

Duplicate the process diagram from the previous exercise to create a 2.1.0 version.

Create the following forms:
- A case instantiation form at pool level that sets the "leaveStart" and "dayCount" data
- A form for the "Validate request" task that displays the "requestor" user details, the "leaveStart" and "dayCount" data in read-only mode and that sets the "isApproved" data

## Step by step instructions
1. Duplicate the process diagram from the previous exercise to create a 2.1.0 version

1. Create a case instantiation form:
   - Select the process pool, and navigate to the "Execution / Instantiation form" tab
   - Click on the pencil next to the Target form input
   - This will open the UI Designer in a browser with a form automatically generated from your instantiation contract

1. Rename the form:
   - Use the text field on top of the screen to rename the form into "fillLeaveRequest" (this is a technical name so it should not contain spaces or special characters)
   - Click on "Save"

1. Update the form title
   - Select the top most widget "Request Input"
   - In the section on the right edit the following properties:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Text           Fill a new leave request

      Text level     Level 2

      Alignment      Center
      -----------------------------------------------------------------------

1. Update the "Day Count" widget
   - Select the "Day count" widget and edit the following properties:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Label          Number of days

      Placeholder    Number of leave days

      Min value not to be confused with the "Value min length" property   1
      -----------------------------------------------------------------------

1. Clear the initial form values (this will show the placeholders at runtime)
   - In the lower "Variables" section, click on the "Pencil" icon for the "formInput" variable
   - Replace the JSON values with this:

    ``` {.json}
    XINCLUDE-ERROR
    ```

1. Add a variable to store potential form submit errors:
   - In the lower "Variables" section, click on "Create a new variable"
   - Set the variable name to "error", leave its type to "String" and it value empty then click on "Save"

1. Update the "Submit" widget
   - Set the "Failed response value" property to "error" (this will store the submit errors in the variable "error" if any)

1. Dynamically display the error**
   - Drag a "Text" widget from the palette and drop it under the "Submit" button
   - Set the "CSS classes" property to "text-danger"
   - Click on the "binding" icon ![](resources/screenshots/ex3_04.png) next to the "Hidden" property
   - Enter the following content in the text field that just appeared (this display the widget only when there is an error):

    ``` {.javascript}
    !error
    ```

   - Replace the "Text" property with the following content:

    ``` {.html}
    XINCLUDE-ERROR
    ```

1. Check the form's appearance:
   - Make sure that the form looks like this in the editor:
   - Click on the "Save" button.
   - Click on the "Preview" button.
   - The form should look like this:
   - Verify the following points:
     - The widget presenting the error is not visible
     - The "Submit" button is disabled by default (this is due to the validation provided by the form container)
     - The "Submit" button is enabled when the form is valid
     - **Note:** the form cannot be submitted from the preview mode even if it is valid.
   - Close the preview window.

1. Create a form for the "Validate request" task:
   - In the Studio, select the "Validate request" task and navigate to the "Execution / Form" tab
   - Click on the pencil next to the Target form input to open a new form in the UI Designer

1. Rename the form
   - In the UI Designer, rename the form into "validateLeaveRequest" and save it

1. Remove unnecessary variables:
   - In the lower "variables" section of the screen, remove the following variables:
    - formInput
    - formOutput

1. Retrieve business data from the ongoing request
   - Click on the "Create a new variable" button and configure the variable with the following properties:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Name           request

      Type           External API

      API URL        {{context.request\_ref.link}}
      -----------------------------------------------------------------------

    **Note:** here, we are calling the Bonita REST APIs to fetch our
    "request" business variable value. We are using the "context"
    variable that exposes links to the process instance business
    variables including our request in the form of "request\_ref". We
    can then retrieve the request thanks to the "link" attribute which
    provides the URL that needs to be called to retrieve the object.

1. Retrieve the requestor's user data
   - Create a new variable with the following properties:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Name           requestor

      Type           External API

      API URL        API/identity/user/{{request.requestorId}}
      -----------------------------------------------------------------------

1. Add a variable for error handling:
   - Create a new variable named "error", leave its type to "String" and its value empty then save it

1. Remove the "Is Approved" checkbox and the "Submit" button:
   - Select the Form container that contains the checkbox and button widgets, then delete it by using the X button that appears when hovering over the container with the cursor.

1. Modify the form title:
   - Select the existing "Title" widget and configure it as following:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Text           Validate a leave request

      Title level    Level 2
      -----------------------------------------------------------------------

1. Add a widget to display the requestor:
   - Drag an "Text" widget from the palette and drop it on a new row under the form title
   - Configure the widget as following:

      -----------------------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------------------
      Text           `<b>Requestor: </b>{{requestor.firstname}} {{requestor.lastname}}`

      -----------------------------------------------------------------------------------

1. Add a widget to display the leave start date:
   - Drag an "Text" widget from the palette and drop it under the requestor widget
   - Configure the widget as following:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Text           \<b\>Leave start date: \</b\>{{request.leaveStart \|
                     date : 'dd/MM/yyyy'}}

      -----------------------------------------------------------------------

1. Add a widget to display the number of days:
   - Drag an "Text" widget from the palette and drop it on a new row under the "Leave start date" widget
   - Configure the widget as following:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Text           `<b>Number of days: </b> {{request.dayCount}}`

      -----------------------------------------------------------------------

1. Add a form container:
   - Drag an "Form container" widget from the palette and drop it on a new row under the "Number of days" widget

1. Add a widget to reject the request:
   - Drag a "Button" widget from the palette and drop it in the form container (highlight with a dashed border)
   - Configure the widget as following:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Width          6

      Label          Reject

      Alignment      right

      Style          danger

      Data sent on   { "requestInput" : {"isApproved" : false} }
      click          

      Failed         error
      response value 

      Target URL on  /bonita
      success        
      -----------------------------------------------------------------------

1. Add a widget to approve the request:
   - Drag a "Button" widget from the palette and drop it on the "6 column" zone located on the right of the "Reject" button
   - Configure the widget as following:

      -----------------------------------------------------------------------
      Property       Value
      -------------- --------------------------------------------------------
      Label          Approve

      Style          success

      Data sent on   { "requestInput" : {"isApproved" : true} }
      click          

      Failed         error
      response value 

      Target URL on  /bonita
      success        
      -----------------------------------------------------------------------

1. Dynamically display potential submit errors:
   - Drag a "Text" widget from the palette and drop it on a new row at the bottom of the form
   - Set the "CSS classes" property to "text-danger"
   - Click on the "binding" icon ![](resources/screenshots/ex3_04.png) next to the "Hidden" property
   - Enter the following content in the text field that just appeared (this display the widget only when there is an error):

    ``` {.javascript}
    !error
    ```
    - Replace the "Text" property with the following content:

    ``` {.html}
    XINCLUDE-ERROR
    ```

1. Check the form's appearance
   - Make sure that the form looks like this in the editor:

1. Save the form
   - Use the top "Save" button to save the form

1. Test the process execution
   - Run the process from the Studio and execute all of its steps
   - Validate that the proper execution path was taken at the end of process execution by looking at the case history in the Bonita Portal
