import java.util.TreeSet;

public class Elevator extends Thread {
    private final int elevatorId;
    private final String color;

    public Elevator(int elevatorId) {
        this.elevatorId = elevatorId;
        int r = (elevatorId * 50) % 256, g = (elevatorId * 100) % 256, b = (elevatorId * 150) % 256;
        this.color = String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
    }

    private final TreeSet<Integer> stops = new TreeSet<>();
    private int currFloor = 0;
    private ElevatorState state = ElevatorState.IDLE;

    public int getElevatorId() { return elevatorId; }
    public String getColor() { return color; }
    public synchronized void addStop(int floor) { stops.add(floor); }
    public synchronized ElevatorState getElevatorState() { return state; }
    public synchronized Integer getMaxFloor() { return stops.last(); }
    public synchronized Integer getMinFloor() { return stops.first(); }

    public synchronized Integer getNextStop() {
        if(stops.isEmpty()) return currFloor;

        if(state == ElevatorState.UP) {
            Integer ceil = stops.ceiling(currFloor);
            return (ceil != null) ? ceil : getMaxFloor();
        }

        if(state == ElevatorState.DOWN) {
            Integer floor = stops.floor(currFloor);
            return (floor != null) ? floor : getMinFloor();
        }

        Integer low = getMinFloor(), high = getMaxFloor();
        return (Math.abs(high - currFloor) <= Math.abs(currFloor - low)) ? high : low;
    }

    @Override
    public void run() {
        while(true) {
            Integer nextStop = this.getNextStop();
            if(nextStop > currFloor) state = ElevatorState.UP;
            else if(nextStop < currFloor) state = ElevatorState.DOWN;

            while(nextStop != currFloor) {
                currFloor += (state == ElevatorState.UP) ? +1 : -1;
                System.out.println(color + "Elevator " + elevatorId + " moved to " + currFloor + " floor.");
                this.wait(2);
            }

            if(stops.isEmpty()) continue;
            System.out.println(color + "Door of Elevator " + elevatorId + " opens at floor " + currFloor);
            this.wait(5);
            System.out.println(color + "Door of Elevator " + elevatorId + " closes.");

            stops.remove(currFloor);
            if(stops.isEmpty()) state = ElevatorState.IDLE;
        }
    }

    private void wait(int seconds) {
        // Simulating Movement of Elevator or Door Opening
        try { Thread.sleep(seconds * 1000L); }
        catch (InterruptedException e) { System.out.println(e.getMessage()); }
    }
}
