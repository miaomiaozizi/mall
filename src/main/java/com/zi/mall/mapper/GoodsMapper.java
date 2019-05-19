package com.zi.mall.mapper;

import com.zi.mall.domain.Goods;
import com.zi.mall.domain.GoodsExample;
import com.zi.mall.vo.GoodsVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    /**
     * 查询热销
     * @param sum
     * @return
     */

    List<Goods> selectHotGoods(Integer sum);
    /**
     * 查询新品
     */
    List<Goods> selectNewGoods(Integer sum);
    /**
     * 模糊查询商品列表
     *
     */
    List<GoodsVo> selectGoodsList(GoodsVo goodsVo);
}