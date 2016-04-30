package de.larmic.butterfaces.tomee;

import de.larmic.butterfaces.model.text.AutoCompleteModel;
import de.larmic.butterfaces.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class SimpleBean implements Serializable {

    private final List<String> autoCompleteValues = new ArrayList<>();

    private String value;

    @PostConstruct
    public void init() {
        autoCompleteValues.add("test");
        autoCompleteValues.add("tetest");
        autoCompleteValues.add("test1 ButterFaces");
        autoCompleteValues.add("test2");
        autoCompleteValues.add("ButterFaces");
        autoCompleteValues.add("ButterFaces JSF");
        autoCompleteValues.add("ButterFaces Mojarra");
        autoCompleteValues.add("ButterFaces Component");
        autoCompleteValues.add("JSF");
        autoCompleteValues.add("JSF 2");
        autoCompleteValues.add("JSF 2.2");
    }

    public List<String> getListOfSimpleValues() {
        final List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        list.add("baz");
        return list;
    }

    public AutoCompleteModel getAutoCompleteModel() {
        return value1 -> {
            final List<String> values = new ArrayList<>();

            if (StringUtils.isNotEmpty(value1.toString())) {
                values.addAll(autoCompleteValues.stream()
                        .filter(autoCompleteValue -> autoCompleteValue.toLowerCase().contains(value1.toString().toLowerCase()))
                        .collect(Collectors.toList()));
            }

            return values;
        };
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
