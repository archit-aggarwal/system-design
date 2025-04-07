import java.util.List;

public class ExternalRequest extends Request {
    private final ElevatorState direction;

    public ExternalRequest(Integer floor, ElevatorState direction) {
        super(floor);
        this.direction = direction;
    }

    @Override
    public void handle(List<Elevator> elevators) {
        Elevator bestElevator = elevators.getFirst();
        int minCost = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int cost = getCost(elevator);
            if (cost < minCost) {
                minCost = cost;
                bestElevator = elevator;
            }
        }

        System.out.println(bestElevator.getColor() + "External Request: [" + getFloor()
                + "," + direction + "], picked by Elevator " + bestElevator.getElevatorId());
        bestElevator.addStop(super.getFloor());
    }

    private int getCost(Elevator elevator) {
        ElevatorState state = elevator.getElevatorState();
        Integer source = elevator.getNextStop(), destination = super.getFloor();

        switch (state) {
            case IDLE -> { return Math.abs(source - destination); }
            case UP -> {
                if(destination >= source && direction == ElevatorState.UP) return destination - source;
                return 2 * (elevator.getMaxFloor() - destination);
            }
            case DOWN -> {
                if(destination <= source && direction == ElevatorState.DOWN) return source - destination;
                return 2 * (destination - elevator.getMinFloor());
            }
        }

        return 0;
    }
}