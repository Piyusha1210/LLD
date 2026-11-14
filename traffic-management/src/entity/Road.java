package entity;

public class Road {
    private Integer id;
    private TrafficLight trafficLight;

    public Road(Integer id, TrafficLight trafficLight) {
        this.id = id;
        this.trafficLight = trafficLight;
    }

    public Integer getId() {
        return id;
    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }
}
