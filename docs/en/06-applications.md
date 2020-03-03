---
title: Exercise 6 - Build a leave request application
---

## Goal

The goal of this exercise is to build an application for users to create and manage their leave requests.

## Instructions overview

Open the UI Designer and create a new "Application page" named
"LeaveRequestStatus" to follow the progress of the connected user
leave request.

This page will contain one "multiple container" that list the on-going
leave requests. For each request, the start date, number of days and
status will be displayed.

Export the page as a zip file and deploy it in the portal using the
"Resources" menu of the "Administrator" view.

Create a new application. Then add the "LeaveRequestStatus" page in
the application.

Access the application using the generated URL.

Optional: Add a date widget and an input widget to collect new leave
request information in the page. Then add a submit button to start a new
leave request.

Step by step instructions
=========================

1. Create a new page:
   - In the Studio, click on the "UI Designer" button
   - Click on the "Create" button, select "Application page", set the name to: LeaveRequestStatus. Then click on "Create"
   - You should now be on the designer page

1. Add a title to your page:
   - Drag the widget Title (A) from the palette to the top of the page (B)
   - Select the widget. On the right panel, enter "Leave request application" in the "Text" field (C). Select "center" for alignment

1. Add another title below:
   - Name it "Leave request status"
   - Select "Level 4" from the Title level drop-down list
   - Select "center" for alignment

1. Create a variable to store the session information:
   - Click on "Create a new variable" and choose "External API" for the type
   - Name it "sessionInfo"
   - In the field API URL, enter:

    ``` {.xml}
    API/system/session/unusedId
    ```

1. Create a variable to list the leave request:
   - Click on "Create a new variable" and choose "External API"
   - Name it "leaveRequestStatus"
   - In the field API URL, enter: (no line break)
   ``` {.xml}
    API/bdm/businessData/com.company.model.LeaveRequest?q=findByRequestorId&p=0&c=100&f=requestorId={{sessionInfo.user_id}}
    ```
   - Be careful when you copy/paste the URL that there is no whitespace left

1. Define a new JavaScript expression to prepare the list:
   - Click on "Create a new variable" and choose "JavaScript expression"
   - Name it "updateLeaveRequestStatus"
   - Replace the existing value with the following script:

    ``` {.javascript}
    XINCLUDE-ERROR
    ```

1. Create a multiple container:
   - Drag the widget container from the palette and place it below the Title "Leave request status"
   - Select the container and on the right panel, enter "leaveRequestStatus" in the field "Collection"

1. Add 4 widgets in the container:
   - One "Input" widget with the following options:

      -----------------------------------------------------------------------
      Property                Value
      ----------------------- -----------------------------------------------
      Width                   3

      Read-Only               Yes

      Label                   Num

      Value                   \$index + 1
      -----------------------------------------------------------------------

    One "Date picker" widget with the following options:

      -----------------------------------------------------------------------
      Property                Value
      ----------------------- -----------------------------------------------
      Width                   3

      Read-Only               Yes

      Label                   Start date

      Value                   \$item.leaveStart

      Show Today button       no
      -----------------------------------------------------------------------

    One input widget with the following options:

      -----------------------------------------------------------------------
      Property                Value
      ----------------------- -----------------------------------------------
      Width                   3

      Read-Only               Yes

      Label                   Number of days

      Value                   \$item.dayCount
      -----------------------------------------------------------------------

    One "Input" widget with the following options:

      -----------------------------------------------------------------------
      Property                Value
      ----------------------- -----------------------------------------------
      Width                   3

      Read-Only               Yes

      Label                   Status

      Value                   \$item.isApprovedLabel
      -----------------------------------------------------------------------

   - Save the page. The page should look like this:
   - You can preview the page at anytime by clicking on preview
   - **Tip:**If you are logged in the Portal in the same browser, the current leave request will be displayed.

1. Export the page:
   - Click on the export button ![](resources/screenshots/ex6_09.png) to download the page in ZIP format

1. Import the page in the Portal:
   - Log in the Bonita Portal with a Administrator user
   - Change the profile to "Administrator". Go to Resources tab
   - Click on the button "Add" (A)
   - Select (B) the ZIP file and click on Next. Then confirm on the next screen
   - The page should now be available in the Pages list

1. Create a new application:
   - In the Portal, navigate to the Applications tab
   - Click on New
   - Enter "Leave request app" in the field "Display name" (A)
   - Enter "leave-request" in the field "URL" (B)
   - Leave the defaults value for the Version (C) and Profile (D)
   - Click on "Create" to create the application
   - Click on "..." to access the configuration page.
   - Find the Pages section on the bottom left part of the screen and
   - Click on "Add"
   - Select the page LeaveRequestStatus and enter "status" in the URL field.
   - Define the leaveRequest page as the homepage by clicking on the "house" icon ![](resources/screenshots/ex6_11.png).
   - Once done, click on the trash icon ![](resources/screenshots/ex6_12.png) to delete the default homepage
   - The configuration page should now look like that:
   - Click on the link "apps/leave-request" to load the application
   - At this point, the exercise is done. However, if you have more time you can follow the next steps to add more features to your application

1. Add a new form container.
   - Go back to edit your page in the UI Designer
   - Drag a form container from the palette and place it between the two titles

1. Create a new variable to store the new leave request values:
   - Click on "Create a new variable" and choose "JSON"
   - Name it "formInput"
   - Enter the following script in the value text field:

    ``` {.json}
    XINCLUDE-ERROR
    ```

1. Create a new variable to store the process information:
   - Click on "Create a new variable" and choose "External API"
   - Name it "processDefinitionInfo"
   - In the field API URL, enter: (no line break)

    ``` {.xml}
    API/bpm/process?p=0&c=100&o=version%20DESC&f=name=LeaveRequest
    ```
   - Be careful when you copy/paste the URL that there is no whitespace left

1. Add 2 widgets in the form container:
   - One date picker widget with the options: Width: 6. Value: formInput.requestInput.leaveStart. Label: Leave start date
   - One input widget with the options: Width: 6. Value: formInput.requestInput.dayCount. Label: Number of days

1. Add a submit button in the form container:
   - Drag the button widget from the palette and place it in the form
   - container below the two widgets
   - Enter "Create a new request" in the field Label
   - Select POST in the Action drop-down list
   - Click on "fx" to switch the "Data sent on click" field mode and then enter "formInput"
   - In the field URL to call, enter:
    ``` {.xml}
    API/bpm/process/{{processDefinitionInfo[0].id}}/instantiation
    ```
   - In the field Target URL Success, enter:
    ``` {.xml}
    /bonita/apps/leave-request
    ```
   - Save the page
   - The page should look like that:
   - You can preview the page to make sure it works as expected.

1. Update the page in the portal:
   - Export the updated page
   - Log in the portal and edit the previous page
   - Select the new zip file
   - Refresh your application, the change should be visible
