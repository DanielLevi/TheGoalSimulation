# TheGoalSimulation
Simulation of a game played in the book "The Goal" (CH14) - My first intro to OOP/Java


<b>Background:</b>
The book "The Goal" is a business novel by Eliyahu Golratt that demonstrates the Theory of Constraints through the narrative of Alex Rogo, a manager of a manufacturing plant that is rapidly going bankrupt. During the 14th chapter, Alex is leading his son's boy scout trip when he gets an idea -- use bowls, matches, and dice to represent manufacturing capacity and statistical fluctuations in throughput. This program is meant to simulate that game in order to output a vastly larger dataset of results. These results are output in .csv format and can be easily examined, manipulated and visualized using Excel, R, etc.

<b>The Rules:</b>

Each player has a bowl that is originally empty. The players/bowls are arranged linearly with matches being moved from the matchbox (unlimited inventory) to the 1st bowl (machine/staging area/etc) to the 2nd bowl... final bowl, and then out to the market. 

At the start of each player's turn, the player rolls a die, indicating the number of matches that the player is able to move into the following player's bowl. The goal of each individual player is to move as many matches from his/her bowl into the bowl of the following player -- the first player has access to unlimited matches (i.e. the matchbox), but all proceeding players can only move the number of matches that have been placed in their bowls by the players earlier in line. If a player's roll is greater than the number of matches he/she is able to move, that player moves the maximum number of matches that are available.

Inventory consists of the total number of matches in the system (i.e. the bowls) at any given time. This is consistent with an assumption that is made that market demand is equal to the average number of matches the system can process. Therefore, each match leaving the final bowl is "sold," and does not remain in inventory.

<b>Motivation:</b>

The game played by Alex Rogo and the boy scouts is supposed to simulate the conditions on the factory floor -- the concurrence of dependent processes and statistical fluctuations. Imagining a system where each player moves the average amount of matches would yield an average of 3.5 matches moved per turn (the midpoint of 1 and 6, the range of a single die). Due to dependent processes (e.g. the dependence of each player on the previous player in this case), players tend to produce much less than what is expected. While player 2's rolls may on average be 3.5, there will often not be any inventory for him to work on. Down the line for player 3, 4... the effects of statistical fluctuation magnify, drastically impeding throughput. Understand these challenges and they can put you on the path to designing an efficient system that can overcome them.



