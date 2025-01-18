import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Train {
  private String trainName;
  private String departureTime; // Format: HH:mm

  public Train(String trainName, String departureTime) {
      this.trainName = trainName;
      this.departureTime = departureTime;
  }

  public String getTrainName() 
  { return trainName; }

  public String getDepartureTime() 
  { return departureTime; }

  @Override
  public String toString() {
      return trainName + " (Departure: " 
      + departureTime + ")";
  }
}

class TrainCollection implements Iterable<Train> {
  private List<Train> trains;

  public TrainCollection() {
      trains = new ArrayList<>();
  }

  public void addTrain(Train train) {
      trains.add(train);
  }

  public List<Train> getTrains() {
      return trains;
  }

  @Override
  public Iterator<Train> iterator() {
    // default iteration
    return new IncreasingDepartureIterator(trains);
  }
}

class IncreasingDepartureIterator implements Iterator<Train> {
  private List<Train> trains;
  private int currentPosition = 0;

  public IncreasingDepartureIterator(List<Train> trains) {
      this.trains = new ArrayList<>(trains);
      this.trains.sort(Comparator.comparing(Train::getDepartureTime));
  }

  @Override
  public boolean hasNext() {
      return currentPosition < trains.size();
  }

  @Override
  public Train next() {
      return trains.get(currentPosition++);
  }
}

class DecreasingDepartureIterator implements Iterator<Train> {
  private List<Train> trains;
  private int currentPosition = 0;

  public DecreasingDepartureIterator(List<Train> trains) {
      this.trains = new ArrayList<>(trains);
      this.trains.sort(Comparator.comparing(
          Train::getDepartureTime).reversed());
  }

  @Override
  public boolean hasNext() {
      return currentPosition < trains.size();
  }

  @Override
  public Train next() {
      return trains.get(currentPosition++);
  }
}

public class _02_Iterator_Solution {
  public static void main(String[] args) {
      Train t1 = new Train("Uttar Sampark Kranti", "06:00");
      Train t2 = new Train("Shri Shakti Superfast", "23:30");
      Train t3 = new Train("Vande Bharat Express", "10:15");

      TrainCollection trainCollection = new TrainCollection();
      trainCollection.addTrain(t1);
      trainCollection.addTrain(t2);
      trainCollection.addTrain(t3);

      System.out.println("Trains with First Departures First:");
      Iterator<Train> increasingDepartureIterator = trainCollection.iterator();
      while (increasingDepartureIterator.hasNext()) {
          System.out.println(increasingDepartureIterator.next());
      }

      System.out.println("-----");

      // Using Iteratable (for each loop - Java inbuilt)
      for(Train train : trainCollection.getTrains()) {
        System.out.println(train);
      }

      System.out.println("-----");

      System.out.println("Trains With Last Departures First");
      Iterator<Train> leastDurationIterator = 
          new DecreasingDepartureIterator(trainCollection.getTrains());
      while (leastDurationIterator.hasNext()) {
          System.out.println(leastDurationIterator.next());
      }
  }
}
