package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.MeiricanpuDao;
import com.cl.entity.MeiricanpuEntity;
import com.cl.service.MeiricanpuService;
import com.cl.entity.view.MeiricanpuView;

@Service("meiricanpuService")
public class MeiricanpuServiceImpl extends ServiceImpl<MeiricanpuDao, MeiricanpuEntity> implements MeiricanpuService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<MeiricanpuEntity> wrapper) {
		Page<MeiricanpuView> page =new Query<MeiricanpuView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeiricanpuEntity> page = this.selectPage(
                new Query<MeiricanpuEntity>(params).getPage(),
                new EntityWrapper<MeiricanpuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeiricanpuEntity> wrapper) {
		  Page<MeiricanpuView> page =new Query<MeiricanpuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<MeiricanpuView> selectListView(Wrapper<MeiricanpuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeiricanpuView selectView(Wrapper<MeiricanpuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
