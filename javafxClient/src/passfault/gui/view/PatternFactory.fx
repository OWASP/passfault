/*
 * PatternFactory.fx
 *
 * Created on Feb 25, 2010, 5:06:02 PM
 */

package passfault.gui.view;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.animation.Interpolator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import com.passfault.PasswordPattern;
import javafx.scene.input.MouseEvent;
import com.passfault.TimeToCrack;
import javafx.scene.Group;
import java.lang.UnsupportedOperationException;

/**
 * @author cam
 */

// place your code here
public class PatternFactory  {
  var oneToZero: Double;
  public-init var width = 80;
  public-init var height = 100;
  def signContentIndent = 10;
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

  def letterWidth = 9;
  public def WORD_EXACT=com.passfault.dictionary.ExactWordStrategy.NAME;
  public def WORD_MISPELL=com.passfault.dictionary.MisspellingStrategy.NAME;
  public def WORD_INSERT=com.passfault.dictionary.AugmentationStrategy.NAME;
  public def WORD_SUBSTITUTE=com.passfault.dictionary.SubstitutionStrategy.NAME;
  public def WORD_BACKWARDS=com.passfault.dictionary.BackwardsAnalysisAdapter.NAME;
  public def WORD_1337=com.passfault.dictionary.l337SubstitutionStrategy.NAME;
  public def KEY_HORIZONTAL=com.passfault.keyboard.KeySequenceFinder.HORIZONTAL;
  public def KEY_Diagonal=com.passfault.keyboard.KeySequenceFinder.DIAGONAL;
  public def KEY_REPEATING=com.passfault.keyboard.KeySequenceFinder.REPEATED;
  public def PATTERN_DUPLICATE=com.passfault.RepeatingPatternFinder.DUPLICATE_PATTERN;
  public def PATTERN_RANDOM=com.passfault.RandomPattern.RANDOM_PATTERN;

  
  def keyboard = Image{ url: "{__DIR__}images/keys-65.png" }
  def die = Image{ url: "{__DIR__}images/die.png" }
  public function start(){
    if (time.running==false){
      time.play();
    }
  }

  public function create(pattern:PasswordPattern, patternCostSum:Double): Group {
    var sign:Group;
    def patternName = pattern.getName();
    def patternLanguage = pattern.getClassification();
    
    if(patternName == WORD_EXACT){
      sign = buildWordMatch(patternLanguage);
    } else if(patternName == WORD_MISPELL){
      sign = buildWordMispell(patternLanguage);
    } else if(patternName == WORD_INSERT){
      sign = buildWordInsert(patternLanguage);
    } else if(patternName == WORD_BACKWARDS){
      sign = buildWordBackwards(patternLanguage);
    } else if(patternName == WORD_SUBSTITUTE){
      sign = buildWordSubstitute(patternLanguage);
    } else if(patternName == WORD_1337){
      sign = buildWordl337(patternLanguage);
    } else if(patternName == KEY_HORIZONTAL){
      sign = buildKeyHorizontal(patternLanguage);
    } else if(patternName == KEY_Diagonal){
      sign = buildKeyDiagonal(patternLanguage);
    } else if(patternName == KEY_REPEATING){
      sign = buildKeyRepeat(patternLanguage);
    } else if(patternName == PATTERN_DUPLICATE){
      sign = buildDuplicate();
    } else if(patternName == PATTERN_RANDOM){
      sign = buildRandom(patternLanguage);
    }
    def patternSign = sign;
    def percentString = "{pattern.getCost()/patternCostSum*100 as Integer}%";
    def costString = TimeToCrack.getRoundedSizeString(pattern.getCost());
    
    def strengthSign = buildStrengthSign(percentString, costString, toString(pattern.getMatchString()));

    def time = Timeline {
        autoReverse: false,
        keyFrames: [
          KeyFrame {time: 0s values: [
            strengthSign.opacity => 1.0
            ]},
          KeyFrame {time: 2s values: [
            strengthSign.opacity => 0.0 tween Interpolator.EASEIN,
            ]
          }
        ]
      }
    patternSign.onMouseEntered = function (e: MouseEvent): Void {
        strengthSign.opacity = 1.0;
    }
    strengthSign.onMouseExited = function (e: MouseEvent): Void {
        strengthSign.opacity = 0.0;
    }
    var toReturn = Group {
      content: [
        patternSign,
        strengthSign
      ]
    }
    time.play();
    return toReturn;
  }

