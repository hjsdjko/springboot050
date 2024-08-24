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

import com.cl.entity.TongzhigonggaoEntity;
import com.cl.entity.view.TongzhigonggaoView;

import com.cl.service.TongzhigonggaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 通知公告
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@RestController
@RequestMapping("/tongzhigonggao")
public class TongzhigonggaoController {
    @Autowired
    private TongzhigonggaoService tongzhigonggaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TongzhigonggaoEntity tongzhigonggao,
		HttpServletRequest request){
        EntityWrapper<TongzhigonggaoEntity> ew = new EntityWrapper<TongzhigonggaoEntity>();

		PageUtils page = tongzhigonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongzhigonggao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TongzhigonggaoEntity tongzhigonggao, 
		HttpServletRequest request){
        EntityWrapper<TongzhigonggaoEntity> ew = new EntityWrapper<TongzhigonggaoEntity>();

		PageUtils page = tongzhigonggaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tongzhigonggao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TongzhigonggaoEntity tongzhigonggao){
       	EntityWrapper<TongzhigonggaoEntity> ew = new EntityWrapper<TongzhigonggaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tongzhigonggao, "tongzhigonggao")); 
        return R.ok().put("data", tongzhigonggaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TongzhigonggaoEntity tongzhigonggao){
        EntityWrapper< TongzhigonggaoEntity> ew = new EntityWrapper< TongzhigonggaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tongzhigonggao, "tongzhigonggao")); 
		TongzhigonggaoView tongzhigonggaoView =  tongzhigonggaoService.selectView(ew);
		return R.ok("查询通知公告成功").put("data", tongzhigonggaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TongzhigonggaoEntity tongzhigonggao = tongzhigonggaoService.selectById(id);
		tongzhigonggao = tongzhigonggaoService.selectView(new EntityWrapper<TongzhigonggaoEntity>().eq("id", id));
        return R.ok().put("data", tongzhigonggao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TongzhigonggaoEntity tongzhigonggao = tongzhigonggaoService.selectById(id);
		tongzhigonggao = tongzhigonggaoService.selectView(new EntityWrapper<TongzhigonggaoEntity>().eq("id", id));
        return R.ok().put("data", tongzhigonggao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增通知公告")
    public R save(@RequestBody TongzhigonggaoEntity tongzhigonggao, HttpServletRequest request){
    	tongzhigonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tongzhigonggao);
        tongzhigonggaoService.insert(tongzhigonggao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增通知公告")
    @RequestMapping("/add")
    public R add(@RequestBody TongzhigonggaoEntity tongzhigonggao, HttpServletRequest request){
    	tongzhigonggao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tongzhigonggao);
        tongzhigonggaoService.insert(tongzhigonggao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改通知公告")
    public R update(@RequestBody TongzhigonggaoEntity tongzhigonggao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tongzhigonggao);
        tongzhigonggaoService.updateById(tongzhigonggao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除通知公告")
    public R delete(@RequestBody Long[] ids){
        tongzhigonggaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}