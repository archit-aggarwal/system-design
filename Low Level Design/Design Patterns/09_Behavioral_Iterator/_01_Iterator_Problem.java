import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Train {
  private String trainName;
  private String departureTime; // Format: HH:mm

  public Train(String trainName, 
        String departureTime) {
      this.trainName = trainName;
      this.departureTime = departureTime;
  }

  public String getTrainName() {
      return trainName;
  }

  public String getDepartureTime() {
      return departureTime;
  }

  @Override
  public String toString() {
      return trainName + " (Departure: " 
        + departureTime + ")";
  }
}

class TrainCollection {
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
}

public class _01_Iterator_Problem {
  public static void main(String[] args) {
    TrainCollection trainCollection = new TrainCollection();
    trainCollection.addTrain(new Train("Express 101", "12:30"));
    trainCollection.addTrain(new Train("Fast Track 202", "10:45"));
    trainCollection.addTrain(new Train("Regional 303", "14:00"));

    List<Train> trains = trainCollection.getTrains();

    // Manually sorting for increasing departure time
    System.out.println("Trains in increasing order of departure:");
    Collections.sort(trains, Comparator.comparing(Train::getDepartureTime));
    for (Train train : trains) {
        System.out.println(train);
    }

    // Manually sorting for decreasing departure time
    System.out.println("\nTrains in decreasing order of departure:");
    Collections.sort(trains, Comparator.comparing(Train::getDepartureTime).reversed());
    for (Train train : trains) {
        System.out.println(train);
    }
  }
}
