# Changelog

.....

### Added

- Add javadocs inside of `/docs`.
- Implemented the Abstract Factory Pattern.
- Added more `throw errors` to improved [unforeseen] error handling.

### Changed

- Added new and updated existing comments.
- Modified file structure.
- Replaced (almost) all instances of `Math.random() * <some number>` with `java.util.Random.nextInt()`.
- Replaced all instances of `token.toLowerCase().equals(<thing to equal>)` with `token.equalsIgnoreCase(<thing to equal>)`.
- Reformatted a snake_case variable name as a camalCase name.
- Reformat coding style using `clang_format`.
- Removed unnecessary `token.length()` from `io.Keyboard.readChar()`.
- Removed a Hero type variable declaration from `Dungeon.chooseHero()`, as it was not used.
- Removed `readChar`, `readDouble`, `readFloat`, `readWord`, `readBoolean`, `setPrintErrors`, `getPrintErrors`, `getErrorCount`, `resetErrorCount`, and `readLong` from `io.Keyboard` because they are never used.
- Removed the `characters.heroes.Hero.defend()` method.
- The method `io.Keyboard.readString()` now uses StringBuilder instead of String.
- Implemented SonarLint rule java:S6212 - Local-Variable Type Inference should be used ([reference](https://rules.sonarsource.com/java/type/Code%20Smell/RSPEC-6212?search=Local-Variable%20Type%20Inference%20should%20be%20used)).
- Where not required, replace imports using `*` with only the required classes/methods, and vise versa.
- Marked all methods that override another with `@Override`.
- Moved variables declared on the same line, to their own seperate line for better readability.
- Constructor of abstract classes have been made `protected`.
- Error output is now done in red text.

### Fixed

- The number of turns will no longer go down when inputting an invalid battle action option.
- Fixed problem where (for Sorceress and Thief) if the monster was killed, the game would not end if the hero still had more turns.
