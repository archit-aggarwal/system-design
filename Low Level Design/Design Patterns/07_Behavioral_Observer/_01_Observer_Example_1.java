import java.util.ArrayList;
import java.util.List;


// Subject / Observable / Publisher
interface Broadcaster {
  void addSubscriber(Subscriber subscriber);
  void removeSubscriber(Subscriber subscriber);
  void notifySubscribers();
}

// Concrete Subject (Live Cricket Broadcaster)
class Hotstar implements Broadcaster {
  private List<Subscriber> subscribers = new ArrayList<>();
  private String matchUpdate;

  public void setMatchUpdate(String matchUpdate) {
      this.matchUpdate = matchUpdate;
      notifySubscribers(); // Notify all subscribers on state change
  }

  @Override
  public void addSubscriber(Subscriber subscriber) {
      subscribers.add(subscriber);
  }

  @Override
  public void removeSubscriber(Subscriber subscriber) {
      subscribers.remove(subscriber);
  }

  @Override
  public void notifySubscribers() {
      for (Subscriber subscriber : subscribers) {
          subscriber.update(matchUpdate);
      }
  }
}

// Observer / Subscriber / Listener
interface Subscriber {
  void update(String matchUpdate);
}

// Concrete Observer 1
class Cricbuzz implements Subscriber {
  @Override
  public void update(String matchUpdate) {
      System.out.println("Cricbuzz received update: " + matchUpdate);
      System.out.println("Displaying scorecard based " 
                + "on latest match event ...");
  }
}

// Concrete Observer 2
class Dream11 implements Subscriber {
  @Override
  public void update(String matchUpdate) {
      System.out.println("Dream11 received update: " + matchUpdate);
      System.out.println("Updating fantasy points based " 
              + "on the latest match event...");
  }
}

public class _01_Observer_Example_1 {
    public static void main(String[] args) {
        // Create the broadcaster (publisher)
        Hotstar broadcaster = new Hotstar();

        // Create subscribers
        Subscriber cricbuzzUser = new Cricbuzz();
        Subscriber dream11User = new Dream11();

        // Register subscribers with the broadcaster
        broadcaster.addSubscriber(cricbuzzUser);
        broadcaster.addSubscriber(dream11User);

        // Send updates from the broadcaster
        broadcaster.setMatchUpdate("India: 150/3 in 10 overs");
        broadcaster.setMatchUpdate("India: 190/4 in 15 overs");

        broadcaster.removeSubscriber(dream11User);
        broadcaster.setMatchUpdate("India: 220/9 in 20 overs");
    }
}
