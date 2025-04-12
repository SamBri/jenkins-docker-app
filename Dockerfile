# let us use an os virtualized instance that supports java 17.
FROM openjdk:17-slim


# setup ownership
MAINTAINER codefilmsplc


# move the jar file into the vos.
COPY target/jenkins-docker-app jenkins-docker-app.jar

# start in the vos.
ENTRYPOINT ["java","-jar","jenkins-docker-app.jar"]