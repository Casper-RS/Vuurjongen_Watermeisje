module Vuurjongen.Watermeisje {
    requires hanyaeger;
    requires org.checkerframework.checker.qual;
    exports dev.eindopdracht;

    opens audio;
    opens backgrounds;
    opens sprites;

    exports dev.eindopdracht.scenes;
    exports dev.eindopdracht.entities.buttons;
    exports dev.eindopdracht.entities;
}