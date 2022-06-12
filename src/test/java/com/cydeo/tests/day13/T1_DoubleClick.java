package com.cydeo.tests.day13;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class T1_DoubleClick {
    @Test
    public void doubleClick(){
//        1. Go to
//        https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("//www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");
//
//        2. Switch to iframe.
//        3. Double click on the text “Double-click me to change my text color.”
//        4. Assert:
//        Text’s “style” attribute value contains “red”.
    }
}
