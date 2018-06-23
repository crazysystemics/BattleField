/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefield;
import java.util.*;

/**
 *
 * @author srbr
 */
//my new comment
public class AirCraft {
    
    int aircraftId;
    CartesianLocation AInitial;
    CartesianLocation  AEnd;
    
    double velocity;
    CartesianLocation ACurrentLoc;
    java.util.ArrayList<Radar> radarList;
    int jammingRadarId;
    double jammingProbability;
    
    
    
    
    public AirCraft(int aId, CartesianLocation Ai, CartesianLocation Ae, double vel) {
        
        aircraftId = aId;
        AInitial = Ai;
        AEnd = Ae;
        ACurrentLoc = Ai;
        assert (ACurrentLoc.getX() > 0):"Aircraft not in first cordant";
        assert (ACurrentLoc.getY() > 0):"Aircraft not in first cordant";
        assert (ACurrentLoc.getZ() > 0):"Aircraft not in first cordant";
        
        radarList = new java.util.ArrayList<Radar>();
        jammingRadarId = -1;
        jammingProbability = 0.7;
        
        velocity = vel;
    }
    
    public String getStatus() {
        String status = "Aircraft "+this.aircraftId+","+this.getCurLoc().getX()+","+this.getCurLoc().getY()+","+this.getCurLoc().getZ();       
        return status;
    }
    
    public int getJammingRadarId() {
        return jammingRadarId;
    }
    
    public double getJammingProbability() {
        return jammingProbability;
    }
    
    public CartesianLocation getCurLoc(){
        return ACurrentLoc;
    }
    
    public void update(){
        
        SphericalLocation sl = ACurrentLoc.getSphLoc();
        sl.updateLocation((velocity/1000), 0.0, 0.0); 
        ACurrentLoc = sl.getCartLoc();
        assert (ACurrentLoc.getX() > 0):"Aircraft not in first cordant";
        assert (ACurrentLoc.getY() > 0):"Aircraft not in first cordant";
        assert (ACurrentLoc.getZ() > 0):"Aircraft not in first cordant";
        
        // pick the first element in the list to begin jamming.
        /*
        if (this.radarList.size() > 0) {
            jammingRadarId = radarList.get(0).getRadarId();
        } 
        */
    }
    
    public void addToRadarList(Radar r) {
        this.radarList.add(r);
    }
    
    public void clearRadarList() {
        if (this.radarList.size() > 0) {
            this.radarList.clear();
        }
        
    }
}
