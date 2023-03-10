package org.example;
import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
public class Window {
    private int width,height;
    private String title;
    private static Window window = null;
    private Long glfwWindow;
    private float r,g,b,a;
    private Window(){
       this.height=1920;
       this.width=1080;
       this.title="mario";
        r = 0;
        b = 0;
        g = 0;
        a = 0;
    }
    public static Window get(){
        if(Window.window == null){
            Window.window = new Window();

        }
        return Window.window;
    }
    public void run(){
    System.out.println("Hello LWGL" + Version.getVersion()+"!");
    init();
    loop();
    glfwFreeCallbacks(glfwWindow);
    glfwDestroyWindow(glfwWindow);

    glfwTerminate();
    glfwSetErrorCallback(null).free();
    }
    public void init(){
        GLFWErrorCallback.createPrint(System.err).set();

        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW.");
        }

        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE,GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE,GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED,GLFW_TRUE);

        glfwWindow = glfwCreateWindow(this.width,this.height,this.title,NULL,NULL);
        if(glfwWindow==NULL){
            throw new IllegalStateException("failed to create window");

        }
        glfwSetCursorPosCallback(glfwWindow,MouseListener::mousePosCallback);
        glfwSetMouseButtonCallback(glfwWindow,MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow,MouseListener::mouseScrollCallback);

        glfwSetKeyCallback(glfwWindow,KeyListener::KeyCallBack);

        glfwMakeContextCurrent(glfwWindow);
        glfwSwapInterval(1);
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();
    }

    public void loop(){
    while (!glfwWindowShouldClose(glfwWindow)){
        glfwPollEvents();

        glClearColor(r,g,b,a);
        glClear(GL_COLOR_BUFFER_BIT);
        if (KeyListener.isKeyPressed(GLFW_KEY_SPACE)){
            System.out.println("space clicked");
        }
        glfwSwapBuffers(glfwWindow);
    }
    }
}






















