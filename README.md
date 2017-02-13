# Welcome to OWASP Passfault
### Objective: Do Passwords Better!


## Running the Command-line Interface:
1. install java 8 jdk
2. `cd core`
3. `../gradlew installDist`
4. run `build/install/core/bin/core`


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
