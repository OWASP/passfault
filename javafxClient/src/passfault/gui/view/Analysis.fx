/*
 * passPOC.fx
 *
 * Created on Jan 26, 2009, 5:12:38 PM
 */
package passfault.gui.view;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.Group;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import com.passfault.ParallelFinder;
import com.passfault.PasswordAnalysis;
import com.passfault.AnalysisListener;
import com.passfault.PasswordPattern;
import javafx.scene.paint.LinearGradient;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.VPos;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.geometry.HPos;
import com.passfault.BuildFinders;

/**
 * @author cam
 */
def height = 660;
def width = 600;

java.lang.System.out.println("{__DIR__}");

def passwordBox = PasswordBox{signColor: ConstructionSign.Green}
def passwordNode = passwordBox.create();
def settings:Settings = Settings{
  layoutX: 150, layoutY: 150
  visible: false;
  onReturn: toggleSettings
  };
var opacity=1.0;

var viewSettingsText = "  View Settings  ";
def viewSettingsSign = ConstructionSign {
  stroke:Color.WHITE
  color:ConstructionSign.Brown
  width: 150
  height: 35
  onclick: toggleSettings
};
viewSettingsSign.toggleVisibility();

function toggleSettings(): Void{
  if(settings.visible){
    opacity = 1.0;
    viewSettingsText = "  View Settings  ";
  } else {
    opacity = .5;
    viewSettingsText = "  Hide Settings  ";
  }
  settings.visible = not settings.visible;
};

def viewSettings = Group {
  content: [
    viewSettingsSign,
    Text {
      font : Font {
        size: 20
        name: "Roadgeek2005 SeriesD"

        }

      x: 15, y: 25
      content: bind viewSettingsText
      fill: Color.WHITE
    }
  ]
}

var patternCount = 0;
def passEngine: ParallelFinder = BuildFinders.build("{__DIR__}dictionaries/");
var hasEvaluated = false;

def welcomeSign = ConstructionSign {
  stroke:Color.WHITE
  color:ConstructionSign.Blue
  width: 500
  height: 180
  x: 40
  y: 10
}
welcomeSign.toggleVisibility();
def welcome = Group {
  opacity: bind opacity
  content: [
    welcomeSign.create(),
    VBox{
      height: welcomeSign.height - 10
      width: welcomeSign.width - 10
      layoutX: 60, layoutY: 30
      content: [
        Text {
          font : Font {  size: 20 name: "Roadgeek2005 SeriesD", oblique: true }
          content: "Welcome to"
          fill: Color.WHITE
        },
        ImageView {
            image: Image{ url: "{__DIR__}images/passfault-logo-blue.png" }
        },
        Text {
          translateX: welcomeSign.width/2
          font : Font {  size: 20 name: "Roadgeek2005 SeriesD", oblique: true}
          content: "Paving the way to"
          fill: Color.WHITE
        },
        Text {
          translateX: welcomeSign.width/2
          font : Font {  size: 20 name: "Roadgeek2005 SeriesD", oblique: true, embolden:true }
          content: "secure passwords"
          fill: Color.WHITE
        }
      ]
    }
  ]
}

function evaluate () {
  if (hasEvaluated){
    patterns1.content = [];
    patterns2.content = [];
    patterns2.visible = false;
  }
  hasEvaluated = true;
  var analysis:PasswordAnalysis = new PasswordAnalysis(passwordBox.getPassword());
  analysis.addListener(new MyCallback());
  passEngine.analyze(analysis);
}

passwordBox.onReturn=evaluate;

def buttonSign = ConstructionSign {
  stroke:Color.WHITE
  color:ConstructionSign.Green
  width: 200
  height: 50
  onclick: evaluate
};

buttonSign.toggleVisibility();

def button = Group {
  content: [
    buttonSign,
    Text {
      font : Font {  size: 24 name: "Roadgeek2005 SeriesD" }
      x: 15, y: 33
      content: "Click To Evaluate"
      fill: Color.WHITE
    }
  ]
}

class MyCallback extends AnalysisListener {
  override function foundPattern(patt: PasswordPattern ) {
    patternCount ++;
  }

  override function foundHighestProbablePatterns(cost: com.passfault.PathCost){
    javafx.lang.FX.deferAction(
        function(){
            def results = AnalysisResults{
                cost: cost,
                translatex: 80
                translatey: 285
                width: 460
                height: 260
                signBuilder: factory
                initialCracker: settings.timeToCrack
                threshold: settings.getPasswordPolicy();
            }
            patterns1.content = [results.create()];
            patterns2.content = [];
            patterns2.visible = false;
           
            results.play();
          }
      );
   }
}

def factory = PatternFactory{};
factory.start();
def patternSigns = [
  factory.buildWordInsert("Dictionary"),
  factory.buildWordSubstitute("Dictionary"),
  factory.buildWordMispell("Dictionary"),
  factory.buildWordBackwards("Dictionary"),
  factory.buildWordl337("Dictionary"),
  factory.buildKeyHorizontal(""),
  factory.buildKeyDiagonal(""),
  factory.buildKeyRepeat(""),
  factory.buildDuplicate(),
  factory.buildRandom(""),
];

var patterns1 = HBox {
  vpos: VPos.CENTER
  hpos: HPos.CENTER
  nodeVPos: VPos.CENTER
  nodeHPos: HPos.CENTER
  opacity: bind opacity
  spacing: 5
  content: [
    for (i in [0..4]){
      patternSigns[i]
    },
  ]
}
var patterns2 = HBox {
  vpos: VPos.CENTER
  hpos: HPos.CENTER
  nodeVPos: VPos.CENTER
  nodeHPos: HPos.CENTER
  opacity: bind opacity
  spacing: 5
  content: [
    for (i in [5..9]){
      patternSigns[i]
    },
  ]
}

def road = Image{ url: "{__DIR__}images/Asphalt.jpg" }
def stage = Stage {
    title: "PassFault"
    width: width
    height: height
    onClose: function() {
        passEngine.end();
    }

    scene: Scene {
        fill: LinearGradient {
            proportional:true;
            startX:0, startY:1,
            endX:1, endY:0
            stops: [ Stop{offset:0, color: Color.BLACK},
                     Stop{offset:1, color: Color.DARKGRAY} ]
        }
        content: [
            for (i in [0..1]){
                for(j in [0..1])
                    ImageView {
                        x: i * 756
                        y: j * 512
                        image: road
                    }
            },

            VBox {
              spacing: 15
              nodeHPos: HPos.CENTER
              nodeVPos: VPos.CENTER
              content: [
                welcome,
                HBox {
                  vpos: VPos.CENTER
                  hpos: HPos.CENTER
                  nodeVPos: VPos.CENTER
                  nodeHPos: HPos.CENTER
                  opacity: bind opacity
                  spacing: 10
                  content: [
                      passwordNode,
                      button,
                  ];
                  visible:true
                },
                Line {
                  startX: 10, startY: 340
                  endX: width, endY: 340
                  strokeWidth: 7
                  opacity: bind opacity
                  stroke: Color.web("#FFFF00",0.85);
                  strokeLineCap: StrokeLineCap.BUTT
                  strokeDashArray: [40]
                },
                patterns1,
                patterns2,
                viewSettings,
              ]
            },
            settings,
          ],
          
      }
}
