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
package com.blp.nova.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.blp.nova.libs.Reference;

/**
 * Project: CataclysmicBattles - 
 *
 * Class: BufferedImageLoader
 *
 * @author BossLetsPlays
 *
 */
public class BufferedImageLoader {

    private BufferedImage image;
    
    public BufferedImage loadImage(String imagePath) throws IOException{
        image = ImageIO.read(new File(Reference.SPRITE_LOCATION + imagePath));
        return image;
    }

}
