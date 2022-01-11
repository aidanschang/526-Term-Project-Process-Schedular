# 526-Term-Project-Process-Schedular

The CS 526 Term Project's goal is to create a PriorityQueue named Q as a process processor that imitate a system that processes a series of process objects at its given virtual arrivalTime. In this project, the virtual time is represented by the numbers of while loops it repeats.

All process objects were sorted by id and initially stored in a text file given by assignment. Process objects were then read and stored into another PriorityQueue named D, as it has to be sorted by arrivalTime in ascending arrangement so D will remove the least arrivalTime and send it to Q at its corresponding virtual time. Due to process objects being a custom class, a comparator was implemented

Within each process objects, assignment gave each with corresponded id, priority, arrival time, and duration. In addition, the priority will increase by 1 if the process has been waiting in Q for every 30 unit time. For that reason, I gave each process objects an additional attribute waitTIme, with 0 as default. As results, a process's waitTime will be increased by 1 in each virtual time and increase priority by 1 for every 30 unit time.

Since a PriorityQueue can only access to the first object and cannot modify the rest of the objects without removing the previous object. To overcome this problem, I added a step at the end of while loops to remove all process object while incrementing the waitTime, and adding to an ArrayList to temporarily storing the process objects. Once Q has emptied,I implemented a for loop to add back all modified processes back to Q.
