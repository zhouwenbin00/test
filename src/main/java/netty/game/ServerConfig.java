package netty.game;

import lombok.Data;

import java.io.*;

/**
 * 服务器配置
 *
 * @author zwb
 */
@Data
public class ServerConfig extends Config {

    /** 端口 */
    private final int port;

    public ServerConfig() throws IOException {
        super();
        File file = new File("server.properties");
        InputStream inputStream = new FileInputStream(file);
        properties.load(inputStream);

        this.port = getInteger("port");
    }
}
