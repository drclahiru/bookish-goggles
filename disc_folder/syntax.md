# Discussion about syntax and paradigms.

_Trying to be minimalist – just to get things started_

### Types

- Integers
- Lists
- Boolean
- Language Features
- Lambda Expressions
- Recursion
- Pattern Matching

# Syntax Discussion

- Use names from spreadsheet language
- UPPERCASE

## Working with tables.

```
struct Person[1..30] {
    Id: A,
    name: B,
    age: D
}
```

## IF & ELSE

IF x > 90 THEN "You got a A" ELSE "You did not get a A”

## Lambda Expression

We’re all kinda fond of Haskell way of handling Lambda Expressions. (\x - > x + 1)

# Implementation Language

We’ll use Java. Because it’s the language being used in the CC Course.

For being able to write some example programs.. It’s agreed upon that the syntax will be “haskell like”.. Go nuts!

Large programs vs. smaller programs.
Lisp vs. Haskell.

### Discussion

How do we make the program useful? It has to get data from the outside world, and it also has to output something.
Do we read from stdin? Read from file? What format?
Do we output to stdout? Write to file?
How does input data get used? Does it have to be bound to a table first?
