package elevator.request;

public class ExternalRequest extends Request{
    Direction direction;

    ExternalRequest(Direction direction) {
        this.direction = direction;
    }
}
