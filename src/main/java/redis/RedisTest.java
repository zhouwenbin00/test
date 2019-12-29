package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.params.sortedset.ZAddParams;

import java.util.List;
import java.util.Set;

/** @author zwb */
public class RedisTest {

    static class JedisUtils {

        private static final Jedis jedis = new Jedis("127.0.0.1", 6379);

        public static Jedis getInstance() {
            return jedis;
        }
    }

    /**
     * 插入
     */
    @Test
    public void test1(){
        Jedis jedis = JedisUtils.getInstance();
        ZAddParams zAddParams =  ZAddParams.zAddParams();
        zAddParams.ch();

        jedis.zadd("server-activity", 15.0, "zhangsan-10086", zAddParams);
        jedis.zadd("server-activity", 11.0, "zhangsan2-10086",zAddParams);
        jedis.zadd("server-activity", 18.0, "zhangsan3-10086",zAddParams);
//        jedis.zadd("server-activity", 11.0, "zhangsan3-10086");
//        jedis.zadd("server-activity", 23.0, "zhangsan3-10086");
    }

    /**
     * 获取分数
     */
    @Test
    public void test2(){
        test1();
        Jedis jedis = JedisUtils.getInstance();
        Double zscore = jedis.zscore("server-activity", "zhangsan3-10086");
        System.out.println(zscore);
    }

    /**
     * 获取排名
     */
    @Test
    public void test3(){
        test1();
        Jedis jedis = JedisUtils.getInstance();
        Long zrank = jedis.zrank("server-activity", "zhangsan-10086");
        System.out.println(zrank);
//        reverse倒排
        Long zrevrank = jedis.zrevrank("server-activity", "zhangsan3-10086");
        System.out.println(zrevrank);
    }

    /**
     * 排序
     */
    @Test
    public void test4(){
        test1();
        Jedis jedis = JedisUtils.getInstance();
        SortingParams sortingParams = new SortingParams();
        sortingParams.alpha().asc().by("score");
        List<String> sort = jedis.sort("server-activity", sortingParams);
        System.out.println(sort);
    }

    /**
     * 获取指定索引的玩家
     */
    @Test
    public void test5(){
        test1();
        Jedis jedis = JedisUtils.getInstance();
        Long zcard = jedis.zcard("server-activity");
        Set<String> zrange = jedis.zrange("server-activity", 0, zcard);
        System.out.println(zrange);
        Set<String> zrevrange = jedis.zrevrange("server-activity", 0, zcard);
        System.out.println(zrevrange);
    }

    /**
     * 统计基数
     */
    @Test
    public void test6(){
        test1();
        Jedis jedis = JedisUtils.getInstance();
        Long zcard = jedis.zcard("server-activity");
        System.out.println(zcard);
    }

    /**
     * 删除
     */
    @Test
    public void test7(){
        test1();
        Jedis jedis = JedisUtils.getInstance();
        Long zrem = jedis.zrem("server-activity", "zhangsan2-10086");
        System.out.println(zrem);
    }
    public static void main(String[] args) {
        Jedis jedis = JedisUtils.getInstance();
        jedis.set("Jedis", "helloworld");
        jedis.close();



        Double zincrby = jedis.zincrby("server-activity", 12.0, "zhangsan-10086");
        System.out.println(zincrby);

        Set<String> strings = jedis.zrangeByScore("server-activity", 0, 30);
        System.out.println(strings);

    }
}
