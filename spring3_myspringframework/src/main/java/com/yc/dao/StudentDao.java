package com.yc.dao;

import com.yc.springframework.stereotype.MyRepository;

//@MyRepository
public interface StudentDao {
    public int add(String name);

    public void update(String name);
}
