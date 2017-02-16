Technical Challenge for Job Applicant: Calculator

Description:
Your assignment is to write a calculator library. A command-line interface is fine, but don’t
spend too much time on it.
You are supposed to take no more than an hour to an hour and a half to complete the test. The
code running is much less important than the architecture of the library. Pay close attention to
the extensibility of your code!
Requirements:

● You commit the code to an online public accessible Git repository (such as Github)

● Handle binary operations, e.g. 5 - 6, 8 * 4

● The calculator should be able to handle a full arithmetic expression at once, for
example:, e.g. 1 + 1 - 4 * 4
● The library must take Order of Operations
(http://en.wikipedia.org/wiki/Order_of_operations) into account
● No need to handle parentheses, e.g. ( 1 + 1 - 4 ) * 4
● Must be extendable​ so that it accepts user-defined operands
Not allowed
- use of eval() in PHP or similar functions in other languages that allow you to evaluate the
equation in a one-liner
Objectives
- Demonstrate skills in OOP code design
- Showcase development best practices
- Demonstrate good algorithmic thinking


output :
--------------------
 
for Input :
2 + 3 - 5 * 56 + 2 * 45
------------------------------------------
For operator precedence :    *+- 

Step 1 :  for precedence *

2+3-280+90

Step 2: for precedence  +

5-370

Step 3: for precedence  –

-365

------------------------------------------------------------------------

For operator precedence :    +-*

 Step 1: for precedence + 

5-5 * 112 * 45

Step 2: for precendence –

0 * 112 * 45

Step 3: for precedence *

0

