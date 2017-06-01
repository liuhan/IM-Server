package com.longlian.service;

import com.longlian.model.Room;

import java.util.List;

/**
 * Created by liuhan on 2017-05-31.
 */
public interface RoomService {
    public List<Room> getRoomByStatus(String status);
}
