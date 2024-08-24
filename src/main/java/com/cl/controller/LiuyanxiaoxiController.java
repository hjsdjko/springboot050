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

import com.cl.entity.LiuyanxiaoxiEntity;
import com.cl.entity.view.LiuyanxiaoxiView;

import com.cl.service.LiuyanxiaoxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 留言消息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@RestController
@RequestMapping("/liuyanxiaoxi")
public class LiuyanxiaoxiController {
    @Autowired
    private LiuyanxiaoxiService liuyanxiaoxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LiuyanxiaoxiEntity liuyanxiaoxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			liuyanxiaoxi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhang")) {
			liuyanxiaoxi.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			liuyanxiaoxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LiuyanxiaoxiEntity> ew = new EntityWrapper<LiuyanxiaoxiEntity>();

		PageUtils page = liuyanxiaoxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanxiaoxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LiuyanxiaoxiEntity liuyanxiaoxi, 
		HttpServletRequest request){
        EntityWrapper<LiuyanxiaoxiEntity> ew = new EntityWrapper<LiuyanxiaoxiEntity>();

		PageUtils page = liuyanxiaoxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanxiaoxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LiuyanxiaoxiEntity liuyanxiaoxi){
       	EntityWrapper<LiuyanxiaoxiEntity> ew = new EntityWrapper<LiuyanxiaoxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( liuyanxiaoxi, "liuyanxiaoxi")); 
        return R.ok().put("data", liuyanxiaoxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LiuyanxiaoxiEntity liuyanxiaoxi){
        EntityWrapper< LiuyanxiaoxiEntity> ew = new EntityWrapper< LiuyanxiaoxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( liuyanxiaoxi, "liuyanxiaoxi")); 
		LiuyanxiaoxiView liuyanxiaoxiView =  liuyanxiaoxiService.selectView(ew);
		return R.ok("查询留言消息成功").put("data", liuyanxiaoxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LiuyanxiaoxiEntity liuyanxiaoxi = liuyanxiaoxiService.selectById(id);
		liuyanxiaoxi = liuyanxiaoxiService.selectView(new EntityWrapper<LiuyanxiaoxiEntity>().eq("id", id));
        return R.ok().put("data", liuyanxiaoxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LiuyanxiaoxiEntity liuyanxiaoxi = liuyanxiaoxiService.selectById(id);
		liuyanxiaoxi = liuyanxiaoxiService.selectView(new EntityWrapper<LiuyanxiaoxiEntity>().eq("id", id));
        return R.ok().put("data", liuyanxiaoxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增留言消息")
    public R save(@RequestBody LiuyanxiaoxiEntity liuyanxiaoxi, HttpServletRequest request){
    	liuyanxiaoxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liuyanxiaoxi);
        liuyanxiaoxiService.insert(liuyanxiaoxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增留言消息")
    @RequestMapping("/add")
    public R add(@RequestBody LiuyanxiaoxiEntity liuyanxiaoxi, HttpServletRequest request){
    	liuyanxiaoxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(liuyanxiaoxi);
        liuyanxiaoxiService.insert(liuyanxiaoxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改留言消息")
    public R update(@RequestBody LiuyanxiaoxiEntity liuyanxiaoxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(liuyanxiaoxi);
        liuyanxiaoxiService.updateById(liuyanxiaoxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除留言消息")
    public R delete(@RequestBody Long[] ids){
        liuyanxiaoxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	






    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,LiuyanxiaoxiEntity liuyanxiaoxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("xuesheng")) {
            liuyanxiaoxi.setXuehao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiazhang")) {
            liuyanxiaoxi.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiaoshi")) {
            liuyanxiaoxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<LiuyanxiaoxiEntity> ew = new EntityWrapper<LiuyanxiaoxiEntity>();
        int count = liuyanxiaoxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, liuyanxiaoxi), params), params));
        return R.ok().put("data", count);
    }


}
