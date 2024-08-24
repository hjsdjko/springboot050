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

import com.cl.entity.MeiricanpuEntity;
import com.cl.entity.view.MeiricanpuView;

import com.cl.service.MeiricanpuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 每日餐谱
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@RestController
@RequestMapping("/meiricanpu")
public class MeiricanpuController {
    @Autowired
    private MeiricanpuService meiricanpuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeiricanpuEntity meiricanpu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqiend,
		HttpServletRequest request){
        EntityWrapper<MeiricanpuEntity> ew = new EntityWrapper<MeiricanpuEntity>();
                if(riqistart!=null) ew.ge("riqi", riqistart);
                if(riqiend!=null) ew.le("riqi", riqiend);

		PageUtils page = meiricanpuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meiricanpu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeiricanpuEntity meiricanpu, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date riqiend,
		HttpServletRequest request){
        EntityWrapper<MeiricanpuEntity> ew = new EntityWrapper<MeiricanpuEntity>();
                if(riqistart!=null) ew.ge("riqi", riqistart);
                if(riqiend!=null) ew.le("riqi", riqiend);

		PageUtils page = meiricanpuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meiricanpu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeiricanpuEntity meiricanpu){
       	EntityWrapper<MeiricanpuEntity> ew = new EntityWrapper<MeiricanpuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meiricanpu, "meiricanpu")); 
        return R.ok().put("data", meiricanpuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeiricanpuEntity meiricanpu){
        EntityWrapper< MeiricanpuEntity> ew = new EntityWrapper< MeiricanpuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meiricanpu, "meiricanpu")); 
		MeiricanpuView meiricanpuView =  meiricanpuService.selectView(ew);
		return R.ok("查询每日餐谱成功").put("data", meiricanpuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeiricanpuEntity meiricanpu = meiricanpuService.selectById(id);
		meiricanpu = meiricanpuService.selectView(new EntityWrapper<MeiricanpuEntity>().eq("id", id));
        return R.ok().put("data", meiricanpu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeiricanpuEntity meiricanpu = meiricanpuService.selectById(id);
		meiricanpu = meiricanpuService.selectView(new EntityWrapper<MeiricanpuEntity>().eq("id", id));
        return R.ok().put("data", meiricanpu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增每日餐谱")
    public R save(@RequestBody MeiricanpuEntity meiricanpu, HttpServletRequest request){
    	meiricanpu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meiricanpu);
        meiricanpuService.insert(meiricanpu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增每日餐谱")
    @RequestMapping("/add")
    public R add(@RequestBody MeiricanpuEntity meiricanpu, HttpServletRequest request){
    	meiricanpu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meiricanpu);
        meiricanpuService.insert(meiricanpu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改每日餐谱")
    public R update(@RequestBody MeiricanpuEntity meiricanpu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meiricanpu);
        meiricanpuService.updateById(meiricanpu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除每日餐谱")
    public R delete(@RequestBody Long[] ids){
        meiricanpuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
