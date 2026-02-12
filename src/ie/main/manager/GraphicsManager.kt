package ie.main.manager

import org.w3c.dom.css.ViewCSS
import java.awt.*;
import kotlin.time.Clock

class GraphicsManager {
    fun renderBackGround(g : Graphics) {
        g.color = Color(30,30,30)
        g.fillRect(-Int.MAX_VALUE/2, -Int.MAX_VALUE/2, Int.MAX_VALUE, Int.MAX_VALUE)
    }
}
