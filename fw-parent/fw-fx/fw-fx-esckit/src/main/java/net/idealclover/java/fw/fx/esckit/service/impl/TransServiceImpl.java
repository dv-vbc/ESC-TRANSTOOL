/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.service.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.idealclover.java.fw.fx.esckit.core.Constant;
import net.idealclover.java.fw.fx.esckit.dao.IPSysparaMapper;
import net.idealclover.java.fw.fx.esckit.dao.ISgccKbDocMapper;
import net.idealclover.java.fw.fx.esckit.po.PSyspara;
import net.idealclover.java.fw.fx.esckit.po.SgccKbDoc;
import net.idealclover.java.fw.fx.esckit.po.SgccPFile;
import net.idealclover.java.fw.fx.esckit.service.ITransService;
import net.idealclover.java.fw.fx.esckit.vo.DocSerializableVo;
import net.idealclover.java.fw.fx.esckit.vo.DocTableVo;
import net.idealclover.java.fw.fx.esckit.vo.DocVo;
import net.idealclover.java.fw.fx.esckit.vo.SysparaVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DragonFly
 */
@Service("transService")
public class TransServiceImpl implements ITransService {

    @Autowired
    private IPSysparaMapper psysparaMapper;

    @Autowired
    private ISgccKbDocMapper sgccKbDocMapper;

    @Override
    public SysparaVo getWebState() throws Exception {

        PSyspara model = psysparaMapper.findByCode("SYS_PARA_WEBSTATE");

        SysparaVo vo = new SysparaVo();

        String name = model.getName();
        String[] nameArr = StringUtils.split(name, "$");

        vo.setCode(nameArr[0]);
        vo.setName(nameArr[1]);
        vo.setValue(model.getDefaultValue());

        return vo;
    }

    @Override
    public List<DocTableVo> listDoc4Tv(DocVo vo) throws Exception {
        List<SgccKbDoc> list = sgccKbDocMapper.list(vo.getBtime(), vo.getEtime());

        List<DocTableVo> result = new ArrayList<DocTableVo>();
        for (SgccKbDoc po : list) {
            DocTableVo tvo = new DocTableVo();
            tvo.setId(po.getId());
            tvo.setFileId(po.getFileId());
            tvo.setOpdept(po.getOpdept());
            tvo.setDocDomain(po.getDocDomain());
            tvo.setDocType(po.getDocType());
            tvo.setDocDomainName(po.getDocDomainName());
            tvo.setDocTypeName(po.getDocTypeName());
            tvo.setTitle(po.getTitle());
            tvo.setAuthor(po.getAuthor());
            tvo.setKeyword(po.getKeyword());
            tvo.setSummary(po.getSummary());
            tvo.setFilename(po.getSgccPFile().getFilename());
            tvo.setFiletype(po.getSgccPFile().getFiletype());
            tvo.setFilesize(po.getSgccPFile().getFilesize());
            tvo.setOldname(po.getSgccPFile().getOldname());
            tvo.setRelapath(po.getSgccPFile().getRelapath());
            tvo.setOper(po.getOper());
            tvo.setOptime(Constant.dffull.format(po.getOptime()));
            result.add(tvo);
        }

        return result;
    }
    
    @Override
    public void saveDoc(DocSerializableVo dsvo, Map<String,String> fileidmap) throws Exception {
        SgccPFile fpo = new SgccPFile();
        String fileid = String.valueOf(dsvo.getFileId());
        String newfileid = fileidmap.get(fileid);
        String newrelapath = dsvo.getRelapath().replaceAll(fileid, newfileid);
        fpo.setId(Long.parseLong(newfileid));
        fpo.setFilename(newfileid);
        fpo.setFiletype(dsvo.getFiletype());
        fpo.setFilesize(dsvo.getFilesize());
        fpo.setFilepath("D:\\escfile\\upload\\".concat(newrelapath));
        fpo.setRelapath(newrelapath);
        fpo.setUploadopr(dsvo.getOper());
        fpo.setUploadtime(dsvo.getOptime());
        fpo.setModifyopr("SYS");
        fpo.setModifytime(new Date());
        fpo.setModifycount(0);
        fpo.setStoretype("01");
        fpo.setOldname(dsvo.getOldname());
        sgccKbDocMapper.saveFile(fpo);
        
        SgccKbDoc po = new SgccKbDoc();
        po.setId(Long.MIN_VALUE);
        po.setOper(dsvo.getOper());
        po.setOptime(new Date());
        po.setOpdept(dsvo.getOpdept());
        po.setDocDomain(dsvo.getDocDomain());
        po.setDocType(dsvo.getDocType());
        po.setDocLevel(1);
        po.setDocState("1");
        po.setKeyword(dsvo.getKeyword());
        po.setTitle(dsvo.getTitle());
        po.setSummary(dsvo.getSummary());
        po.setAuthor(dsvo.getAuthor());
        po.setUploadtime(dsvo.getOptime());
        po.setPreviewCount(0);
        po.setDownloadCount(0);
        po.setFileId(Long.parseLong(newfileid));
        po.setSn("0");
        po.setSync("");
        sgccKbDocMapper.save(po);
    }

}
