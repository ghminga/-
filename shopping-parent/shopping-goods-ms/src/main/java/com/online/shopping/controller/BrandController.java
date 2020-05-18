package com.online.shopping.controller;

import com.online.shopping.entity.PageResult;
import com.online.shopping.entity.Result;
import com.online.shopping.pojo.TbBrand;
import com.online.shopping.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/brand-Ms")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查询所有品牌
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    /**
     * 添加
     * @param brand
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand) {
        System.out.println("#######"+brand.getName()+"#######");
        System.out.println("#######"+brand.getFirstChar()+"#######");

        try {
            brandService.add(brand);
            return new Result(true,"增加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"增加失败");
        }

    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand) {
        TbBrand brand1 = brandService.findOne(brand.getId());
        if(!brand1.getId().equals(brand.getId())) {
            return new Result(false,"非法操作");
        }

        try {
            brandService.update(brand);
            return new Result(true,"修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }

    /**
     * 批量删除
     */
    @RequestMapping("/delete")
    public Result delete(Long [] ids) {
        try {
            brandService.delete(ids);
            return new Result(true,"删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }

    /**
     * 分页
     */
    @RequestMapping("/findPage")
    public PageResult search(int pageNum,int pageSize) {

        return  brandService.findPage(pageNum,pageSize);
    }


    @RequestMapping("/selectOptionList")
    public List<Map> selectOptionList() {
        return brandService.selectOptionList();
    }


}
