/*   Copyright 2013 BossLetsPlays(Matthew Rogers)
*
*   Licensed under the Apache License, Version 2.0 (the "License");
*   you may not use this file except in compliance with the License.
*   You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
*   Unless required by applicable law or agreed to in writing, software
*   distributed under the License is distributed on an "AS IS" BASIS,
*   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*   See the License for the specific language governing permissions and
*   limitations under the License.
*/
package com.blp.nova;

import java.awt.Graphics;
import java.util.ArrayList;

import com.blp.nova.core.CoreObject;

/**
 * <strong>Project:</strong> CataclysmicBattles <br>
 *
 * <strong>Class:</strong> Controller
 *
 * @author <a href = "http://youtube.com/BossLetsPlays"> BossLetsPlays</a>
 *
 */
public class Controller {

    private static ArrayList<CoreObject> objects = new ArrayList<CoreObject>();

    /**
     * Runs the ticking operations for all the objects in the <code>ArrayList</code>
     */
    public void tick() {
        for (CoreObject obj : objects)
            obj.tick();
    }

    
    /**
     * Runs the rendering operations for all the objects in the <code>ArrayList</code>
     */
    public void render(Graphics g) {
        for (CoreObject obj : objects)
            obj.render(g);
    }
    
    
    /**
     * Adds a new <code>CoreObject</code> to the <code>ArrayList</code>
     * @param instance a <code>CoreObject</code> instance
     */
    public static void addObject(CoreObject instance){
        objects.add(instance);
    }
    
    
    /**
     * Removes a <code>CoreObject</code> to the <code>ArrayList</code>
     * @param instance a <code>CoreObject</code> instance
     */
    public static void removeObject(CoreObject instance){
        objects.remove(instance);
    }

    
    /**
     * Retrieves the <code>ArrayList</code> of <code>CoreObjects</code>
     * @return the <code>CoreObject</code> list
     */
    public static ArrayList<CoreObject> getObjects(){
        return objects;
    }
}
