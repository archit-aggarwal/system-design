import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    final static int NO_OF_ELEVATORS = 3;
    final static int MAX_FLOOR = 10;
    final static String color = "\u001B[0m";

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler(MAX_FLOOR, NO_OF_ELEVATORS);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Request request = generateRandomRequest();
                scheduler.addRequest(request);
            }
        }, 0, 4000); // add a new request every 4 seconds
    }

    private static Request generateRandomRequest() {
        Random rand = ThreadLocalRandom.current();
        boolean isInternal = rand.nextBoolean();
        int floor = rand.nextInt(MAX_FLOOR + 1);

        if (isInternal) {
            int elevatorId = rand.nextInt(1, NO_OF_ELEVATORS + 1);
            System.out.println(color + "Internal Request: Elevator " + elevatorId + " -> Floor " + floor);
            return new InternalRequest(floor, elevatorId);
        } else {
            ElevatorState direction = (rand.nextBoolean()) ? ElevatorState.UP : ElevatorState.DOWN;
            if(floor == 0) direction = ElevatorState.UP;
            else if(floor == MAX_FLOOR) direction = ElevatorState.DOWN;
            System.out.println(color + "External Request: Floor " + floor + " -> " + direction);
            return new ExternalRequest(floor, direction);
        }
    }
}