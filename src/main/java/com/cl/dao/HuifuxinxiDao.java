package com.cl.dao;

import com.cl.entity.HuifuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.HuifuxinxiView;


/**
 * 回复信息
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:54:27
 */
public interface HuifuxinxiDao extends BaseMapper<HuifuxinxiEntity> {
	
	List<HuifuxinxiView> selectListView(@Param("ew") Wrapper<HuifuxinxiEntity> wrapper);

	List<HuifuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<HuifuxinxiEntity> wrapper);
	
	HuifuxinxiView selectView(@Param("ew") Wrapper<HuifuxinxiEntity> wrapper);
	
	List<HuifuxinxiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<HuifuxinxiEntity> wrapper);

}
