/*
 * Main.fx
 *
 * Created on Sep 7, 2009, 3:49:22 PM
 */

package fonts;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import javafx.scene.control.Button;

import javafx.scene.layout.VBox;

/**
 * @author Rakesh Menon
 */

function registerFont(fontURL : String) : Void {

    // Register Font
    var registerFontTask : RegisterFontTask = RegisterFontTask {
        url: fontURL
        onDone: function() {
            if(registerFontTask.succeeded) {
                text.font = Font { name: "RaghuMalayalam" size: 40 };
            }
        }
    };
    registerFontTask.start();
}

var text : Text = Text {
    translateX: bind (300 - text.layoutBounds.width) / 2.0
    font: Font { name: "RaghuMalayalam" size: 40 }
    content: "\u0d2e\u0d32\u0d2f\u0d3e\u0d33\u0d02"
}

var button : Button = Button {
    translateX: bind (300 - button.layoutBounds.width) / 2.0
    text: "Register Font"
    action: function() {
        registerFont("http://www.cdacmumbai.in/projects/indix/RaghuFonts/RRRaghuMalayalam.ttf");
    }
}

var vBox = VBox {
    layoutY: 50
    spacing: 20
    content: [ text, button ]
}

Stage {
    title: "Malayalam Font"
    resizable: false
    scene: Scene {
        width: 300
        height: 150
        content: vBox
    }
}
