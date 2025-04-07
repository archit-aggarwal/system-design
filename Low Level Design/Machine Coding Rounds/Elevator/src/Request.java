import java.util.List;

public abstract class Request {
    private final Integer floor;
    public Request(Integer floor) { this.floor = floor; }
    public Integer getFloor() { return floor; }
    public abstract void handle(List<Elevator> elevators);
}
