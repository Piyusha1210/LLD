import entity.Road;
import entity.Signal;
import entity.TrafficLight;

import java.util.List;

public class TrafficSignalSystem {

    private static TrafficSignalSystem instance;
    private List<Road> roads;
    private List<TrafficLight> trafficLights;
    private Integer defaultTimer = 10;

    private TrafficSignalSystem() {
        for(int i = 0; i < 4; i++) {
            Integer timer = (defaultTimer + 2) * i + 1;
            TrafficLight trafficLight = new TrafficLight(i, timer);
            trafficLights.add(trafficLight);
            roads.add(new Road(i, trafficLight));
        }
    }

    public TrafficSignalSystem getInstanse() {
        if(instance == null) {
            instance = new TrafficSignalSystem();
        }
        return instance;
    }

    public void changeDefaultTimer(Integer timer) {
        this.defaultTimer = timer;
    }

    public void decreaseTimer() {
        trafficLights.stream().forEach(trafficLight -> {
            trafficLight.reduceTimer();
            if(trafficLight.getTimer() == 0) {
                changeSignal(trafficLight);
            }
        });
    }

    public void changeSignal(TrafficLight trafficLight) {
        if(trafficLight.getSignal() == Signal.RED) {
            trafficLight.setSignal(Signal.GREEN);
            trafficLight.setTimer(10);
        } else if(trafficLight.getSignal() == Signal.GREEN) {
            trafficLight.setSignal(Signal.YELLOW);
            trafficLight.setTimer(2);
        } else {
            trafficLight.setSignal(Signal.RED);
            trafficLight.setTimer(36);
            Integer nextLightID = (trafficLight.getId()+1) % 4;
            TrafficLight nextTrafficLight = trafficLights.get(nextLightID);
            changeSignal(nextTrafficLight);
        }
    }

    public void emergencyVehicle(Integer roadId) {

    }

}
