
import java.util.ArrayList;

public class Boleyn {
    
    final static double pi = 3.14159265358979323846;
    static ImageConstruction image;
    static int size;
    static ArrayList<Entity> entities;
    static int timeStep = 1;
    
    public static void main(String[] args) {
        KeyboardInputClass input = new KeyboardInputClass();
        //
        size = 800;
        //posSize = size / 2;
        //negSize = size / -2;
        while (true) {
            entities = new ArrayList<>();
            size = input.getInteger(true, 800, 0, 5000, "Enter the size for the window (Default is 800):");
            createImage();
            newEntityMenu();
            image.displayImage(false, "Simulation", false);
            
            menu();
        }
    }
    
    static void menu() {
        int exit = 0;
        while (exit == 0) {
            updateImage();
            System.out.println("Menu");
            System.out.println("______");
            System.out.println("Iterate:  I");
            System.out.println("Zoom:     ZI: Zoom In; ZO: Zoom Out");
            System.out.println("Pan:      PU: Pan Up; PD: Pan Down; PL: Pan Left; PR: Pan Right");
            System.out.println("Time:     TD: Double Time increment; TH: Half Time increment");
            System.out.println("Change:   C");
            System.out.println("Restart:  R");
            System.out.println("Exit:     E");
            KeyboardInputClass z = new KeyboardInputClass();
            String input = z.getString("I", "");
            input = input.toUpperCase();
            if (null != input) {
                switch (input) {
                    case "I":
                        iterate();
                        break;
                    //zoom in
                    case "ZI":
                        image.xLeft+= (image.xRange/4);
                        image.xRight-= (image.xRange/4);
                        image.yBottom+= (image.yRange/4);
                        image.yTop-= (image.yRange/4);
                        image.xRange=image.xRight-image.xLeft;
                        image.yRange=image.yTop-image.yBottom;

                        System.out.println("Top: " + image.yTop + " , Bottom: " + image.yBottom);
                        System.out.println("Left: " + image.xLeft + " , Right: " + image.xRight);
                        break;
                    //zoom out
                    case "ZO":
                        //y=.5yrange
                       image.xLeft-= (.5 * image.xRange);
                        image.xRight+= (.5 * image.xRange);
                        image.yBottom-= (.5 * image.yRange);
                        image.yTop+= (.5 * image.yRange);
                        image.xRange=image.xRight-image.xLeft;
                        image.yRange=image.yTop-image.yBottom;
                        System.out.println("Top: " + image.yTop + " , Bottom: " + image.yBottom);
                        System.out.println("Left: " + image.xLeft + " , Right: " + image.xRight);
                        
                        //image.displayImage(false, null, false);
                        break;
                    //pan up
                    case "PU":
                        image.yTop+=(image.yRange/2);
                        image.yBottom+=(image.yRange/2);
                        System.out.println("Top: " + image.yTop + " , Bottom: " + image.yBottom);
                        System.out.println("Left: " + image.xLeft + " , Right: " + image.xRight);
                        break;
                    //pan down
                    case "PD":
                        image.yTop-=(image.yRange/2);
                        image.yBottom-=(image.yRange/2);
                        System.out.println("Top: " + image.yTop + " , Bottom: " + image.yBottom);
                        System.out.println("Left: " + image.xLeft + " , Right: " + image.xRight);
                        break;
                    case "PL":
                        image.xLeft-=(image.yRange/2);
                        image.xRight-=(image.yRange/2);
                        System.out.println("Top: " + image.yTop + " , Bottom: " + image.yBottom);
                        System.out.println("Left: " + image.xLeft + " , Right: " + image.xRight);
                        break;
                    //pan right
                    case "PR":
                        image.xLeft+=(image.xRange/2);
                        image.xRight+=(image.xRange/2);
                        System.out.println("Top: " + image.yTop + " , Bottom: " + image.yBottom);
                        System.out.println("Left: " + image.xLeft + " , Right: " + image.xRight);
                        break;
                    //time ddouble    
                    case "TD":                        
                        timeStep *= 2;
                        break;
                    //time half    
                    case "TH":
                        timeStep /= 2;
                        break;
                    //change
                    case "C":
                        newEntityMenu();
                        break;
                    //restart
                    case "R":
                        exit = 1;
                        //image.clearImage(0, 0, 0);
                        image.closeDisplay();
                        break;
                    case "E":
                        System.exit(0);
                        break;
                    default:
                        System.out.println(input + " is not a valid entry, try again");
                        break;
                }
            }
            //updateImage();
        }
    }

    static void newEntityMenu() {
        int exit = 0;
        
        while (exit == 0) {
            int x = 0;
            int y = 0;
            double vx = 0;
            double vy = 0;
            double r = 0;
            System.out.println("Press 0 to stop entering entities");
            System.out.println("Press 1 to randomize a new entity (DEFAULT)");
            System.out.println("Press 2 to select a situation");
            System.out.println("Press 3 to select your own coordinates");
            KeyboardInputClass input = new KeyboardInputClass();
            int menu = input.getInteger(true, 1, 0, 3, "");
            switch (menu) {
                case 0:
                    if (entities.isEmpty()) {
                        System.out.println("Error, there must be at least 1 entity, try again.");
                    } else {
                        exit = 1;
                        break;
                    }//range with defaults.. for max radius etc.. 1/10th size of window
                case 1:
                    int numRandEntities = input.getInteger(true, 1, 0, 1000000, "How many random entities? (Default is 1):");
                    while (numRandEntities > 0) {
                        x = (int) ((Math.random() * image.xRange) + image.xLeft);
                        y = (int) ((Math.random() * image.yRange) + image.yBottom);
                        System.out.println("X is: " + x + ", Y is: " + y);
                        vx = (int) (Math.random() * size) - (size / 2);
                        vy = (int) (Math.random() * size) - (size / 2);
                        r = (int) (Math.random() * size) / 10;//max 
                        entities.add(new Entity(x, y, vx, vy, r));
                        numRandEntities--;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    x = input.getInteger(true, 0, 0, size, "Enter an x coordinate (Default is 0):");
                    y = input.getInteger(true, 0, 0, size, "Enter a y coordinate (Default is 0):");
                    vx = input.getDouble(true, 0, 0, size, "Enter velocity on the x axis (Default is 0):");
                    vy = input.getDouble(true, 0, 0, size, "Enter velocity on the y axis (Default is 0):");
                    r = input.getDouble(true, 1, 0, size, "Enter the radius (Default is 1):");
                    entities.add(new Entity(x, y, vx, vy, r));
                    break;
            }
            updateImage();
        }
    }
    //****************************************************************************

    static void createImage() {
        image = new ImageConstruction(size, size, size/-2, size/2, size/-2, size/2, 1);
        image.displaySetup();
        
    }
    //****************************************************************************

    static void iterate() {
        
    }
    
    static void updateImage() {
        System.out.println("I ran");
        image.clearImage(0, 0, 0);
        for (int i = 0; i < entities.size(); i++) {
            drawEntity(entities.get(i));
        }
        image.setPixelValues();
    }

    //****************************************************************************
    static void drawEntity(Entity entity) {
        image.insertCircle(entity.getX(), entity.getY(), entity.getRadius(), 255, 255, 255, false);
    }
}
//****************************************************************************
//****************************************************************************

