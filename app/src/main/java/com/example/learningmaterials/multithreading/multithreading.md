# 多线程

### 多线程与线程同步

多线程使用：
1. Thread：重写run定义工作
2. Runnable：传入Thread定义工作
3. threadFactory：线程批量创建
4. Executor：线程批量创建，线程池
5. Future + Callable + ExecutorService：等待线程返回值

线程同步：

1. Synchronized1Demo：多线程共享running变量，需要解决可见性，一般用volatile、AtomicBoolean
2. Synchronized2Demo：多线程修改x变量，需要解决原子性和可见性，一般通过synchronized、AtomicInteger
3. Synchronized3Demo：通过锁保护资源，锁方法或者锁对象，一个锁只能被一个线程持有

### 线程通信

1. ThreadInterractionDemo：interrupt()中断线程，在InterruptedException中回收资源，结束线程
2. WaitDemo：wait()释放锁，等待下一次唤醒、notifyAll()唤醒所有等待锁

### Android多线程机制

1. customThread：Android线程的简单模型
2. threadLocal：建立线程独有的资源
3. handlerThread：启动一个自带Lopper的线程
4. 废弃AsyncTask：没有static会发生内存泄漏 1.线程是GC Root对象 2.当MyAsyncTask生命周期比Activity长