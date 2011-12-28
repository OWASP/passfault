/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fonts;

/**
 *
 * @author Rakesh Menon
 */

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.Method;
import java.net.URL;
import javafx.async.RunnableFuture;

class FontRunnableFuture implements RunnableFuture {

    private String url = null;

    FontRunnableFuture(String url) {
        this.url = url;
    }

    public void run() {

        try {

            URL fontURL = new URL(url);
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Class clazz = ge.getClass();
            Method registerFont = clazz.getMethod("registerFont", font.getClass());
            Object success = registerFont.invoke(ge, font);
            if(!((Boolean) success).booleanValue()) {
                throw new RuntimeException("Register font failed!");
            }
            
        } catch(Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
