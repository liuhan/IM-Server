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

import com.corundumstudio.socketio.SocketIOServer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.longlian.model.Course;
import com.longlian.service.CourseService;
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
import java.util.Properties;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	@Autowired
	PageInterceptor pageInterceptor;
	@Autowired
	SocketIOServer socketIOServer;
	@Override
	public void run(String... args) {
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
