# Multiple Choice Practice Questions Solutions

- [Multiple Choice Practice Questions Solutions](#multiple-choice-practice-questions-solutions)
  - [Question 1 (2 marks)](#question-1-2-marks)
  - [Question 2 (2 marks)](#question-2-2-marks)
  - [Question 3 (2 marks)](#question-3-2-marks)
  - [Question 4 (2 marks)](#question-4-2-marks)
  - [Question 5 (2 marks)](#question-5-2-marks)
  - [Question 6 (2 marks)](#question-6-2-marks)
  - [Question 7 (2 marks)](#question-7-2-marks)
  - [Question 8 (2 marks)](#question-8-2-marks)
  - [Question 9 (2 marks)](#question-9-2-marks)
  - [Question 10 (2 marks)](#question-10-2-marks)
  - [Question 11 (2 marks)](#question-11-2-marks)

## Question 1 (2 marks)

On a bike, there are one or more tyres.

The following relationship is an example of:

- A) **Aggregation**
- B) Composition
- C) Neither

## Question 2 (2 marks)

Consider the following lambda function which prints log. The type signature has been redacted.

`[redacted] logger = log -> System.out.println(log);`

Pick the most semantically correct type from the list below:

- A) Function<String, Boolean>
- B) **Consumer<String>**
- C) Predicate<String>
- D) Supplier<String>

## Question 3 (2 marks)

Grace is developing a simple application that generates a course outline for new CSE courses.

There are exactly three types of course outline - COMP, SENG and BINF. No other types or subtypes of courses exist. Each course outline is composed of two parts:

- A randomly generated course code, in the format COMPXXXX, SENGXXXX, or BINFXXXX.
- The lecturer of the course, randomly chosen from a provided list of all valid lecturers for either COMP, SENG, or BINF courses.

All course outlines have exactly these two features, nothing more or less.

Grace would like to pass one of the strings “COMP”, “SENG” or “BINF” to a particular method and receive an instance of an appropriate course outline in return.

Which of the following design patterns would be the most appropriate for this design?

- A) Composite Pattern
  **- B) Factory Pattern**
- C) Abstract Factory Pattern
- D) Decorator Pattern

## Question 4 (2 marks)

The following is taken from a student’s Assignment II blog.

> In Assignment II, after I completed Part 1 and refactored the code, I started work on Part 2 but found I had to go and modify everything because the design didn’t work with the new requirements.

Which SOLID principle is being violated? Select the most suitable answer.

- A) Single Responsibility Principle
- B) **Open-Closed Principle**
- C) Liskov Substitution Principle
- D) Interface Segregation Principle
- E) Dependency Inversion Principle

## Question 5 (2 marks)

Which of the following statements is correct?

- A) Overloaded methods have the same method signature, while overridden methods have a different method signature.
- B) Overloaded methods can have different access modifiers, while overridden methods must have the same access modifier.
- C) Overloaded methods are defined in different classes, while overridden methods are defined in the same class.
- D) **Overloaded methods are resolved at compile-time, while overridden methods are resolved at runtime.**

## Question 6 (2 marks)

Which of the following statements is untrue about method overriding?

- A) Constructors cannot be overridden
- B) If a static method in the base class, is redefined in the sub-class, the later hides the method in the base class
- C) In method overriding, run-time polymorphism ensures that instantiated, the call to any method in the base class will be resolved to the correct method, based on the run-time type of the object instantiated.
- D) **During method overriding, the overridden method in the sub-class can specify a less permissive access modifier**

## Question 7 (2 marks)

A design pattern used to enhance a component’s functionality dynamically at run-time is:

- A) Composite Pattern
- B) **Decorator Pattern**
- C) Abstract Factory Pattern
- D) Observer Pattern

## Question 8 (2 marks)

Which of the following exceptions must be handled by a try-catch block or declared?

- A) NullPointerException
- B) **MalformedURLException**
- C) ClassCastException
- D) ArithmeticException

## Question 9 (2 marks)

Consider the following code:

```java
class X {
    public void a() {}
}

class Y {
    public void b() {}
}

class Z extends X, Y {
    protected void a() {}

    public void b() {}

    public void b(String arg) {}
}
```

Now, consider the following statements about the code:

- (1) The code doesn’t compile because there is more than one class in the same file;
- (2) The code doesn’t compile because double inheritance is not possible in Java;
- (3) The code doesn’t compile because the methods a and b are not marked with @Override
- (4) The code doesn't compile because you cannot overload a method that is overriding a method in a superclass;
- (5) The code doesn’t compile because a cannot have its visibility reduced from the superclass to the subclass.
- (6) The code does compile.

Which of the following sets of statements about the code are true?

- A) (1), (2)
- B) (1), (3), (5)
- C) (2), (3), (4), (5)
- D) **(2), (5)**
- E) (2), (4), (5)
- F) (6)

## Question 10 (2 marks)

Nick is currently working on a UNSW CSE system. Which of the following statements is most accurate about how Nick should build the system?

- A) The system should be built in Java so that Design Patterns can be used.
- B) Documentation is unimportant as the code should be written so well it is understandable.
- C) **The design should allow new engineers to easily join the project after Nick has left.**
- D) Testing the system works is a lower priority than getting it working.

## Question 11 (2 marks)

Which of the following would be a valid use case for instanceof instead of getClass for checking the type of an object?

- A) **Checking if an object complies with an interface so that we can use a method on that interface**
- B) Implementing the equals method for an object
- C) It’s a trick question, you should never use instanceof in your code at all
