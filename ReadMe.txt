### Course link
https://youtu.be/F9UC9DY-vIU


### Install Kotlin compiler
sudo snap install --classic kotlin


### Compile & Run project
PROJECT_NAME=Main && \
kotlinc $PROJECT_NAME.kt -include-runtime -d $PROJECT_NAME.jar && \
java -jar $PROJECT_NAME.jar
