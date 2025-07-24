COMP = javac -g -Xlint:all
TASK1 = TASK1/*.java
TASK2 = TASK2/*.java
RUN = java -XX:+PrintCommandLineFlags
RUN1 = -cp .. OS_PROGASN2.TASK1.BlockManager
RUN2 = -cp .. OS_PROGASN2.TASK2.BlockManager

all: clean comp1 comp2

clean:
	@echo "cleaning .class files"
	find . -name "*.class" -print -delete

comp%:
	$(COMP) $(TASK$*)

run%:
	$(MAKE) comp$*
	$(RUN) $(RUN$*)

.PHONY: all clean comp% run%