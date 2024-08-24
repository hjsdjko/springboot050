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


import com.cl.dao.LiuyanxiaoxiDao;
import com.cl.entity.LiuyanxiaoxiEntity;
import com.cl.service.LiuyanxiaoxiService;
import com.cl.entity.view.LiuyanxiaoxiView;

@Service("liuyanxiaoxiService")
public class LiuyanxiaoxiServiceImpl extends ServiceImpl<LiuyanxiaoxiDao, LiuyanxiaoxiEntity> implements LiuyanxiaoxiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<LiuyanxiaoxiEntity> wrapper) {
		Page<LiuyanxiaoxiView> page =new Query<LiuyanxiaoxiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LiuyanxiaoxiEntity> page = this.selectPage(
                new Query<LiuyanxiaoxiEntity>(params).getPage(),
                new EntityWrapper<LiuyanxiaoxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LiuyanxiaoxiEntity> wrapper) {
		  Page<LiuyanxiaoxiView> page =new Query<LiuyanxiaoxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LiuyanxiaoxiView> selectListView(Wrapper<LiuyanxiaoxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LiuyanxiaoxiView selectView(Wrapper<LiuyanxiaoxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
