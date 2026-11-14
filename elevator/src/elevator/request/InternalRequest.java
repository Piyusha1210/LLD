package elevator.request;

public class InternalRequest extends Request{
    int floor;

    InternalRequest(int floor) {
        this.floor = floor;
    }
}
