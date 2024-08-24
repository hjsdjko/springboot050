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


import com.cl.dao.TongzhigonggaoDao;
import com.cl.entity.TongzhigonggaoEntity;
import com.cl.service.TongzhigonggaoService;
import com.cl.entity.view.TongzhigonggaoView;

@Service("tongzhigonggaoService")
public class TongzhigonggaoServiceImpl extends ServiceImpl<TongzhigonggaoDao, TongzhigonggaoEntity> implements TongzhigonggaoService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<TongzhigonggaoEntity> wrapper) {
		Page<TongzhigonggaoView> page =new Query<TongzhigonggaoView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TongzhigonggaoEntity> page = this.selectPage(
                new Query<TongzhigonggaoEntity>(params).getPage(),
                new EntityWrapper<TongzhigonggaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TongzhigonggaoEntity> wrapper) {
		  Page<TongzhigonggaoView> page =new Query<TongzhigonggaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TongzhigonggaoView> selectListView(Wrapper<TongzhigonggaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TongzhigonggaoView selectView(Wrapper<TongzhigonggaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
