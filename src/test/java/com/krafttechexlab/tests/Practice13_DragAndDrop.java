package com.krafttechexlab.tests;

import com.krafttechexlab.pages.DraggablePage;
import com.krafttechexlab.utilities.Driver;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Practice13_DragAndDrop extends TestBase{

    @Test
    public void test1_DraggableElement() throws InterruptedException {
        DraggablePage draggablePage= new DraggablePage();
        draggablePage.navigateToModule("JavaScript","Draggable");

        Point location = draggablePage.draggableElement.getLocation();
        System.out.println("location = " + location);
        Thread.sleep(1000);

        Actions actions = new Actions(Driver.get());

        actions.dragAndDropBy(draggablePage.draggableElement,500,0).perform();
        location = draggablePage.draggableElement.getLocation();
        System.out.println("location = " + location);
        Thread.sleep(1000);

        actions.clickAndHold(draggablePage.draggableElement)
                .moveToElement(draggablePage.draggableElement,50,250).release().perform();
        location = draggablePage.draggableElement.getLocation();
        System.out.println("location = " + location);
        Thread.sleep(1000);

        actions.clickAndHold(draggablePage.draggableElement)
                .moveByOffset(-200,-200).pause(Duration.ofSeconds(1))
                .moveByOffset(400,250).pause(Duration.ofSeconds(1)).release().perform();
        location = draggablePage.draggableElement.getLocation();
        System.out.println("location = " + location);
        Thread.sleep(1000);

    }
}
