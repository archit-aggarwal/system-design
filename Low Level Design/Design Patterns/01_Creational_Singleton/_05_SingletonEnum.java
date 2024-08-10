import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/*
 * ENUM's constructor gets invoked by JVM not by User who is using so reflection API cannot be used on it.
 * Another advantage of using enum is, we don't need to worry about threads as it is thread safe.
 * It also solved the problem of Serialization as JVM takes care to return same object.
 * Advantage:it overcomes all challenges of thread safety, serializable safety, reflection API safety.
 * Disadvantage: Though, this is using eager initialization (during enum loading) instead of lazy loading
 */
enum Logger {
  INSTANCE;

  public void log(String message) {
    System.out.println(this + " @ " 
        + this.hashCode() + " : " + message);
  }
}

public class _05_SingletonEnum extends Thread {
  @Override
  public void run() {
    Logger.INSTANCE.log("Logging From Thread : " 
        + Thread.currentThread());
  }

  public static void threadSafety() {
    Thread t1 = new _05_SingletonEnum();
    Thread t2 = new _05_SingletonEnum();
    Thread t3 = new _05_SingletonEnum();
    Thread t4 = new _05_SingletonEnum();
    Thread t5 = new _05_SingletonEnum();
    Thread t6 = new _05_SingletonEnum();
    Thread t7 = new _05_SingletonEnum();
    Thread t8 = new _05_SingletonEnum();
    
    t1.start(); t2.start(); t3.start();
    t4.start(); t5.start(); t6.start();
    t7.start(); t8.start();
  }

  public static void serializableSafety() throws Exception{
    Logger singleton1 = Logger.INSTANCE;
    
    ObjectOutputStream outputStream = 
      new ObjectOutputStream(new FileOutputStream("object.obj"));
    outputStream.writeObject(singleton1);
    outputStream.close();

    ObjectInputStream inputStream = 
      new ObjectInputStream(new FileInputStream("object.obj"));
    Logger singleton2 = (Logger) inputStream.readObject();
    inputStream.close();

    singleton1.log("Logging From Object Before Serialization");
    singleton2.log("Logging From Object After Serialization");
  }

  @SuppressWarnings("all")
  public static void reflectionSafety() throws Exception {
    Logger singleton1 = Logger.INSTANCE;

    Constructor[] constructors = Logger.class.getDeclaredConstructors();
    Constructor constructor = constructors[0];
    constructor.setAccessible(true);
    Logger singleton2 = (Logger) constructor.newInstance();

    singleton1.log("Logging From Object Using getInstance() Method");
    singleton2.log("Logging From Object Using Reflection API");
  }

  public static void main(String[] args) {
    try{
     threadSafety();
     serializableSafety();
     reflectionSafety();
    } catch(Exception e){
      System.out.println("Exception : " + e);
    }
  }
}
