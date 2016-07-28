package designpatterns.tests;

import org.testng.annotations.Test;

import designpatterns.composite.*;



public class CompositeTest {
    @Test
    public void verifyCompositeTest() {
        Composite fileMainMenu = new Menu("File", 0);
        Composite newSubMenu = new Menu("New...", 1);
        Composite saveAsSubmenu = new Menu("Save As...", 1);
        Component openItem = new MenuItem("Open");
        Component closeItem = new MenuItem("Close");
        Composite txtSubMenu = new Menu("Txt", 2);
        Component pdfItem = new MenuItem("Pdf");
        Component docItem = new MenuItem("Doc");
        Component csvItem = new MenuItem("Csv");
        Component utf8Item = new MenuItem("UTF-8");
        Component utf16Item = new MenuItem("UTF-16");

        fileMainMenu.add(newSubMenu);
        fileMainMenu.add(openItem);
        fileMainMenu.add(saveAsSubmenu);
        fileMainMenu.add(closeItem);

        newSubMenu.add(txtSubMenu);
        newSubMenu.add(pdfItem);

        saveAsSubmenu.add(docItem);
        saveAsSubmenu.add(csvItem);

        txtSubMenu.add(utf8Item);
        txtSubMenu.add(utf16Item);

        fileMainMenu.display();
    }
}
