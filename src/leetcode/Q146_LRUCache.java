package leetcode;

/**
 * Created by GuoWeiyu on 2017-04-15.
 */
public class Q146_LRUCache {
    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

    private static class LRUCache {
        private Cache[] caches;       //缓存
        private int capacity;   //总容量
        private int count=0;      //缓存数目

        public LRUCache(int capacity) {
            this.capacity=capacity;
            caches=new Cache[capacity];
        }

        public int get(int key) {
            for (Cache cache : caches) {
                if (cache.key == key) {
                    cache.lastTime=System.nanoTime();  //更新时间
                    return cache.value;
                }
            }
            return -1;
        }

        public void put(int key, int value) {
            int index=0,i=0;        //记录lastTime最小的cache的index,即将删除
            long lastTime=System.nanoTime();
            for (i=0;i<count;i++) {
                Cache cache=caches[i];
                if (cache.key == key) {     //已经存在key，覆盖
                    cache.value=value;
                    cache.lastTime=System.nanoTime();
                    return;
                }
                if (cache.lastTime < lastTime) {    //寻找最早的时间
                    index=i;
                    lastTime=cache.lastTime;
                }
            }
            Cache newCache = new Cache(key, value, System.nanoTime());
            if (count == capacity) {        //容量满了，且未找到以存在的
                caches[index] = newCache;
            } else {            //未满，插入并数量+1
                caches[i]=newCache;
                count++;
            }
        }

    }

    private static class Cache{
        private int key;
        private int value;
        private long lastTime;      //上一次使用时间

        public Cache(int key, int value, long lastTime) {
            this.key = key;
            this.value = value;
            this.lastTime = lastTime;
        }
    }
}
