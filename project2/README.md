The Tortoise and Hare with Graphic Simulation
=============================================

The mission of this assignment is to re-create the classic race of the tortoise and the hare. You'll use random-number generation to develop a simulation of this memorable event.

Our contenders begin the race at square 1 of 70 squares. Each square represents a possible position along the race course. The finish line is at square 70. The first contender to reach or pass square 70 is rewarded with a pail of fresh carrots and lettuce. The course weaves its way up the side of a slippery mountain, so occasionally the contenders lose ground. A clock ticks once per second. With each tick of the clock, your application should adjust the position of the animals according to the rules in Table 1 below. Use variables to keep track of the positions of the animals (i. e., position numbers are 1—70). Start each animal at position 1 (the "starting gate"). If an animal slips left before square 1, move it back to square 1.

Table 1: Rules for adjusting the positions of the tortise and hare

|Animal    |Move type   |Percentage of the time  |Actual move           |
|----------|------------|------------------------|----------------------|
|Tortoise  |Fast plod   |50%                     |3 squares to the right|
|          |Slip        |20%                     |6 squares to the left |
|          |Slow plod   |30%                     |1 square to the right |
|Hare      |Sleep       |20%                     |No move at all        |
|          |Big hop     |20%                     |9 squares to the right|
|          |Big slip    |10%                     |12 squares to the left|
|          |Small hop   |30%                     |1 square to the right |
|          |Small slip  |20%                     |2 squares to the left |

Generate the percentages in Table 1 by producing a random integer i in the range 1 ≤ i ≤ 10. For the tortoise, perform a "fast plod" when 1 ≤ i ≤ 5, a "slip" when 6 ≤ i ≤ 7 or a "slow plod" when 8 ≤ i ≤ 10. Use a similar technique to move the hare. Begin the race by displaying

BANG !!!!! AND THEY'RE OFF !!!!!

Then, for each tick of the clock ( i. e., each repetition of a loop), display an icon in the position of the tortoise and another icon in the position of the hare. Occasionally, the contenders will land on the same square. In this case, the tortoise bites the hare, and your application should display  OUCH!!! beginning at that position. Continue execution and test for whether either animal has reached or passed square 70. If so, display the winner and terminate the simulation. If the tortoise wins, display "TORTOISE WINS!!! YAY!!!" If the hare wins, display something like "Hare wins. Yuch." If both animals win on the same tick of the clock, you may want to favor the tortoise (the "underdog"), or you may want to display "It's a tie." If neither animal wins, perform the loop again to simulate the next tick of the clock.

To realize graphic presentation, refer to the site [here](http://www.dreamincode.net/forums/topic/236223-animating-an-image-in-swing-utilizing-the-swing-timer/). You should be able to reverse-engineer the mechanism to realize graphic motions. As optional extra points (2 points), realize go/quit buttons and edit capability to change the number of squares. Chapter 12 - 13 of the textbook covers Swing-based GUI development introduction. See the image of sample implementation below.
