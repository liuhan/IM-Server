package com.longlian.service.impl;

import com.longlian.dao.RoomMapper;
import com.longlian.model.Room;
import com.longlian.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuhan on 2017-05-31.
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public List<Room> getRoomByStatus(String status) {
        return roomMapper.getRoomByStatus(status);
    }
}
