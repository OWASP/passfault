/*
 * ConstructionSign.fx
 *
 * Created on Jan 9, 2010, 2:52:45 PM
 */

package passfault.gui.view;

import javafx.scene.CustomNode;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.scene.paint.Color;
import javafx.animation.Interpolator;
import javafx.scene.input.MouseEvent;

/**
 * @author cam
 */

public def Brown  = Color.rgb(97,54,29);
public def Green  = Color.rgb(0,155,103);
public def Red    = Color.rgb(181,39,60);
public def Blue   = Color.rgb(0,62,134);
public def Yellow = Color.rgb(255,242,0);
public def Orange = Color.rgb(247,146,51);

public class ConstructionSign extends CustomNode {
  public var color  = Green;
  public-init var width= 450;
  public-init var height= 250;
  public-init var x=0;
  public-init var y=0;
  public-init var strokeWidth=4;
  public var stroke: Color;
  var varWidth = 0;
  var varHeight = 0;
  var translatex = 0;
  var translatey = 0;
  public-init var onclick: function () ;
  
  var isAnimationDone = true;
  var time = Timeline {
    autoReverse: true,
    repeatCount: 1,
    rate: -1,
    keyFrames: [
      KeyFrame{
        time: 0s
        values: [
          translatex => width/2,
          translatey => height/2,
          varHeight => 0,
          varWidth => 0,
        ]
      },
      KeyFrame{
        time: 1s
        values: [
          translatex => 0 tween Interpolator.EASEOUT,
          translatey => 0 tween Interpolator.EASEOUT,
          varHeight => height tween Interpolator.EASEOUT,
          varWidth => width tween Interpolator.EASEOUT,
        ]
      }
    ];
  }

  public function toggleVisibility(){
    java.lang.System.out.println("Rate {time.rate}");
    time.rate = -time.rate;
    time.play();
  }

  public override function create(): Node {
    return Group {
      onMouseClicked: function (e: MouseEvent): Void {
        onclick();
      }
      content: [
        Rectangle {
          x : x,
          y : y,
          width: bind varWidth,
          height: bind varHeight,
          translateX: bind translatex
          translateY: bind translatey
          arcHeight:20,
          arcWidth:20,
          fill: color
        },
        Rectangle {
          x: x,
          y: y
          width: bind varWidth - 10
          height: bind varHeight - 10
          translateX: bind translatex + 5
          translateY: bind translatey + 5
          arcHeight:20,
          arcWidth:20,
          strokeWidth: strokeWidth
          stroke: stroke
          fill: Color.TRANSPARENT
        }
      ]
    };
  }
}
