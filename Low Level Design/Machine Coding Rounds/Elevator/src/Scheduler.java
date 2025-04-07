import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Scheduler extends Thread {
    private final BlockingQueue<Request> requests = new LinkedBlockingQueue<>();
    private final int MAXIMUM_FLOORS;
    private final List<Elevator> elevators = new ArrayList<>();

    public Scheduler(int noOfFloors, int noOfElevators) {
        this.MAXIMUM_FLOORS = noOfFloors;

        for(int id = 1; id <= noOfElevators; id++) {
            Elevator elevator = new Elevator(id);
            elevators.add(elevator);
            elevator.start(); // Start Elevator Thread
        }

        this.start(); // Start Scheduler Thread
    }

    public void addRequest(Request request) {
        Integer requestedFloor = request.getFloor();
        if(requestedFloor == null || requestedFloor < 0 || requestedFloor > MAXIMUM_FLOORS) {
            System.out.println("Invalid Floor Requested."); return;
        }
        requests.add(request);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = requests.take(); // blocks until request available
                request.handle(elevators);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
