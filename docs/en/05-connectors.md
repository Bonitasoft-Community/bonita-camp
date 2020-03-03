---
title: Exercise 5 - Using a connector to send an email
---

## Goal

The goal of this exercise is to demonstrate an interaction between Bonita and an external system with the use of a connector. In this context, we will notify the leave request initiator about his request status with an email connector.

> **Warning**
>
> Depending on your network configuration, your firewall or the security settings of your email server you may not be able to send an email from Bonita.
>
> In order to get rid of those technical constraints, we will use a program that simulates an email server (FakeSMTP).

## Instructions overview

Obtain and start the FakeSMTP server.

Duplicate the process diagram from the previous exercise to create a 3.1.0 version.

Add an email connector on the "Notify request approved" and "Notify request rejected" service tasks. These will send an email to the requestor with the request validation status.

The following code will be used to retrieve the requestor's email in the connector:

``` {.java}
XINCLUDE-ERROR
```

## Step by step instructions

1. FakeSMTP setup:
   - Download FakeSMTP from this link: <http://nilhcem.github.com/FakeSMTP/downloads/fakeSMTP-latest.zip>
   - Unzip the file and run FakeSMTP by either double-clicking on the JAR file or running this shell command: ` {.shell} java -jar fakeSMTP-2.0.jar `
   - Once the user interface is displayed, set the listenning port to 2525 and click on the "Start server" button

1. Duplicate the process diagram from the previous exercise to create a 3.1.0 version

1. Test the email connector to obtain the right SMTP configuration:
   - Navigate to the "Development / Connectors / Test connector" top menu.
   - Select the "Email (SMTP)" connector by using either the text filter or the "Messaging" category and click on "Next".
   - Set these connection parameters (username and password remain empty):
   -----------------------------------------------------------------------   Property                Value   ----------------------- -----------------------------------------------   SMTP host               localhost
   SMTP port               2525 (the port number specified in FakeSMTP)
   SSL (in the             unchecked   "Security" section)      -----------------------------------------------------------------------
   - Click on "Next"
   - Enter some email addresses (not necessarily existing addresses) in the "From" and "To" fields and click on "Next"
   - Enter "Bonita test" as the subject, click on the "Test" button and confirm the test without checking any dependency
   - At this stage, you should get a message similar to this one:
   - Make sure that the email is received by FakeSMTP as shown below:
   - Once the configuration is valid, click on ![](resources/screenshots/ex5_02.png)
   - Name the configuration "emailConfig" and save it
   - Close the connector test interface

1. Add an email connector on the "Notify request approved" task:
   - Select the task, navigate to the "Execution / Connectors in" tab and click on "Add..."
   - Select the "Email (SMTP)" connector and click on "Next"
   - Name it "sendRequestApprovedEmail" and click on "Next"
   - Do not fill in the parameters but click on ![](resources/screenshots/ex5_03.png)
   - Select the "emailConfig" and move to the "Email addressee" configuration page
   - Enter "hr@acme.com" in the "From" field
   - Use the "pencil" icon to edit the expression of the "To" field
   - Set the "Expression type" to "Script", name the script "getRequestorEmail" and paste the following in the code edition zone:
 ``` {.java} XINCLUDE-ERROR ```
   - Move to the next page and set "Leave request approved" as the subject
   - Click on "Finish"

1. Add an email connector on the "Notify request rejected" task:
   - Repeat the previous steps by naming the connector "sendRequestRejectedEmail" and setting "Leave request rejected" as the subject
   - Alternatively you can use the feature that let you create a copy of an already configured connector and add it to another task

1. Test the process:
   - Execute the process twice to test the different paths and check that FakeSMTP receives the right emails
