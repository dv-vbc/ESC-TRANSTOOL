/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.dao;

import java.util.List;
import net.idealclover.java.fw.fx.esckit.po.SgccKbDoc;
import net.idealclover.java.fw.fx.esckit.po.SgccPFile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DragonFly
 */
@Repository("sgccKbDocMapper")
public interface ISgccKbDocMapper {

    public SgccKbDoc getModel(Long id);

    public List<SgccKbDoc> list(String btime, String etime);
    
    public void save(SgccKbDoc po);
    
    public void saveFile(SgccPFile po);

}
