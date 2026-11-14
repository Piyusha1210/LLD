import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cache {

    private CacheNode head;
    private CacheNode tail;
    private Map<String, CacheNode> cacheMap;
    private static Cache instance;
    private Long TTL = 1000L;
    private Integer maxSize = 10;

    private Cache() {
        cacheMap = new HashMap<>();
        this.head = new CacheNode("head", null, getExpiryTime());
        this.tail = new CacheNode("tail", null, getExpiryTime());
        head.next = tail;
        tail.prev = head;
    }

    public static Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }

    public void put(String key, ValueDto value) {
        removeExpiredCache();
        CacheNode node = cacheMap.get(key);
        if(node == null) {
            node = new CacheNode(key, value, getExpiryTime());
            insertNode(node);
        } else {
            node.value = value;
            updateNode(node);
        }
    }

    public ValueDto get(String key) {
        removeExpiredCache();
        CacheNode cacheNode = cacheMap.get(key);
        if(cacheNode == null) {
            return null;
        }
        updateNode(cacheNode);
        return cacheNode.value;
    }

    private void updateNode(CacheNode cacheNode) {
        cacheNode.expireTime = getExpiryTime();
        removeNode(cacheNode);
        insertNode(cacheNode);
    }

    private void insertNode(CacheNode cacheNode) {
        if(Objects.equals(cacheMap.size(), maxSize)) {
            removeNode(tail.prev);
        }
        cacheNode.next = head.next;
        head.next.prev = cacheNode;
        cacheNode.prev = head;
        head.next = cacheNode;
        cacheMap.put(cacheNode.key, cacheNode);
    }

    private void removeNode(CacheNode cacheNode) {
        cacheNode.prev.next = cacheNode.next;
        cacheNode.next.prev = cacheNode.prev;
        cacheMap.remove(cacheNode.key);
    }
    
    private Long getExpiryTime() {
        return System.currentTimeMillis() + TTL;
    }

    private void removeExpiredCache() {
        if(!cacheMap.isEmpty() && tail.prev.expireTime < System.currentTimeMillis()) {
            removeNode(tail.prev);
            removeExpiredCache();
        }
    }
}
