/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package mygame.Quests.Mission1;

import com.jme3.app.state.AppStateManager;
import com.jme3.scene.Node;
import mygame.Quest;

/**
*
* @author Bob
*/
public class LagoQuest extends Quest {
    
    public LagoQuest(AppStateManager stateManager, Node holder) {
        super(stateManager, holder);
        name = "GoblinQuest";
    }
    
    @Override
    public void act() {
        
        Quest goblinQuest = player.questList.getQuest("GoblinQuest");
        String speech;
        
        if (goblinQuest == null) {
            goblinQuest      = new GoblinQuest(stateManager, player);
            goblinQuest.step = "Start";
            player.questList.add(goblinQuest);
        }
        
        switch (goblinQuest.step) {
            case "Start":
                speech = "A traveler? You should talk to Edmund.";
                break;
            case "SeeGuard":
                speech = "Their gate has been broken and we must repair it. Then kill those goblins";
                goblinQuest.step = "SeeAndy";
                break;
            case "SeeAndy":
                speech = "Andy built these gates years ago, he will know how to fix it.";
                break;
            default:
                speech = "";
                break;
        }
        
        gui.showAlert(holder.getName(), speech);
        
    }
    
}
