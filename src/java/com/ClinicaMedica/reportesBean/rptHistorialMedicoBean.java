package com.ClinicaMedica.reportesBean;

import com.ClinicaMedica.Sesiones.controlador;
import com.ClinicaMedica.reportesDAO.rptHistorialMedicoDAO;
import com.ClinicaMedica.reportesModelo.rptHistorialMedico;
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
public class rptHistorialMedicoBean {

    private rptHistorialMedico rptBs = new rptHistorialMedico();
    private controlador objeto = new controlador();
    private List<rptHistorialMedico> lstRpt = new ArrayList<rptHistorialMedico>();
    rptHistorialMedicoDAO dao;

    public rptHistorialMedico getRptBs() {
        return rptBs;
    }

    public void setRptBs(rptHistorialMedico rptBs) {
        this.rptBs = rptBs;
    }

    public controlador getObjeto() {
        return objeto;
    }

    public void setObjeto(controlador objeto) {
        this.objeto = objeto;
    }

    public List<rptHistorialMedico> getLstRpt() {
        return lstRpt;
    }

    public void setLstRpt(List<rptHistorialMedico> lstRpt) {
        this.lstRpt = lstRpt;
    }

    public rptHistorialMedicoDAO getDao() {
        return dao;
    }

    public void setDao(rptHistorialMedicoDAO dao) {
        this.dao = dao;
    }

    public void listarDocumentos() {

        try {
            dao = new rptHistorialMedicoDAO();
            lstRpt = dao.listarReporte(rptBs);

            rptBs.setNombrePaciente(lstRpt.get(0).getNombrePaciente());
            rptBs.setFechaNacimiento(lstRpt.get(0).getFechaNacimiento());
            rptBs.setTelefono(lstRpt.get(0).getTelefono());
            rptBs.setCorreo(lstRpt.get(0).getCorreo());
            rptBs.setSexo(lstRpt.get(0).getSexo());
            rptBs.setCivil(lstRpt.get(0).getCivil());
            rptBs.setDocumento(lstRpt.get(0).getDocumento());
            rptBs.setNoDocumento(lstRpt.get(0).getNoDocumento());
            rptBs.setReligion(lstRpt.get(0).getReligion());
            rptBs.setDireccion(lstRpt.get(0).getDireccion());
            rptBs.setDetalleVivienda(lstRpt.get(0).getDetalleVivienda());
            rptBs.setPersonaEncargada(lstRpt.get(0).getPersonaEncargada());
            rptBs.setContactoDeEmergencia(lstRpt.get(0).getContactoDeEmergencia());
            rptBs.setOcupacionPaciente(lstRpt.get(0).getOcupacionPaciente());
            rptBs.setCodigoHistorial(lstRpt.get(0).getCodigoHistorial());
            rptBs.setDescripcionHistorial(lstRpt.get(0).getDescripcionHistorial());
            rptBs.setClinicaProveniente(lstRpt.get(0).getClinicaProveniente());
            rptBs.setNombreEnfermedad(lstRpt.get(0).getNombreEnfermedad());
            rptBs.setTipoEnfermedad(lstRpt.get(0).getTipoEnfermedad());
            rptBs.setMotivoConsulta(lstRpt.get(0).getMotivoConsulta());
            rptBs.setDescripcion(lstRpt.get(0).getDescripcion());
            rptBs.setExamenDiagnositcado(lstRpt.get(0).getExamenDiagnositcado());
            rptBs.setTipoExamen(lstRpt.get(0).getTipoExamen());
            rptBs.setFechaCita(lstRpt.get(0).getFechaCita());
            rptBs.setHoraCita(lstRpt.get(0).getHoraCita());
            rptBs.setTipoCita(lstRpt.get(0).getTipoCita());
            rptBs.setPresionPaciente(lstRpt.get(0).getPresionPaciente());
            rptBs.setTemperaturaPaciente(lstRpt.get(0).getTemperaturaPaciente());
            rptBs.setPesoPaciente(lstRpt.get(0).getPesoPaciente());
            rptBs.setEstaturaPaciente(lstRpt.get(0).getEstaturaPaciente());
            rptBs.setTallaPaciente(lstRpt.get(0).getTallaPaciente());
            rptBs.setNombreEmpleado(lstRpt.get(0).getNombreEmpleado());

        } catch (Exception e) {
            System.out.println("No se desplego informacion en ReportesBusquedaPacienteBean " + e);
        }
    }
    
    public void exportarPDF() throws JRException, IOException, SQLException {

        Map<String, Object> parametros = new HashMap<String, Object>();

        parametros.put("txtUsuario", objeto.getUsu().getNombre());
        parametros.put("txtPaciente", rptBs.getNombrePaciente());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptHistorialMedico.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=HistorialMedico.pdf");
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

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptHistorialMedico.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=HistorialMedico.xls");
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

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptHistorialMedico.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(dao.listarReporte(rptBs)));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=HistorialMedico.doc");
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
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportes/rptHistorialMedico.jasper"));

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
