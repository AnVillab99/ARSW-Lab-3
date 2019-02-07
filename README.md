# Laboratorio-3
## Black List Search
### Part I - Introduction to threads in JAVA

1.  In agreement with the lectures, complete the classes `CountThread`, so that they define the life cycle of a thread that prints the numbers between A and B on the screen.
    
2.  Complete the `main` method of the `CountMainThreads` class so that:
    
    1.  Create 3 threads of type `CountThread`, assigning the first interval [0..99], the second [99..199], and the third [200..299].
        
    2.  Start the three threads with `start()`. Run and check the output on the screen.
    ![imagen 1 del counThread con run](images/counThreadR.png)
    ![imagen 1 del counThread con start](images/counThreadS.png)
        
    4.  Change the beginning with `start()` to `run()`. How does the output change? Why?
	    > If we use the method `start()`, it creates a new Thread and then it executes the method `run()` from the thread, if we use `run()` no new thread is created and only execute this method
### # Part II - Black List Search Exercise

![imagen 1 del blacklist search](images/blacklist1.png)
![imagen 2 del blacklist search](images/blacklist2.png)


### Part III - Discussion

The strategy of parallelism previously implemented is inefficient in certain cases, since the search is still carried out even when the `N` threads (as a whole) have already found the minimum number of occurrences required to report to the server as malicious. How could the implementation be modified to minimize the number of queries in these cases? What new element would this bring to the problem?

>When a thread found an occurence, tell it to the main thread, when this one gets the maximun nmber of ocurrences, stop all the threadas and terminate

## Part IV - Performance Evaluation
From the above, implement the following sequence of experiments to perform the validation of dispersed IP addresses (for example 202.24.34.55), taking the execution times of them (be sure to do them on the same machine):

1.  A single thread.
    ![imagen 1thread](images/1thread.png)
2.  As many threads as processing cores (have the program determine this using the Runtime API)
        ![imagen 4 threads](images/4thread.png)
3.  As many threads as twice the number of processing cores.
        ![imagen 8 threads](images/8thread.png)
4.  50 threads
            ![imagen 50 threads](images/50thread.png)
5.  100 threads
        ![imagen 100 threads](images/100thread.png)


-   According to Amdahls law, where `S(n)` is the theoretical improvement of performance, **P** the parallel fraction of the algorithm, and **n** the number of threads, the greater **n**, the better this improvement should be. Why is the best performance not achieved with the 500 threads? How is this performance compared when using 200 ?.
    
![](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWJN2LirJZqzEmpZ3Gn%2F-LXX-N0xe_iYMHKeMI_F%2F-LXX0JMxJUi0CH7YwNxg%2Fahmdahls.png?alt=media&token=341a4fdd-bb18-4d57-8a63-7d6456c56267)

-   How does the solution behave using as many processing threads as cores compared to the result of using twice as much?
    
-   According to the above, if for this problem instead of 100 threads in a single CPU could be used 1 thread in each of 100 hypothetical machines, Amdahls law would apply better ?. If **x** threads are used instead of **100/x** distributed machines (where **x** is the number of cores of these machines), would it be improved? Explain your answer.

## Snake Race
# 

Description[](#description)

The purpose of this exercise is for the student to know and apply concurrent programming concepts.

## 

Part 1[](#part-1)

Control threads using [wait/notify.](http://howtodoinjava.com/core-java/multi-threading/how-to-work-with-wait-notify-and-notifyall-in-java/)

1.  Download the project [_PrimeFinder_](https://github.com/ARSW-ECI/wait-notify-excercise). this is a program that calculates prime numbers beetween 0 and M (Control.MAXVALUE),concurrently, distributing the searching of them between n (Control.NTHREADS) independent threads.
    
2.  Modify the application in such way that each t milliseconds of thread execution, all the threads stop and show the number of primes found until that moment. Then, you have to wait until press ENTER in order to resume the threads execution.Use the synchronization mechanisms given by java (wait y notify, notifyAll).
    

Note that:

-   The synchronized statement is used in order to get exclusive access to an object
    
-   The statement A.wait executed in a B thread set it to suspended mode (Independently that objective A is being used as 'lock') To resume, other active thread can resume B calling notify () to the object used as 'lock' ( in this case A)
    
-   The notify() statement, wakes the first thread up who called wait() on the object
    
-   The notifyAll() instruction, wake every thread up that are waiting for the object
![imagen de ejercicio primos]( images/primos)  

## 

Part 2[](#part-2)

SnakeRace is an autonomous version, multi-snake of the famous game called 'snake' based on the Joao Andrade´s project-this exercise is a fork thereof

-   N snakes works as an autonomous way.
    
-   The collision concept does not exists among them. The only way that they die is by crashing against a wall
    
-   There are mice distributed along the game. As in the classic game, each time a snake eats a mouse, it grows
    
-   There are some points (red arrows) that teleport the snakes
    
-   the rays causes that the snake increase its speed
    

![](https://blobscdn.gitbook.com/v0/b/gitbook-28427.appspot.com/o/assets%2F-LWJN2LirJZqzEmpZ3Gn%2F-LXX1N13pZ0J3aLfpIVs%2F-LXX30GuNDr3OE0TrP6I%2Fsshot.png?alt=media&token=1fc9f721-58b1-41e3-adc1-9566520149dc)

## 

Part 3[](#part-3)

1.  Analyse the code in order to understand how the threads are being used to create an autonomous behavior in the N snakes
    
2.  Accordingly, and using the game logic, identify and write clearly (ANSWERS.txt file)
    
    1.  Possible race conditions
	    >* More than 1 snake trying to eat a mice at the same time
	    >* 2 heads of snakes try to be in the same position
        
    2.  An incorrect or inappropriate use of collections, considering its concurrent handling(For this increase the game speed and execute it multiples times until an error has been raised).
    > appeard 2 errors when raising the game speed java.util.ConcurrentModificationException and java.lang.NullPointerException, this because, java try to access a cell where there where 2 heads of sanke because of a non syncronized method

        
    4.  Unnecessary use of active waits
        
    
3.  Identify critical regions associated with race conditions, and do something in order to eliminate them.Note that you have to synchronize strictly needed. In the answers document suggest the solution proposed for each item of the point 2. As the same way note that you don´t have to add more race conditions
> it may be fix with Collections.synchronizedList(new LinkedList());
    
5.  As you can see, the game is incomplete. Write code in order to implement functionallities through buttons in the GUI to start / Pause / Resume the game: start the game if it has not started, Pause the game if it is on, Resume the game if it is suspended. Keep in mind:
    
    1.  When the game has been paused, in some point of the screen you have to show
        
        1.  the longest snake
            
        2.  The worst snake:(the first snake dead)
            
        
        Remember that the pause of the snakes are not instantanious, and you have to guarantee that all the information showed is consistent