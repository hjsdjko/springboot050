package com.cl.dao;

import com.cl.entity.MeiricanpuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.MeiricanpuView;


/**
 * 每日餐谱
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface MeiricanpuDao extends BaseMapper<MeiricanpuEntity> {
	
	List<MeiricanpuView> selectListView(@Param("ew") Wrapper<MeiricanpuEntity> wrapper);

	List<MeiricanpuView> selectListView(Pagination page,@Param("ew") Wrapper<MeiricanpuEntity> wrapper);
	
	MeiricanpuView selectView(@Param("ew") Wrapper<MeiricanpuEntity> wrapper);
	
	List<MeiricanpuView> selectGroupBy(Pagination page,@Param("ew") Wrapper<MeiricanpuEntity> wrapper);

}
