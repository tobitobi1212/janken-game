FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY JankenGame.java .
RUN javac JankenGame.java
CMD ["java", "JankenGame"]
