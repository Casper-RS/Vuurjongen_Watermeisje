module Vuurjongen.Watermeisje {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    requires java.desktop;
    exports dev.eindopdracht;

    opens audio;
    opens backgrounds;
    opens sprites;

    exports dev.eindopdracht.scenes;
    exports dev.eindopdracht.entities.buttons;
    exports dev.eindopdracht.entities;
    exports dev.eindopdracht.entities.map;

}