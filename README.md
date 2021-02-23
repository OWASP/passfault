# Welcome to OWASP Passfault
### Objective: Do Passwords Better!
NOTE: This project has been discontinued, but the zxcvbn project has a very similar approach and has been quite successful.  We recommend using that library.

## Running the Command-line Interface:
1. install java 8 jdk
2. `cd commandLine`
3. `../gradlew installDist`
4. run `build/install/passfault/bin/passfault`


## Running the jsonWebService:
1. cd jsonService
2. `../gradlew build jettyRunWar`
3. browse to localhost:8080/jsonService
Note the war will be located in jsonService/build/lib/passfault-jsonService-[version].war

## Running in Docker:
1. Pull the Passfault image: `docker pull ccaamm/passfault`
2. Create and run a passfault instance: `docker run -p 8080:8080 --name myPassfault ccaamm/passfault`
3. Browse to localhost:8080

License: Passfault is licensed under Apache 2.0 license, and is a project at OWASP, the Open Web Application Security Project, a non-profit organization dedicated to building security tools and learning resources.
