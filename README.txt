Welcome to OWASP Passfault
Objective: Do Passwords Better


Building:
1) install gradle and java
2) run 'gradle build'
(builds and tests the core, applet, and jsonService)

Running the command line:
java -jar core/build/lib/passfault-core-[version].jar

Running the jsonWebService:
1) cd jsonService
2) gradle build jettyRunWar
3) browse to localhost:8080/jsonService
Note the war will be located in jsonService/build/lib/passfault-jsonService-[version].war

Running the applet:
The applet will be located in applet/build/lib/passfault-applet-[version].jar.  Inside the jar file are a sample html, css, javascript, and jnlp file.  Extract these files and tweak to your purpose.

License: Passfault is licensed under Apache 2.0 license, and is a project at OWASP, the Open Web Application Security Project, a non-profit organization dedicated to building security tools and learning resources.
