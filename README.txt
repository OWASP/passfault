Welcome to OWASP Passfault
Objective: Do Passwords Better


Running the Command-line Interface:
1) install java
2) `cd core`
3) `gradlew installApp`
4) run `build/install/core/bin/core`
(builds and tests the core, applet, and jsonService)

Running the jsonWebService:
1) cd jsonService
2) `gradlew build jettyRunWar`
3) browse to localhost:8080/jsonService
Note the war will be located in jsonService/build/lib/passfault-jsonService-[version].war

Running the applet:
The applet will be located in applet/build/lib/passfault-applet-[version].jar.  Inside the jar file are a sample html, css, javascript, and jnlp file.  Extract these files and tweak to your purpose.

License: Passfault is licensed under Apache 2.0 license, and is a project at OWASP, the Open Web Application Security Project, a non-profit organization dedicated to building security tools and learning resources.
