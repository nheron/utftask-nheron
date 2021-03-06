package org.uberfire.client.navbar;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import org.uberfire.client.workbench.Header;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBarPresenter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static java.lang.Integer.MAX_VALUE;

@ApplicationScoped
public class AppNavBar
        extends Composite implements Header {

    @Inject
    private WorkbenchMenuBarPresenter menuBarPresenter;



    @Override
    public Widget asWidget() {
        return menuBarPresenter.getView().asWidget();
        //this.headerViewPresenter.show(menuBarPresenter);
        //return headerViewPresenter.getView().asWidget();
    }

    @Override
    public String getId() {
        return "AppNavBar";
    }

    @Override
    public int getOrder() {
        return MAX_VALUE;
    }


}
