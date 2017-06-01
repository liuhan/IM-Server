package com.longlian.listener;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.listener.DataListener;
import com.longlian.MainApplication;
import com.longlian.model.User;
import com.longlian.service.RoomService;
import com.longlian.service.UserService;
import com.longlian.util.JsonUtil;
import com.longlian.util.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.UUID;

/**
 * Created by liuhan on 2017-05-31.
 */
@Component
public class MessageDataListener<IMMessage> implements DataListener<IMMessage> {

    private static final Logger logger = LoggerFactory
            .getLogger(MessageDataListener.class);

     @Autowired
     UserService userService;
    /**
     * Invokes when data object received from client
     *
     * @param client    - receiver
     * @param data      - received object
     * @param ackSender
     */
    @Override
    public void onData(SocketIOClient client, IMMessage data, AckRequest ackSender) throws Exception {
        logger.info("收到消息:{}" , JsonUtil.toJson(data));
        UUID sessionId = client.getSessionId();
        com.longlian.model.IMMessage message = (com.longlian.model.IMMessage)data;

            User u =  userService.getUserInfoBySessionId(sessionId.toString());
            if (u != null) {
                message.setFrom(u.getUuid());
                message.setFromAvatar(u.getIcon());
                message.setFromNick(u.getName());
                client.getNamespace().getBroadcastOperations().sendEvent("message", message);
            } else {
                client.disconnect();
            }

    }
}
