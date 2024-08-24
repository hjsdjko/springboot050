package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.HuifuxinxiEntity;
import com.cl.entity.view.HuifuxinxiView;

import com.cl.service.HuifuxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 回复信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:54:27
 */
@RestController
@RequestMapping("/huifuxinxi")
public class HuifuxinxiController {
    @Autowired
    private HuifuxinxiService huifuxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuifuxinxiEntity huifuxinxi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date huifushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date huifushijianend,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			huifuxinxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhang")) {
			huifuxinxi.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			huifuxinxi.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<HuifuxinxiEntity> ew = new EntityWrapper<HuifuxinxiEntity>();
                if(huifushijianstart!=null) ew.ge("huifushijian", huifushijianstart);
                if(huifushijianend!=null) ew.le("huifushijian", huifushijianend);

		PageUtils page = huifuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huifuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuifuxinxiEntity huifuxinxi, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date huifushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date huifushijianend,
		HttpServletRequest request){
        EntityWrapper<HuifuxinxiEntity> ew = new EntityWrapper<HuifuxinxiEntity>();
                if(huifushijianstart!=null) ew.ge("huifushijian", huifushijianstart);
                if(huifushijianend!=null) ew.le("huifushijian", huifushijianend);

		PageUtils page = huifuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huifuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuifuxinxiEntity huifuxinxi){
       	EntityWrapper<HuifuxinxiEntity> ew = new EntityWrapper<HuifuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huifuxinxi, "huifuxinxi")); 
        return R.ok().put("data", huifuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuifuxinxiEntity huifuxinxi){
        EntityWrapper< HuifuxinxiEntity> ew = new EntityWrapper< HuifuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huifuxinxi, "huifuxinxi")); 
		HuifuxinxiView huifuxinxiView =  huifuxinxiService.selectView(ew);
		return R.ok("查询回复信息成功").put("data", huifuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuifuxinxiEntity huifuxinxi = huifuxinxiService.selectById(id);
		huifuxinxi = huifuxinxiService.selectView(new EntityWrapper<HuifuxinxiEntity>().eq("id", id));
        return R.ok().put("data", huifuxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuifuxinxiEntity huifuxinxi = huifuxinxiService.selectById(id);
		huifuxinxi = huifuxinxiService.selectView(new EntityWrapper<HuifuxinxiEntity>().eq("id", id));
        return R.ok().put("data", huifuxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增回复信息")
    public R save(@RequestBody HuifuxinxiEntity huifuxinxi, HttpServletRequest request){
    	huifuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huifuxinxi);
        huifuxinxiService.insert(huifuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增回复信息")
    @RequestMapping("/add")
    public R add(@RequestBody HuifuxinxiEntity huifuxinxi, HttpServletRequest request){
    	huifuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huifuxinxi);
        huifuxinxiService.insert(huifuxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改回复信息")
    public R update(@RequestBody HuifuxinxiEntity huifuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huifuxinxi);
        huifuxinxiService.updateById(huifuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除回复信息")
    public R delete(@RequestBody Long[] ids){
        huifuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,HuifuxinxiEntity huifuxinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaoshi")) {
            huifuxinxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiazhang")) {
            huifuxinxi.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("xuesheng")) {
            huifuxinxi.setXuehao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<HuifuxinxiEntity> ew = new EntityWrapper<HuifuxinxiEntity>();
        int count = huifuxinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huifuxinxi), params), params));
        return R.ok().put("data", count);
    }


}
