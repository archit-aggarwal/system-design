class Hotstar {
  private String matchUpdate;

  public void setMatchUpdate(String matchUpdate) {
      this.matchUpdate = matchUpdate;
      notifySubscribers(); // Notify all subscribers manually
  }

  public void notifySubscribers() {
      // Hardcoded logic to notify each subscriber
      Cricbuzz cricbuzz = new Cricbuzz();
      Dream11 dream11 = new Dream11();

      cricbuzz.receiveUpdate(matchUpdate);
      dream11.receiveUpdate(matchUpdate);
  }
}

class Cricbuzz {
  public void receiveUpdate(String matchUpdate) {
      System.out.println("Cricbuzz received update: " + matchUpdate);
      System.out.println("Displaying scorecard based on the latest match event...");
  }
}

class Dream11 {
  public void receiveUpdate(String matchUpdate) {
      System.out.println("Dream11 received update: " + matchUpdate);
      System.out.println("Updating fantasy points based on the latest match event...");
  }
}

public class _01_Observer_Problem {
  public static void main(String[] args) {
    Hotstar hotstar = new Hotstar();
    hotstar.setMatchUpdate("Player hits a six! Score: 102/3");
  }
}