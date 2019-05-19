package com.zi.mall.mapper;

import com.zi.mall.domain.UserAdd;
import com.zi.mall.domain.UserAddExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAddMapper {
    long countByExample(UserAddExample example);

    int deleteByExample(UserAddExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAdd record);

    int insertSelective(UserAdd record);

    List<UserAdd> selectByExample(UserAddExample example);

    UserAdd selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAdd record, @Param("example") UserAddExample example);

    int updateByExample(@Param("record") UserAdd record, @Param("example") UserAddExample example);

    int updateByPrimaryKeySelective(UserAdd record);

    int updateByPrimaryKey(UserAdd record);
    /**
     * 更新默认地址
     */
    int updateDefaultAddress(Integer userId);
}