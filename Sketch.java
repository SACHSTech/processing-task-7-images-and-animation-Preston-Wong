import processing.core.PApplet;
import processing.core.PImage;

/**
 * Animates a shape in a set pattern with edge detection 
 * @author Preston Wong
 *
 */

public class Sketch extends PApplet {

  PImage img;

  // location and speed variables for the circle
	float floatX = 20;
  float floatY = 10;
  float floatXSpeed = 5;
  float floatYSpeed = 5;

  // location and speed variables for the image 
  float floatXPic = 0;
  float floatYPic = 0;
  float floatXPicSpeed = 0;
  float floatYPicSpeed = 0;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1024, 1024);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    img = loadImage("Processing-Task-7.jpg");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    // prints background right before printout the the new circle location 
    image(img,0,0);

    // prints out the circle 
    fill(0,0,0);
    ellipse(floatX, floatY,15, 15);

    // adjust the circle location 
    floatX = floatX + floatXSpeed;
    floatY = floatY + floatYSpeed;

    // detects if the circle has hit the edge of the window or not 
    if (floatX >= width - 10) {
      floatXSpeed = floatXSpeed * -1;
    } else if (floatX <= 0) {
      floatXSpeed = floatXSpeed * -1;
    }

    if (floatY >= height - 10) {
      floatYSpeed = floatYSpeed * -1;
    } else if (floatY <= 0) {
      floatYSpeed = floatYSpeed * -1;
    }
    
  }
  
  // define other methods down here.
}