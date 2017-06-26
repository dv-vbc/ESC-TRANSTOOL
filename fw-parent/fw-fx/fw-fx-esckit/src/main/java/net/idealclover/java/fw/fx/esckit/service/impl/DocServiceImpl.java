/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.service.impl;

import net.idealclover.java.fw.fx.esckit.dao.ISgccKbDocMapper;
import net.idealclover.java.fw.fx.esckit.po.SgccKbDoc;
import net.idealclover.java.fw.fx.esckit.service.IDocService;
import net.idealclover.java.fw.fx.esckit.vo.DocVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DragonFly
 */
@Service("docService")
public class DocServiceImpl implements IDocService {

    @Autowired
    private ISgccKbDocMapper sgccKbDocMapper;

    @Override
    public DocVo getDoc() throws Exception {

        SgccKbDoc model = sgccKbDocMapper.getModel(1000000000000221L);

        System.out.println("net.idealclover.java.fw.fx.esckit.service.impl.DocServiceImpl.getDoc()");

        DocVo vo = new DocVo();
        BeanUtils.copyProperties(model, vo);

        return vo;
    }

}