  public function buildStrengthSign(percent:String, size:String, match:String): Group {
    return Group {
      content: [
          Rectangle {
            width:width, height: height,
            fill: Color.WHITE
            strokeWidth: 3
            stroke: Color.BLACK
            arcWidth: 7
            arcHeight: 7
          },
          VBox{
            layoutX: signContentIndent
            layoutY: 4
            width: width
            spacing: 2
            vpos: VPos.CENTER
            nodeHPos: HPos.CENTER
            hpos: HPos.CENTER
            nodeVPos: VPos.CENTER
            content: [
              Text {
              font : Font {size : 16 name: "Roadgeek2005 SeriesD" }
                content: match
                smooth: true
              },
              Text {
              font : Font {size : 14 name: "Roadgeek2005 SeriesB"}
                content: "Pattern Size"
                smooth: true
              },
              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesD" embolden:true}
                content: size
                smooth: true
              },
              Text {
              font : Font {size : 24 name: "Roadgeek2005 SeriesEM"}
                content: percent
                smooth: true
              },
              Text {
              font : Font {size : 14 name: "Roadgeek2005 SeriesB"}
                content: "of Total Strength"
                smooth: true
              },
            ]
          }
        ]
      };
  }

  public function buildWordMatch(lang:String): Group {
    return Group { 
      content: [
          Rectangle {
            width:width, height: height,
            fill: Color.WHITE
            strokeWidth: 3
            stroke: Color.BLACK
            arcWidth: 7
            arcHeight: 7
          },
          VBox{
            layoutY: 5
            layoutX: signContentIndent + 4
            width: width
            height: height
            spacing: 6
            vpos: VPos.CENTER
            nodeHPos: HPos.CENTER
            hpos: HPos.CENTER
            nodeVPos: VPos.CENTER
            content: [
              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
                content: lang
              },
              Text {
              font : Font {size : 20 name: "Roadgeek2005 SeriesEM"}
                content: "Word"
              }
            ]
          }
        ]
      }
  }

  public function buildDuplicate(): Group {
    return Group {
      content: [
          Rectangle {
            width:width, height: height,
            fill: Color.WHITE
            strokeWidth: 3
            stroke: Color.BLACK
            arcWidth: 7
            arcHeight: 7
          },
          VBox{
            layoutY: 5
            layoutX: signContentIndent + 4
            width: width
            height: height
            spacing: 6
            vpos: VPos.CENTER
            nodeHPos: HPos.CENTER
            hpos: HPos.CENTER
            content: [

              Text {
              font : Font {size : 13 name: "Roadgeek2005 SeriesD"}
                content: "Repeated"
              },
              Text {
              font : Font {size : 11 name: "Roadgeek2005 SeriesD"}
                content: "Pattern"
              },
              Group {
                content: [
                  Rectangle {
                    x: bind (oneToZero) * width/5 + width/12
                    width:width/3-4, height: height/3,
                    fill: Color.WHITE
                    strokeWidth: 2
                    stroke: Color.BLACK
                    arcWidth: 4
                    arcHeight: 4
                  },
                  Rectangle {
                    x: bind (1-oneToZero) * width/5 - width/12
                    width:width/3-4, height: height/3,
                    fill: Color.WHITE
                    strokeWidth: 2
                    stroke: Color.BLACK
                    arcWidth: 4
                    arcHeight: 4
                  }
                ]
              },
            ]
          }
        ]
      }
  }

  public function buildRandom(classification:String): Group {
    return Group {
      content: [
          Rectangle {
            width:width, height: height,
            fill: Color.WHITE
            strokeWidth: 3
            stroke: Color.BLACK
            arcWidth: 7
            arcHeight: 7
          },
          VBox{
            layoutX: signContentIndent + 3
            layoutY: 5
            width: width
            height: height
            spacing: 6
            vpos: VPos.CENTER
            nodeHPos: HPos.CENTER
            hpos: HPos.CENTER
            content: [
              Text {
              font : Font {size : 13 name: "Roadgeek2005 SeriesD"}
                content: "Random"
              },
              Text {
              font : Font {size : 11 name: "Roadgeek2005 SeriesD"}
                content: classification
              },
              ImageView {
                  image: die
                },
            ]
          }
        ]
      }
  }

  public function buildWordMispell(lang:String): Group {
    return Group { 
      content: [
        Rectangle {
          width: width, height: height

          fill: Color.WHITE
          strokeWidth: 3
          stroke: Color.BLACK
          arcWidth: 7
          arcHeight: 7
        },
        VBox{
          layoutX: signContentIndent
          layoutY: 5
          width: width
          height: height
          spacing: 6
          vpos: VPos.CENTER
          nodeHPos: HPos.CENTER
          hpos: HPos.CENTER
          nodeVPos: VPos.CENTER
          content: [

            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
              content: lang
            },
            HBox{
              content: [
                Text {
                  layoutX: 1
                  font : Font {size : 20 name: "Roadgeek2005 SeriesEM"}
                  content: "W"
                },
                Group {
                  layoutY:3
                  content: [
                    Text {
                      translateX: 1
                      font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                      content: "o"
                      opacity: bind 1-oneToZero;
                    },
                    Text {
                      translateX: 1
                      font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                      content: "e"
                      opacity: bind oneToZero;
                    },
                  ]
                },
                Text {
                  translateX: -3
                font : Font {size : 20 name: "Roadgeek2005 SeriesEM"}
                  content: "rd"
                },
              ]
            }

            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
              content: "Misspelling"
            },
          ]
        }
      ]
    }
  }

  public function buildWordInsert(lang:String): Group {
    return Group { //sign 2
        content: [
          Rectangle {
            width: width, height: height

            fill: Color.WHITE
            strokeWidth: 3
            stroke: Color.BLACK
            arcWidth: 7
            arcHeight: 7
          },
          VBox{
            layoutY: 5
            layoutX: signContentIndent - 1
            width: width
            height: height
            spacing: 6
            vpos: VPos.CENTER
            nodeHPos: HPos.CENTER
            hpos: HPos.CENTER
            nodeVPos: VPos.CENTER
            content: [

              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
                content: lang
              },
              HBox{
                nodeHPos: HPos.CENTER
                nodeVPos: VPos.BOTTOM
                content: [
                  Text {
                    translateX: bind 7*oneToZero
                    font : Font {size : 20 name: "Roadgeek2005 SeriesEM"}
                    content: "Wo"
                  },
                  Text {
                    font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                    content: "&"
                    scaleX: bind (1-oneToZero)
                    scaleY: bind (1-oneToZero)
                  },
                  Text {
                    translateX: bind -7*oneToZero
                  font : Font {size : 20 name: "Roadgeek2005 SeriesEM"}
                    content: "rd"
                  },
                ]
              }

              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
                content: "Insertion"
              }
            ]
          }
        ]
      }

  }

  public function buildWordBackwards(lang:String): Group {
    return Group { //sign 5
      content: [
        Rectangle {
          width: width, height: height

          fill: Color.WHITE
          strokeWidth: 3
          stroke: Color.BLACK
          arcWidth: 7
          arcHeight: 7
        },
        VBox{
          layoutY: 5
          layoutX: signContentIndent
          width: width
          height: height
          spacing: 6
          vpos: VPos.CENTER
          nodeHPos: HPos.CENTER
          hpos: HPos.CENTER
          nodeVPos: VPos.CENTER
          content: [
            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
              content: lang
            },
            Group {
              content: [
              Text {
                font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                content: "W"
                translateX: bind -letterWidth*1.8*(1-oneToZero) + letterWidth*1.8*oneToZero
              },
              Text {
                font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                content: "o"
                translateX: bind -letterWidth*.4*(1-oneToZero) + letterWidth*.4*oneToZero
              },
              Text {
                font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                content: "r"
                translateX: bind letterWidth*.7*(1-oneToZero) - letterWidth*.7*oneToZero
              },
              Text {
                font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                content: "d"
                translateX: bind letterWidth*1.8*(1-oneToZero) - letterWidth*1.8*oneToZero
              }
            ]
          },
            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
              content: "Backwards"
            }
          ]
        }
      ]
    }
  }

  public function buildWordSubstitute(lang:String): Group {
    return Group {
      content: [
        Rectangle {
          width: width, height: height

          fill: Color.WHITE
          strokeWidth: 3
          stroke: Color.BLACK
          arcWidth: 7
          arcHeight: 7
        },
        VBox{
          layoutY: 5
          layoutX: signContentIndent
          width: width
          height: height
          spacing: 6
          vpos: VPos.CENTER
          nodeHPos: HPos.CENTER
          hpos: HPos.CENTER
          nodeVPos: VPos.CENTER
          content: [

            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
              content: lang
            },
            HBox{
              nodeHPos: HPos.CENTER
              nodeVPos: VPos.BOTTOM
              content: [
                Text {
                  translateX: 1
                  font : Font {size : 20 name: "Roadgeek2005 SeriesEM"}
                  content: "W"
                },
                Group {
                  translateY:3
                  content: [
                    Text {
                      translateX: -1
                      translateY: 1
                      font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                      content: "o"
                      opacity: bind 1-oneToZero;
                    },
                    Text {
                      translateY: 5
                      font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                      content: "*"
                      opacity: bind oneToZero;
                    },
                  ]
                },
                Text {
                  translateX: -3
                font : Font {size : 20 name: "Roadgeek2005 SeriesEM"}
                  content: "rd"
                },
              ]
            }

            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
              content: "Substitution"
            }
          ]
        }
      ]
    }
  }

