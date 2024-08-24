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

import com.cl.entity.KetangbiaoxianEntity;
import com.cl.entity.view.KetangbiaoxianView;

import com.cl.service.KetangbiaoxianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 课堂表现
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@RestController
@RequestMapping("/ketangbiaoxian")
public class KetangbiaoxianController {
    @Autowired
    private KetangbiaoxianService ketangbiaoxianService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KetangbiaoxianEntity ketangbiaoxian,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			ketangbiaoxian.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhang")) {
			ketangbiaoxian.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			ketangbiaoxian.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<KetangbiaoxianEntity> ew = new EntityWrapper<KetangbiaoxianEntity>();

		PageUtils page = ketangbiaoxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ketangbiaoxian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KetangbiaoxianEntity ketangbiaoxian, 
		HttpServletRequest request){
        EntityWrapper<KetangbiaoxianEntity> ew = new EntityWrapper<KetangbiaoxianEntity>();

		PageUtils page = ketangbiaoxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ketangbiaoxian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KetangbiaoxianEntity ketangbiaoxian){
       	EntityWrapper<KetangbiaoxianEntity> ew = new EntityWrapper<KetangbiaoxianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ketangbiaoxian, "ketangbiaoxian")); 
        return R.ok().put("data", ketangbiaoxianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KetangbiaoxianEntity ketangbiaoxian){
        EntityWrapper< KetangbiaoxianEntity> ew = new EntityWrapper< KetangbiaoxianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ketangbiaoxian, "ketangbiaoxian")); 
		KetangbiaoxianView ketangbiaoxianView =  ketangbiaoxianService.selectView(ew);
		return R.ok("查询课堂表现成功").put("data", ketangbiaoxianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KetangbiaoxianEntity ketangbiaoxian = ketangbiaoxianService.selectById(id);
		ketangbiaoxian = ketangbiaoxianService.selectView(new EntityWrapper<KetangbiaoxianEntity>().eq("id", id));
        return R.ok().put("data", ketangbiaoxian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KetangbiaoxianEntity ketangbiaoxian = ketangbiaoxianService.selectById(id);
		ketangbiaoxian = ketangbiaoxianService.selectView(new EntityWrapper<KetangbiaoxianEntity>().eq("id", id));
        return R.ok().put("data", ketangbiaoxian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增课堂表现")
    public R save(@RequestBody KetangbiaoxianEntity ketangbiaoxian, HttpServletRequest request){
    	ketangbiaoxian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ketangbiaoxian);
        ketangbiaoxianService.insert(ketangbiaoxian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增课堂表现")
    @RequestMapping("/add")
    public R add(@RequestBody KetangbiaoxianEntity ketangbiaoxian, HttpServletRequest request){
    	ketangbiaoxian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ketangbiaoxian);
        ketangbiaoxianService.insert(ketangbiaoxian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改课堂表现")
    public R update(@RequestBody KetangbiaoxianEntity ketangbiaoxian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ketangbiaoxian);
        ketangbiaoxianService.updateById(ketangbiaoxian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除课堂表现")
    public R delete(@RequestBody Long[] ids){
        ketangbiaoxianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
