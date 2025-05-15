package com.hbv.appz1_hbv_l5.composite;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("IComponent")
public interface IComponent {
    void add(IComponent component);
    void remove(IComponent component);
    void setAbsoluteCode(String absoluteCode);
    String getAbsoluteCode();
    void updateAbsoluteCodes(String newParentCode);
}