/*
 * FontTask.fx
 *
 * Created on Sep 7, 2009, 4:00:35 PM
 */

package fonts;


import javafx.async.RunnableFuture;
import javafx.async.JavaTaskBase;
import fonts.FontRunnableFuture;

/**
 * @author Rakesh Menon
 */

public class RegisterFontTask extends JavaTaskBase {

    public-init var url : String;
    
    override function create() : RunnableFuture {
        return new FontRunnableFuture(url);
    }
}
