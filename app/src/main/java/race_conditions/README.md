# Race Condition
* The problem: use a race condition in a shared counter variable inside a class
Is valid to know that:
<br>-> In newests versions of Java you have JIT Compiler Optimization that can be "correcting" the code and presenting
then good results.
<br>-> The execution time if is too short (maybe using 100 as a for range) probably will turn into impossible the replication of the problem.
<br>-> If one thread ends its execution and then another one starts, theres no concurrency so theres no Race Condition.

1. Usage of `synchronized`, limits to one thread at time per block execution
2. Usage of AtomicInteger forces atomic CPU operations (CAS - Compare-And-Swap)
3. Usage of ReentrantLock, offers more control while compared to synchronized