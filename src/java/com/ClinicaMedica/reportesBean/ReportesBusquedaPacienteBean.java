package com.ClinicaMedica.reportesBean;

import com.ClinicaMedica.Sesiones.controlador;
import com.ClinicaMedica.reportesDAO.ReportesBusquedaPacienteDAO;
import com.ClinicaMedica.reportesModelo.rptBusquedaPaciente;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class ReportesBusquedaPacienteBean {

    private rptBusquedaPaciente rptBs = new rptBusquedaPaciente();
    private controlador objeto = new controlador();
    private List<rptBusquedaPaciente> lstRpt = new ArrayList<rptBusquedaPaciente>();
    ReportesBusquedaPacienteDAO dao = new ReportesBusquedaPacienteDAO();

    public rptBusquedaPaciente getRptBs() {
        return rptBs;
    }

    public void setRptBs(rptBusquedaPaciente rptBs) {
        this.rptBs = rptBs;
    }

    public controlador getObjeto() {
        return objeto;
    }

    public void setObjeto(controlador objeto) {
        this.objeto = objeto;
    }

    public List<rptBusquedaPaciente> getLstRpt() {
        return lstRpt;
    }

    public void setLstRpt(List<rptBusquedaPaciente> lstRpt) {
        this.lstRpt = lstRpt;
    }

    public void listarDocumentos() {
        ReportesBusquedaPacienteDAO dao;

        try {
            dao = new ReportesBusquedaPacienteDAO();
            System.out.println("");
            lstRpt = dao.listarReporte(rptBs);

            rptBs.setNombrePaciente(lstRpt.get(0).getNombrePaciente());
            rptBs.setFechaNacimiento(lstRpt.get(0).getFechaNacimiento());
            rptBs.setTelefono(lstRpt.get(0).getTelefono());
            rptBs.setCorreo(lstRpt.get(0).getCorreo());
            rptBs.setGenero(lstRpt.get(0).getGenero());
            rptBs.setCivil(lstRpt.get(0).getCivil());
            rptBs.setDocumento(lstRpt.get(0).getDocumento());
            rptBs.setNoDocumento(lstRpt.get(0).getNoDocumento());
            rptBs.setReligion(lstRpt.get(0).getReligion());
            rptBs.setDireccion(lstRpt.get(0).getDireccion());
            rptBs.setDetalleVivienda(lstRpt.get(0).getDetalleVivienda());
            rptBs.setOcupacion(lstRpt.get(0).getOcupacion());
            rptBs.setCodigoHistorial(lstRpt.get(0).getCodigoHistorial());
            rptBs.setDescripcion(lstRpt.get(0).getDescripcion());
            rptBs.setFechaIngreso(lstRpt.get(0).getFechaIngreso());
            rptBs.setReferenciaClinica(lstRpt.get(0).getReferenciaClinica());
        } catch (Exception e) {
            System.out.println("No se desplego informacion en ReportesBusquedaPacienteBean " + e);
        }
    }

    public void exportarPDF() throws JRException, IOException, SQLException {

        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put("txtUsuario", objeto.getUsu().getNombre());
        parametros.put("txtPaciente", rptBs.getNombrePaciente());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptBusquedaPaciente.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));

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

        parametros.put("txtUsuario", objeto.getUsu().getNombre());
        parametros.put("txtPaciente", rptBs.getNombrePaciente());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptBusquedaPaciente.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));

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

        parametros.put("txtUsuario", objeto.getUsu().getNombre());
        parametros.put("txtPaciente", rptBs.getNombrePaciente());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptBusquedaPaciente.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));

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
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptBusquedaPaciente.jasper"));

        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));
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
