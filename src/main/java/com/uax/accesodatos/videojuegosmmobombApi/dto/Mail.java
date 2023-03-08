package com.uax.accesodatos.videojuegosmmobombApi.dto;

import java.util.List;
import java.util.Map;

public class Mail {

    private String form;
    private String to;
    private String asunto;
    private List<Object> attach;
    private Map<String, Object> props;



    public Mail() {

    }

    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public List<Object> getAttach() {
        return attach;
    }
    public void setAttach(List<Object> attach) {
        this.attach = attach;
    }
    public Map<String, Object> getProps() {
        return props;
    }
    public void setProps(Map<String, Object> props) {
        this.props = props;
    } 


}