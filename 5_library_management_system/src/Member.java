import java.util.UUID;

public class Member {
    String memberID;
    String name;
    String address;
    String phone;

    Member(String memberID, String name, String phone, String address) {
        this.memberID = memberID;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
}
