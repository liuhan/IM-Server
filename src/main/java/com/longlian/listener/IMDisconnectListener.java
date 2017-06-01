package com.longlian.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.longlian.model.User;
import com.longlian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liuhan on 2017-06-01.
 */
@Component
public class IMDisconnectListener implements DisconnectListener {
    @Autowired
    UserService userService;
    @Override
    public void onDisconnect(SocketIOClient client) {
        User u =  userService.getUserInfoBySessionId(client.getSessionId().toString());
        client.getNamespace().getBroadcastOperations().sendEvent("system", u.getName() + "下线了");
    }
}
