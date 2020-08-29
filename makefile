#
# makefile 
#
# input file for 'make' build tool ( /usr/bin/make )
# to build solution for JUnit sample
#
# @author Dr. Fenwick
# @version Summer 2018
#

JUNIT_JAR = junit-platform-console-standalone-1.2.0.jar
JUNIT_RUNNER = org.junit.platform.console.ConsoleLauncher

default: 
	@echo "usage: make target"
	@echo "5 available targets: clean - removes editor tmpfiles and .class files"
	@echo "____________________ compile - builds project"
	@echo "____________________ run - runs with no args"
	@echo "____________________ run2 - runs with an arg"
	@echo "____________________ test - runs JUnit tests"



compile: src/Hello.java src/HelloTest.java $(JUNIT_JAR)
	cd src; javac -cp .:../$(JUNIT_JAR) HelloTest.java
	cd src; javac Hello.java

clean:
	rm -f *~
	rm -f src/*~
	rm -f src/*.class

test: src/Hello.class src/HelloTest.class $(JUNIT_JAR)
	cd src; java -cp .:../$(JUNIT_JAR) $(JUNIT_RUNNER) --scan-class-path

run: src/Hello.class
	echo "Running Hello: should output: 'Hello, Jay.'"
	cd src; java -cp . Hello

run2: src/Hello.class
	echo "Running Hello: should output: 'Hello, Bob.'"
	cd src; java -cp . Hello Bob
