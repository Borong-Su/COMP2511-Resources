## Barbie

Following the release of the hit feature film Barbie, Mattel have hired you and a number of other COMP2511 students to build their new platform for keeping track of their product offerings.

You’ve inherited a codebase which has design issues.

In this question, you will need to refactor the code to improve the quality of the design.

Inside the `barbie` folder is some simple code to represent different types of Dolls. The code contains support for Barbie and Ken dolls as well as a box in which Barbies can be stored.

Barbie dolls specifically can come with zero or more accessories. Currently, there is support for a car and a dream house, but more accessories may be added in the future.

Inside `App.java` is some code that works with these different entities:

### Refactoring to Design Patterns (10 marks)

Now that the code is functioning correctly, we can also look at how we can make other design improvements.

i) In q20.txt, identify one class where the code fails to satisfy the Open-Closed principle, and explain how the principle is violated. (2 marks)

ii) Using a design pattern of your choosing, refactor the code to improve the quality of the design. (8 marks)

Write down which design pattern you have implemented inside q20.txt.

You can change the code inside the q20 package as you like, provided that App.java produces the correct output.

There is a simple test called `testBarbie` inside test/barbie that checks your implementation works as expected after the refactoring.
