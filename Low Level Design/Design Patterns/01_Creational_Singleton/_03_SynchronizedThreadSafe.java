/**
 * To avoid multiple instances getting created in multi-threaded application, we can 
 * make getInstance() become synchronized so that only one thread at a time can access it.
 * Drawback -> Multiple threads will have to wait for both steps (returning already 
 * instance or creating first instance), hence latency will increase.
 */
class Logger {
  private static Logger instance;

  private Logger(){}

  public static synchronized Logger getInstance() {
    if(instance == null) instance = new Logger();
    return instance;
  }

  public void log(String message) {
    System.out.println(this + " : " + message);
  }
}

public class _03_SynchronizedThreadSafe extends Thread {
    @Override
    public void run() {
      Logger logger = Logger.getInstance();
      logger.log("Logging From Thread : " 
          + Thread.currentThread());
    }
  
    public static void main(String[] args){
       Thread t1 = new _03_SynchronizedThreadSafe();
       Thread t2 = new _03_SynchronizedThreadSafe();
       Thread t3 = new _03_SynchronizedThreadSafe();
       Thread t4 = new _03_SynchronizedThreadSafe();
       Thread t5 = new _03_SynchronizedThreadSafe();
       Thread t6 = new _03_SynchronizedThreadSafe();
       Thread t7 = new _03_SynchronizedThreadSafe();
       Thread t8 = new _03_SynchronizedThreadSafe();
       
       t1.start();  t2.start(); t3.start();
       t4.start();  t5.start(); t6.start();
       t7.start();  t8.start();
    }
}


