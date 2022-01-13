# 526-Term-Project-Process-Schedular

## Overview
The CS 526 Term Project's goal is to simulate a process schedular that scans a file of raw process datas as input, then systematically processing each processes based on system parameters through the implementation of PriorityQueue and other generic data structures.

## Project Breakdowns

### process.java
Process.java is a custom class that defines what a process consist of. Each process was given thier ids, arrival times, priorities, and duration by the assignment through text file format. 

The priority of each process will increase by 1 if any given process has been waiting in Q for every 30 unit time. For that reason, I gave each process objects an additional attribute waitTIme, with 0 as default. As results, a process's waitTime will be increased by 1 in each virtual time so that priority will increase by 1 for every 30 virtual time.

In addition to the attributes that mentioned above, I added waitTime attribute to keep a count of time each process has been waiting. Lastly, I created some custom set and get methods to eaisly access and modify the appropriate attributes.

### PriorityQueue<D>
All process class objects were represented by a bunch of numbers that sorted by id and stored in a text file given by assignment. Process class objects were then read and stored into a PriorityQueue named D, as it has to be sorted by arrivalTime in ascending arrangement so D will remove the least arrivalTime and send it to Q at its corresponding virtual time. Due to process objects being a custom class, a comparator was implemented
  
### PriorityQueue<Q>
All process class objects were represented by a bunch of numbers that sorted by id and stored in a text file given by assignment. Process class objects were then read and stored into a PriorityQueue named D, as it has to be sorted by arrivalTime in ascending arrangement so D will remove the least arrivalTime and send it to Q at its corresponding virtual time. Due to process objects being a custom class, a comparator was implemented
  
### printMessage.java
In order to log any transactions of process updates, I realized that there is a way to systemacially allocate all logging templates to simplify the codes. Therefore, I consolidated all the templates and created two custom methods to keep my mian program cleaner.

### processScheduling.java
Since a PriorityQueue can only access to the first object and cannot modify the rest of the objects without removing the previous object. To overcome this problem, I added a step at the end of while loops to remove all process object while incrementing the waitTime, and adding to an ArrayList to temporarily storing the process objects. Once Q has emptied,I implemented a for loop to add back all modified processes back to Q.
