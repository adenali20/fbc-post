FROM openjdk:17-jdk-alpine
EXPOSE 8082

ADD target/fbc-post.jar fbc-post.jar
ENTRYPOINT ["java","-jar","/fbc-post.jar"]

#FROM maven
#WORKDIR /app
#COPY . .
#
#RUN JAVA_HOME="/usr/lib/jvm/open-jdk"

#RUN mvn install

#EXPOSE 8081

#CMD ["java","-jar","mvn1.0.0.2.jar"]
#LABEL authors="Adesh"
#
#ENTRYPOINT ["top", "-b"]

