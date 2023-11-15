import processing.core.PApplet;
import processing.core.PImage;

/**
 * Animates a shape in a set pattern with edge detection 
 * @author Preston Wong
 *
 */

public class Sketch extends PApplet {

  PImage ImgBackground;
  PImage ImgClouds;

  // location and speed variables for the circle
	float floatX = 200; // 200 and 800 start
  float floatY = 800; // 730 and 475 end
  float floatXSpeed = 5;
  float floatYSpeed = -5;

  // location and speed variables for the image 
  float floatXPic = 0;
  float floatYPic = -100;
  float floatXPicSpeed = 5;
  float floatYPicSpeed = 0;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(1000, 1000);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    ImgBackground = loadImage("Processing-Task-7.jpg");
    ImgClouds = loadImage("Clouds-removebg-preview.png");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
    // prints background right before printout the the new circle location 
    image(ImgBackground,0,0);

    // prints out the clousd 
    image(ImgClouds, floatXPic, floatYPic);

    // prints out the cloud and moves them from left to right
    floatXPic = floatXPic + floatXPicSpeed ;

    // changes the direction of the clouds when it hits the sides
    if (floatXPic  < 0) {
      floatXPicSpeed  = floatXPicSpeed  * -1;
    } else if (floatXPic  > width - 475) {
      floatXPicSpeed  = floatXPicSpeed  * -1;
    }

    // prints out the circle 
    fill(255,165,0);
    ellipse(floatX, floatY,50, 50);

    // adjust the circle location 
      floatX = floatX + floatXSpeed;
      floatY = floatY + floatYSpeed;

    // detects if the circle has hit the edge of the window or not 
    if (floatX <= 0) {
      floatX = floatX * -1;
    } else if (floatX >= width - 50) {
      floatX = floatX * -1;
    }
    
    if (floatY <= 0) {
      floatY =floatY * -1;
    } else if (floatY >= height - 50) {
      floatY = floatY * -1;
    }
  }
  
  // define other methods down here.
}