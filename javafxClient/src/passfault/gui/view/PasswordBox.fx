/*
 * PasswordBox.fx
 *
 * Created on Jun 12, 2010, 7:25:43 AM
 */
package passfault.gui.view;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import java.lang.StringBuilder;
import java.lang.Character;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.CustomNode;
import javafx.geometry.VPos;
import javafx.scene.shape.Rectangle;
import javafx.geometry.HPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.LayoutInfo;

/**
 * @author cam
 */
public class PasswordBox extends CustomNode {
  def passwordBuilder = StringBuilder { };
  def passStarsBuilder = StringBuilder { };
  public-init var fontColor = Color.WHITE;
  public-init var signColor = ConstructionSign.Blue;
  public var onReturn: function (): Void;

  function buildCharView(ch: String): Node {
    var oneToZero = 1.0;
    def time = Timeline {
        autoReverse: false,
        keyFrames: [
          KeyFrame {
            time: 0s
            values: [oneToZero => 1.0]
          },
          KeyFrame {
            time: 1s
            values: [oneToZero => 0.0 tween Interpolator.EASEIN]
          }
        ]
      }
    def group = Group {
      onMouseEntered: function (e: MouseEvent): Void {
        oneToZero = 1.0
      }
      onMouseExited: function (e: MouseEvent): Void {
        time.playFromStart();
      }
      content: [
          Text {
            font: Font { size: 22, name: "Roadgeek2005 SeriesC" }
            content: ch
            opacity: bind oneToZero
            fill: fontColor
          },
          Text {
            font: Font { size: 22, name: "Roadgeek2005 SeriesC" }
            content: "*"
            opacity: bind 1 - oneToZero
            fill: fontColor
          }
        ]
      }
    time.play();
    return group;
  }

  public function getPassword(): String {
    return passwordBuilder.toString();
  }

  public override function create(): Node {
   def sign = ConstructionSign {
        height: 50,
        width: 250,
        x: 0
        y: 0
        color: signColor;
        stroke: fontColor;
      };
    var passSet: Node[] = [];
    sign.toggleVisibility();
    var isInitialState = true;
    def toReturn = Group {
      content: [
        sign.create(),
        Text {
            layoutX: 15
            layoutY: 33
            font: Font { size: 24, name: "Roadgeek2005 SeriesD" }
            content: "Enter Password Here"
            visible: bind isInitialState
            fill: fontColor
          },
        HBox {
          layoutX: 10
          layoutY: 15
          width: 250
          spacing: 0
          nodeHPos: HPos.CENTER
          nodeVPos: VPos.BOTTOM
          content: bind passSet
          focusTraversable: true
          
          onKeyTyped: function (e: KeyEvent): Void {

            //why would a char be a string?
            def ch = e.char.charAt(0);
            if (not Character.isISOControl(ch)) {
              if (isInitialState){
                isInitialState = false;
              }
              passwordBuilder.append(ch);
              passStarsBuilder.append('*');
              insert buildCharView(e.char) into passSet
            } else if (isBackSpace(ch) and passwordBuilder.length() > 0) {
              if (passwordBuilder.length()==1){
                isInitialState = true;
              } 
              delete passSet[sizeof passSet - 1];
              passwordBuilder.deleteCharAt(passwordBuilder.length() - 1);
              passStarsBuilder.deleteCharAt(passStarsBuilder.length() - 1);
            } else if (isEnter(ch)) {
              onReturn();
            }
          }
        },
        passSet
      ]
    }
    insert Text {
            font: Font { size: 12, name: "Roadgeek2005 SeriesC" }
            content: "*"
            opacity: 0
            fill: fontColor
          }
          into passSet;

    return toReturn;
  }
  
}
public function isBackSpace(ch: Character): Boolean {
   return ch.equals("\b");
  }
public function isEnter(ch: Character): Boolean {
  return ch.equals("\n");
}

