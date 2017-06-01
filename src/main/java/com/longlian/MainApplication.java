/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.longlian;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIONamespace;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.longlian.listener.IMAuthorizationListener;
import com.longlian.listener.IMConnectListener;
import com.longlian.listener.IMDisconnectListener;
import com.longlian.listener.MessageDataListener;
import com.longlian.model.IMMessage;
import com.longlian.model.Room;
import com.longlian.service.RoomService;
import com.longlian.simple.ChatObject;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	PageInterceptor pageInterceptor;
	@Autowired
	SocketIOServer socketIOServer;
	@Autowired
	RoomService roomService;
	@Autowired
	IMConnectListener imConnectionListener;
	@Autowired
	IMDisconnectListener imDisconnectListener;
	@Autowired
	MessageDataListener messageDataListener;



	@Override
	public void run(String... args) {
		List<Room> list = roomService.getRoomByStatus("0");
		for (Room r : list) {
			logger.info("注册聊天室事件:{}" ,"/" + r.getId());
			SocketIONamespace chatnamespace = socketIOServer.addNamespace("/" + r.getId());
			chatnamespace.addEventListener("message", IMMessage.class,messageDataListener);
			chatnamespace.addConnectListener(imConnectionListener);
			chatnamespace.addDisconnectListener(imDisconnectListener);
		}
		socketIOServer.start();

	}

	private static final Logger logger = LoggerFactory
			.getLogger(MainApplication.class);

	@PostConstruct
	public void initialization() {
		sqlSessionFactory.getConfiguration().addInterceptor( pageInterceptor);
		logger.info("完成初史化");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplication.class, args);
	}

}
