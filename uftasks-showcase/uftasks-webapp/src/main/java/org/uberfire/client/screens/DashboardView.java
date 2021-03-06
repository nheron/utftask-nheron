package org.uberfire.client.screens;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import org.gwtbootstrap3.client.ui.Badge;
import org.gwtbootstrap3.client.ui.ListGroup;
import org.gwtbootstrap3.client.ui.ListGroupItem;
import org.gwtbootstrap3.client.ui.constants.ListGroupItemType;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Dependent
@Templated
public class DashboardView extends Composite implements DashboardPresenter.View {

    private DashboardPresenter presenter;

    @Inject
    @DataField("projects")
    FlowPanel projects;

    @Override
    public void init( DashboardPresenter presenter ) {
        this.presenter = presenter;
    }

    @Override
    public void addProject( final String project,
                            final String tasksCreated,
                            final String tasksDone ) {
        ListGroup projectGroup = GWT.create( ListGroup.class );

        projectGroup.add( createListGroupItem( ListGroupItemType.INFO, project.toUpperCase(), null ) );
        projectGroup.add( createListGroupItem( ListGroupItemType.WARNING, "TODO", String.valueOf( tasksCreated ) ) );
        projectGroup.add( createListGroupItem( ListGroupItemType.SUCCESS, "DONE", String.valueOf( tasksDone ) ) );

        projects.add( projectGroup );
    }

    @Override
    public void clear() {
        projects.clear();
    }

    private ListGroupItem createListGroupItem( final ListGroupItemType type,
                                               final String text,
                                               final String number ) {
        ListGroupItem item = GWT.create( ListGroupItem.class );

        item.setType( type );
        item.setText( text );
        if ( number != null ) {
            Badge numberBadge = GWT.create( Badge.class );
            numberBadge.setText( number );
            item.add( numberBadge );
        }

        return item;
    }
}
