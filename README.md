# Resolving Threads exercices from web in Java
1) Do a program to calculates the sum of each row of a matrix using threads.

# Java Threads: Basic Explanation ☕

In Java, a thread is the smallest unit of execution. It allows programs to perform multiple tasks concurrently, making
it possible to perform operations like I/O, computations, and background tasks without blocking the main thread.

## How Threads Work

* Each thread runs a separate path of execution inside the same program.
* Java provides the Thread class and the Runnable interface to create and manage threads.

## Types of Threads

Threads in Java are broadly classified into two categories:

### User Threads:

* These are the standard threads created by the application for specific tasks.
* They remain active until they complete their tasks or are explicitly terminated.
* Examples: Threads for handling client requests in a server, background computation threads, etc.

### Daemon Threads:

* These are low-priority threads designed to run in the background and provide services to user threads.
* They terminate automatically when all user threads have finished execution.
* Examples: Garbage collection thread, background monitoring threads, etc.
* To set a thread as a daemon thread
  <br/>` Thread thread = new Thread(task);`
  <br/>` thread.setDaemon(true);`

## Traditional Threads vs. Virtual Threads

With Java's Project Loom (introduced in Java 19 as a preview), Virtual Threads were introduced to simplify thread
management and improve scalability. Here's a comparison:

| Aspect         | Traditional (Platform) Threads                            | Virtual Threads                                  |
|----------------|-----------------------------------------------------------|--------------------------------------------------|
| Implementation | Backed by the OS threads.                                 | Managed entirely by the JVM, not the OS.         |
| Resource Usage | Limited by the number of OS threads.                      | Lightweight, can have millions of threads.       |
| Blocking       | 	Blocking a thread blocks an OS thread.                   | Blocking is handled by the JVM scheduler.        |
| Scalability    | Heavy and resource-intensive for large-scale concurrency. | Highly scalable due to their lightweight nature. |
| Creation Time  | 	Expensive and time-consuming.                            | Fast and efficient to create.                    |
| Use Cases      | Suitable for CPU-intensive tasks.                         | Ideal for high-concurrency I/O tasks.	           |


### Key Features of Virtual Threads
* They are lightweight threads managed by the JVM.
* Each virtual thread has its own stack but shares the OS thread pool.
* Makes it easy to write code for high-concurrency applications (like servers) without worrying about the limitations of OS threads.

### Problems while using Threads:
1. Race Conditions

    Occurs when multiple threads access shared data simultaneously.

    The result depends on the execution order of threads.

    Hard to reproduce and debug.

2. Deadlocks

    Happens when two or more threads block each other while waiting for resources.

    Each thread holds a resource that the other needs.

3. Livelocks

    Similar to deadlocks, but threads keep "working" without making progress.

    They keep responding to each other in a way that prevents actual execution.

4. Starvation

    A thread is unable to access shared resources for a long time.

    Occurs when higher-priority threads monopolize resources.

5. Visibility Issues

    Changes made by one thread may not be immediately visible to others.

    Caused by compiler/JVM optimizations and CPU caching.

6. Incorrect Use of wait(), notify(), and notifyAll()

    Forgetting to call them inside a synchronized block.

    Using notify() when notifyAll() is needed.

    Checking conditions in if instead of while loops.

7. Thread Leaks

    Creating threads in pools but never shutting them down properly.

    Forgetting to call shutdown() on ExecutorService.

8. Synchronizing on the Wrong Objects

    Synchronizing on mutable objects or different instances.

    Using string literals as locks (risky due to string interning).

9. Excessive Synchronization

    Can lead to contention and performance degradation.

    Overly large synchronized blocks.

10. Issues with Non-Thread-Safe Collections

    Using ArrayList, HashMap, etc., in multi-threaded environments without proper synchronization.

Tips to Avoid Threading Problems:

    Prefer classes from java.util.concurrent.

    Use volatile for simple flags.

    Consider immutability where possible.

    For complex synchronization, prefer ReentrantLock over synchronized.

    Always document your thread-safety strategies.

Generated with ChatGPT/DeepSeek 🤖
