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


import com.cl.dao.KechengbiaoDao;
import com.cl.entity.KechengbiaoEntity;
import com.cl.service.KechengbiaoService;
import com.cl.entity.view.KechengbiaoView;

@Service("kechengbiaoService")
public class KechengbiaoServiceImpl extends ServiceImpl<KechengbiaoDao, KechengbiaoEntity> implements KechengbiaoService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<KechengbiaoEntity> wrapper) {
		Page<KechengbiaoView> page =new Query<KechengbiaoView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengbiaoEntity> page = this.selectPage(
                new Query<KechengbiaoEntity>(params).getPage(),
                new EntityWrapper<KechengbiaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengbiaoEntity> wrapper) {
		  Page<KechengbiaoView> page =new Query<KechengbiaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengbiaoView> selectListView(Wrapper<KechengbiaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengbiaoView selectView(Wrapper<KechengbiaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<KechengbiaoEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<KechengbiaoEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<KechengbiaoEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
