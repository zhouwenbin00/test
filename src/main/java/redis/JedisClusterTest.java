package redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import javax.xml.crypto.Data;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/** @author zwb */
public class JedisClusterTest {

    static class JedisUtils {
        private static final Set<HostAndPort> hostAndPorts = new HashSet<>();
        private static final JedisCluster jedis;

        static {
            for (int i = 1; i <= 6; i++) {
                HostAndPort hostAndPort = new HostAndPort("172.20.188.154", 1000 + i);
                hostAndPorts.add(hostAndPort);
            }
            jedis = new JedisCluster(hostAndPorts);
        }

        public static JedisCluster getInstance() {
            return jedis;
        }
    }

    @Test
    public void test() {
        JedisCluster instance = JedisUtils.getInstance();
        Set<String> hkeys = instance.hkeys("*");
        System.out.println(hkeys);
    }

    static class Log {
        public String playerName;
        public long roleId;
        public String templateNum;
        public String serverId;
        public int luckyNum;
        public long time;

        private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        @Override
        public String toString() {
            return roleId
                    + "\t"
                    + serverId
                    + "\t"
                    + playerName
                    + "\t"
                    + templateNum
                    + "\t"
                    + luckyNum
                    + "\t"
                    + simpleDateFormat.format(new Date(time));
        }
    }

    @Test
    public void name() throws IOException {
        File file = new File("C:\\Users\\mshz\\Documents\\新建文本文档.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String ss =
                "{\"playerName\":\"Albie\",\"roleId\":2546325670256327797,\"templateNum\":\"XX52X\",\"time\":1578988498034,\"serverId\":\"S46\",\"luckyNum\":49528}";
        String str = null;
        List<Log> logs = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        while ((str = bufferedReader.readLine()) != null) {
            str = str.substring(1, str.length() - 1);
            System.out.println(str);
            str = str.replaceAll("\\\\", "");
            System.out.println(str);
            Log log = JSON.parseObject(str, Log.class);

            logs.add(log);
            map.put(log.templateNum, map.getOrDefault(log.templateNum, 0) + 1);
        }

        map.forEach(
                (k, v) -> {
                    System.out.println(String.format("templateNum:%s--num:%s", k, v));
                });
        System.out.println("count:" + logs.size());
        logs.forEach(System.out::println);

        // close
        fileInputStream.close();
        bufferedReader.close();
    }
}
