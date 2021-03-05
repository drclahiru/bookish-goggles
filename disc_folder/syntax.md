# Discussion about the language design

_Trying to be minimalist – just to get things started_

## Data importing

Data will be kept in an excel sheet and our programming language will be used to do computations and stuff from the sheet and output reports or whatever.

### Types

- Boolean
- Numbers (doubles under the hood)
- String
- Lists(Ranges?)

## If & else

```
if x > 90 {
    "You got a A"
} elseif x > 80 {
    "You did not get a B”
} else {
    "You did not get a A”
}
```

## Recursion

Pattern matching is difficult to implement, so maybe it should be postponed for v0.2.

```
let ztoa = (x) {
    return match x {
    | [] -> []
    | [a:bz] -> concat(ztoa(bz), [a])
    };
};
```

## Bindings

```
let x = 4;
```

## Lambda Expression

```
let get_age = (x) {
    let age = x.age;
    return age;
};
```

## Type representation

Optional for bindings

```
let x = 4; // x inferred to be Number
let x: Number = 4; // ok
let x: Number = "4"; // error because type-mismatch
```

Lambda expression type signatures

```
(Number) -> Number
```

```
(Number, Number) -> Number
```

Nice to have, but not essential:

```
let f = (x: Number) {
    return x * x;
};
```

## Data representation

```
Range(sheet1!A1:A5) = (5632145895,8547412565,5478521456,5632587412,5698254695);
Range(B1:B5) = (10,20,5,4,2);
Range(C1:C5) = (0,1,0,1,0);
Range(D1:D5) = (1,0,0,1,1);
```

```
Input(sheet1);
Output(sheet2);
Range(sheet2!A1:A5) = f(Range(sheet1!A1:A5));
```

## Operator precedence

We should try to match the precedence rules that already exist in excel.

TODO: What are the precedence rules in excel?

`4 + x * 2` = `4 + (x \* 2)`

`a || b && c || d` = `((a || b) && c) || d`

`a < 4`

## Pattern matching

Default case at the end is required if the pattern is not complete

```
match x {
| [] -> []
| [a:bz] -> concat(bz, [a])
| _ -> []
};
```

## Structs

Structs would be nice to have, and should be considered for v0.2.

```
struct Person {
    name: String,
    age: Number
}

// Create a binding to the table using the Person struct and specifying the begining and end rows.
table Persons = Person[1:4] {
    name: A,
    age: B,
}
```

# Implementation Language

We’ll use Java because it’s the language being used in the CC Course and so the exercises from the course will be more relevant to our compiler work.
