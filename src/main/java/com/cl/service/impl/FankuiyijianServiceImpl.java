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


import com.cl.dao.FankuiyijianDao;
import com.cl.entity.FankuiyijianEntity;
import com.cl.service.FankuiyijianService;
import com.cl.entity.view.FankuiyijianView;

@Service("fankuiyijianService")
public class FankuiyijianServiceImpl extends ServiceImpl<FankuiyijianDao, FankuiyijianEntity> implements FankuiyijianService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<FankuiyijianEntity> wrapper) {
		Page<FankuiyijianView> page =new Query<FankuiyijianView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FankuiyijianEntity> page = this.selectPage(
                new Query<FankuiyijianEntity>(params).getPage(),
                new EntityWrapper<FankuiyijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FankuiyijianEntity> wrapper) {
		  Page<FankuiyijianView> page =new Query<FankuiyijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<FankuiyijianView> selectListView(Wrapper<FankuiyijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FankuiyijianView selectView(Wrapper<FankuiyijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
