/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.idealclover.java.fw.fx.esckit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.idealclover.java.fw.fx.esckit.core.Constant;
import net.idealclover.java.fw.fx.esckit.core.DocCompassUtil;
import net.idealclover.java.fw.fx.esckit.core.FXMLController;
import net.idealclover.java.fw.fx.esckit.core.FXMLRouteController;
import net.idealclover.java.fw.fx.esckit.service.ITransService;
import net.idealclover.java.fw.fx.esckit.vo.DocSearch;
import net.idealclover.java.fw.fx.esckit.vo.DocSerializableVo;
import net.idealclover.java.fw.fx.esckit.vo.DocTableVo;
import net.idealclover.java.fw.fx.esckit.vo.DocVo;
import net.idealclover.java.fw.fx.esckit.vo.SysparaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author DragonFly
 */
@Controller("mainController")
public class MainController implements FXMLController {

    @Autowired
    private FXMLRouteController fxmlRouteController;

    @Autowired
    private ITransService service;

    private Stage stage;

    private final String title = "ETL Tool for KB Platform";

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    MenuItem importMi;

    @FXML
    MenuItem exportMi;

    @FXML
    DatePicker btimeDp;

    @FXML
    DatePicker etimeDp;

    @FXML
    Button queryBtn;

    @FXML
    TableView docTv;

    @FXML
    TableColumn checkboxTc;

    @FXML
    protected void initialize() {
        stage.setResizable(false);
        stage.setTitle(this.title);
        // 设置菜单项状态
        String webState = "0";
        try {
            SysparaVo vo = service.getWebState();
            webState = vo.getValue();
            if ("1".equals(webState)) {// 外网
                importMi.setDisable(false);
                exportMi.setDisable(true);
                btimeDp.setDisable(true);
                etimeDp.setDisable(true);
                queryBtn.setDisable(true);
            } else if ("0".equals(webState)) {//内网
                importMi.setDisable(true);
                exportMi.setDisable(false);
                btimeDp.setDisable(false);
                etimeDp.setDisable(false);
                queryBtn.setDisable(false);
            }
        } catch (Exception e) {
            importMi.setDisable(true);
            exportMi.setDisable(true);
            btimeDp.setDisable(true);
            etimeDp.setDisable(true);
            queryBtn.setDisable(true);
        }
        // 默认查询
        // 设置默认查询条件
        LocalDate today = LocalDate.now();
        LocalDate lastMonthDay = today.plusDays(-30);
        btimeDp.setValue(lastMonthDay);
        etimeDp.setValue(today);
        // 设置表格格式
        docTv.setEditable(true);
        ObservableList<TableColumn> observableList = docTv.getColumns();
        observableList.get(0).setCellFactory(CheckBoxTableCell.forTableColumn(observableList.get(0)));
        observableList.get(0).setEditable(true);
        observableList.get(0).setCellValueFactory(new PropertyValueFactory("checkbox"));
        observableList.get(1).setCellValueFactory(new PropertyValueFactory("docDomainName"));
        observableList.get(2).setCellValueFactory(new PropertyValueFactory("docTypeName"));
        observableList.get(3).setCellValueFactory(new PropertyValueFactory("title"));
        observableList.get(4).setCellValueFactory(new PropertyValueFactory("author"));
        observableList.get(5).setCellValueFactory(new PropertyValueFactory("keyword"));
        observableList.get(6).setCellValueFactory(new PropertyValueFactory("summary"));
        observableList.get(7).setCellValueFactory(new PropertyValueFactory("filename"));
        observableList.get(8).setCellValueFactory(new PropertyValueFactory("filetype"));
        observableList.get(9).setCellValueFactory(new PropertyValueFactory("filesize"));
        observableList.get(9).setStyle("-fx-alignment:CENTER-RIGHT;");
        observableList.get(10).setCellValueFactory(new PropertyValueFactory("oldname"));
        observableList.get(11).setCellValueFactory(new PropertyValueFactory("relapath"));
        observableList.get(12).setCellValueFactory(new PropertyValueFactory("oper"));
        observableList.get(13).setCellValueFactory(new PropertyValueFactory("optime"));

        if ("1".equals(webState)) {

        } else if ("0".equals(webState)) {
            query();
        }
    }

    @FXML
    public void query() {

        //设置查询条件
        DocVo vo = new DocVo();
        LocalDate btime = btimeDp.getValue();
        String btimeStr = btime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        vo.setBtime(btimeStr);
        LocalDate etime = etimeDp.getValue();
        String etimeStr = etime.format(DateTimeFormatter.ISO_LOCAL_DATE);
        vo.setEtime(etimeStr);

        // 执行查询
        List<DocTableVo> data;
        try {
            data = service.listDoc4Tv(vo);
        } catch (Exception e) {
            e.printStackTrace();
            data = new ArrayList<>();
        }

        // 填充数据
        ObservableList<DocTableVo> list = FXCollections.observableArrayList();
        list.clear();
        for (DocTableVo dtVo : data) {
            dtVo.setCheckbox(true);
            list.add(dtVo);
        }
        docTv.setItems(list);
    }

