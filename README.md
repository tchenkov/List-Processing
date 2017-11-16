# List-Processing
SoftUni >Module: TeamWork - September 2017 > List Processing – Teamwork Project Assignment

Contributors: Тодор Ченков - joto_to, Цветелина Йорданова - cvet_yordanova, Христо Спиртов - morgoth

# Commands Description
Design and implement a console-based application for list processing. It should enter a list of strings from the console and continuously execute commands (like add / remove / replace, invert) over the list. 

The first input line holds the initial list of strings:
* space separated list of items

Print the list immediately after you read it (space separated).
The next lines hold one of the following commands (until the commands “end” is found):
* append <string> – adds the specified string at the end of the list and prints the list (space separated).
* prepend <string> – inserts the specified string at the start of the list and prints the list.
* reverse – reorders the list items in reversed order (from its end to its start) and prints the list.
* insert <index> <string> – inserts the specified string at the specified position in the list and prints the list after that.
    * Positions are indexed from 0 to list_size - 1.
    * In case of invalid index, print “Error: invalid index <index>”.
*delete <index> – deletes the string at the specified position in the list and prints the list.
    * Positions are indexed from 0 to list_size - 1.
    * In case of invalid index, print “Error: invalid index <index>”.
* roll left – rolls the list on the left and prints the list. The first list item comes last.
* roll right – rolls the list on the right and prints the list. The last list item comes first.
* sort – sorts the list in alphabetical order and prints the list.
* count <string> – prints how many times the specified string occurs in the list (case sensitive). The command prints a single integer number as output.
* end – stops the execution of commands. Print “Finished” as command output.
  
Each command produces one of the following outputs:
* In case of success the command prints its expected output as described above.
* In case of error (e.g. invalid index or command parameter) the commands prints “Error: <error message>”.
    * In case of invalid command name print “Error: invalid command”. Command names are case-sensitive.
    * In case of invalid number of parameters or incorrect format of the parameters print “Error: invalid command parameters”.
