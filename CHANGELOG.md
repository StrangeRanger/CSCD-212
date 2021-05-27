# Changelog

.....

### Added

- Add javadocs inside of `/docs`.

### Changed

- Rewrote all the comments to follow the standard javadocs comments...
- Modified file structure.
- Removed unused parameter from `io.Keyboard.resetErrorCount()`.
- Replaced (almost) all instances of `Math.random() * <some number>` with `java.util.Random.nextInt()`.
- Replaced all instances of `token.toLowerCase().equals(<thing to equal>)` with `token.equalsIgnoreCase(<thing to equal>)`.
- Replaced deprecated `Float(token)` and `Double(token)` in `io.Keyboard.readFloat()` and `io.Keyboard.readDouble()`, with `Double.parseFloat(token)` and `Double.parseDouble(token)` respectively.
- Reformatted a snake_case variable name as a camalCase name.
- Implement SonarLint rule java:S6212 - Local-Variable Type Inference should be used | [reference](https://rules.sonarsource.com/java/type/Code%20Smell/RSPEC-6212?search=Local-Variable%20Type%20Inference%20should%20be%20used).
- Where not required, replace imports using `*` with only the required classes/methods.
- Reformat coding style using `clang_format`. (Refactor +?)
- Marked all methods that override another with `@Override`. 
- Moved variables declared on the same line, to their own seperate line for better readbility.
- Constructor of abstract classes have been made `protected`.
