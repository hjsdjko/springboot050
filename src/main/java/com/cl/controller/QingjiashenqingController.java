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

import com.cl.entity.QingjiashenqingEntity;
import com.cl.entity.view.QingjiashenqingView;

import com.cl.service.QingjiashenqingService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 请假申请
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@RestController
@RequestMapping("/qingjiashenqing")
public class QingjiashenqingController {
    @Autowired
    private QingjiashenqingService qingjiashenqingService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QingjiashenqingEntity qingjiashenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			qingjiashenqing.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiazhang")) {
			qingjiashenqing.setJiazhangzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("xuesheng")) {
			qingjiashenqing.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QingjiashenqingEntity> ew = new EntityWrapper<QingjiashenqingEntity>();

		PageUtils page = qingjiashenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingjiashenqing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QingjiashenqingEntity qingjiashenqing, 
		HttpServletRequest request){
        EntityWrapper<QingjiashenqingEntity> ew = new EntityWrapper<QingjiashenqingEntity>();

		PageUtils page = qingjiashenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qingjiashenqing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QingjiashenqingEntity qingjiashenqing){
       	EntityWrapper<QingjiashenqingEntity> ew = new EntityWrapper<QingjiashenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qingjiashenqing, "qingjiashenqing")); 
        return R.ok().put("data", qingjiashenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QingjiashenqingEntity qingjiashenqing){
        EntityWrapper< QingjiashenqingEntity> ew = new EntityWrapper< QingjiashenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qingjiashenqing, "qingjiashenqing")); 
		QingjiashenqingView qingjiashenqingView =  qingjiashenqingService.selectView(ew);
		return R.ok("查询请假申请成功").put("data", qingjiashenqingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QingjiashenqingEntity qingjiashenqing = qingjiashenqingService.selectById(id);
		qingjiashenqing = qingjiashenqingService.selectView(new EntityWrapper<QingjiashenqingEntity>().eq("id", id));
        return R.ok().put("data", qingjiashenqing);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QingjiashenqingEntity qingjiashenqing = qingjiashenqingService.selectById(id);
		qingjiashenqing = qingjiashenqingService.selectView(new EntityWrapper<QingjiashenqingEntity>().eq("id", id));
        return R.ok().put("data", qingjiashenqing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增请假申请")
    public R save(@RequestBody QingjiashenqingEntity qingjiashenqing, HttpServletRequest request){
    	qingjiashenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qingjiashenqing);
        qingjiashenqingService.insert(qingjiashenqing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增请假申请")
    @RequestMapping("/add")
    public R add(@RequestBody QingjiashenqingEntity qingjiashenqing, HttpServletRequest request){
    	qingjiashenqing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qingjiashenqing);
        qingjiashenqingService.insert(qingjiashenqing);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改请假申请")
    public R update(@RequestBody QingjiashenqingEntity qingjiashenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qingjiashenqing);
        qingjiashenqingService.updateById(qingjiashenqing);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核请假申请")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<QingjiashenqingEntity> list = new ArrayList<QingjiashenqingEntity>();
        for(Long id : ids) {
            QingjiashenqingEntity qingjiashenqing = qingjiashenqingService.selectById(id);
            qingjiashenqing.setSfsh(sfsh);
            qingjiashenqing.setShhf(shhf);
            list.add(qingjiashenqing);
        }
        qingjiashenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除请假申请")
    public R delete(@RequestBody Long[] ids){
        qingjiashenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
