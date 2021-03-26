# pf2ecs (Pathfinder 2e Character Sheet)

## File Structure

The project has the following directory structure
```
.
|-- doc
`-- src
    `-- main
        |-- java
        |   `-- pf2ecs
        |       |-- controller
        |       |-- model
        |       `-- view
        `-- resources
            `-- pf2ecs
                |-- controller
                |-- model
                |   |-- ancestries
                |   |   `-- heritages
                |   |-- backgrounds
                |   |-- classes
                |   |   `-- subclasses
                |   |-- feats
                |   |-- feat_books
                |   |-- items
                |   |-- skills
                |   |-- spells
                |   `-- spellTraditions
                `-- view
```
./doc : contains all of the documentation for pf2cs in .html files created with javadocs \
./src : contains all of the source code and other resources for pf2ecs \
./src/main/java : contains all of the .java files in pf2ecs and nothing else \
./src/main/java/pf2ecs : only contains Main.java and Launcher.java \
./src/main/java/pf2ecs/[controller,model,view] : contains the releveant code dictated by a Model-View-Controller program structure \
./src/main/resources : contains all other (non .java) files used in pf2ecs such as .fxml and .json files \
./src/main/resources/pf2ecs/controller : idk yet tbh \
./src/main/resources/pf2ecs/model : contains all the data files used by the program's model such as .json files storing pathfinder data \
./src/main/resources/pf2ecs/view : contains all the data files used in creating the view such as .fxml files and images \
