package com.longlian.im;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


/**
 * Created by liuhan on 2017-05-28.
 */
@org.springframework.context.annotation.Configuration
public class IMServer {
    @Value("${im.server.host}")
    private String host;

    @Value("${im.server.port}")
    private Integer port;
    private static final Logger logger = LoggerFactory
            .getLogger(IMServer.class);
    @Bean
    public SocketIOServer socketIOServer()
    {

        Configuration config = new Configuration();
        config.setPort(port);
        config.setSocketConfig(new SocketConfig());
        logger.info("服务器HOST:{}, 端口：{}" , host , port);

        config.setWorkerThreads(100);
        config.setAuthorizationListener(new AuthorizationListener() {

            public boolean isAuthorized(HandshakeData data) {
                return true;
            }
        });

        SocketIOServer server  = new SocketIOServer(config);
        return server;
    }
}
