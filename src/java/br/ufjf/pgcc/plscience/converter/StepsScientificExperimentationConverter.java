/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.pgcc.plscience.converter;

import br.ufjf.pgcc.plscience.model.StepsScientificExperimentation;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Guilherme Martins
 */
@FacesConverter("stepsScientificExperimentationConverter")
@ManagedBean
public class StepsScientificExperimentationConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (StepsScientificExperimentation) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof StepsScientificExperimentation) {
            StepsScientificExperimentation pergunta = (StepsScientificExperimentation) value;
            if (pergunta != null && pergunta instanceof StepsScientificExperimentation && pergunta.getId() != null) {
                uic.getAttributes().put( pergunta.getId().toString(), pergunta);
                return pergunta.getId().toString();
            }
        }
        return "";
    }
}
