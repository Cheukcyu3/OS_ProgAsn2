COMP = javac -g -Xlint:all
TASK1 = TASK1/*.java
TASK2 = TASK2/*.java
RUN = java -XX:+PrintCommandLineFlags
RUN1 = -cp .. OS_PROGASN2.TASK1.BlockManager
RUN2 = -cp .. OS_PROGASN2.TASK2.BlockManager

all: clean comp1 comp2

clean:
	@echo "Allen is cleaning up"
	find . -name "*.class" -print -delete
# 	Write-Host "cleaning .class files"
# 	get-childitem * -include *.class -recurse | remove-item

comp%:
	$(COMP) $(TASK$*)

run%:
	$(MAKE) comp$*
	$(RUN) $(RUN$*)

.PHONY: all clean comp% run%