    @FXML
    public void import0() throws Exception {

        List<DocSerializableVo> dsvolist = null;
        ObservableList<DocTableVo> dtvolist = FXCollections.observableArrayList();
        dtvolist.clear();

        // 获取导入文件
        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Transport Files", "*.tra"));
        File file = fileChooser.showOpenDialog(stage);

        if (file == null) {
            throw new RuntimeException();
        }

        if (!file.exists()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("文件不存在！");
            alert.initOwner(stage);
            alert.show();
            docTv.setEditable(true);
            throw new RuntimeException();
        }

        // 读文件，获取数据，保存文件
        Map<String, String> fileidmap = new HashMap<String, String>();

        try (FileInputStream fis = new FileInputStream(file);
                BufferedInputStream in = new BufferedInputStream(fis);
                CheckedInputStream csum = new CheckedInputStream(in, new Adler32());
                ZipInputStream zis = new ZipInputStream(csum)) {
            ZipEntry ze;
            while ((ze = zis.getNextEntry()) != null) {
                if ("TableData\\A0".equals(ze.getName())) {
                    ObjectInputStream ois = new ObjectInputStream(zis);
                    dsvolist = (List<DocSerializableVo>) ois.readObject();
                    for (DocSerializableVo dsvo : dsvolist) {
                        DocTableVo dtvo = new DocTableVo();
                        dtvo.setId(dsvo.getId());
                        dtvo.setFileId(dsvo.getFileId());
                        dtvo.setOpdept(dsvo.getOpdept());
                        dtvo.setDocDomain(dsvo.getDocDomain());
                        dtvo.setDocType(dsvo.getDocType());
                        dtvo.setDocDomainName(dsvo.getDocDomainName());
                        dtvo.setDocTypeName(dsvo.getDocTypeName());
                        dtvo.setTitle(dsvo.getTitle());
                        dtvo.setAuthor(dsvo.getAuthor());
                        dtvo.setKeyword(dsvo.getKeyword());
                        dtvo.setSummary(dsvo.getSummary());
                        dtvo.setFilename(dsvo.getFilename());
                        dtvo.setFiletype(dsvo.getFiletype());
                        dtvo.setFilesize(dsvo.getFilesize());
                        dtvo.setOldname(dsvo.getOldname());
                        dtvo.setRelapath(dsvo.getRelapath());
                        dtvo.setOper(dsvo.getOper());
                        dtvo.setOptime(Constant.dffull.format(dsvo.getOptime()));
                        dtvolist.add(dtvo);
                    }
                    docTv.setItems(dtvolist);
                    //    ois.close();
                } else {
                    if (!ze.getName().startsWith("FileData") || ze.getName().length() != 44) {
                        continue;
                    }
                    String fileid = ze.getName().substring(32, 44);
                    File docfile = new File("D:\\escfile\\upload\\".concat(ze.getName().substring(9)));
                    String newfileid = this.getNewFileName(docfile);
                    fileidmap.put(fileid, newfileid);
                    File newfile = new File(docfile.getPath().replaceAll(fileid, newfileid));
                    if (!newfile.exists()) {
                        newfile.getParentFile().mkdirs();
                        newfile.createNewFile();
                    }
                    try (FileOutputStream fos = new FileOutputStream(newfile);
                            BufferedOutputStream out = new BufferedOutputStream(fos)) {
                        int c;
                        while ((c = zis.read()) != -1) {
                            out.write(c);
                        }
                        out.flush();
                    } catch (IOException e0) {
                        throw new RuntimeException(e0);
                    }
                }
                System.err.println(ze.getName());
            }

        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("文件导入失败！");
            alert.setContentText(e.getMessage());
            alert.initOwner(stage);
            alert.show();
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e);
        }

        // 数据录入数据库
        DocCompassUtil docCu = new DocCompassUtil();
        for (DocSerializableVo dsvo1 : dsvolist) {
            service.saveDoc(dsvo1, fileidmap);
            DocSearch smodel = new DocSearch();
            smodel.setId(String.valueOf(dsvo1.getId()));
            smodel.setDocdomain(dsvo1.getDocDomain());
            smodel.setDoctype(dsvo1.getDocType());
            smodel.setKeyword(dsvo1.getKeyword());
            smodel.setTitle(dsvo1.getTitle());
            smodel.setAuthor(dsvo1.getAuthor());
            smodel.setUploadtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            smodel.setFileid(String.valueOf(dsvo1.getFileId()));
            smodel.setSummary(dsvo1.getSummary());
            smodel.setContent(dsvo1.getKeyword() + dsvo1.getSummary());
            docCu.index(smodel);
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("数据导入成功！");
        alert.initOwner(stage);
        alert.show();
    }

