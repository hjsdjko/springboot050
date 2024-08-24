package com.cl.dao;

import com.cl.entity.LiuyanxiaoxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.LiuyanxiaoxiView;


/**
 * 留言消息
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface LiuyanxiaoxiDao extends BaseMapper<LiuyanxiaoxiEntity> {
	
	List<LiuyanxiaoxiView> selectListView(@Param("ew") Wrapper<LiuyanxiaoxiEntity> wrapper);

	List<LiuyanxiaoxiView> selectListView(Pagination page,@Param("ew") Wrapper<LiuyanxiaoxiEntity> wrapper);
	
	LiuyanxiaoxiView selectView(@Param("ew") Wrapper<LiuyanxiaoxiEntity> wrapper);
	
	List<LiuyanxiaoxiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<LiuyanxiaoxiEntity> wrapper);

}
