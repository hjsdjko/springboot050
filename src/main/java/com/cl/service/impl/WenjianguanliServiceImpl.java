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


import com.cl.dao.WenjianguanliDao;
import com.cl.entity.WenjianguanliEntity;
import com.cl.service.WenjianguanliService;
import com.cl.entity.view.WenjianguanliView;

@Service("wenjianguanliService")
public class WenjianguanliServiceImpl extends ServiceImpl<WenjianguanliDao, WenjianguanliEntity> implements WenjianguanliService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<WenjianguanliEntity> wrapper) {
		Page<WenjianguanliView> page =new Query<WenjianguanliView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WenjianguanliEntity> page = this.selectPage(
                new Query<WenjianguanliEntity>(params).getPage(),
                new EntityWrapper<WenjianguanliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WenjianguanliEntity> wrapper) {
		  Page<WenjianguanliView> page =new Query<WenjianguanliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WenjianguanliView> selectListView(Wrapper<WenjianguanliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WenjianguanliView selectView(Wrapper<WenjianguanliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
