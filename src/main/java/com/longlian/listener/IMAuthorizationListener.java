package com.longlian.listener;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.HandshakeData;
import com.longlian.dao.UserMapper;
import com.longlian.im.IMServer;
import com.longlian.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by liuhan on 2017-05-31.
 */
public class IMAuthorizationListener implements AuthorizationListener {
    @Autowired
    private UserService userService;
    /**
     * Checks is client with handshake data is authorized
     *
     * @param data - handshake data
     * @return - <b>true</b> if client is authorized of <b>false</b> otherwise
     */
    private static final Logger logger = LoggerFactory
            .getLogger(IMAuthorizationListener.class);
    @Override
    public boolean isAuthorized(HandshakeData data) {
        String token = data.getSingleUrlParam("token");
        String uuid = data.getSingleUrlParam("uuid");

        logger.info("开如验证:{}, token：{}" , uuid , token);
        if (userService.login(uuid , token)) {
            logger.info("验证成功:{}, token：{}" , uuid , token);

            return true;
        } else {
            logger.info("验证失败:{}, token：{}" , uuid , token);
            return false;
        }
    }
}
