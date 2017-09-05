package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.scene.control.ListView;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

import java.util.ArrayList;

@RobotKeywords
public class List {

    @Autowired
    Misc misc;

    /**
     * <b>Description:</b> This keyword returns a list with the values in a listview specified with
     * <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the listview
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
     *  The list of values
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{list}=</td>
     *         <td>Get List Items From List View</td>
     *         <td>idListView01</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public java.util.List<String> getListItemsFromListView(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        java.util.List<String> list = new ArrayList<>();
        listView.getItems().forEach(item ->
            list.add((String) item)
        );

        return list;
    }

    /**
     * <b>Description:</b> This keyword selects an item in a listview by text. The listview is specified with
     * <i>identifier</i> and <i>text</i> is the text that specifies the item to be selected.<br>
     *
     * @param identifier
     * : The id of the listview
     * @param text
     * : The text to get the selected item
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
     *         <td>text</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select From List View By Text</td>
     *         <td>idListView01</td>
     *         <td>hello world</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectFromListViewByText(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier, text);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(listView);

        listView.getItems().forEach(item -> {
            if(((String)item).equals(text)){
                listView.getSelectionModel().select(item);
            }
        });
    }

    /**
     * <b>Description:</b> This keyword selects an item in a listview by position. The listview is
     * specified with <i>identifier</i>. The position that defines the item to be selected is
     * specified with <i>position</i>, which can take values from 0 to item count minus 1; a value
     * of -1 clears the selection.<br>
     *
     * @param identifier
     * : The id of the listview
     * @param position
     * : The position to get the selected item
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
     *         <td>posiotion</td>
     *         <td>Yes</td>
     *         <td>int (values from 0 to item count - 1)</td>
     *         <td>-1</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select From List View By Position</td>
     *         <td>idListView01</td>
     *         <td>1</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "position"})
    public void selectFromListViewByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateIndex(position);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(listView);

        listView.getSelectionModel().select(position);

    }

    /**
     * <b>Description:</b> This keyword returns a list of items which are currently selected on a
     * list. This list is specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the list
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
     *  The items selected
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{list}=</td>
     *         <td>Get Selected Items From List</td>
     *         <td>idList23</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public java.util.List<String> getSelectedItemsFromList(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();
        return listView.getSelectionModel().getSelectedItems();
    }

    /**
     * <b>Description:</b> This keyword returns the number of selected items on a list.
     * This list is specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the list
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
     *  The number of items selected
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${integer}=</td>
     *         <td>Get List Item Count From List</td>
     *         <td>idList76</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public int getListItemCountFromList(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();
        return listView.getSelectionModel().getSelectedItems().size();
    }

    /**
     * <b>Description:</b> This keyword clears all items selected on a listview.
     * <i>identifier</i> specifies the listview to be cleared.<br>
     *
     * @param identifier
     * : The id of the listview
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
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Clear Selection From List</td>
     *         <td>idListView2J</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void clearSelectionFromList(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        listView.getSelectionModel().clearSelection();
    }

    /**
     * <b>Description:</b> This keyword selects all items on a listview. <i>identifier</i>
     * specifies the listview.<br>
     *
     * @param identifier
     * : The id of the listview
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
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select All From List</td>
     *         <td>idListView56</td>
     *         <td>hello world</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void selectAllFromList(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        listView.getSelectionModel().selectAll();
    }

    /**
     * <b>Description:</b> This keyword clears selection on a listview by position.
     * <i>identifier</i> specifies listview and <i>position</i> specifies position.<br>
     *
     * @param identifier
     * : The id of the listview
     * @param position
     * : position on listview
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
     *         <td>position</td>
     *         <td>Yes</td>
     *         <td>integer</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Unselect From List By Position</td>
     *         <td>idListView8B</td>
     *         <td>12</td>
     *     </tr>
     * </table>
     *
     *          the position of the component
     */
    @RobotKeyword
    @ArgumentNames({"identifier","position"})
    public void unselectFromListByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        listView.getSelectionModel().clearSelection(position);
    }

    /**
     * <b>Description:</b> This keyword clears selection on a listview by text.
     * <i>identifier</i> specifies listview and <i>text</i> specifies text to
     * identify item.<br>
     *
     * @param identifier
     * : The id of the listview
     * @param text
     * : The text to identify selection to clear
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
     *         <td>text</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Unselect From List By Text</td>
     *         <td>idListView8B</td>
     *         <td>Hello world</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier","text"})
    public void unselectFromListByText(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        for(int i=0 ; i< listView.getItems().size(); i++){
            if(((String)listView.getItems().get(i)).equals(text)){
                listView.getSelectionModel().clearSelection(i);
            }
        }
    }

}