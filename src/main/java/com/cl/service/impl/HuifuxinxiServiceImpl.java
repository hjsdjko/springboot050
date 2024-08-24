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


import com.cl.dao.HuifuxinxiDao;
import com.cl.entity.HuifuxinxiEntity;
import com.cl.service.HuifuxinxiService;
import com.cl.entity.view.HuifuxinxiView;

@Service("huifuxinxiService")
public class HuifuxinxiServiceImpl extends ServiceImpl<HuifuxinxiDao, HuifuxinxiEntity> implements HuifuxinxiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<HuifuxinxiEntity> wrapper) {
		Page<HuifuxinxiView> page =new Query<HuifuxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<HuifuxinxiEntity> page = this.selectPage(
                new Query<HuifuxinxiEntity>(params).getPage(),
                new EntityWrapper<HuifuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<HuifuxinxiEntity> wrapper) {
		  Page<HuifuxinxiView> page =new Query<HuifuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<HuifuxinxiView> selectListView(Wrapper<HuifuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public HuifuxinxiView selectView(Wrapper<HuifuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
