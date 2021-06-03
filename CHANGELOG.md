# Changelog

Here is a list of most, if not all, the major/notable changes to the original code.

### Added

- Added Javadoc inside of `/docs`.
- Added more `throw errors` in areas where possible unforeseen errors could occur.
- Implemented the Abstract Factory Pattern.

### Changed

- Added new and updated existing comments.
- Modified file structure.
- Replaced (almost) all instances of `Math.random() * <some number>` with `java.util.Random.nextInt()`.
- Replaced all instances of `token.toLowerCase().equals(<thing to equal>)` with `token.equalsIgnoreCase(<thing to equal>)`.
- Reformatted a snake_case variable with camalCase formatting.
- Reformatted coding style using `clang_format`.
- Removed unnecessary `token.length()` from `io.Keyboard.readChar()`.
- Removed `readChar`, `readDouble`, `readFloat`, `readWord`, `readBoolean`, `setPrintErrors`, `getPrintErrors`, `getErrorCount`, `resetErrorCount`, and `readLong` from `io.Keyboard` because they are never used.
   - Following the YAGNI standard coding principle ("you aren't gonna need it": don't implement something until necessary).
- Removed the `characters.heroes.Hero.defend()` method.
- When checking if the user wants to play again, it looks for both `y' and `yes`, and forcefully makes the user input lowercase.
- The method `io.Keyboard.readString()` now uses StringBuilder instead of String. 
- Implemented SonarLint rule java:S6212 - Local-Variable Type Inference should be used ([reference](https://rules.sonarsource.com/java/type/Code%20Smell/RSPEC-6212?search=Local-Variable%20Type%20Inference%20should%20be%20used)).
Where not required, replace imports using `*` with only the required classes/methods and vice versa.
- Marked all methods that override another with `@Override`.
- Moved variables declared on the same line to their separate line for better readability.
- Constructors of abstract classes have been made `protected`.
- Moved the number of turn code to its own method. 

### Fixed

- The number of turns will no longer decrease when inputting an invalid battle action option.
- Fixed a problem where (for Sorceress and Thief) if the monster was killed and the hero still had more turns, the game would not end.

