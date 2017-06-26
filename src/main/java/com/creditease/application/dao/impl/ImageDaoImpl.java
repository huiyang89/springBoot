package com.creditease.application.dao.impl;

import com.creditease.application.entity.Image;
import com.creditease.application.entity.User;
import com.creditease.application.query.ImageBean;
import com.creditease.application.query.Pager;
import com.creditease.application.query.UserBean;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public class ImageDaoImpl {

    @PersistenceContext(unitName="myPersistenceUnit")
    private EntityManager entityManager;


    public Pager findImageByPage(ImageBean bean) {
        Pager pager = new Pager();
        pager.setCurrentPage(bean.getPage());
        pager.setShowCount(bean.getRows());
        String hql = "from Image where 1=1";
        Query query = entityManager.createQuery(hql,Image.class);

        Query queryCount = entityManager.createQuery("select count(*) "+hql);

        pager.initPage(query,queryCount);

        return pager;

    }
}