# Changelog

Here is a list of most, if not all, the major/notable changes to the original code. Along with each change, will be attached a reason for that change.

Applied Coding Principles:

- YAGNI ("you aren't gonna need it"): don't implement something until necessary.

## Added

- Added Javadoc inside of `/docs`.
  - Reason: Provide a human readable template of the the in program documentation/comments.
- Added more `throw errors` in areas where possible unforeseen errors could occur.
  - Reason: Protect from unforeseen internal errors.
- Implemented the Abstract Factory Pattern.
  - Reason: Keep all [main] class instantiation to a single class/method that does not belong to the main class/method.

## Changed

- Added new and updated existing comments.
  - Reason: Provide more in depth documentation on new and prior existing code.
- Modified file structure.
  - Reason: Group alike classes together for better human readability.
- Replaced (almost) all instances of `Math.random() * <some number>` with `java.util.Random.nextInt()`.
  - Reason: Allows for better readability and is more comprehensive.
- Replaced all instances of `token.toLowerCase().equals(<thing to equal>)` with `token.equalsIgnoreCase(<thing to equal>)`.
  - Reason: Using `equalsIgnoreCase()` is a simplified version of `toLowerCase().equals()`.
- Reformatted a snake_case variable with camelCase formatting.
  - Reason: Follow Java formatting standards for consistency.
- Reformatted coding style using `clang_format`.
  - Reason: Force code style consistency.
- Removed unnecessary `token.length()` from `io.Keyboard.readChar()`.
  - Reason: Wasn't being used. (YAGNI)
- Removed `readChar`, `readDouble`, `readFloat`, `readWord`, `readBoolean`, `setPrintErrors`, `getPrintErrors`, `getErrorCount`, `resetErrorCount`, and `readLong` from `io.Keyboard` because they are never used.
  - Reason: Wasn't being used. (YAGNI)
- Moved cod inside of the `characters.heroes.Hero.defend()` directly into another method.
  - Reason: There was no justification for being in it's own method.
- When checking if the user wants to play again, it looks for both `y` and `yes`, and transforms the user input to lowercase.
  - Reason: Allows for more flexibility for user input.
- The method `io.Keyboard.readString()` now uses StringBuilder instead of String.
  - Reason: Allows us to join strings without the explicit `+` concatenation.
- Implemented SonarLint rule java:S6212 - Local-Variable Type Inference should be used ([reference](https://rules.sonarsource.com/java/type/Code%20Smell/RSPEC-6212?search=Local-Variable%20Type%20Inference%20should%20be%20used)).
  - Reason: Following suggested rule to help simplify the code.
- Where not required, replace imports using `*` with only the required classes/methods and vice versa.
  - Reason: Prevents importing stuff that we don't need...
- Marked all methods that override another with `@Override`.
  - Reason: Allows people to easily identify methods that override another.
- Moved variables declared on the same line to their separate line for better readability.
  - Reason: Allows for better human readability.
- Constructors of abstract classes have been made `protected`.
  - Reason: If a class doesn't need to be public, the don't make it public. This reduces the possibility of classes that shouldn't call it, call it.
- Moved the number of turn code to its own method.
  - Reason: Allows for more modular code.

## Fixed

- The number of turns will no longer decrease when inputting an invalid battle action option.
  - Reason: Bugs should be fixed.
- Fixed a problem where (for Sorceress and Thief) if the monster was killed and the hero still had more turns, the game would not end.
  - Reason: Bugs should be fixed.
