# cs56-scrapers-baseball-stats

This is a simple MLB baseball statistics program. 

The program parses through raw .xml data retrieved from MLB servers and organizes the data into player statistics. These new, organized stats can then be viewed from the GUI. For the purposes of this demo, the program loads in data from 9 different games which have been included under the `stats/DemoFiles` folder.

The files were downloaded from [gd2.mlb.com/components/game/mlb/](http://gd2.mlb.com/components/game/mlb/)

project history
===============
```
 W14 | jstaahl 5pm | maxsorenson | (kjorg50) a scraper that gathers statistics on Major League Baseball players
```

## Usage

To run the GUI, simply type `ant run` after cloning the code. You will see a window like this

![](http://i.imgur.com/vJl9b1e.png)


Any usage of these files acknowledges agreement to the terms posted [here](http://gdx.mlb.com/components/copyright.txt)

W16 Final Remarks: Something useful to know about this repository is that most of the GUI features and action performed methods are taken care of in the StatWindow.java class.  Some of the recently added functions to this project are the search for player function and a make fantasy team function.  Both of these functions rely on user input into a text box.  There are instructions in the Stat Window about making a fantasy team.  Perhaps something to change about this part would be to change where the instructions are so that the statistics take up the entire window instead of only some of it (since the instructions take up part of the left side of the window).  Also, in the make fantasy team function, you should check to see if the player exists when the user tries to add them to the team, and display the proper error message to them (sorry, we didnt do that).  Also, something major that could make this project a lot better would be to restrict it to only one window.  For instance, allow the window to be able to change its appearance when the user does something to change the state of the UI.  As of right now, a new frame pops up when a player is searched for, when a fantasy team is created, or when a row in the window is clicked. As far as clean up goes, there are some unnecessary System.out.print statements in some of the classes that can be erased (those were just used to do some simple tests while we were writing new functions).

