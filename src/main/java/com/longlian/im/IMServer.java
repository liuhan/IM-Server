package com.longlian.im;

import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.listener.DataListener;
import com.longlian.listener.IMAuthorizationListener;
import com.longlian.service.UserService;
import com.longlian.simple.ChatObject;
import com.sun.org.apache.xml.internal.resolver.helpers.Namespaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


/**
 * Created by liuhan on 2017-05-28.
 */
@org.springframework.context.annotation.Configuration
@Import(IMAuthorizationListener.class)
public class IMServer {
    @Value("${im.server.host}")
    private String host;

    @Value("${im.server.port}")
    private Integer port;
    @Autowired
    IMAuthorizationListener imAuthorizationListener;

    private static final Logger logger = LoggerFactory
            .getLogger(IMServer.class);
    @Bean
    public SocketIOServer socketIOServer()
    {

        Configuration config = new Configuration();
        config.setPort(port);
        config.setHostname(host);
        config.setSocketConfig(new SocketConfig());
        logger.info("服务器HOST:{}, 端口：{}" , host , port);
        //config.setAllowCustomRequests(true);
        //config.setOrigin(null);
        config.setWorkerThreads(100);

        config.setAuthorizationListener(imAuthorizationListener);
        SocketIOServer server  = new SocketIOServer(config);



        return server;
    }


}
