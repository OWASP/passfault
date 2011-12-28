/*
 * PasswordBoxTest.fx
 *
 * Created on Jun 22, 2010, 7:31:17 AM
 */

package passfault.gui.view;

import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * @author cam
 */

def passwordBox = PasswordBox{}
def passwordNode = passwordBox.create();

Stage {
    title: "Application title"
    scene: Scene {
        width: 250
        height: 80
        content: [
            passwordNode
        ]
    }
}