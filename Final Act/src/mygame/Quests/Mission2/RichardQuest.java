/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission2;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class RichardQuest extends Quest {
    
    public RichardQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "MineQuest";
    }
    
    @Override
    public void act() {
        
        Quest mineQuest = player.questList.getQuest("MineQuest");
        String speech;
        
        if (mineQuest == null) {
            mineQuest      = new MineQuest(stateManager, player);
            mineQuest.step = "Start";
            player.questList.add(mineQuest);
        }
        
        switch (mineQuest.step) {
            case "Start":
                speech  = "I've just inherited this estate from my fater... A barren mine is all he left.";
                mineQuest.step = "FindPaper";
                break;
            case "FindPaper":
                speech = "My father closed that mine years ago. I've hired a few miners, but it seems barren. What a waste.";
                break;
            case "FoundPaper":
                speech = "Gold you say? I don't care to hear about dark forces, my father was a supersticious fool.";
                mineQuest.step = "FindMiner";
                break;
            case "FindMiner":
                speech = "Apparently one of my mines are talking about, go why he's skipping out on his contract...";
                break;
            default:
                speech = "I'm eager to find that gold my father spoke of. Dark forces... How ridiculous!";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
