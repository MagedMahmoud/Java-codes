# Object Oriented Guessing Game

Implement an object oriented version of The Guessing Game.

## Deliverables

A zip file containing the unaltered `cli` and `core` packages.
A `gui` package containing the files:

* `GUI.java`
* `MainGUI.java`

## Assignment

In class we created the files in the `core` and `cli` packages.  Using your previous homework assignment as a starting place, create a GUI for the guessing game that implements the `IClient` and `IGuesser` interfaces.

To implement `IGuesser` you will need to cause the main thread to block when the `nextGuess` method is called, similar to how the command-line version blocks when `nextInt` is called.  When a guess is available (i.e. the user has clicked the submit button) the `nextGuess` method should unblock and return the appropriate value.
To do this you may use any of the methods we discussed in class.

The `main` method will go in `MainGUI.java`.  In `main` simply instantiate the necessary dependencies, instantiate the GUI class, and call the appropriate methods.

## Notes

Ensure that your GUI class does *not* implement the guessing game.  We completed the "object oriented" version of the guessing game in class, your assignment is to implement the interfaces necessary for this code to use your GUI as a `IClient.java` and `IGuesser.java`.

