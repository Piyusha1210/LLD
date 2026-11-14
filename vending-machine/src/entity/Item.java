package entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    String name;
    String code;
    Integer price;

    public Item(String name, String code, Integer price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }
}
