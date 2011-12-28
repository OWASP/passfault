/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package passfault.gui.view;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.ext.swing.SwingSlider;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.ext.swing.SwingComboBox;
import javafx.ext.swing.SwingComboBoxItem;
import com.passfault.TimeToCrack;
import javafx.util.Math;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.CustomNode;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * @author cam
 */

public class Settings extends CustomNode {
public-init var fontColor = Color.WHITE;
public-init var signColor = ConstructionSign.Brown;
public var onReturn: function (): Void;
def sign = ConstructionSign {
        height: 270,
        width: 300,
        color: signColor;
        stroke: fontColor;
      };
var slider = SwingSlider {
    minimum: 1
    maximum: 1000000
    value: 10000
    vertical: false
    width: 200
  };
var combo = SwingComboBox {
  items: [
    for(item in TimeToCrack.values()){
      SwingComboBoxItem {
        text: item.getDisplayName()
        value: item
      }
    }
	]
  selectedIndex: 2;
}

public-read var timeToCrack = bind getCracker(combo.selectedItem);
public function getPasswordPolicy():Double {
  return scale(slider.value);
}

function getCracker(item:SwingComboBoxItem): TimeToCrack{
  var toReturn:TimeToCrack = (item.value as TimeToCrack);
  return toReturn;
}

function generateTimeToCrack(sliderVar:Double, cracker:TimeToCrack): String{
  return "{timeToCrack.getTimeToCrackString(scale(sliderVar))}";
}

function generateStrength(sliderVar:Double, cracker:TimeToCrack): String{
  return "{timeToCrack.getRoundedSizeString(scale(sliderVar))}";
}

function scale(size:Double):Double{
  return Math.pow(size, 2);
}

public override function create(): Node {
  sign.toggleVisibility();
    return Group {
      onKeyTyped: function(event:KeyEvent):Void{
        onReturn();
      }

      content: [
          sign,
          Text {
              layoutX: 275
              layoutY: 12
                font : Font {size : 30 embolden: true}
                content: "x"
                smooth: true
                fill: fontColor
                stroke: signColor
                onMouseClicked: function (event:MouseEvent): Void{
                  onReturn();
                }
              },
          VBox{
            nodeHPos: HPos.CENTER
            layoutY:15
            layoutX:15
            spacing: 8
            content: [
              Text {
                font : Font {size : 25 name: "Roadgeek2005 SeriesC"}
                content: "  Required Password Strength:  "
                smooth: true
                fill: fontColor
              },
              Text {
                font : Font {size : 25 name: "Roadgeek2005 SeriesEM"}
                content: bind generateStrength(slider.value, timeToCrack)
                smooth: true
                fill: fontColor
              },
              slider,
              Text {
                font : Font {size : 18 name: "Roadgeek2005 SeriesC"}
                content: "A password of this strength"
                smooth: true
                fill: fontColor
              },
              Text {
                font : Font {size : 18 name: "Roadgeek2005 SeriesC"}
                content: "could be cracked in:"
                smooth: true
                fill: fontColor
              },
              Text {
                font : Font {size : 22 name: "Roadgeek2005 SeriesEM"}
                content: bind generateTimeToCrack(slider.value, timeToCrack)
                smooth: true
                fill: fontColor
              },
              Text {
                font : Font {size : 18 name: "Roadgeek2005 SeriesC"}
                content: "By this type of equipment:"
                smooth: true
                fill: fontColor
              },
              combo,
            ]
          },
        ]
    }
  }
}