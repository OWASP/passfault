/*
 * patterns.fx
 *
 * Created on Feb 4, 2010, 9:07:53 PM
 */

package passfault.gui.view;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.layout.LayoutInfo;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.paint.Color;
import javafx.animation.Interpolator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;

/**
 * @author cam
 */

var oneToZero: Double;
def time = Timeline{
  autoReverse: true,
  repeatCount: Timeline.INDEFINITE,
  keyFrames: [
    KeyFrame{
        time: 0s
        values: [
          oneToZero => 1,
        ]
      },
      KeyFrame{
        time: 1s
        values: [
          oneToZero => 0 tween Interpolator.EASEBOTH
        ]
      }
  ]
}

def factory = PatternFactory{};
factory.start();

Stage {
    title: "Application title"
    width: 900
    height: 300
    
    scene: Scene {
        fill: Color.GRAY
        content: [
          VBox {
          vpos: VPos.CENTER
          hpos: HPos.CENTER
          nodeVPos: VPos.CENTER
          nodeHPos: HPos.CENTER
        content: [
          HBox {
            width: 700
            vpos: VPos.CENTER
            hpos: HPos.CENTER
            spacing:6
            content: [
              factory.buildWordMatch("Dictionary"),
              factory.buildWordInsert("Dictionary"),
              factory.buildWordSubstitute("Dictionary"),
              factory.buildWordMispell("Dictionary"),
              factory.buildWordBackwards("Dictionary"),
              factory.buildKeyHorizontal(""),
              factory.buildKeyDiagonal(""),
              factory.buildKeyRepeat(""),
              factory.buildDuplicate(),
              factory.buildRandom("")
            ]
          }
          ]
          }
        ]
    }
}
time.play();