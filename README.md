# zipCodeRestServer
A simple Java EE 7 REST Server that serves up basic information about a U.S. Zip Code.

The zip code file included was created from a CSV that was downloaded from this website:
http://www.unitedstateszipcodes.org/zip-code-database/

The code has been tested on Glassfish 4 and Wildfly.

To run this project on Apache Tomcat
1.  Edit the pom.xml
2.  Uncomment the dependancy on Jersey (The reference implementation of JAX-RS.  https://jersey.java.net )

