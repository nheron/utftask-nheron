package org.uberfire.client;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import org.gwtbootstrap3.client.ui.AnchorListItem;
import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.ButtonGroup;
import org.gwtbootstrap3.client.ui.DropDownMenu;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.constants.Toggle;
import org.jboss.errai.ioc.client.api.EntryPoint;
import org.uberfire.client.mvp.PlaceManager;
import org.uberfire.client.resources.AppResource;
import org.uberfire.client.views.pfly.menu.MainBrand;
import org.uberfire.client.workbench.events.ApplicationReadyEvent;
import org.uberfire.client.workbench.widgets.menu.WorkbenchMenuBar;
import org.uberfire.workbench.model.menu.MenuFactory;
import org.uberfire.workbench.model.menu.MenuItem;
import org.uberfire.workbench.model.menu.Menus;
import org.uberfire.workbench.model.menu.impl.BaseMenuCustom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import static org.uberfire.workbench.model.menu.MenuFactory.newTopLevelCustomMenu;

@EntryPoint
public class ShowcaseEntryPoint {

    @Inject
    private WorkbenchMenuBar menubar;

    @Inject
    private PlaceManager placeManager;

    @PostConstruct
    public void startApp() {
        AppResource.INSTANCE.CSS().ensureInjected();
        hideLoadingPopup();
    }

