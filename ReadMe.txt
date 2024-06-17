### Course link
https://youtu.be/F9UC9DY-vIU


### Install Kotlin compiler
sudo snap install --classic kotlin


### Compile & Run project
CHAPTER=01-variables && \
kotlinc $CHAPTER.kt -include-runtime -d $CHAPTER.jar && \
java -jar $CHAPTER.jar
