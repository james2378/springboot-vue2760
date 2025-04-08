


















package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 指南信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhinan")
public class ZhinanController {
    private static final Logger logger = LoggerFactory.getLogger(ZhinanController.class);

    @Autowired
    private ZhinanService zhinanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JiaoshiService jiaoshiService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        params.put("zhinanDeleteStart",1);params.put("zhinanDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zhinanService.queryPage(params);

        //字典表数据转换
        List<ZhinanView> list =(List<ZhinanView>)page.getList();
        for(ZhinanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhinanEntity zhinan = zhinanService.selectById(id);
        if(zhinan !=null){
            //entity转view
            ZhinanView view = new ZhinanView();
            BeanUtils.copyProperties( zhinan , view );//把实体数据重构到view中

                //级联表
                JiaoshiEntity jiaoshi = jiaoshiService.selectById(zhinan.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zhinan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhinanEntity zhinan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhinan:{}",this.getClass().getName(),zhinan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("教师".equals(role)){
            zhinan.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            zhinan.setYonghuId(null);
            zhinan.setZhinanYesnoTypes(1);
        }else if("用户".equals(role)){
            zhinan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            zhinan.setJiaoshiId(null);
            zhinan.setZhinanYesnoTypes(1);
        }else{
            zhinan.setJiaoshiId(null);
            zhinan.setYonghuId(null);
            zhinan.setZhinanYesnoTypes(2);
        }
        Wrapper<ZhinanEntity> queryWrapper = new EntityWrapper<ZhinanEntity>()
            .eq("zhinan_name", zhinan.getZhinanName())
            .eq("zhinan_types", zhinan.getZhinanTypes())
            .eq("jiaoshi_id", zhinan.getJiaoshiId())
            .eq("yonghu_id", zhinan.getYonghuId())
            .eq("zhinan_yesno_types", zhinan.getZhinanYesnoTypes())
            .eq("zhinan_delete", zhinan.getZhinanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhinanEntity zhinanEntity = zhinanService.selectOne(queryWrapper);
        if(zhinanEntity==null){
            zhinan.setZhinanDelete(1);
            zhinan.setCreateTime(new Date());
            zhinanService.insert(zhinan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhinanEntity zhinan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhinan:{}",this.getClass().getName(),zhinan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(StringUtil.isEmpty(role))
//            return R.error(511,"权限为空");
//        else if("教师".equals(role))
//            zhinan.setJiaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            zhinan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhinanEntity> queryWrapper = new EntityWrapper<ZhinanEntity>()
            .notIn("id",zhinan.getId())
            .andNew()
            .eq("zhinan_name", zhinan.getZhinanName())
            .eq("zhinan_types", zhinan.getZhinanTypes())
            .eq("jiaoshi_id", zhinan.getJiaoshiId())
            .eq("yonghu_id", zhinan.getYonghuId())
            .eq("zhinan_yesno_types", zhinan.getZhinanYesnoTypes())
            .eq("zhinan_delete", zhinan.getZhinanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhinanEntity zhinanEntity = zhinanService.selectOne(queryWrapper);
        if("".equals(zhinan.getZhinanPhoto()) || "null".equals(zhinan.getZhinanPhoto())){
                zhinan.setZhinanPhoto(null);
        }
        if(zhinanEntity==null){
            if(zhinanService.selectById(zhinan.getId()).getZhinanYesnoTypes() == 3){
                zhinan.setZhinanYesnoTypes(1);
            }
            zhinanService.updateById(zhinan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ZhinanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ZhinanEntity zhinanEntity = new ZhinanEntity();
            zhinanEntity.setId(id);
            zhinanEntity.setZhinanDelete(2);
            list.add(zhinanEntity);
        }
        if(list != null && list.size() >0){
            zhinanService.updateBatchById(list);
        }
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhinanEntity> zhinanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhinanEntity zhinanEntity = new ZhinanEntity();
//                            zhinanEntity.setZhinanName(data.get(0));                    //信息标题 要改的
//                            zhinanEntity.setZhinanTypes(data.get(0));                    //信息类型 要改的
//                            zhinanEntity.setZhinanPhoto("");//照片
//                            zhinanEntity.setJiaoshiId(Integer.valueOf(data.get(0)));   //教师 要改的
//                            zhinanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            zhinanEntity.setZhinanYesnoTypes(Integer.valueOf(data.get(0)));   //审核结果 要改的
//                            zhinanEntity.setZhinanContent("");//照片
//                            zhinanEntity.setZhinanDelete(1);//逻辑删除字段
//                            zhinanEntity.setCreateTime(date);//时间
                            zhinanList.add(zhinanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zhinanService.insertBatch(zhinanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = zhinanService.queryPage(params);

        //字典表数据转换
        List<ZhinanView> list =(List<ZhinanView>)page.getList();
        for(ZhinanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhinanEntity zhinan = zhinanService.selectById(id);
            if(zhinan !=null){


                //entity转view
                ZhinanView view = new ZhinanView();
                BeanUtils.copyProperties( zhinan , view );//把实体数据重构到view中

                //级联表
                    JiaoshiEntity jiaoshi = jiaoshiService.selectById(zhinan.getJiaoshiId());
                if(jiaoshi != null){
                    BeanUtils.copyProperties( jiaoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiaoshiId(jiaoshi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(zhinan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZhinanEntity zhinan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhinan:{}",this.getClass().getName(),zhinan.toString());
        Wrapper<ZhinanEntity> queryWrapper = new EntityWrapper<ZhinanEntity>()
            .eq("zhinan_name", zhinan.getZhinanName())
            .eq("zhinan_types", zhinan.getZhinanTypes())
            .eq("jiaoshi_id", zhinan.getJiaoshiId())
            .eq("yonghu_id", zhinan.getYonghuId())
            .eq("zhinan_yesno_types", zhinan.getZhinanYesnoTypes())
            .eq("zhinan_delete", zhinan.getZhinanDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhinanEntity zhinanEntity = zhinanService.selectOne(queryWrapper);
        if(zhinanEntity==null){
            zhinan.setZhinanYesnoTypes(1);
            zhinan.setZhinanDelete(1);
            zhinan.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zhinan.set
        //  }
        zhinanService.insert(zhinan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
