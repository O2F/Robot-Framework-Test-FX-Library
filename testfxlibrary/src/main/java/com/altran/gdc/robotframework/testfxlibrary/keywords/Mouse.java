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
     * <b>Description:</b>This keyword clicks on a component specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the component
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br>
     * @throws TimeoutException
     * : If something goes wrong
     */
    @RobotKeywordOverload
    public void clickOnComponent(String identifier) throws TimeoutException {
        clickOnComponent(identifier, null);
    }

    /**
     * <b>Description:</b>This keyword clicks on a component specified <i>nodeKey</i>.
     * If <i>nodeKey</i> is not provided, <i>identifier</i> is used instead.<br>
     *
     * @throws TimeoutException
     *  If something goes wrong
     *
     * @param identifier
     * : The identifier of the component
     * @param nodeKey
     * : The key of the component.
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>nodeKey</td>
     *         <td>No</td>
     *         <td>string</td>
     *         <td>null</td>
     *     </tr>
     * </table>
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
     * <b>Description:</b> This keyword double clicks on a component specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the component
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void doubleClickOnComponent(String identifier) {
        new FxRobot().doubleClickOn(identifier);
    }

    /**
     * <b>Description:</b> This keyword drags a component specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the component
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void drag(String identifier) {
        new FxRobot().drag(identifier);
    }

    /**
     *<b>Description:</b> This keyword drops a component that is being dragged<br>
     *
     */
    @RobotKeyword
    public void drop() {
        new FxRobot().drop();
    }

    /**
     * <b>Description:</b> This keyword drops a component that is being dragged
     * into a component specified with <i>identifier</i><br>
     *
     * @param identifier
     * : The identifier of the component
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void dropTo(String identifier) {
        new FxRobot().dropTo(identifier);
    }

    /**
     * <b>Description:</b> This keyword moves the mouse to an x, y location specified with
     * <i>xCoordinate</i> and <i>yCoordinate</i>.<br>
     *
     * @param xCoordinate
     * : The x coordinate
     * @param yCoordinate
     * : The y coordinate
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>xCoordinate</td>
     *         <td>No</td>
     *         <td>double</td>
     *         <td>0</td>
     *     </tr>
     *     <tr>
     *         <td>yCoordinate</td>
     *         <td>Yes</td>
     *         <td>double</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"xCoordinate", "yCoordinate"})
    public void moveBy(double xCoordinate, double yCoordinate) {
        new FxRobot().moveBy(xCoordinate, yCoordinate, Motion.DIRECT);
    }

    /**
     * <b>Description:</b> This keyword moves the mouse to a component specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the component
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void moveTo(String identifier) {
        new FxRobot().moveTo(identifier, Motion.DIRECT);
    }

    /**
     * <b>Description:</b> This keyword right clicks on a component specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the node
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void rightClickOnComponent(String identifier) {
        new FxRobot().rightClickOn(identifier, Motion.DIRECT);
    }

    /**
     * <b>Description:</b> This keyword scrolls left by the amount specified with <i>amount</i>.<br>
     *
     * @param amount
     * : The amount to be scrolled
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>amount</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollLeft(int amount) {
        new FxRobot().scroll(amount, HorizontalDirection.LEFT);
    }

    /**
     * <b>Description:</b> This keyword scrolls right by the amount specified with <i>amount</i>.<br>
     *
     * @param amount
     * : The amount to be scrolled
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>amount</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollRight(int amount) {
        new FxRobot().scroll(amount, HorizontalDirection.RIGHT);
    }

    /**
     * <b>Description:</b> This keyword scrolls up by the amount specified with <i>amount</i>.<br>
     *
     * @param amount
     * : The amount to be scrolled
     * <br><br>
     * <table summary ="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>amount</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollUp(int amount) {
        new FxRobot().scroll(amount, VerticalDirection.UP);
    }

    /**
     * <b>Description:</b>This keyword scrolls down by the amount specified with <i>amount</i>.<br>
     *
     * @param amount
     * : The amount to be scrolled
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>amount</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollDown(int amount) {
        new FxRobot().scroll(amount, VerticalDirection.DOWN);
    }

    /**
     * <b>Description:</b> This keyword gets the component list within the component specified
     * with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The component from where you want to get list of components
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * @return
     *  Attribute value in a string
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Set<Node> getNodeList(String identifier) {
        return new FxRobot().lookup(identifier).queryAll();
    }

    /**
     * <b>Description:</b> This keyword sets the state of a checkbox specified with <i>identifier</i>.
     * <i>booleanValue</i> is a boolean which defines the state<br>
     *
     * @param identifier
     * : The identifier of the checkbox
     * @param booleanValue
     * : Boolean value to set the checkbox selection
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>booleanValue</td>
     *         <td>Yes</td>
     *         <td>boolean</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
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
     * <b>Description:</b> This keyword returns the boolean value state of a given
     * checkbox identified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the checkbox
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     * : Boolean value if the checkbox is selected (true) or not (false).
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
     * <b>Description:</b> This keyword tests if a given checkbox specified with <i>identifier</i> is enabled.<br>
     *
     * @param identifier
     * : The identifier of the checkbox
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
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
     * <b>Description:</b> This keyword tests if a given checkbox specified
     * with <i>identifier</i> is disabled<br>
     *
     * @param identifier
     * : The identifier of the checkbox
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
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
     * <b>Description:</b> This keyword tests if a checkbox specified with <i>identifier</i> is selected.
     * If this checkbox is not selected a TestFxLibraryFatalException is thrown.<br>
     *
     * @param identifier
     * : The identifier of the checkbox
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void checkBoxShouldBeSelected(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        CheckBox checkBox = new FxRobot().lookup(identifier).query();

        try{
            if(!checkBox.isSelected()){
                LOG.info("CheckBox is unselected!");
                throw new TestFxLibraryNonFatalException("CheckBox is unselected!");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }


    }

    /**
     * <b>Description:</b> This keyword tests if a checkbox specified with <i>identifier</i> is not selected.
     * If this checkbox is selected a TestFxLibraryFatalException is thrown.<br>
     *
     * @param identifier
     * : The identifier of the checkbox
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void checkBoxShouldNotBeSelected(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        CheckBox checkBox = new FxRobot().lookup(identifier).query();

        try{
            if(checkBox.isSelected()){
                LOG.info("CheckBox is selected!");
                throw new TestFxLibraryNonFatalException("CheckBox is selected!");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     * <b>Description:</b> This keyword selects a function from a popup menu of an component.
     * The component is specified with <i>identifier</i> and the function is specified with
     * <i>functionText</i>. An Exception is thrown if an error occurs.<br>
     *
     * @param identifier
     * : The identifier of the component
     * @param functionText
     * : The name of the function that you want to select
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>functionText</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
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
