package com.cl.dao;

import com.cl.entity.QingjiashenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.QingjiashenqingView;


/**
 * 请假申请
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface QingjiashenqingDao extends BaseMapper<QingjiashenqingEntity> {
	
	List<QingjiashenqingView> selectListView(@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);

	List<QingjiashenqingView> selectListView(Pagination page,@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);
	
	QingjiashenqingView selectView(@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);
	
	List<QingjiashenqingView> selectGroupBy(Pagination page,@Param("ew") Wrapper<QingjiashenqingEntity> wrapper);

}
