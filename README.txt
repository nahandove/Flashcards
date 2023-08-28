Project assignment from JetBrains Academy (www.hyperskill.org), Java Developer track.

Flashcards are often used for exam preparations and memory aids. The program allows the user to
create flashcards of their own design, save flashcards into a file, load flashcards from 
a file, and test their knowledge about the definition of any word. The program is also capable
of recording user errors and pointing out "difficult cards" where they made the most mistakes.

A total of 9 different operations are available to the user, 2 of which can be input via the
command line: import and export. All the operations, including import and export, are listed on 
the menu prompt, which pops up whenever an operation is finished and continuously until the 
user chooses the exit operation. All the operations are listed as below:

1. Add operation. Indicated by the input "add" after the menu prompt. The operation prompts the
user to add a card with their chosen word, and then supply the definition of the word. The
program checks if the card or the definition already exists in the collection. If so, the user is 
informed and the new card is not added. The word-definition pair is stored for future testing 
purposes and can also be saved into a file later via the export operation.

2. Remove operation. Indicated by the input "remove" after the menu prompt. The operation allows
the user to remove a card from the collection using the word of the card. The program then informs
the user of the card's removal. If a card does not exist in the collection, the user is informed of 
its absence. 

3. Import operation. This operation can either be supplied by the command line using "-import" and
then the file name as the next argument, or as "import" response to the menu prompt. If the file name 
is supplied via the command line, it is used as a default import operation. Otherwise, the program 
prompts the user to supply the import file as a file path. The file feeds the user all the existing
card entries from the file that the user had previously saved, and the user is informed of the number
of cards loaded. If there are cards in the current collection that also exist in the import file, the 
cards from the import files replace the the cards in the current collection.

4. Export operation. This operation can either be supplied by the command line using "-export" and
then the file name as the next argument, or as "export" response to the menu prompt. If the file name
is supplied via the command line, it is used as the default export operation and automatically save 
the current card collections into the export file upon exit. Otherwise, the program prompts the
user to supply a file name to save their progress. The user is informed that the cards are saved and the
file recording saved cards (including error counts) can be used for future sessions.

5. Ask operation. Indicated by the input "ask" after the menu prompt. This operation tests the user's
knowledge by asking the user to supply definitions for the word of the card. The program first asks 
how many tests the user wants to take, after which it runs through the existing collection for the 
number of tests indicated by the user. If all the cards in the collection are worked through, the 
program returns to the beginning of the collection. The program informs the user if they answers the 
question correctly or, if incorrect, if the definition belongs to another word instead. Each incorrect
response is recorded by the program as an error count on the card.

6. Exit operation. Indicated by the input "exit" after the menu prompt. This operation prints "Bye bye!" 
and the program ends. If the user previously supplied an export file via the command line, the current
card collection and progress is automatically saved in the export file.

7. Log operation. Indicated by the input "log" after the menu prompt. This operation records all inputs
and outputs that occur during a session (from beginning of the program till exit). The program asks the
user to supply a log file, and the session is saved in the file.

8. Hardest Card operation: Indicated by the input "hardest card" after the menu prompt. The operation
goes through the existing collection and pick out the cards where the user made the most mistakes in past
test sessions. If more than one card have the highest number of errors marks, all the cards are listed.
The user is also informed if none of the cards have error marks.

9. Reset Stats operation: Indicated by the input "reset stats" after the menu prompt. The operation resets
the error marks of all the cards in the collection to 0 and informs the user.

August 27th, 2023--description by E. Hsu (nahandove@gmail.com)
