
package com.example.servlet;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.el.MethodBinding;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/callManagedBean")
public class CallManagedBeanServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 1083288687606498770L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LifecycleFactory lFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        Lifecycle lifecycle = lFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
        FacesContextFactory fcFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        fcFactory.getFacesContext(getServletContext(), req, resp, lifecycle);

        FacesContext facesContext = FacesContext.getCurrentInstance();
        String elExpression = "#{fromResolveVariableManagedBean.execute}";
        MethodBinding mb = facesContext.getApplication().createMethodBinding(elExpression, null);

        // FromResolveVariableManagedBean.executeåƒèo
        String result = (String) mb.invoke(facesContext, null);
    }
}
