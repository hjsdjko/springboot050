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

import com.cl.entity.WenjianguanliEntity;
import com.cl.entity.view.WenjianguanliView;

import com.cl.service.WenjianguanliService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 文件管理
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-13 19:54:26
 */
@RestController
@RequestMapping("/wenjianguanli")
public class WenjianguanliController {
    @Autowired
    private WenjianguanliService wenjianguanliService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WenjianguanliEntity wenjianguanli,
		HttpServletRequest request){
        EntityWrapper<WenjianguanliEntity> ew = new EntityWrapper<WenjianguanliEntity>();

		PageUtils page = wenjianguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenjianguanli), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WenjianguanliEntity wenjianguanli, 
		HttpServletRequest request){
        EntityWrapper<WenjianguanliEntity> ew = new EntityWrapper<WenjianguanliEntity>();

		PageUtils page = wenjianguanliService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wenjianguanli), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WenjianguanliEntity wenjianguanli){
       	EntityWrapper<WenjianguanliEntity> ew = new EntityWrapper<WenjianguanliEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wenjianguanli, "wenjianguanli")); 
        return R.ok().put("data", wenjianguanliService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WenjianguanliEntity wenjianguanli){
        EntityWrapper< WenjianguanliEntity> ew = new EntityWrapper< WenjianguanliEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wenjianguanli, "wenjianguanli")); 
		WenjianguanliView wenjianguanliView =  wenjianguanliService.selectView(ew);
		return R.ok("查询文件管理成功").put("data", wenjianguanliView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WenjianguanliEntity wenjianguanli = wenjianguanliService.selectById(id);
		wenjianguanli = wenjianguanliService.selectView(new EntityWrapper<WenjianguanliEntity>().eq("id", id));
        return R.ok().put("data", wenjianguanli);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WenjianguanliEntity wenjianguanli = wenjianguanliService.selectById(id);
		wenjianguanli = wenjianguanliService.selectView(new EntityWrapper<WenjianguanliEntity>().eq("id", id));
        return R.ok().put("data", wenjianguanli);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增文件管理")
    public R save(@RequestBody WenjianguanliEntity wenjianguanli, HttpServletRequest request){
    	wenjianguanli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenjianguanli);
        wenjianguanliService.insert(wenjianguanli);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增文件管理")
    @RequestMapping("/add")
    public R add(@RequestBody WenjianguanliEntity wenjianguanli, HttpServletRequest request){
    	wenjianguanli.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wenjianguanli);
        wenjianguanliService.insert(wenjianguanli);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改文件管理")
    public R update(@RequestBody WenjianguanliEntity wenjianguanli, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wenjianguanli);
        wenjianguanliService.updateById(wenjianguanli);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除文件管理")
    public R delete(@RequestBody Long[] ids){
        wenjianguanliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	




    @RequestMapping("/importExcel")
    @SysLog("导入文件管理")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    WenjianguanliEntity wenjianguanliEntity =new WenjianguanliEntity();
                    wenjianguanliEntity.setId(new Date().getTime());
                    String wenjianbianhao = CommonUtil.getCellValue(row.getCell(0));
                    wenjianguanliEntity.setWenjianbianhao(wenjianbianhao);
                    String wenjianmingcheng = CommonUtil.getCellValue(row.getCell(1));
                    wenjianguanliEntity.setWenjianmingcheng(wenjianmingcheng);
                    String wenjian = CommonUtil.getCellValue(row.getCell(2));
                    wenjianguanliEntity.setWenjian(wenjian);
                     
                    //想数据库中添加新对象
                    wenjianguanliService.insert(wenjianguanliEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }




}
