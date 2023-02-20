FROM ibmjava:8-jre
COPY target/jpa-demo-0.0.1-SNAPSHOT.jar jpa-demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/jpa-demo-0.0.1-SNAPSHOT.jar"]