
package com.example.managedbean;

import java.io.Serializable;

import javax.faces.context.FacesContext;

public final class FromResolveVariableManagedBean implements Serializable {

    private static final long serialVersionUID = -7126389365512697700L;

    public String execute() {

        System.out.println("---------First---------");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ToResolveVariableManagedBean managedBean = (ToResolveVariableManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(
                facesContext, "toResolveVariableManagedBean");

        System.out.println("  ToResolveVariableManagedBean：" + managedBean);
        System.out.println("  ToResolveVariableManagedBean.hashCode：" + managedBean.hashCode());

        System.out.println("---------Second---------");
        managedBean = (ToResolveVariableManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext,
                "toResolveVariableManagedBean");
        System.out.println("  ToResolveVariableManagedBean：" + managedBean);
        System.out.println("  ToResolveVariableManagedBean.hashCode：" + managedBean.hashCode());

        System.out.println("---------Third---------");
        managedBean = (ToResolveVariableManagedBean) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext,
                "toResolveVariableManagedBean");
        System.out.println("  ToResolveVariableManagedBean：" + managedBean);
        System.out.println("  ToResolveVariableManagedBean.hashCode：" + managedBean.hashCode());

        return "SUCCESS";
    }
}
