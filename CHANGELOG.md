# Changelog

.....

### Added

- Add javadocs inside of `/docs`.

### Changed

- Added new and updated existing comments to follow the standard javadocs comment style...
- Modified file structure.
- Replaced (almost) all instances of `Math.random() * <some number>` with `java.util.Random.nextInt()`.
- Replaced all instances of `token.toLowerCase().equals(<thing to equal>)` with `token.equalsIgnoreCase(<thing to equal>)`.
- Replaced deprecated `Float(token)` and `Double(token)` in `io.Keyboard.readFloat()` and `io.Keyboard.readDouble()`, with `Double.parseFloat(token)` and `Double.parseDouble(token)` respectively.
- Reformatted a snake_case variable name as a camalCase name.
- Reformat coding style using `clang_format`. (Refactor +?)
- Removed unnecessary `token.length()` from `io.Keyboard.readChar()`.
- Removed a Hero type variable declaration from `Dungeon.chooseHero()`, as it was not used.
- Removed `readDouble`, `readFloat`, `readWord`, `readBoolean`, `setPrintErrors`, `getPrintErrors`, `getErrorCount`, `resetErrorCount`, and `readLong` from `io.Keyboard` because they are never used.
- The method `io.Keyboard.readString()` now uses StringBuilder instead of String.
- Implement SonarLint rule java:S6212 - Local-Variable Type Inference should be used | [reference](https://rules.sonarsource.com/java/type/Code%20Smell/RSPEC-6212?search=Local-Variable%20Type%20Inference%20should%20be%20used).
- Where not required, replace imports using `*` with only the required classes/methods.
- Marked all methods that override another with `@Override`.
- Moved variables declared on the same line, to their own seperate line for better readability.
- Constructor of abstract classes have been made `protected`.
