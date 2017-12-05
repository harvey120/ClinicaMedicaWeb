//package com.ClinicaMedica.reportesBean;
//
//import com.ClinicaMedica.Sesiones.controlador;
//import com.ClinicaMedica.reportesDAO.ReportesBusquedaEmpleadoDAO;
//import com.ClinicaMedica.reportesDAO.ReportesEmpleadoDAO;
//import com.ClinicaMedica.reportesModelo.rptBusquedaEmpleado;
//import java.io.File;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.context.FacesContext;
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletResponse;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRExporterParameter;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperRunManager;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.export.JRXlsExporter;
//import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
//
///**
// * @author Harvey
// */
//@ManagedBean
//@RequestScoped
//public class ReportesBusquedaEmpleadoBean {
//
//    private rptBusquedaEmpleado rptBs = new rptBusquedaEmpleado();
//    private controlador objeto = new controlador();
//    private List<rptBusquedaEmpleado> lstRpt = new ArrayList<rptBusquedaEmpleado>();
//
//    public controlador getObjeto() {
//        return objeto;
//    }
//
//    public void setObjeto(controlador objeto) {
//        this.objeto = objeto;
//    }
//
//    public ReportesBusquedaEmpleadoDAO getDao() {
//        return dao;
//    }
//
//    public void setDao(ReportesBusquedaEmpleadoDAO dao) {
//        this.dao = dao;
//    }
//
//    public ReportesBusquedaEmpleadoBean() {
//    }
//
//    public rptBusquedaEmpleado getRptBs() {
//        return rptBs;
//    }
//
//    public void setRptBs(rptBusquedaEmpleado rptBs) {
//        this.rptBs = rptBs;
//    }
//
//    public List<rptBusquedaEmpleado> getLstRpt() {
//        return lstRpt;
//    }
//
//    public void setLstRpt(List<rptBusquedaEmpleado> lstRpt) {
//        this.lstRpt = lstRpt;
//    }
//
//    public void listarDocumentos() {
//        ReportesBusquedaEmpleadoDAO dao;
//
//        try {
//            dao = new ReportesBusquedaEmpleadoDAO();
//            System.out.println("");
//            lstRpt = dao.listarReporte(rptBs);
//
//            rptBs.setNombreCompleto(lstRpt.get(0).getNombreCompleto());
//            rptBs.setFechaNacimiento(lstRpt.get(0).getFechaNacimiento());
//            rptBs.setTelefonoDeContacto(lstRpt.get(0).getTelefonoDeContacto());
//            rptBs.setCorreo(lstRpt.get(0).getCorreo());
//            rptBs.setSexo(lstRpt.get(0).getSexo());
//            rptBs.setCivil(lstRpt.get(0).getCivil());
//            rptBs.setDocumentoIdentificacion(lstRpt.get(0).getDocumentoIdentificacion());
//            rptBs.setNoDocumento(lstRpt.get(0).getNoDocumento());
//            rptBs.setEspecialidad(lstRpt.get(0).getEspecialidad());
//            rptBs.setConsultorio(lstRpt.get(0).getConsultorio());
//            rptBs.setEstadoCita(lstRpt.get(0).getEstadoCita());
//            rptBs.setPuesto(lstRpt.get(0).getPuesto());
//            rptBs.setUsuario(lstRpt.get(0).getUsuario());
//            rptBs.setContrasena(lstRpt.get(0).getContrasena());
//            rptBs.setEstado(lstRpt.get(0).getEstado());
//
//            System.out.println(rptBs.getNombreCompleto());
//        } catch (Exception e) {
//            System.out.println("No se desplego informacion en ReportesBusquedaEmpleadoBean " + e);
//        }
//    }
//
//    ReportesBusquedaEmpleadoDAO dao = new ReportesBusquedaEmpleadoDAO();
//
//    public void exportarPDF() throws JRException, IOException, SQLException {
//
//        Map<String, Object> parametros = new HashMap<String, Object>();
//
//        parametros.put("txtUsuario", objeto.getUsu().getNombre());
//        parametros.put("txtEmpleado", rptBs.getNombreCompleto());
//
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptBusquedaEmpleado.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));
//
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=ReporteDeEmpleados.pdf");
//        ServletOutputStream stream = response.getOutputStream();
//
//        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
//
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
//    
//    public void exportarExcel() throws JRException, IOException, SQLException {
//
//        Map<String, Object> parametros = new HashMap<String, Object>();
//
//        parametros.put("txtUsuario", objeto.getUsu().getNombre());
//        parametros.put("txtEmpleado", rptBs.getNombreCompleto());
//
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptBusquedaEmpleado.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));
//
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=ReporteDeEmpleados.xls");
//        ServletOutputStream stream = response.getOutputStream();
//
//        JRXlsExporter exporter = new JRXlsExporter();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
//        exporter.exportReport();
//
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
//
//    public void exportarDOC() throws JRException, IOException, SQLException {
//
//        Map<String, Object> parametros = new HashMap<String, Object>();
//
//        parametros.put("txtUsuario", objeto.getUsu().getNombre());
//        parametros.put("txtEmpleado", rptBs.getNombreCompleto());
//
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptBusquedaEmpleado.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));
//        
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=ReporteDeEmpleados.doc");
//        ServletOutputStream stream = response.getOutputStream();
//
//        JRDocxExporter exporter = new JRDocxExporter();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
//        exporter.exportReport();
//
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
//
//    public void verPDF() throws Exception {
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptBusquedaEmpleado.jasper"));
//
//        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.setContentType("application/pdf");
//        response.setContentLength(bytes.length);
//        ServletOutputStream outStream = response.getOutputStream();
//        outStream.write(bytes, 0, bytes.length);
//        outStream.flush();
//        outStream.close();
//
//        FacesContext.getCurrentInstance().responseComplete();
//    }
//
//}
