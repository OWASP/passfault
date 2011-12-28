/*
 * FoundPatternView.fx
 *
 * Created on Oct 14, 2009, 7:17:37 AM
 */

package passfault.gui.view;

import javafx.scene.CustomNode;
import javafx.scene.Group;
import javafx.scene.Node;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.lang.System;

import java.lang.Math;

/**
 * @author cam
 */


public class FoundPatternView extends CustomNode {
    public var fontSize:Integer;
    public var x = 0;
    public var y = 0;
    public var startx =0;
    public var starty =0;
    public var width = 100;
    public var height = 100;
    public var substring:String;
    public var cost:Double;
    public var matchString:String;
    public var starti:Integer;
    
    var time:Timeline;
    def rand = java.util.Random{};

    public override function create(): Node {
        def sizeFactor = Math.log(cost);
        var fontScale=sizeFactor/30;
        def xdistance = rand.nextInt(width)+ x;
        def ydistance = rand.nextInt(height) +y;
        var myx =0.0;
        var myy =0.0;

        time = Timeline {
        keyFrames: [
            KeyFrame{
                time: 0s
                values: [
                    myx => startx,
                    myy => starty
                        ]
            },
            KeyFrame{
                time: 2s
                values: [
                    myx => xdistance tween Interpolator.EASEOUT,
                    myy => ydistance tween Interpolator.EASEOUT,
                    ]
            }
        ];
        }
        def text = Text {
            
            fill: Color.WHITE

            y: bind myy;
            x: bind myx;
            font : Font {
                size: fontSize * fontScale
                name: "Roadgeek2005 SeriesEM"
            }
            content: substring;
            smooth: true;
        } ;
        
        return text;
    }

   public function play(){
       time.play();
   }

}

