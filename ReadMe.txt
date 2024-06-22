### Course link
https://youtu.be/F9UC9DY-vIU


### Install Kotlin compiler
sudo snap install --classic kotlin


### Compile & Run chapter
CHAPTER=05-classes && \
if [[ -d $CHAPTER ]]; then \
kotlinc $CHAPTER/* -include-runtime -d out/$CHAPTER.jar; else \
kotlinc $CHAPTER.kt -include-runtime -d out/$CHAPTER.jar; fi && \
java -jar out/$CHAPTER.jar
