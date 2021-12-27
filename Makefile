SOURCEPATH := src/
ifeq ($(OS),Windows_NT)
	CLASSPATH := "src/;ini4j-0.5.2/ini4j-0.5.2.jar;ini4j-0.5.2/ini4j-0.5.2-jdk14.jar"
else
	CLASSPATH := src/:ini4j-0.5.2/ini4j-0.5.2.jar:ini4j-0.5.2/ini4j-0.5.2-jdk14.jar
endif
BUILDPATH := build/

JARFILE := RouteTwo.jar

SOURCES := $(wildcard src/*.java)

JAVAC_FLAGS := -classpath $(CLASSPATH) -sourcepath $(SOURCEPATH) -d $(BUILDPATH)

all: jar

jar: classes explode_ini resources
	jar cef Main $(JARFILE) -C $(BUILDPATH) .

classes: $(SOURCES)
	mkdir -p $(BUILDPATH)
	javac $(JAVAC_FLAGS) $(SOURCEPATH)/Main.java

explode_ini: ini4j-0.5.2/ini4j-0.5.2.jar ini4j-0.5.2/ini4j-0.5.2-jdk14.jar
	unzip -o -d $(BUILDPATH) ini4j-0.5.2/ini4j-0.5.2.jar
	unzip -o -d $(BUILDPATH) ini4j-0.5.2/ini4j-0.5.2-jdk14.jar
	rm -rf $(BUILDPATH)/META-INF

resources:
	cp -r $(SOURCEPATH)/resources $(BUILDPATH)

clean:
	rm -rf $(JARFILE)
	rm -rf build/*
	rmdir build
