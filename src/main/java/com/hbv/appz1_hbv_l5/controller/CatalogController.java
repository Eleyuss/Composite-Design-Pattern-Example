package com.hbv.appz1_hbv_l5.controller;


import com.hbv.appz1_hbv_l5.composite.IComponent;
import com.hbv.appz1_hbv_l5.composite.Manager;
import com.hbv.appz1_hbv_l5.composite.Node;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CatalogController {

    private String source = "main.xml";

    @GetMapping("/")
    public String home() {
        return "redirect:/catalog";
    }

    @GetMapping("/catalog")
    public String showCatalog(Model model) {
        Manager manager = new Manager();
        manager.getElementsFromXMLFile(source);
        List<IComponent> components = new ArrayList<>();
        collectComponents(manager.getRoot(), components);
        model.addAttribute("components", components);
        return "main-page";
    }

    @GetMapping("/catalog/delete")
    public String showCatalog(@RequestParam("id") String absoluteCode,  RedirectAttributes redirectAttributes) {
       if(!absoluteCode.isEmpty()){
        try {
            Manager manager = new Manager();
            manager.getElementsFromXMLFile(source);
            manager.removeComponent(absoluteCode);
            manager.writeToXMLFile(source);
            manager.getElementsFromXMLFile(source);
            List<IComponent> components = new ArrayList<>();
            collectComponents(manager.getRoot(), components);
            redirectAttributes.addFlashAttribute("components", components);
            redirectAttributes.addFlashAttribute("message", "Component successfully deleted");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Error:" + e);
        }
       }else{
           redirectAttributes.addFlashAttribute("message", "Root can not be delete");
       }
        return "redirect:/catalog";
    }

    @PostMapping("/catalog/add-group")
    public String addGroup(@RequestParam("groupName") String name,
                           @RequestParam("groupId") String groupId,
                           RedirectAttributes redirectAttributes) {
        try{
            Manager manager = new Manager();
            manager.getElementsFromXMLFile(source);
            manager.addComposite(groupId, name);
            manager.writeToXMLFile(source);
            redirectAttributes.addFlashAttribute("message", "Group successfully added");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Error:" + e);
        }
        return "redirect:/catalog";
    }

    @PostMapping("/catalog/add-product")
    public String addProduct(@RequestParam("productName") String name,
                             @RequestParam("productId") String productId,
                             @RequestParam("productPrice") double price,
                             RedirectAttributes redirectAttributes) {
        try{
            Manager manager = new Manager();
            manager.getElementsFromXMLFile(source);
            manager.addProduct(productId, name, price);
            manager.writeToXMLFile(source);
            redirectAttributes.addFlashAttribute("message", "Product successfully added");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Error:" + e);
        }
        return "redirect:/catalog";
    }

    @PostMapping("/catalog/save")
    public String saveCatalogToXML(@RequestParam("filename") String filename,
                                   RedirectAttributes redirectAttributes) {
        try {
            Manager manager = new Manager();
            manager.getElementsFromXMLFile(source);
            manager.writeToXMLFile(filename + ".xml");
            redirectAttributes.addFlashAttribute("message", "Catalog successfully saved");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Error:" + e);
        }
        return "redirect:/catalog";
    }

    @PostMapping("/catalog/open")
    public String openXMLFile(@RequestParam("path") String filename,
                              RedirectAttributes redirectAttributes) {
        try {
            this.source = filename;
             redirectAttributes.addFlashAttribute("message", "Catalog successfully opened");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("message", "Error:" + e);
        }
        return "redirect:/catalog";
    }

    private void collectComponents(IComponent component, List<IComponent> components) {
        components.add(component);

        if (component instanceof Node) {
            for (IComponent child : ((Node) component).getChildren()) {
                collectComponents(child, components);
            }
        }
    }
}

