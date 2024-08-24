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


import com.cl.dao.KetangbiaoxianDao;
import com.cl.entity.KetangbiaoxianEntity;
import com.cl.service.KetangbiaoxianService;
import com.cl.entity.view.KetangbiaoxianView;

@Service("ketangbiaoxianService")
public class KetangbiaoxianServiceImpl extends ServiceImpl<KetangbiaoxianDao, KetangbiaoxianEntity> implements KetangbiaoxianService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<KetangbiaoxianEntity> wrapper) {
		Page<KetangbiaoxianView> page =new Query<KetangbiaoxianView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KetangbiaoxianEntity> page = this.selectPage(
                new Query<KetangbiaoxianEntity>(params).getPage(),
                new EntityWrapper<KetangbiaoxianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KetangbiaoxianEntity> wrapper) {
		  Page<KetangbiaoxianView> page =new Query<KetangbiaoxianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KetangbiaoxianView> selectListView(Wrapper<KetangbiaoxianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KetangbiaoxianView selectView(Wrapper<KetangbiaoxianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
