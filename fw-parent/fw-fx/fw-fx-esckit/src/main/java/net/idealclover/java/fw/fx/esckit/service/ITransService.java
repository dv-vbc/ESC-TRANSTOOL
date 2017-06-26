/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.service;

import java.util.List;
import java.util.Map;
import net.idealclover.java.fw.fx.esckit.vo.DocSerializableVo;
import net.idealclover.java.fw.fx.esckit.vo.DocTableVo;
import net.idealclover.java.fw.fx.esckit.vo.DocVo;
import net.idealclover.java.fw.fx.esckit.vo.SysparaVo;

/**
 *
 * @author DragonFly
 */
public interface ITransService {

    public SysparaVo getWebState() throws Exception;

    public List<DocTableVo> listDoc4Tv(DocVo vo) throws Exception;
    
    public void saveDoc(DocSerializableVo dsvo, Map<String,String> fileidmap) throws Exception;

}
