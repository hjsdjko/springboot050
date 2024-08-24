package com.cl.dao;

import com.cl.entity.KetangbiaoxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KetangbiaoxianView;


/**
 * 课堂表现
 * 
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
public interface KetangbiaoxianDao extends BaseMapper<KetangbiaoxianEntity> {
	
	List<KetangbiaoxianView> selectListView(@Param("ew") Wrapper<KetangbiaoxianEntity> wrapper);

	List<KetangbiaoxianView> selectListView(Pagination page,@Param("ew") Wrapper<KetangbiaoxianEntity> wrapper);
	
	KetangbiaoxianView selectView(@Param("ew") Wrapper<KetangbiaoxianEntity> wrapper);
	
	List<KetangbiaoxianView> selectGroupBy(Pagination page,@Param("ew") Wrapper<KetangbiaoxianEntity> wrapper);

}
