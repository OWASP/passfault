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
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.passfault.ParallelFinder;
import com.passfault.PasswordAnalysis;
import com.passfault.AnalysisListener;
import com.passfault.PasswordPattern;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.VPos;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import com.passfault.BuildFinders;


/**
 * @author cam
 */
var vert = 10;
var fontSize = 40;
var superContent = javafx.scene.Group {
    content: [];
}

def passwordBox = PasswordBox{signColor: ConstructionSign.Green}
def passwordNode = passwordBox.create();

var passEngine: ParallelFinder = BuildFinders.build("{__DIR__}dictionaries/");
var hasEvaluated = false;

def welcomeSign = ConstructionSign {
  stroke:Color.WHITE
  color:ConstructionSign.Blue
  width: 500
  height: 210
  x: 10
  y: 10
}
welcomeSign.toggleVisibility();
def welcome = Group {
  translateX:150, translateY: 10
  content: [
    welcomeSign.create(),
    VBox{
      vpos: VPos.CENTER
      height: welcomeSign.height- 10
      width: welcomeSign.width - 10
      translateX: 40, translateY: 20
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
          content: "We pave the way to"
          fill: Color.WHITE
        },
        Text {
          translateX: welcomeSign.width/2
          font : Font {  size: 20 name: "Roadgeek2005 SeriesD", oblique: true}
          content: "secure passwords"
          fill: Color.WHITE
        }
      ]
    }
  ]
}

def buttonSign = ConstructionSign {
  stroke:Color.WHITE
  color:ConstructionSign.Green
  width: 200
  height: 50
  onclick: function() {
    if (hasEvaluated){
      var toDelete = superContent.content[1..];
      for (item in toDelete){
      delete item from superContent.content;
      };
    }
    for (sign in patternSigns){
      sign.visible = false;
      sign.translateX = 10;
      sign.translateY = 400;
    }
    hasEvaluated = true;
    var analysis:PasswordAnalysis = new PasswordAnalysis(passwordBox.getPassword());
    analysis.addListener(new MyCallback());
    passEngine.analyze(analysis);
  }
}
buttonSign.toggleVisibility();

def button = Group {
  content: [
    buttonSign,
    Text {
      font : Font {  size: 24 name: "Roadgeek2005 SeriesD" }
      x: 15, y: 35
      content: "Click To Evaluate"
      fill: Color.WHITE
    }
  ]
}

class MyCallback extends AnalysisListener {
  override function foundPattern(patt: PasswordPattern ) {
    if (patt.getMatchString() != null and patt.getLength()>0){
        def word = passwordBox.getPassword().substring(
            patt.getStartIndex(), patt.getStartIndex()+patt.getLength());
        javafx.lang.FX.deferAction(
            function(){
                launchSubString(word, toString(patt.getMatchString()), patt.getStartIndex(), patt.getCost());
            }
        )
    }
  }

  function toString(chars:java.lang.CharSequence):String {
    def string = new java.lang.StringBuffer();
    for(i in [0..chars.length()]){
      string.append(chars.charAt(i));
    }
    return string.toString();
  }

  override function foundHighestProbablePatterns(cost: com.passfault.PathCost){
    javafx.lang.FX.deferAction(
        function(){
            def results = AnalysisResults{
                cost: cost,
                translatex: 150
                translatey: 5
                width: 600
                height: 275
                signBuilder: factory
            }
            insert results.create() into superContent.content;
            results.play();
          }
      );
   }
}

function launchSubString(substring:String, matchString:String, starti:Integer, cost:Double){
    def patternView = FoundPatternView{
        matchString: matchString,
        starti: starti,
        substring: substring,
        startx: 320
        starty: 320
        x: 10,
        y: 360,
        width: 775
        height: 270
        fontSize: fontSize
        cost: cost
    };
    insert patternView.create() before superContent.content[1] ;
    patternView.play();
}

insert HBox {
    translateX: 180
    translateY: 280
    nodeVPos: VPos.TOP
    content: [
        passwordNode,
        button,
    ];
    visible:true
} before superContent.content[0];

def factory = PatternFactory{};
factory.start();
def patternSigns = [
  factory.buildWordMatch("Dictionary"),
  factory.buildWordInsert("Dictionary"),
  factory.buildWordSubstitute("Dictionary"),
  factory.buildWordMispell("Dictionary"),
  factory.buildWordBackwards("Dictionary"),
  factory.buildKeyHorizontal(""),
  factory.buildKeyDiagonal(""),
  factory.buildKeyRepeat(""),
  factory.buildDuplicate(),
  factory.buildRandom(""),
];

for(i in [0..4]){
  patternSigns[i].translateX = 200+80*i;
  patternSigns[i].translateY = 400;
}
for(i in [5..9]){
  patternSigns[i].translateX = 200+80*(i-5);
  patternSigns[i].translateY = 500;
}

def road = Image{ url: "{__DIR__}images/Asphalt.jpg" }
def stage = Stage {
    title: "PassFault"
    width: 850
    height: 700
    onClose: function() {
        passEngine.end();
    }

    scene: Scene {
        fill: LinearGradient {
            proportional:true;
            startX:0, startY:1,
            endX:1, endY:0
            stops: [ Stop{offset:0, color: Color.BLACK},
                     Stop{offset:1, color: Color.DARKSLATEBLUE} ]
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
            for (s in patternSigns){
              s
            },
            welcome,
            Group{
                content:[
                superContent,
                Line {
                      startX: 10, startY: 340
                      endX: 900, endY: 340
                      strokeWidth: 7
                      stroke: Color.web("#FFFF00",0.85);
                      strokeLineCap: StrokeLineCap.BUTT
                      strokeDashArray: [40]
                  }
                ]
              },
          ],
      }
}
