package com.sky.service;

import com.github.pagehelper.Page;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.vo.SetmealVO;

import java.util.List;

public interface SetMealService {

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    void saveWithDish(SetmealDTO setmealDTO);

    void deleteBatch(List<Long> ids);

    void status(long id, Integer status);
}
