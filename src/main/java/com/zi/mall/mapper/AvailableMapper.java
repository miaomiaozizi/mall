package com.zi.mall.mapper;

import com.zi.mall.domain.Available;
import com.zi.mall.domain.AvailableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AvailableMapper {
    long countByExample(AvailableExample example);

    int deleteByExample(AvailableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Available record);

    int insertSelective(Available record);

    List<Available> selectByExample(AvailableExample example);

    Available selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Available record, @Param("example") AvailableExample example);

    int updateByExample(@Param("record") Available record, @Param("example") AvailableExample example);

    int updateByPrimaryKeySelective(Available record);

    int updateByPrimaryKey(Available record);
}