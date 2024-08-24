package com.cl.dao;

import com.cl.entity.TongzhigonggaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TongzhigonggaoView;


/**
 * 通知公告
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface TongzhigonggaoDao extends BaseMapper<TongzhigonggaoEntity> {
	
	List<TongzhigonggaoView> selectListView(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);

	List<TongzhigonggaoView> selectListView(Pagination page,@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
	TongzhigonggaoView selectView(@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);
	
	List<TongzhigonggaoView> selectGroupBy(Pagination page,@Param("ew") Wrapper<TongzhigonggaoEntity> wrapper);

}
