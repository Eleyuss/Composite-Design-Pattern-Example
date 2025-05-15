package com.hbv.appz1_hbv_l5.composite;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("Product")
public class Product implements IComponent {
    @XStreamAsAttribute
    @XStreamAlias("absoluteCode")
    private String absoluteCode;
    @XStreamAsAttribute
    @XStreamAlias("name")
    private String name;
    @XStreamAsAttribute
    @XStreamAlias("price")
    private double price;

    @Override
    public void add(IComponent component) {}

    @Override
    public void remove(IComponent component) {}

    @Override
    public String getAbsoluteCode() {
        return absoluteCode;
    }

    @Override
    public void setAbsoluteCode(String absoluteCode) {
        this.absoluteCode = absoluteCode;
    }

    @Override
    public void updateAbsoluteCodes(String absoluteCode) {}

}

