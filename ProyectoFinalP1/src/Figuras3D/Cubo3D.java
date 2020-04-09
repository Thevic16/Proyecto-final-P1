package Figuras3D;

//JFrame

import javax.swing.JFrame;

//BorderLayout stuff
import java.awt.*;
import javax.swing.*;

//Canvas3D
import javax.media.j3d.Canvas3D;

//The Universe
import com.sun.j3d.utils.universe.SimpleUniverse;



//The BranchGroup
import javax.media.j3d.BranchGroup;

//For the Box
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;

import javax.vecmath.*;

//The directional light
import javax.media.j3d.DirectionalLight;

//For the bouding sphere of the light source
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.Material;

//Transformgroup
import javax.media.j3d.TransformGroup;
import com.sun.j3d.utils.behaviors.mouse.*;

public class Cubo3D extends JFrame {
/**
* The SimpleUniverse object
*/
protected SimpleUniverse simpleU;

/**
* The root BranchGroup Object.
*/
protected BranchGroup rootBranchGroup;
private Dimension dim = null; // para ajustar el tamaño de la ventana

/**
* Constructor that consturcts the window with the given name.
* 
* @param name
*            The name of the window, in String format
*/
public Cubo3D(String name) {
//The next line will construct the window and name it
//with the given name
super(name);

dim = super.getToolkit().getScreenSize();
super.setSize(dim.width, (dim.height-50));
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Perform the initial setup, just once
initial_setup();
}

/**
* Perform the essential setups for the Java3D
*/
protected void initial_setup() {
//A JFrame is a Container -- something that can hold
//other things, e.g a button, a textfield, etc..
//however, for a container to hold something, you need
//to specify the layout of the storage. For our
//example, we would like to use a BorderLayout.
//The next line does just this:
getContentPane().setLayout(new BorderLayout());

//The next step is to setup graphics configuration
//for Java3D. Since different machines/OS have differnt
//configuration for displaying stuff, therefore, for
//java3D to work, it is important to obtain the correct
//graphics configuration first.
GraphicsConfiguration config = SimpleUniverse
.getPreferredConfiguration();

//Since we are doing stuff via java3D -- meaning we
//cannot write pixels directly to the screen, we need
//to construct a "canvas" for java3D to "paint". And
//this "canvas" will be constructed with the graphics
//information we just obtained.
Canvas3D canvas3D = new Canvas3D(config);

//And we need to add the "canvas to the centre of our
//window..
getContentPane().add("Center", canvas3D);

//Creates the universe
simpleU = new SimpleUniverse(canvas3D);

//First create the BranchGroup object
rootBranchGroup = new BranchGroup();
}

/**
* Adds a light source to the universe
* 
* @param direction
*            The inverse direction of the light
* @param color
*            The color of the light
*/
public void addDirectionalLight(Vector3f direction, Color3f color) {
//Creates a bounding sphere for the lights
BoundingSphere bounds = new BoundingSphere();
bounds.setRadius(1000d);

//Then create a directional light with the given
//direction and color
DirectionalLight lightD = new DirectionalLight(color, direction);
lightD.setInfluencingBounds(bounds);

//Then add it to the root BranchGroup
rootBranchGroup.addChild(lightD);
}

/**
* Adds a box to the universe
* 
* @param x
*            The x dimension of the box
* @param y
*            The y dimension of the box
* @param z
*            The z dimension of the box
*/
public void addBox(float x, float y, float z, Color3f diffuse, Color3f spec) {
//Add a box with the given dimension

//First setup an appearance for the box
Appearance app = new Appearance();
Material mat = new Material();
mat.setDiffuseColor(diffuse);
mat.setSpecularColor(spec);
mat.setShininess(5.0f);

app.setMaterial(mat);
Box box = new Box(x, y, z, app);


//Create a TransformGroup and make it the parent of the box
TransformGroup tg = new TransformGroup();

tg.addChild(box);



//Then add it to the rootBranchGroup
rootBranchGroup.addChild(tg);

tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
tg.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);

MouseRotate myMouseRotate = new MouseRotate();
myMouseRotate.setTransformGroup(tg);
myMouseRotate.setSchedulingBounds(new BoundingSphere());
rootBranchGroup.addChild(myMouseRotate);

MouseTranslate myMouseTranslate = new MouseTranslate();
myMouseTranslate.setTransformGroup(tg);
myMouseTranslate.setSchedulingBounds(new BoundingSphere());
rootBranchGroup.addChild(myMouseTranslate);

MouseZoom myMouseZoom = new MouseZoom();
myMouseZoom.setTransformGroup(tg);
myMouseZoom.setSchedulingBounds(new BoundingSphere());
rootBranchGroup.addChild(myMouseZoom);
}

/**
* Finalise everything to get ready
*/
public void finalise() {
//Then add the branch group into the Universe
simpleU.addBranchGraph(rootBranchGroup);

//And set up the camera position
simpleU.getViewingPlatform().setNominalViewingTransform();
}

public static void VisualizarFigura(String nombre,float tamano,String color) {
	Color aux = null;
	
	if(color.equalsIgnoreCase("Blanco")) {
		aux = Color.white;
	}
	else if(color.equalsIgnoreCase("Azul")) {
		aux = Color.blue;
	}
	else if(color.equalsIgnoreCase("Cian")) {
		aux = Color.cyan;
	}
	else if(color.equalsIgnoreCase("Gris")) {
		aux = Color.gray;
	}
	else if(color.equalsIgnoreCase("Gris claro")) {
		aux = Color.lightGray;
	}
	else if(color.equalsIgnoreCase("Verde")) {
		aux = Color.green;
	}
	else if(color.equalsIgnoreCase("Magenta")) {
		aux = Color.magenta;
	}
	else if(color.equalsIgnoreCase("Naranja")) {
		aux = Color.orange;
	}
	else if(color.equalsIgnoreCase("Rosa")) {
		aux = Color.pink;
	}
	else if(color.equalsIgnoreCase("Rojo")) {
		aux = Color.red;
	}
	else if(color.equalsIgnoreCase("Amarillo")) {
		aux = Color.yellow;
	}
	else {
		aux = Color.white; // Por defecto
	}
	
	Cubo3D bc = new Cubo3D(nombre);

//bc.setSize(250, 250);
bc.addBox(tamano, tamano, tamano, new Color3f(aux), new Color3f(aux));


bc.addDirectionalLight(new Vector3f(0f, 0f, -1),
 new Color3f(aux));
bc.finalise();

bc.show();
	
}

public static void main(String[] argv) {

	VisualizarFigura("Cubo",0.1f,"Amarillo");

return;
}
}
