/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFXLibraryCache;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.VerticalDirection;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import org.robotframework.javalib.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testfx.api.FxRobot;
import org.testfx.robot.Motion;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author pcosta
 */
@RobotKeywords
public class Mouse {

    @Autowired
    private Logging logging;
    @Autowired
    private Misc misc;

    private static final Logger LOG = LoggerFactory.getLogger(Logging.class);

    /**
     *
     *<b>Description:</b>This keyword clicks on an identifier<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The identifier of the node</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @throws TimeoutException
     *      If something goes wrong
     *
     */
    @RobotKeywordOverload
    public void clickOnComponent(String identifier) throws TimeoutException {
        clickOnComponent(identifier, null);
    }

    /**
     *<b>Description:</b>This keyword clicks on an identifier using the node key as second parameter
     * when provided<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The identifier of the nod</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>nodeKey</td>
     *         <td>No</td>
     *         <td>The node clicked on</td>
     *         <td>string</td>
     *         <td>null</td>
     *     </tr>
     * </table>
     *
     * @throws TimeoutException
     *      If something goes wrong
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "nodeKey=null"})
    public void clickOnComponent(String identifier, String nodeKey) throws TimeoutException {
        if(nodeKey != null){
            Node node = (Node) TestFXLibraryCache.getIstance().get(nodeKey);
            Node n = new FxRobot().from(node).lookup(identifier).query();
            new FxRobot().clickOn(n);
        } else {
            new FxRobot().clickOn(identifier);
        }
    }

    /**
     *<b>Description:</b>This keyword double clicks on a node using the identifier as parameter<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The identifier of the node</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void doubleClickOnComponent(String identifier) {
        new FxRobot().doubleClickOn(identifier);
    }

    /**
     *<b>Description:</b>This keyword drags a node using the identifier as argument<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The identifier of the node</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void drag(String identifier) {
        new FxRobot().drag(identifier);
    }

    /**
     *<b>Description:</b>This keyword drops a node that is being dragged<br><br>
     *
     */
    @RobotKeyword
    public void drop() {
        new FxRobot().drop();
    }

    /**
     *<b>Description:</b>This keyword drops a node that is being dragged to a node identified as argument<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The identifier of the node</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void dropTo(String identifier) {
        new FxRobot().dropTo(identifier);
    }

    /**
     * Move the mouse to a x,y coordinate
     *
     * @param xCoordinate
     *            The x coordinate
     * @param yCoordinate
     *            The y coordinate
     *
     *<b>Description:</b>This keyword moves the mouse to an x, y location identified as the two parameters.<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>xCoordinate</td>
     *         <td>No</td>
     *         <td>The identifier of the node</td>
     *         <td>double</td>
     *         <td>0</td>
     *     </tr>
     *     <tr>
     *         <td>yCoordinate</td>
     *         <td>Yes</td>
     *         <td>The identifier of the node</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"xCoordinate", "yCoordinate"})
    public void moveBy(double xCoordinate, double yCoordinate) {
        new FxRobot().moveBy(xCoordinate, yCoordinate, Motion.DIRECT);
    }

    /**
     *<b>Description:</b>This keyword moves the mouse to a node identified by the argument<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The identifier of the node</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void moveTo(String identifier) {
        new FxRobot().moveTo(identifier, Motion.DIRECT);
    }

    /**
     *<b>Description:</b>This keyword right clicks on a node identified as the argument<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The identifier of the node</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void rightClickOnComponent(String identifier) {
        new FxRobot().rightClickOn(identifier, Motion.DIRECT);
    }

    /**
     *<b>Description:</b>This keyword scrolls left by the amount passed as argument<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>amount</td>
     *         <td>No</td>
     *         <td>The amount to be scrolled</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollLeft(int amount) {
        new FxRobot().scroll(amount, HorizontalDirection.LEFT);
    }

    /**
     *<b>Description:</b>This keyword scrolls right by the amount passed as argument<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>amount</td>
     *         <td>No</td>
     *         <td>The amount to be scrolled</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollRight(int amount) {
        new FxRobot().scroll(amount, HorizontalDirection.RIGHT);
    }

    /**
     *<b>Description:</b>This keyword scrolls up by the amount passed as argument<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>amount</td>
     *         <td>No</td>
     *         <td>The amount to be scrolled</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollUp(int amount) {
        new FxRobot().scroll(amount, VerticalDirection.UP);
    }

    /**
     *<b>Description:</b>This keyword scrolls down by the amount passed as argument<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>amount</td>
     *         <td>No</td>
     *         <td>The amount to be scrolled</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollDown(int amount) {
        new FxRobot().scroll(amount, VerticalDirection.DOWN);
    }
    /**
     * Get Node list
     *
     * @param identifier
     *          The node identifier that has the list to be returned
     * @return
     *          The nodes
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Set<Node> getNodeList(String identifier) {
        return new FxRobot().lookup(identifier).queryAll();
    }

    /**
     *
     * @param identifier
     *          The identifier of the CheckBox
     * @param booleanValue
     *          Boolean value to set the CheckBox selection
     */

    @RobotKeyword
    @ArgumentNames({"identifier" , "booleanValue"})
    public void setCheckBoxState(String identifier, Boolean booleanValue) {

        TestFxLibraryValidation.validateArguments(identifier, booleanValue);

        try{
            CheckBox check = new FxRobot().lookup(identifier).query();
            check.setSelected(booleanValue);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     *
     * @param identifier
     *          The identifier of the CheckBox
     * @return
     *          Boolean value if the checkbox is selected (true) or not (false).
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Boolean getCheckBoxState(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        try{
            CheckBox check = new FxRobot().lookup(identifier).query();
            return check.isSelected();
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     * Test if component is Enabled
     *
     * @param identifier
     *          The identifier of the Component
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void checkBoxShouldBeEnabled(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        try{
            if(getCheckBoxState(identifier).equals(true)){
                LOG.info("CheckBox is enabled!");
            } else {
                throw new TestFxLibraryNonFatalException("Component is disabled");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     * Test if component is disabled
     *
     * @param identifier
     *          The identifier of the Component
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void checkBoxShouldBeDisabled(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        try{
            if(getCheckBoxState(identifier).equals(false)){
                LOG.info("CheckBox is disabled!");
            } else {
                throw new TestFxLibraryNonFatalException("Component is enabled");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     * Select function from a popup menu of an element
     *
     * @param identifier
     *          The identifier of the CheckBox
     * @param functionText
     *          The name of the funciton that you want to select
     */

    @RobotKeyword
    @ArgumentNames({"identifier", "functionText"})
    public void selectFromPopupMenu(String identifier, String functionText) {

        TestFxLibraryValidation.validateArguments(identifier, functionText);

        try{
            misc.waitUntilPageContains(identifier);
            rightClickOnComponent(identifier);
            clickOnComponent(functionText);
        } catch (IllegalArgumentException | NullPointerException | TimeoutException e) {
            throw new TestFxLibraryFatalException(e);
        }

    }
}
