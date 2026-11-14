package entity;

public class TrafficLight {
    private Integer id;
    private Signal signal;
    private Integer timer;

    public TrafficLight(Integer id, Integer timer) {
        this.id = id;
        this.signal = Signal.RED;
        this.timer = timer;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getTimer() {
        return this.timer;
    }

    public Signal getSignal() {
        return this.signal;
    }

    public void setTimer(Integer timer) {
        this.timer = timer;
    }

    public void setSignal(Signal signal) {
        this.signal = signal;
    }

    public void reduceTimer() {
        this.timer -= 1;
    }

    public void changeSignal(Signal signal) {
        this.signal = signal;
    }
}
