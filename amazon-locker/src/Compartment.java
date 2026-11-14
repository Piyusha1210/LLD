public class Compartment {
    private final Long compartmentId;
    private final Size size;
    private Boolean isEmpty;

    public Compartment(Long compartmentId, Size size) {
        this.compartmentId = compartmentId;
        this.size = size;
        this.isEmpty = true;
    }

    public Long getCompartmentId() {
        return compartmentId;
    }

    public Size getSize() {
        return size;
    }

    public Boolean getIsEmpty() {
        return isEmpty;
    }

    public void setContainerEmpty() {
        isEmpty = true;
    }

    public void setContainerFilled() {
        isEmpty = false;
    }

    public void open() {}

    public void close() {}
}
