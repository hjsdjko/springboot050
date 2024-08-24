package com.cl.dao;

import com.cl.entity.WenjianguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenjianguanliView;


/**
 * 文件管理
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface WenjianguanliDao extends BaseMapper<WenjianguanliEntity> {
	
	List<WenjianguanliView> selectListView(@Param("ew") Wrapper<WenjianguanliEntity> wrapper);

	List<WenjianguanliView> selectListView(Pagination page,@Param("ew") Wrapper<WenjianguanliEntity> wrapper);
	
	WenjianguanliView selectView(@Param("ew") Wrapper<WenjianguanliEntity> wrapper);
	
	List<WenjianguanliView> selectGroupBy(Pagination page,@Param("ew") Wrapper<WenjianguanliEntity> wrapper);

}
