/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlefield;
import java.lang.*;

/**
 *
 * @author srbr
 */
public class BattleEngine {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        int i = 0;
        double C = 300000000.0;
        double R;
        
        AirCraft A1 = new AirCraft(1, new CartesianLocation(1732.1, 1732.1, 1732.1), new CartesianLocation(0, 0, 0), -300.0);
        Radar R1 = new Radar(1, new CartesianLocation(0, 0, 0), 25  * Math.pow(10.0, -6.0));
        // Radar R2 = new Radar(2, new CartesianLocation(98, 78, 6), 25  * Math.pow(10.0, -6.0));
        
        CartesianLocation cl;
        SphericalLocation sl;
        
        // Main loop.
        for (i = 0; i < 10000; i++){
            
            cl = A1.getCurLoc();
            sl = cl.getSphLoc();
            
            System.out.println(i + "," + A1.getStatus());
            
            System.out.println(i + "," + R1.getStatus());
            R1.setEchoMatrix(A1, R1);
            R = R1.getCurLoc().distanceCart(cl);
            R1.setEchoMatrixFilledTime((2 * R) / C);
            if (A1.getJammingRadarId() == 1)
                System.out.printf("%d,", i);
            R1.update();
              
            /*
            System.out.printf("%d,", i);
            R2.setEchoMatrix(A1, R2);
            R = R2.getCurLoc().distanceCart(cl);
            R2.setEchoMatrixFilledTime((2 * R) / C);
            if (A1.getJammingRadarId() == 2)
                System.out.printf("%d,", i);
            R2.update();
            */
            
            // Aircraft
            A1.clearRadarList();
            
            if (R1.isEchoMatrixSet() == 1) {
                A1.addToRadarList(R1);
            }
            
            /*
            if (R2.isEchoMatrixSet() == 1) {
                A1.addToRadarList(R2);
            }
            */
            
            // Update the Aircraft.
            A1.update();
            
            
        }
    }
    
}
