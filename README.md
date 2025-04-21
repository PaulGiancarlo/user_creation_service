# User create API REST
This project tries to show how to implement a REST API for user creation with java and springboot.

## Table of Contents
- [Design](##Design)
- [Build](##Build)
- [Usage](##Usage)
- [Contributing](#contributing)
- [License](#license)

## Design

### Create a User

![Shows the get user flow](C:\Users\paulg\OneDrive\Pictures\sequence_create_user_service.PNG) "Create user flow")

## Build

You will need to have java version 17 installed and maven configured to run the following:

1. Clone the repository:
    ```bash
     git clone https://github.com/PaulGiancarlo/user_creation_service.git
    ```
2. Build with maven:

    ```bash
    mvn clean install -X
    ```
## Usage

Run the following in the terminal:

```bash
    mvn spring-boot:run
```
Or you can use intellij to run using Actions like:
Execute maven goal and search for "spring-boot:run"

1. Database:
    Check your database using the user and password from the application properties here:
    ```bash
    http://localhost:8080/h2-console/
    ```
   ![DB interaction in local](C:\Users\paulg\OneDrive\Pictures\dbinteraction.PNG)
2. Test in you favorite API client to call the endpoint:
    Using REST API Client extension in vscode.

Create a User
![Create a User](C:\Users\paulg\OneDrive\Pictures\requestAndResponseOk.PNG)

Password Validation
![Password Validation](C:\Users\paulg\OneDrive\Pictures\passwordValidation.PNG "Password Validation")

Validations on Fields
![](C:\Users\paulg\OneDrive\Pictures\validationsOnFields.PNG "Validations on Fields")