    @FXML
    public void export() throws Exception {
        // 冻结所选状态
        docTv.setEditable(false);

        // 准备数据
        ObservableList<DocTableVo> items = docTv.getItems();
        List<DocSerializableVo> dsvolist = new ArrayList<DocSerializableVo>();
        int checknum = 0;
        for (DocTableVo vo : items) {
            if (vo.getCheckbox()) {
                checknum++;
                DocSerializableVo dsvo = new DocSerializableVo();
                dsvo.setId(vo.getId());
                dsvo.setOper(vo.getOper());
                dsvo.setOpdept(vo.getOpdept());
                dsvo.setOptime(Constant.dffull.parse(vo.getOptime()));
                dsvo.setDocDomain(vo.getDocDomain());
                dsvo.setDocType(vo.getDocType());
                dsvo.setTitle(vo.getTitle());
                dsvo.setKeyword(vo.getKeyword());
                dsvo.setAuthor(vo.getAuthor());
                dsvo.setSummary(vo.getSummary());
                dsvo.setFileId(vo.getFileId());
                dsvo.setFilename(vo.getFilename());
                dsvo.setFiletype(vo.getFiletype());
                dsvo.setFilesize(vo.getFilesize());
                dsvo.setOldname(vo.getOldname());
                dsvo.setRelapath(vo.getRelapath());
                dsvo.setDocDomainName(vo.getDocDomainName());
                dsvo.setDocTypeName(vo.getDocTypeName());
                dsvolist.add(dsvo);
            }
        }

        // 判断是否有数据需要被导出
        if (checknum == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("请选择需要导出的数据！");
            alert.initOwner(stage);
            alert.show();
            docTv.setEditable(true);
            throw new RuntimeException();
        }

        // 选择保存文件
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Transport Files", "*.tra"));
        File file = fileChooser.showSaveDialog(stage);
        if (file == null) {
            docTv.setEditable(true);
            throw new RuntimeException();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("文件创建失败！");
                alert.setContentText(e.getMessage());
                alert.initOwner(stage);
                alert.show();
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, e);
                docTv.setEditable(true);
                throw new RuntimeException();
            }
        }

        // 保存数据和文件
        try (FileOutputStream fos = new FileOutputStream(file);
                CheckedOutputStream csum = new CheckedOutputStream(fos, new Adler32());
                ZipOutputStream zos = new ZipOutputStream(csum);
                BufferedOutputStream out = new BufferedOutputStream(zos);
                ObjectOutputStream oos = new ObjectOutputStream(out)) {

            zos.setComment("TableData");
            zos.putNextEntry(new ZipEntry("TableData\\A0"));
            oos.writeObject(dsvolist);
            oos.flush();
            zos.closeEntry();

            for (DocSerializableVo dsvof : dsvolist) {
                try (FileInputStream fis = new FileInputStream("D:\\escfile\\upload\\".concat(dsvof.getRelapath()));
                        BufferedInputStream in = new BufferedInputStream(fis)) {
                    zos.putNextEntry(new ZipEntry("FileData\\".concat(dsvof.getRelapath())));
                    int c;
                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }
                    out.flush();
                    zos.closeEntry();
                } catch (IOException e0) {
                    throw new RuntimeException(e0);
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("数据导出成功！");
            alert.initOwner(stage);
            alert.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("文件更新失败！");
            alert.setContentText(e.getMessage());
            alert.initOwner(stage);
            alert.show();
            // 失败了就把文件给删了
            if (file.exists()) {
                file.delete();
            }
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, e);
            docTv.setEditable(true);
            throw new RuntimeException(e);
        }
        docTv.setEditable(true);
    }

    @FXML
    public void exit() {
        System.exit(0);
    }

    @FXML
    public void about() {
        fxmlRouteController.showDialog("about");
    }

    private String getNewFileName(File file) {
        String path = file.getPath();
        String name = path.substring(path.lastIndexOf("\\") + 1);
        String newname = null;
        if (file.exists()) {
            String tmname = name.substring(0, 10);
            String rdname = name.substring(10, 12);
            int rdint = Integer.parseInt(rdname) + 101;
            String rdnewname = String.valueOf(rdint);
            rdnewname = rdnewname.substring(rdnewname.length() - 2, rdnewname.length());
            String newttname = tmname.concat(rdnewname);
            String newttpath = path.replaceAll(name, newttname);
            file = new File(newttpath);
        } else {
            newname = name;
        }

        if (newname == null) {
            return getNewFileName(file);
        } else {
            return newname;
        }
    }

    public static void main(String[] args) {
        MainController m = new MainController();
        File file = new File("D:\\kb\\201705\\149490308699\\149490308699");
        System.out.println(m.getNewFileName(file));
    }

}
