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


import com.cl.dao.QingjiashenqingDao;
import com.cl.entity.QingjiashenqingEntity;
import com.cl.service.QingjiashenqingService;
import com.cl.entity.view.QingjiashenqingView;

@Service("qingjiashenqingService")
public class QingjiashenqingServiceImpl extends ServiceImpl<QingjiashenqingDao, QingjiashenqingEntity> implements QingjiashenqingService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<QingjiashenqingEntity> wrapper) {
		Page<QingjiashenqingView> page =new Query<QingjiashenqingView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QingjiashenqingEntity> page = this.selectPage(
                new Query<QingjiashenqingEntity>(params).getPage(),
                new EntityWrapper<QingjiashenqingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QingjiashenqingEntity> wrapper) {
		  Page<QingjiashenqingView> page =new Query<QingjiashenqingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<QingjiashenqingView> selectListView(Wrapper<QingjiashenqingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QingjiashenqingView selectView(Wrapper<QingjiashenqingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
