# WhatsApp Message Sender

## Description
This program automates the process of sending messages on WhatsApp using Selenium WebDriver and Java. It uses a Chrome browser with a persistent user profile and reads contact information and message templates from external files.

---

## Features
- Sends personalized messages to multiple contacts via WhatsApp Web.
- Reads contact information from an Excel file.
- Supports message templates with customizable greetings and closings.
- Includes functionality for attaching and sending photos.

---

## Prerequisites

### Software and Tools Required:
1. **Java Development Kit (JDK)**:
   - Version 8 or higher.
   - [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

2. **Apache POI Library**:
   - For reading Excel files.
   - Add these dependencies to your project:
     - poi
     - poi-ooxml

3. **Selenium WebDriver**:
   - Used for automating browser actions.
   - Download the [Selenium WebDriver](https://www.selenium.dev/downloads/).

4. **ChromeDriver**:
   - Compatible with your installed Chrome browser version.
   - [Download ChromeDriver](https://sites.google.com/chromium.org/driver/).

5. **AutoIt** (Optional):
   - To handle file uploads (e.g., photos).
   - [Download AutoIt](https://www.autoitscript.com/site/autoit/).

### External Files Needed:
1. **Excel File**:
   - Contains contact details.
   - Format:
     | Phone Number | Name    | Full Name        |
     |--------------|---------|------------------|
     | 1234567890   | John    | John Doe         |

2. **Text File**:
   - Provides configurable paths and templates.
   - Format:
     ```
     # Path to the photo to send
     C:/path/to/photo.jpg

     # Path to the Excel file
     C:/path/to/contacts.xlsx

     # Greetings
     Hello %NOMBRE%
     Hi %NOMBRE%

     # Message body
     This is a test message sent using an automated tool.

     # Closings
     Regards,
     Sincerely,
     Thank you,
     ```

---

## Setup Instructions

### Step 1: Install Java and Configure Environment
- Install JDK and set the `JAVA_HOME` environment variable.

### Step 2: Add Required Libraries to the Project
- Download Apache POI libraries and Selenium WebDriver.
- Add these `.jar` files to your project build path.

### Step 3: Configure ChromeDriver
- Place the downloaded ChromeDriver executable in the same directory as your program or specify its location in the program code.

### Step 4: AutoIt Script (Optional for Photos)
- Create an AutoIt script named `uploadFile.au3` with the following content:
  ```
  ControlFocus("Open", "", "Edit1")
  ControlSetText("Open", "", "Edit1", $CmdLine[1])
  ControlClick("Open", "", "Button1")
  ```
- Compile this script into an executable file `uploadFile.exe`.

### Step 5: Prepare External Files
- Create an Excel file with contact details.
- Prepare a text file for paths and message templates as shown above.

---

## How to Use the Program

1. **Run the Program**:
   - Compile and execute the Java program.

2. **Login to WhatsApp Web**:
   - Scan the QR code to log in for the first time.
   - Ensure the Chrome profile directory is configured for persistent sessions.

3. **Verify Contacts**:
   - The program will read contact details from the Excel file.

4. **Message Sending**:
   - The program generates personalized messages for each contact and sends them via WhatsApp Web.

5. **Close the Program**:
   - Once all messages are sent, WhatsApp Web will remain open for manual use.

---

## Troubleshooting
- **Messages not delivered**:
  - Ensure the phone numbers are formatted correctly, including the country code.

- **Browser issues**:
  - Check if the ChromeDriver version matches the installed Chrome browser version.

- **File errors**:
  - Verify paths in the text file and ensure the Excel file format is correct.

---

## Notes
- Keep your Chrome browser updated.
- Use a dedicated WhatsApp account for testing to avoid potential bans.
- Ensure compliance with WhatsApp’s terms of service when using this tool.
