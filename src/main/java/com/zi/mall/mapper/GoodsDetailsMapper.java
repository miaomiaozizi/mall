package com.zi.mall.mapper;

import com.zi.mall.domain.Goods;
import com.zi.mall.domain.GoodsDetails;
import com.zi.mall.domain.GoodsDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDetailsMapper {
    long countByExample(GoodsDetailsExample example);

    int deleteByExample(GoodsDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDetails record);

    int insertSelective(GoodsDetails record);

    List<GoodsDetails> selectByExample(GoodsDetailsExample example);

    GoodsDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsDetails record, @Param("example") GoodsDetailsExample example);

    int updateByExample(@Param("record") GoodsDetails record, @Param("example") GoodsDetailsExample example);

    int updateByPrimaryKeySelective(GoodsDetails record);

    int updateByPrimaryKey(GoodsDetails record);
    /**
     * 更新商品编号
     */
    int updateGoodsId(Integer goodsId);
    /**
     * 更新图片路径
     */
    int updateImgUrl(GoodsDetails goodsDetails);
}