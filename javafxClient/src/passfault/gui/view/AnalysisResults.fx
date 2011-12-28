/*
 * AnalysisResults.fx
 *
 * Created on Sep 24, 2009, 5:16:26 PM
 */

package passfault.gui.view;

import javafx.scene.CustomNode;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import com.passfault.TimeToCrack;
import javafx.scene.shape.Line;
import javafx.ext.swing.SwingComboBox;
import javafx.ext.swing.SwingComboBoxItem;
import javafx.scene.input.MouseEvent;

/**
 * @author cam
 */

public class AnalysisResults extends CustomNode {
    public var cost: com.passfault.PathCost;
    public var fontSize = 18;
    public var width  = 250;
    public var height = 950;
    public-init var signBuilder: PatternFactory;
    
    public-init var threshold: Double;
    public-init var translatex = 0;
    public-init var translatey = 0;
    var sign: ConstructionSign;
    var comboOpacity = 0.0;
    public-init var initialCracker: TimeToCrack;
    var combo = SwingComboBox {
      items: [
        for(item in TimeToCrack.values()){
          SwingComboBoxItem {
            text: item.getDisplayName()
            value: item
            selected: (item == initialCracker)
          }
        }
      ]
      opacity: bind comboOpacity
      layoutY: -15
      focusTraversable: false
    }
    public-read var cracker = bind getCracker(combo.selectedItem);
    function getCracker(item:SwingComboBoxItem): TimeToCrack{
      var toReturn:TimeToCrack = (item.value as TimeToCrack);
      return toReturn;
    }

    function generateTimeToCrack(size:Double, cracker:TimeToCrack): String{
      return "{cracker.getTimeToCrackString(size)}";
    }

    function generateDisplayName(cracker:TimeToCrack): String{
      return "{cracker.getDisplayName()}:";
    }

    public override function create(): Node {
      sign = ConstructionSign {
        height: height,
        width: width+50,
        x: translatex-30,
        y: translatey,
        color: ConstructionSign.Green;
      };
      var result = "Password Accepted";
      if (cost.getTotalCost() > threshold){
        sign.color = ConstructionSign.Green;
        sign.stroke = Color.WHITE;
        result = "      Password Accepted      ";
      } else {
        sign.color = ConstructionSign.Orange;
        sign.stroke = Color.BLACK;
        result = "Password Needs More Work";
      }
      var patternCostSum=0;
      for( pattern in cost.getPath()){
        patternCostSum += pattern.getPatternSize() as Integer;
      }

      var content =   [
        sign.create(),
        VBox {
          width: width
          spacing: 10
          nodeHPos: HPos.CENTER
          nodeVPos: VPos.TOP
          layoutX: translatex-10
          layoutY: translatey+20

          visible: bind sign.visible
          content:
          [
            Text {
              font: Font {size: 32, name: "Roadgeek2005 SeriesEM"}
              smooth: true
              content: result;
              fill: sign.stroke
            },
            HBox {
              nodeHPos: HPos.CENTER
              hpos: HPos.CENTER
              content:
              [
                Text {
                  font: Font { size: fontSize name: "Roadgeek2005 SeriesC" }
                  content: "Time to Crack by a  ";
                  fill: sign.stroke
                },
                Group {
                  layoutY: -6
                  content: [
                    Text {
                      font: Font { size: fontSize name: "Roadgeek2005 SeriesC" oblique:true}
                      content: bind generateDisplayName(cracker);
                      fill: sign.stroke
                      opacity: bind 1 - combo.opacity
                      onMouseEntered: function (e: MouseEvent): Void {
                          comboOpacity = 1.0;
                      };
                      onMouseExited: function (e: MouseEvent): Void {
                          comboOpacity = 0.0;
                      };
                    },
                    combo
                  ]
                }
                Text {
                  font: Font { size: fontSize name: "Roadgeek2005 SeriesEM" embolden:true}
                  content: bind generateTimeToCrack(cost.getTotalCost(), cracker)
                  fill: sign.stroke
                },
              ]
            },
            HBox {
              nodeHPos: HPos.CENTER
              hpos: HPos.CENTER
              width: width
              content:
              [
                Text {
                  font: Font { size: fontSize name: "Roadgeek2005 SeriesC"}
                  content: "Passwords in pattern:";
                  fill: sign.stroke
                },
                Text {
                  font: Font { size: fontSize name: "Roadgeek2005 SeriesEM"}
                  content: " {cracker.getRoundedSizeString(cost.getTotalCost())}";
                  fill: sign.stroke
                },
              ]
            },
            Text
            {
              font: Font {size: fontSize-3 name: "Roadgeek2005 SeriesC"}
              content: "Most crackable combination of patterns found: ";
              fill: sign.stroke
            },
            HBox{
              nodeHPos: HPos.CENTER
              hpos: HPos.CENTER
              width: width
              spacing: 5
              content: [
                for( pattern in cost.getPath()){
                  signBuilder.create(pattern, patternCostSum);
                }
              ]
            },
          ]
        }
    ];

    def group = Group {
      content: content
    }
  return group;
 }

   public function play(){
       sign.toggleVisibility();
   }
}
