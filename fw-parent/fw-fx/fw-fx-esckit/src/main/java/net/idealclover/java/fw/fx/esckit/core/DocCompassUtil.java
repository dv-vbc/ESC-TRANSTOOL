/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.idealclover.java.fw.fx.esckit.vo.DocSearch;
import org.compass.core.Compass;
import org.compass.core.CompassException;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.compass.core.CompassTransaction;
import org.compass.core.config.CompassConfiguration;

/**
 *
 * @author DragonFly
 */
public class DocCompassUtil {

    private static Compass compassSessionFactory = null;

    /**
     * 初始化检索器
     *
     * @param path
     */
    public DocCompassUtil() {
        if (compassSessionFactory == null) {
            CompassConfiguration cfg = new CompassConfiguration().configure();
            compassSessionFactory = cfg.configure().buildCompass();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                compassSessionFactory.close();
            }
        });
    }

    /**
     * 建立数据索引
     *
     * @param book
     */
    public void index(DocSearch vo) {
        System.out.println("index doc : " + vo);
        CompassSession session = null;
        CompassTransaction tx = null;

        try {
            session = compassSessionFactory.openSession();
            tx = session.beginTransaction();

            session.create(vo);
            tx.commit();
        } catch (CompassException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    /**
     * 删除索引
     *
     * @param book
     */
    public void unIndex(DocSearch vo) {
        CompassSession session = null;
        CompassTransaction tx = null;

        try {
            session = compassSessionFactory.openSession();
            tx = session.beginTransaction();

            session.delete(vo);
            tx.commit();
        } catch (CompassException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    /**
     * 重置对象索引
     *
     * @param vo
     */
    public void reIndex(DocSearch vo) {
        unIndex(vo);
        index(vo);
    }

    /**
     * 查询
     *
     * @param q
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<DocSearch> search(String q) {
        CompassSession session = null;
        CompassTransaction tx = null;

        try {
            session = compassSessionFactory.openSession();
            tx = session.beginTransaction();
            CompassHits hits = session.find(q);

            int n = hits.length();
            if (n == 0) {
                return Collections.EMPTY_LIST;
            }

            List<DocSearch> vos = new ArrayList<DocSearch>(n);
            for (int i = 0; i < n; i++) {
                vos.add((DocSearch) hits.data(i));
            }

            hits.close();
            tx.commit();
            return vos;
        } catch (CompassException e) {
            tx.rollback();
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