    private void setupMenu(@Observes final ApplicationReadyEvent event) {

        final Menus menus =
                newTopLevelCustomMenu(new MenuFactory.CustomMenuBuilder() {
                    @Override
                    public void push(MenuFactory.CustomMenuBuilder element) {
                    }

                    @Override
                    public MenuItem build() {
                        return new BaseMenuCustom<IsWidget>() {
                            @Override
                            public IsWidget build() {
                                final ButtonGroup group = new ButtonGroup();
                                final Button dropdown = new Button("Production");
                                dropdown.setSize(ButtonSize.SMALL);
                                dropdown.setDataToggle(Toggle.DROPDOWN);
                                group.add(dropdown);
                                final DropDownMenu menu = new DropDownMenu();
                                menu.setPull(Pull.RIGHT);
                                final AnchorListItem build = new AnchorListItem("Assurés entreprises");
                                build.addClickHandler(new ClickHandler() {
                                    @Override
                                    public void onClick(ClickEvent event) {

                                        Window.alert("Assurés entreprises!");
                                    }
                                });

                                menu.add(build);
                                final AnchorListItem build2 = new AnchorListItem("Véhicules entreprises");

                                build2.addClickHandler(new ClickHandler() {
                                    @Override
                                    public void onClick(ClickEvent event) {
                                        Window.alert("Véhicules entreprises!");
                                    }
                                });
                                menu.add(build2);
                                final AnchorListItem build3 = new AnchorListItem("Assurés particuliers");
                                build3.addClickHandler(new ClickHandler() {
                                    @Override
                                    public void onClick(ClickEvent event) {
                                        Window.alert("Assurés particuliers!");
                                    }
                                });
                                menu.add(build3);
                                final AnchorListItem build4 = new AnchorListItem("Véhicules particuliers");
                                build4.addClickHandler(new ClickHandler() {
                                    @Override
                                    public void onClick(ClickEvent event) {
                                        Window.alert("Véhicules particuliers!");
                                    }
                                });
                                menu.add(build4);
                                final AnchorListItem build5 = new AnchorListItem("Conditions générales");
                                build5.addClickHandler(new ClickHandler() {
                                    @Override
                                    public void onClick(ClickEvent event) {
                                        Window.alert("Conditions générales!");
                                    }
                                });
                                menu.add(build5);
                                final AnchorListItem build6 = new AnchorListItem("Conditions particulières");
                                build6.addClickHandler(new ClickHandler() {
                                    @Override
                                    public void onClick(ClickEvent event) {
                                        Window.alert("Conditions particulières!");
                                    }
                                });
                                menu.add(build6);
                                group.add(menu);

                                return group;
                            }
                        };
                    }
                }).endMenu()
                        .newTopLevelCustomMenu(new MenuFactory.CustomMenuBuilder() {
                            @Override
                            public void push(MenuFactory.CustomMenuBuilder element) {
                            }

                            @Override
                            public MenuItem build() {
                                return new BaseMenuCustom<IsWidget>() {
                                    @Override
                                    public IsWidget build() {
                                        final ButtonGroup group = new ButtonGroup();
                                        final Button dropdown = new Button("Sinistres");
                                        dropdown.setSize(ButtonSize.SMALL);
                                        dropdown.setDataToggle(Toggle.DROPDOWN);
                                        group.add(dropdown);
                                        final DropDownMenu menu = new DropDownMenu();
                                        menu.setPull(Pull.RIGHT);
                                        final AnchorListItem build = new AnchorListItem("Constats ");
                                        build.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Accès rapide!");
                                            }
                                        });
                                        menu.add(build);
                                        final AnchorListItem build2 = new AnchorListItem("Sinistres");
                                        build2.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Dashboard!");
                                            }
                                        });
                                        menu.add(build2);
                                        final AnchorListItem build3 = new AnchorListItem("Recours");
                                        build3.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Scanner!");
                                            }
                                        });
                                        menu.add(build3);
                                        final AnchorListItem build4 = new AnchorListItem("Véhicules");
                                        build4.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Tâches!");
                                            }
                                        });
                                        menu.add(build4);
                                        final AnchorListItem build5 = new AnchorListItem("Accident Management");
                                        build5.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build5);

                                        group.add(menu);

                                        return group;
                                    }
                                };
                            }
                        }).endMenu()
                        .newTopLevelCustomMenu(new MenuFactory.CustomMenuBuilder() {
                            @Override
                            public void push(MenuFactory.CustomMenuBuilder element) {
                            }

                            @Override
                            public MenuItem build() {
                                return new BaseMenuCustom<IsWidget>() {
                                    @Override
                                    public IsWidget build() {
                                        final ButtonGroup group = new ButtonGroup();
                                        final Button dropdown = new Button("Flottes");
                                        dropdown.setSize(ButtonSize.SMALL);
                                        dropdown.setDataToggle(Toggle.DROPDOWN);
                                        group.add(dropdown);
                                        final DropDownMenu menu = new DropDownMenu();
                                        menu.setPull(Pull.RIGHT);
                                        final AnchorListItem build = new AnchorListItem("Entreprises ");
                                        build.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Accès rapide!");
                                            }
                                        });
                                        menu.add(build);
                                        final AnchorListItem build2 = new AnchorListItem("Commande location");
                                        build2.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Dashboard!");
                                            }
                                        });
                                        menu.add(build2);
                                        final AnchorListItem build3 = new AnchorListItem("Consommations carburant");
                                        build3.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Scanner!");
                                            }
                                        });
                                        menu.add(build3);

                                        group.add(menu);

                                        return group;
                                    }
                                };
                            }
                        }).endMenu()
                        .newTopLevelCustomMenu(new MenuFactory.CustomMenuBuilder() {
                            @Override
                            public void push(MenuFactory.CustomMenuBuilder element) {
                            }

                            @Override
                            public MenuItem build() {
                                return new BaseMenuCustom<IsWidget>() {
                                    @Override
                                    public IsWidget build() {
                                        final ButtonGroup group = new ButtonGroup();
                                        final Button dropdown = new Button("Règlement");
                                        dropdown.setSize(ButtonSize.SMALL);
                                        dropdown.setDataToggle(Toggle.DROPDOWN);
                                        group.add(dropdown);
                                        final DropDownMenu menu = new DropDownMenu();
                                        menu.setPull(Pull.RIGHT);
                                        final AnchorListItem build = new AnchorListItem("Honoraire ");
                                        build.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Accès rapide!");
                                            }
                                        });
                                        menu.add(build);
                                        final AnchorListItem build2 = new AnchorListItem("Factures de vente de véhicule");
                                        build2.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Dashboard!");
                                            }
                                        });
                                        menu.add(build2);
                                        final AnchorListItem build3 = new AnchorListItem("Bordereaux");
                                        build3.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Scanner!");
                                            }
                                        });
                                        menu.add(build3);
                                        final AnchorListItem build4 = new AnchorListItem("Factures");
                                        build4.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Tâches!");
                                            }
                                        });
                                        menu.add(build4);
                                        final AnchorListItem build5 = new AnchorListItem("Notes d'honoraires");
                                        build5.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build5);

                                        group.add(menu);

                                        return group;
                                    }
                                };
                            }
                        }).endMenu()

                        .newTopLevelCustomMenu(new MenuFactory.CustomMenuBuilder() {
                            @Override
                            public void push(MenuFactory.CustomMenuBuilder element) {
                            }

                            @Override
                            public MenuItem build() {
                                return new BaseMenuCustom<IsWidget>() {
                                    @Override
                                    public IsWidget build() {
                                        final ButtonGroup group = new ButtonGroup();
                                        final Button dropdown = new Button("Configuration");
                                        dropdown.setSize(ButtonSize.SMALL);
                                        dropdown.setDataToggle(Toggle.DROPDOWN);
                                        group.add(dropdown);
                                        final DropDownMenu menu = new DropDownMenu();
                                        menu.setPull(Pull.RIGHT);
                                        final AnchorListItem build = new AnchorListItem("Accueil ");
                                        build.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Accès rapide!");
                                            }
                                        });
                                        menu.add(build);
                                        final AnchorListItem build2 = new AnchorListItem("Clients");
                                        build2.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Dashboard!");
                                            }
                                        });
                                        menu.add(build2);
                                        final AnchorListItem build3 = new AnchorListItem("Utilisateurs");
                                        build3.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Scanner!");
                                            }
                                        });
                                        menu.add(build3);
                                        final AnchorListItem build4 = new AnchorListItem("Groupes");
                                        build4.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Tâches!");
                                            }
                                        });
                                        menu.add(build4);
                                        final AnchorListItem build5 = new AnchorListItem("Droits");
                                        build5.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build5);

                                        final AnchorListItem build6 = new AnchorListItem("Profils de droits");
                                        build6.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build6);
                                        final AnchorListItem build7 = new AnchorListItem("Droits/Rôles documents");
                                        build7.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build7);
                                        final AnchorListItem build8 = new AnchorListItem("Documents rejetés");
                                        build8.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build8);
                                        final AnchorListItem build9 = new AnchorListItem("Mise à jour données EDI");
                                        build9.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build9);
                                        final AnchorListItem build10 = new AnchorListItem("Testeur EDI");
                                        build10.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build10);

                                        group.add(menu);

                                        return group;
                                    }
                                };
                            }
                        }).endMenu()
                        .newTopLevelCustomMenu(new MenuFactory.CustomMenuBuilder() {
                            @Override
                            public void push(MenuFactory.CustomMenuBuilder element) {
                            }

                            @Override
                            public MenuItem build() {
                                return new BaseMenuCustom<IsWidget>() {
                                    @Override
                                    public IsWidget build() {
                                        final ButtonGroup group = new ButtonGroup();
                                        final Button dropdown = new Button("Autre");
                                        dropdown.setSize(ButtonSize.SMALL);
                                        dropdown.setDataToggle(Toggle.DROPDOWN);
                                        group.add(dropdown);
                                        final DropDownMenu menu = new DropDownMenu();
                                        menu.setPull(Pull.RIGHT);
                                        final AnchorListItem build = new AnchorListItem("Accès rapide ");
                                        build.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Accès rapide!");
                                            }
                                        });
                                        menu.add(build);
                                        final AnchorListItem build2 = new AnchorListItem("Dashboard");
                                        build2.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Dashboard!");
                                            }
                                        });
                                        menu.add(build2);
                                        final AnchorListItem build3 = new AnchorListItem("Scanner");
                                        build3.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Scanner!");
                                            }
                                        });
                                        menu.add(build3);
                                        final AnchorListItem build4 = new AnchorListItem("Tâches");
                                        build4.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Tâches!");
                                            }
                                        });
                                        menu.add(build4);
                                        final AnchorListItem build5 = new AnchorListItem("Agenda");
                                        build5.addClickHandler(new ClickHandler() {
                                            @Override
                                            public void onClick(ClickEvent event) {
                                                Window.alert("Agenda!");
                                            }
                                        });
                                        menu.add(build5);

                                        group.add(menu);

                                        return group;
                                    }
                                };
                            }
                        }).endMenu()
                        .build();


        menubar.addMenus(menus);
    }

    @Produces
    @ApplicationScoped
    public MainBrand createBrandLogo() {
        return new MainBrand() {
            @Override
            public Widget asWidget() {
                return new Image(AppResource.INSTANCE.images().ufBrandLogo());
            }
        };
    }

    //Fade out the "Loading application" pop-up
    private void hideLoadingPopup() {
        final Element e = RootPanel.get("loading").getElement();

        new Animation() {

            @Override
            protected void onUpdate(double progress) {
                e.getStyle().setOpacity(1.0 - progress);
            }

            @Override
            protected void onComplete() {
                e.getStyle().setVisibility(Style.Visibility.HIDDEN);
            }
        }.run(500);
    }
}