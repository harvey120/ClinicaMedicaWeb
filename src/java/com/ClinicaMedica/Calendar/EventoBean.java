package com.ClinicaMedica.Calendar;

import com.ClinicaMedica.Calendar.EventoDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.ClinicaMedica.Calendar.Evento;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author erick osoy
 */
@ManagedBean
@ViewScoped
public class EventoBean implements Serializable {

    private static final long serialVersionUID = 8458259708861027697L;

    private Evento evento;
    private ScheduleModel eventMode1;
    private List<Evento> listaEvento;
    private EventoDAO eDao;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public ScheduleModel getEventMode1() {
        return eventMode1;
    }

    public void setEventMode1(ScheduleModel eventMode1) {
        this.eventMode1 = eventMode1;
    }

    public List<Evento> getListaEvento() {
        return listaEvento;
    }

    public void setListaEvento(List<Evento> listaEvento) {
        this.listaEvento = listaEvento;
    }

    public EventoDAO geteDao() {
        return eDao;
    }

    public void seteDao(EventoDAO eDao) {
        this.eDao = eDao;
    }

    @PostConstruct
    public void inivializar() {

        eDao = new EventoDAO();
        evento = new Evento();
        eventMode1 = new DefaultScheduleModel();

        try {

            listaEvento = eDao.todosEventos();

        } catch (SQLException ex) {
            ex.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "ERROR DE SQL"));
        }
        for (Evento ev : listaEvento) {
            DefaultScheduleEvent evt = new DefaultScheduleEvent();
            evt.setEndDate(ev.getFin());
            evt.setStartDate(ev.getInicio());
            evt.setTitle(ev.getHorainicio());
            evt.setTitle(ev.getHorafin());
            evt.setTitle(ev.getNombre_empleado());
            evt.setTitle(ev.getNombre_paciente());
            evt.setTitle(ev.getTitulo());
            evt.setData(ev.getId());
            evt.setDescription(ev.getDescripcion());
            evt.setAllDay(true);
            evt.setEditable(true);

            if (ev.isStatus() == true) {
                evt.setStyleClass("emp1");
            } else if (ev.isStatus() == false) {
                evt.setStyleClass("emp2");
            }

            eventMode1.addEvent(evt);
        }
    }

    public void cuandoSeleccionado(SelectEvent selectEvent) {
        ScheduleEvent event = (ScheduleEvent) selectEvent.getObject();

        for (Evento ev : listaEvento) {
            if (ev.getId() == (Long) event.getData()) {
                evento = ev;
                break;
            }
        }
    }

    public void quandoNovo(SelectEvent selectEvent) {
        ScheduleEvent event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        evento = new Evento();
        evento.setInicio(new java.sql.Date(event.getStartDate().getTime()));

        System.out.println("hora inicio: " + evento.getInicio().getTime());

        evento.setFin(new java.sql.Date(event.getEndDate().getTime()));
    }

    
    
    public void salvar() {
        if (evento.getId() == null) {
            if (evento.getInicio().getTime() >= evento.getFin().getTime()) {
                eDao = new EventoDAO();
                try {
                    eDao.salvar(evento);
                    inivializar();
                } catch (SQLException ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inicio", "ERROR:" + ex.getMessage()));
                }
                evento = new Evento();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inicio", "Data inicio"));
            }
        } else {
            try {
                eDao.actualizar(evento);
                inivializar();
            } catch (SQLException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inicio", "ERROR:" + e.getMessage()));
            }
        }
    }

    public void modificar() {
        if (evento.getId() == null) {
            if (evento.getInicio().getTime() >= evento.getFin().getTime()) {
                eDao = new EventoDAO();
                try {
                    eDao.actualizar(evento);
                    inivializar();
                } catch (SQLException ex) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inicio", "ERROR:" + ex.getMessage()));
                }
                evento = new Evento();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inicio", "Data inicio"));
            }
        } else {
            try {
                eDao.actualizar(evento);
                inivializar();
            } catch (SQLException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inicio", "ERROR:" + e.getMessage()));
            }
        }
    }

    
    
    
    public void cuandoMovido(ScheduleEntryMoveEvent event) {
        for (Evento ev : listaEvento) {
            if (ev.getId() == (Long) event.getScheduleEvent().getData()) {
                evento = ev;
                eDao = new EventoDAO();
                try {
                    eDao.actualizar(evento);
                    inivializar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inicio", "ERROR:" + ex.getMessage()));
                }
                break;
            }
        }
    }
    
    
    

    public void cuandoRedimensiono(ScheduleEntryResizeEvent event) {
        for (Evento ev : listaEvento) {
            if (ev.getId() == (Long) event.getScheduleEvent().getData()) {
                evento = ev;
                eDao = new EventoDAO();
                try {
                    eDao.actualizar(evento);
                    inivializar();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inicio", "ERROR:" + ex.getMessage()));
                }
                break;
            }
        }
    }

}
