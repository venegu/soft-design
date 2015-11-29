# BMI tracker based on JavaFX
Read Chapter 25 at first to know about the Java movement to realize GUI libraries (AWT → Swing → JavaFX). The most recent JavaFX enables you to design with [Model-View-Controller (MVC)](https://en.wikipedia.org/wiki/Model–view–controller) through the use of FXML and Java. The "Model" consists of application-specific domain objects, the "View" consists of FXML, and the "Controller" is Java code that defines the GUI's behavior for interacting with the user.

JavaFX is the one to use in this assignment. Refer to the Oracle's Scene Builder [installation](http://docs.oracle.com/javafx/scenebuilder/1/use_java_ides/sb-with-eclipse.htm). The mission of your work is to realize a Persisitent BMI Tracking Viewer having the set of capabilities defined below:

   - The viewer allows to compute BMI based on two real-time sliders to input height (in inches) and weight (in pounds) values
   - The viewer allows to associate date of measure to the computed value.
   - The viewer allows to retrieve 5 (or more if you want) past data by choosing the name of file by opening it ([FileChooser](http://examples.javacodegeeks.com/desktop-java/javafx/javafx-filechooser-example/)).
   - The viewer allows to plot such historical data in a line chart.
   - The viewer allows to append new data to the history.
   - The viewer allows to remove the last data in the history (therefore clear out the history by removing all the data iteratively).
   - The viewer allows to save the history into a file.

The layout can be chosen freely. My prototype interface is shown below (revised with a more complete version whenever realized by myself).

<img src="/images/prototype.png" width="426">

Note that your learning curve of JavaFX Scene Builder is high (because its operation is similar to Android Studio) but the implementation of this whole scheme needs at least one week of your continuous work. Start early.