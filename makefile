all:
	javac *.java

run:
	java Coder $(ARGS)

clean: 
	rm *.class