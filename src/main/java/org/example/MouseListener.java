package org.example;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class MouseListener {
    private static MouseListener instance;
    private double scrollY,scrollX;
    private double Xpos,Ypos,lastX,lastY;
    private Boolean mouseButtonPressed[] = new Boolean[3];
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

    public static void MousePosCallBack(long window,double xpos,double ypos) {
        get().lastX = get().Xpos;
        get().lastY = get().Ypos;
        get().Xpos = xpos;
        get().Ypos = ypos;
        get().isDragging = get().mouseButtonPressed[0] || get().mouseButtonPressed[1] || get().mouseButtonPressed[2];
    }
    public static void MouseButtonCallBack(long window , int button ,int action ,int mods){
        if (action == GLFW_PRESS) {
            if (button < get().mouseButtonPressed.length) {


                get().mouseButtonPressed[button] = true;
            }
        } else if (action == GLFW_RELEASE) {
            if (button < get().mouseButtonPressed.length) {
            get().mouseButtonPressed[button] = false;
            get().isDragging = false;
            }
        }
    }

    public static void MouseScrollCallBack(long window , double xOffset , double yOffset){
        get().scrollX = xOffset;
        get().scrollY = yOffset;
    }

    public static void endFrame(){
        get().scrollY = 0;
        get().scrollX = 0;
        get().lastY = get().Ypos;
        get().lastX = get().Xpos;
    }

    public static float getX(){
        return (float)get().Xpos;
    }
    public static float getY(){
        return (float)get().Ypos;
    }

    public static float getDX(){
        return (float)(get().lastX - get().Xpos);
    }

    public static float getDY(){
        return (float)(get().lastY - get().Ypos);
    }

    public static float getScrollX(){
        return (float)get().scrollX;
    }

    public static float getScrollY(){
        return (float)get().scrollY;
    }

    public static boolean isDragging(){
        return get().isDragging;
    }

    public static boolean mouseButtonDown(int button){
        if (button < get().mouseButtonPressed.length){
            return get().mouseButtonPressed[button];
        }else {
            return false;
        }
    }








}








