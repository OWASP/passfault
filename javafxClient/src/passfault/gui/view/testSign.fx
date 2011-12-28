/*
 * testSign.fx
 *
 * Created on Jan 9, 2010, 3:24:15 PM
 */

package passfault.gui.view;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.Button;

/**
 * @author cam
 */

def sign = ConstructionSign{
  height: 300,
  width: 100
  x: 100
  y: 100
  color: ConstructionSign.Blue;
};

Stage {
  title: "Application title"
  width: 500
  height: 500
  scene: Scene {
    content: [
      Text {
        font : Font {
          name: "Roadgeek2005 SeriesEM"
          size : 30
        }
        smooth: true
        x: 10
        y: 60
        content: "Application content-road"
      },
      Button {
        text: "Button"
        action: function() {
          sign.toggleVisibility();
        }
      },
      sign.create(),
    ]
  }
}
