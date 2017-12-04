package com.ClinicaMedica.reportesBean;

import com.ClinicaMedica.Sesiones.controlador;
import com.ClinicaMedica.reportesDAO.ReportesEmpleadoDAO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

/**
 * @author Harvey
 */
@ManagedBean
@RequestScoped
public class ReportesEmpleadoBean {

    ReportesEmpleadoDAO dao = new ReportesEmpleadoDAO();

    public void exportarPDF() throws JRException, IOException, SQLException {

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("txtUsuario", "Harvey Herrera");

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptEmpleado.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte()));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=ReporteDeEmpleados.pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarExcel() throws JRException, IOException, SQLException {

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("txtUsuario", "Harvey Herrera");

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptEmpleado.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte()));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=ReporteDeEmpleados.xls");
        ServletOutputStream stream = response.getOutputStream();

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarDOC() throws JRException, IOException, SQLException {

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("txtUsuario", "MitoCode");

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptEmpleado.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte()));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=ReporteDeEmpleados.doc");
        ServletOutputStream stream = response.getOutputStream();

        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void verPDF() throws Exception {
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptEmpleado.jasper"));

        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(dao.listarReporte()));
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(bytes, 0, bytes.length);
        outStream.flush();
        outStream.close();

        FacesContext.getCurrentInstance().responseComplete();
    }

}
