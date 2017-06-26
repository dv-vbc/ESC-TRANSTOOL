/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.dao;

import net.idealclover.java.fw.fx.esckit.po.PSyspara;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DragonFly
 */
@Repository("psysparaMapper")
public interface IPSysparaMapper {

    public PSyspara findByCode(String code);

}
