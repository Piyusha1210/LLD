package Entities;

import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
public class DeliveryPartner {
    private String id;
    private String name;
    private Address currentLocation;
    private AtomicBoolean isAvailable;

    public DeliveryPartner(String name, Address location) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.currentLocation = location;
        this.isAvailable = new AtomicBoolean(true);
    }

    public void updateAvailability() {
        this.isAvailable.compareAndSet(false, true);
    }

    public void updateCurrentLocation(Address address) {
        this.currentLocation = address;
    }

    public boolean tryAssign() {
        return this.isAvailable.compareAndSet(true, false);
    }
}
