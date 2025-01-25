// Context Class
class Elevator {
  private ElevatorState currentState;
  private int currentFloor;

  public Elevator() {
      this.currentFloor = 0;
      this.setState(new IdleState());
  }

  public void setState(ElevatorState state) {
      this.currentState = state;
      currentState.setContext(this);
  }

  public int getCurrentFloor() {
      return currentFloor;
  }

  public void setCurrentFloor(int floor) {
      this.currentFloor = floor;
  }

  public void requestFloor(int targetFloor) {
      currentState.requestFloor(targetFloor);
  }

  public void reachFloor(int targetFloor) {
      currentState.reachFloor(targetFloor);
  }

  public void openDoor() {
      currentState.openDoor();
  }
}

abstract class ElevatorState {
  protected Elevator context;

  abstract void requestFloor(int targetFloor);
  abstract void reachFloor(int targetFloor);
  abstract void openDoor();

  public void setContext(Elevator elevator) {
    this.context = elevator;
  }
}

// Concrete State: Idle
class IdleState extends ElevatorState {
  @Override
  public void requestFloor(int targetFloor) {
      if (targetFloor > context.getCurrentFloor()) {
          context.setState(new MovingUpState());
          context.requestFloor(targetFloor);
      } else if (targetFloor < context.getCurrentFloor()) {
          context.setState(new MovingDownState());
          context.requestFloor(targetFloor);
      } else {
          context.openDoor();
      }
  }

  @Override
  public void reachFloor(int targetFloor) {
      System.out.println("Elevator is idle. Cannot move.");
  }

  @Override
  public void openDoor() {
      System.out.println("Door is opening...");
      System.out.println("Door is closing...");
  }
}

// Concrete State: Moving Up
class MovingUpState extends ElevatorState {
  @Override
  public void requestFloor(int targetFloor) {
      System.out.println("Elevator is moving up...");
      for (int i = context.getCurrentFloor() + 1; i <= targetFloor; i++) {
          System.out.println("Floor " + i);
      }
      context.setCurrentFloor(targetFloor);
      context.setState(new DoorOpenState());
      context.reachFloor(targetFloor);
  }

  @Override
  public void reachFloor(int targetFloor) {
      System.out.println("Reached floor " + targetFloor);
      context.openDoor();
  }

  @Override
  public void openDoor() {
      System.out.println("Cannot open door while moving.");
  }
}

// Concrete State: Moving Down
class MovingDownState extends ElevatorState {
  @Override
  public void requestFloor(int targetFloor) {
      System.out.println("Elevator is moving down...");
      for (int i = context.getCurrentFloor() - 1; i >= targetFloor; i--) {
          System.out.println("Floor " + i);
      }
      context.setCurrentFloor(targetFloor);
      context.setState(new DoorOpenState());
      context.reachFloor(targetFloor);
  }

  @Override
  public void reachFloor(int targetFloor) {
      System.out.println("Reached floor " + targetFloor);
      context.openDoor();
  }

  @Override
  public void openDoor() {
      System.out.println("Cannot open door while moving.");
  }
}

// Concrete State: Door Open
class DoorOpenState extends ElevatorState {
  @Override
  public void requestFloor(int targetFloor) {
    System.out.println("Closing door...");
    context.setState(new IdleState());
    context.requestFloor(targetFloor);
  }

  @Override
  public void reachFloor(int targetFloor) {
    System.out.println("Opening door...");
    context.setState(new IdleState());
    System.out.println("Closing door...");
  }

  @Override
  public void openDoor() {
      System.out.println("Door is already open.");
  }
}

public class _02_Solution_State {
  public static void main(String[] args) {
    Elevator elevator = new Elevator();

    elevator.requestFloor(3);
    elevator.requestFloor(5);
    elevator.requestFloor(1);
    elevator.requestFloor(1);
  }  
}
