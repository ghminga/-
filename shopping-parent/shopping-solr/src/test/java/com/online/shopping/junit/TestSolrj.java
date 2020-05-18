package com.online.shopping.junit;

import com.online.shopping.App;
import com.online.shopping.mapper.TbBrandMapper;
import com.online.shopping.mapper.TbItemMapper;
import com.online.shopping.pojo.TbBrand;
import com.online.shopping.pojo.TbItem;
import com.online.shopping.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class TestSolrj {

    @Autowired
    private SolrTemplate solrTemplate;

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Autowired
    private ItemService itemService;

    @Test
    public void testRemoverAll() {

        Query query = new SimpleQuery("*:*");
        solrTemplate.delete("collection1",query);
        solrTemplate.commit("collection1");
        System.out.println("操作完成");
    }

    @Test
    public void testAdd() {
        TbItem item = new TbItem();
        item.setId(10L);
        item.setTitle("康师傅牛肉面");
        item.setPrice(5D);
        item.setImage("http://localhost:");
        solrTemplate.saveBean("collection1",item);
        solrTemplate.commit("collection1");
        System.out.println("添加数据完成");
    }

    @Test
    public void importData() {
        //List<TbItem> list = itemService.findAll();
        List<TbItem> list = tbItemMapper.selectByExample(null);
        solrTemplate.saveBeans("collection1",list);
        solrTemplate.commit("collection1");
        System.out.println("添加数据完成");
    }

}
