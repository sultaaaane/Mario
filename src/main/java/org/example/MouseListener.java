package org.example;

public class MouseListener {
    private static MouseListener instance;
    private double scrollY,scrollX;
    private double Xpos,Ypos,lastX,lastY;
    private Boolean mouseButton[] = new Boolean[3];
    private Boolean isDragging;

    private MouseListener() {
        this.scrollY = 0.0;
        this.scrollX = 0.0;
        this.lastX = 0.0;
        this.lastY = 0.0;
        this.Xpos = 0.0;
        this.Ypos = 0.0;
    }

    public static MouseListener get(){
        if (instance == null){
            instance = new MouseListener();
        }
        return MouseListener.instance;
    }

    public static void MousePosCallBack(long window){

    }








}








