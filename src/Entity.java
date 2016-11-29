public class Entity {

    private double[] position = new double[2];
    private double[] velocity = new double[2];//0 is x, 1 is y
    private double[] acceleration = new double[2];
    private double[] nPosition = new double[2];
    private double[] nVelocity = new double[2];//0 is x, 1 is y
    private double[] nAcceleration = new double[2];
    private double radius;//maybe should be int?
    private double mass;// equal to area
    final double pi = 3.14159265358979323846;
    
    Entity(double x, double y,double vx, double vy, double r){
        this.setX(x);
        this.setY(y);
        this.setVX(vx);
        this.setVY(vy);
        this.setRadiusAndMass(r);
        //this.setMass(mass);
        
    }

    double[] getPosition() {
        return this.position;
    }
    //****************************************************************************
    double getX(){
        return this.position[0];
    }
    //****************************************************************************
    double getY(){
        return this.position[1];
    }
    //****************************************************************************
    void setPosition(double p[]) {
        this.position = p;
    }
    //****************************************************************************
    void setX(double x){
        this.position[0] = x;
    }
    //****************************************************************************
    void setY(double y){
        this.position[1] = y;
    }
    //****************************************************************************
    double[] getVelocity() {
        return this.velocity;
    }
    //****************************************************************************
    double getVX(){
        return this.velocity[0];
    }
    //****************************************************************************
    double getVY(){
        return this.velocity[1];
    }
    //****************************************************************************
    void setVelocity(double v[]) {
        this.velocity = v;
    }
    //****************************************************************************
    void setVX(double vx){
        this.velocity[0] = vx;
    }
    //****************************************************************************
    void setVY(double vy){
        this.velocity[1] = vy;
    }
    //****************************************************************************
    double[] getAcceleration(){
        return this.acceleration;
    }
    //****************************************************************************
    double getAX(){
        return this.acceleration[0];
    }
    //****************************************************************************
    double getAY(){
        return this.acceleration[1];
    }
    //****************************************************************************
    void setAcceleration(double a[]) {
        this.acceleration = a;
    }
    //****************************************************************************
    void setAX(double ax){
        this.acceleration[0] = ax;
    }
    //****************************************************************************
    void setAY(double ay){
        this.acceleration[1] = ay;
    }
    //****************************************************************************
    double getRadius(){
        return this.radius;
    }
    //****************************************************************************
//    void setRadius(double r){
//        this.radius = r;
//    }
    void setRadiusAndMass(double r){
        this.radius = r;
        this.mass = pi * r * r;//a=pi*r^2
    }
    //****************************************************************************
    double getMass(){
        return this.mass;
    }
    //****************************************************************************  
    void setMass(double area){// shouldn't be needed except for when setRadius calls it.. private?
        this.mass = area;
    }
    //****************************************************************************
    void setNX(double x){
        this.nPosition[0] = x;
    }
    //****************************************************************************
    void setNY(double y){
        this.nPosition[1] = y;
    }
    //****************************************************************************
    void setNVX(double vx){
        this.nVelocity[0] = vx;
    }
    //****************************************************************************
    void setNVY(double vy){
        this.nVelocity[1] = vy;
    }
    //****************************************************************************
     void setNAX(double ax){
        this.nAcceleration[0] = ax;
    }
    //****************************************************************************
    void setNAY(double ay){
        this.nAcceleration[1] = ay;
    }
    //****************************************************************************
}
//****************************************************************************
//****************************************************************************