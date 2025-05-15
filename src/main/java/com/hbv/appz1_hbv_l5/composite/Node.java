package com.hbv.appz1_hbv_l5.composite;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@XStreamAlias("Node")
public class Node implements IComponent {
    @XStreamAsAttribute
    @XStreamAlias("absoluteCode")
    private String absoluteCode;
    @XStreamAsAttribute
    @XStreamAlias("name")
    private String name;

    @XStreamImplicit
    private final List<IComponent> children = new ArrayList<>();

    public Node(String absoluteCode, String name) {
        this.absoluteCode = absoluteCode;
        this.name = name;
    }

    @Override
    public void add(IComponent component) {
        children.add(component);
        updateAbsoluteCodes(absoluteCode);
    }

    @Override
    public void remove(IComponent component) {
        children.remove(component);
        updateAbsoluteCodes(absoluteCode);
    }

    @Override
    public void setAbsoluteCode(String absoluteCode) {
        this.absoluteCode = absoluteCode;
    }

    @Override
    public String getAbsoluteCode() {
        return absoluteCode;
    }

    @Override
    public void updateAbsoluteCodes(String newParentCode) {
        int index = 1;
        for (IComponent child : children) {
            String newCode = newParentCode + String.format("%02d", index++);
            child.setAbsoluteCode(newCode);
            child.updateAbsoluteCodes(newCode);
        }
    }
}
