package com.longlian.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.longlian.model.User;
import com.longlian.service.UserService;
import com.longlian.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by liuhan on 2017-06-01.
 */
@Component
public class IMConnectListener implements ConnectListener {
    @Autowired
    UserService userService;
    private static final Logger logger = LoggerFactory
            .getLogger(IMConnectListener.class);
    @Override
    public void onConnect(SocketIOClient client) {
        String token =  client.getHandshakeData().getSingleUrlParam("token");
        String uuid = client.getHandshakeData().getSingleUrlParam("uuid");
        logger.info("客户端连接上了,sessionId:{},token:{},uuid:{}"
                ,client.getSessionId().toString() , token , uuid);
        UUID sessionId = client.getSessionId();
        User u = userService.saveInfo(token , sessionId.toString());
        client.getNamespace().getBroadcastOperations().sendEvent("system", u.getName() + "连接上了");
    }
}
