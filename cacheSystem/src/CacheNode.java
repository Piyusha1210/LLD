public class CacheNode {

    String key;
    ValueDto value;
    Long expireTime;
    CacheNode next;
    CacheNode prev;


    public CacheNode(String key, ValueDto value, Long expireTime) {
        this.key = key;
        this.value = value;
        this.expireTime = expireTime;
    }
}
