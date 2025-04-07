import java.util.List;

public class InternalRequest extends Request {
    private final Integer elevatorId;

    public InternalRequest(Integer stop, Integer elevatorId) {
        super(stop);
        this.elevatorId = elevatorId;
    }

    @Override
    public void handle(List<Elevator> elevators) {
        Elevator elevator = null;
        for(Elevator itr : elevators) {
            if(itr.getElevatorId() == elevatorId) {
                elevator = itr; break;
            }
        }

        if(elevator == null) System.out.println("No Elevator with Id " + elevatorId + " Found");
        else {
            String color = elevator.getColor();
            System.out.println(color + "Stop [" + getFloor() + "] added for elevator " + elevatorId);
            elevator.addStop(super.getFloor());
        }
    }
}
