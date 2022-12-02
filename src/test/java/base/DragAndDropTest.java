package base;

import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTests{


    @Test(priority = 3)
    public void DragFrom_boxA_to_boxB_test() {
      DragAndDropPage dragAndDropPage = homePage.ClickOnDragAndDrop("Drag and Drop");
      dragAndDropPage.DragFrom_boxA_to_boxB();
    }
}