public function buildWordl337(lang:String): Group {
    return Group {
      content: [
        Rectangle {
          width: width, height: height

          fill: Color.WHITE
          strokeWidth: 3
          stroke: Color.BLACK
          arcWidth: 7
          arcHeight: 7
        },
        VBox{
          layoutY: 5
          layoutX: signContentIndent
          width: width
          height: height
          spacing: 6
          vpos: VPos.CENTER
          nodeHPos: HPos.CENTER
          hpos: HPos.CENTER
          nodeVPos: VPos.CENTER
          content: [

            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
              content: lang
            },
            Group {
              content: [
                Text {
                  font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                  content: "Elite"
                  opacity: bind 1-oneToZero;
                },
                Text {
                  font : Font {size : 20 name: "Roadgeek2005 SeriesEM" embolden:true}
                  content: " 1337 "
                  opacity: bind oneToZero;
                },
              ]
            },

            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesD"}
              content: "Substitution"
            }
          ]
        }
      ]
    }
  }

  public function buildKeyRepeat(lang:String): Group {
    return Group { //sign 1
    content: [
          Rectangle {
            width:width, height: height,
            fill: Color.WHITE
            strokeWidth: 3
            stroke: Color.BLACK
            arcWidth: 7
            arcHeight: 7
          },
          VBox{
            layoutY: 5
            layoutX: signContentIndent - 2
            width: width
            height: height
            spacing: 3
            vpos: VPos.CENTER
            nodeHPos: HPos.CENTER
            hpos: HPos.CENTER
            nodeVPos: VPos.CENTER
            content: [
              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesC"}
                content: lang
              },
              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesC"}
                content: "Key Sequence"
              },
              Group {
                content: [
                  ImageView {
                    image: keyboard
                  },
                  Group {
                    content: [
                      Arc {
                        centerX: 33, centerY: 18
                        radiusX: 6, radiusY: 6
                        startAngle: bind oneToZero * 520, length: 250
                        fill: Color.TRANSPARENT
                        strokeWidth: 3
                        type: ArcType.OPEN
                        stroke: Color.BLACK

                      }
                      /*
                      Polygon {
                        points : [ 18,15, 11,22, 18,29 ]
                        fill: Color.BLACK
                      },
                      */
                    ]
                  },
                ]
              }
              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesE"}
                content: "Repeated"
              }
            ]
          }
        ]
      }
  }

  public function buildKeyHorizontal(lang:String): Group {
    return Group { //sign 1
    content: [
          Rectangle {
            width:width, height: height,
            fill: Color.WHITE
            strokeWidth: 3
            stroke: Color.BLACK
            arcWidth: 7
            arcHeight: 7
          },
          VBox{
            layoutY: 5
            layoutX: signContentIndent -2
            width: width
            height: height
            spacing: 3
            vpos: VPos.CENTER
            nodeHPos: HPos.CENTER
            hpos: HPos.CENTER
            nodeVPos: VPos.CENTER
            content: [

              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesC"}
                content: lang
              },
              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesC"}
                content: "Key Sequence"
              },
              Group {
                content: [
                  ImageView {
                    image: keyboard
                  },
                  Group {
                    content: [
                      Rectangle {
                        x: 15, y: 20
                        width: bind 35, height: 4
                        fill: Color.BLACK
                      },
                      Polygon {
                        points : [ 18,15, 11,22, 18,29 ]
                        fill: Color.BLACK
                      },
                      Polygon {
                        points : [ 47,15, 54,22, 47,29 ]
                        fill: Color.BLACK
                      }
                    ]
                  },
                ]
              }
              Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesE"}
                content: "Horizontal"
              }
            ]
          }
        ]
      }
  }

  public function buildKeyDiagonal(lang:String): Group {
    return Group { //sign 2
      content: [
        Rectangle {
          width:width, height: height,
          fill: Color.WHITE
          strokeWidth: 3
          stroke: Color.BLACK
          arcWidth: 7
          arcHeight: 7
        },
        VBox{
          layoutY: 5
          layoutX: signContentIndent -2
          width: width
          height: height
          spacing: 3
          vpos: VPos.CENTER
          nodeHPos: HPos.CENTER
          hpos: HPos.CENTER
          nodeVPos: VPos.CENTER
          content: [

            Text {
              font : Font {size : 12 name: "Roadgeek2005 SeriesC"}
                content: lang
            },
            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesC"}
              content: "Key Sequence"
            },
            Group {
              content: [
                ImageView {
                  image: keyboard
                },
                Group {
                  rotate: 60
                  content: [
                    Rectangle {
                      x: 15, y: 20
                      width: bind 35, height: 4
                      fill: Color.BLACK
                    },
                    Polygon {
                      points : [ 18,15, 11,22, 18,29 ]
                      fill: Color.BLACK
                    },
                    Polygon {
                      points : [ 47,15, 54,22, 47,29 ]
                      fill: Color.BLACK
                    }
                  ]
                },
                Group {
                  rotate: -60
                  content: [
                    Rectangle {
                      x: 15, y: 20
                      width: bind 35, height: 4
                      fill: Color.BLACK
                    },
                    Polygon {
                      points : [ 18,15, 11,22, 18,29 ]
                      fill: Color.BLACK
                    },
                    Polygon {
                      points : [ 47,15, 54,22, 47,29 ]
                      fill: Color.BLACK
                    }
                  ]
                },
              ]
            }
            Text {
            font : Font {size : 12 name: "Roadgeek2005 SeriesE"}
              content: "Diagonal"
            }
          ]
        }
      ]
    }
  }

  function toString(chars:java.lang.CharSequence):String {
      def string = new java.lang.StringBuffer();
      for(i in [0..chars.length()-1]){
        string.append(chars.charAt(i));
      }
      return string.toString();
  }

}

