package com.zi.mall.mapper;

import com.zi.mall.domain.GoodsImg;
import com.zi.mall.domain.GoodsImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsImgMapper {
    long countByExample(GoodsImgExample example);

    int deleteByExample(GoodsImgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsImg record);

    int insertSelective(GoodsImg record);

    List<GoodsImg> selectByExample(GoodsImgExample example);

    GoodsImg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsImg record, @Param("example") GoodsImgExample example);

    int updateByExample(@Param("record") GoodsImg record, @Param("example") GoodsImgExample example);

    int updateByPrimaryKeySelective(GoodsImg record);

    int updateByPrimaryKey(GoodsImg record);
    /**
     * 查询商品对应的图片列表
     *
     */
    List<GoodsImg> selectGoodsImgs(Integer id);
    /**
     * 更新商品编号
     */
    int updateGoodsId(Integer goodsId);
    /**
     * 更新图片url
     */
    int updateGoodsImg(GoodsImg goodsImg);
}