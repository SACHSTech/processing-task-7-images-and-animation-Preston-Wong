import processing.core.PApplet;
import processing.core.PImage;

/**
 * shoots a bascketball into a hoop with clouds moving in the background 
 * @author Preston Wong
 *
 */

public class Sketch extends PApplet {

  // image variables
  PImage ImgBackground;
  PImage ImgClouds;

  // location and speed variables for the circle
	float floatX = 320; // 320, 800
  float floatY = 900; // 730 and 475 end
  float floatXSpeed = 1;
  float floatYSpeed = 1;

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
    size(950, 950);
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

    // changes the location of the clouds 
    floatXPic = floatXPic + floatXPicSpeed;

    // changes the direction of the clouds when it hits the sides
    if (floatXPic  < 0) {
      floatXPicSpeed  = floatXPicSpeed  * -1;
    } else if (floatXPic  > width - 475) {
      floatXPicSpeed  = floatXPicSpeed  * -1;
    }

    // prints out the bascketball
    fill(255,165,0);
    noStroke();
    ellipse(floatX, floatY,50, 50);

    // change the location of the ball 
    floatX = floatX + floatXSpeed;    
    floatY = floatY + floatYSpeed;

    // adjust the ball location 
    if (floatX >= 320 && floatX <= 570 && floatY <= 851) {
      floatXSpeed = 1;
      floatYSpeed = (float) -(0.0001 * Math.pow((-floatX + 570),2));
    } else if (floatX >= 570 && floatX <= 730) {
      floatYSpeed = (float) (0.0001 * Math.pow((-floatX + 570),2));
    } else if (floatY >= 475 && floatY < 840) {
      floatYSpeed = 5;
      floatXSpeed = 0;
    } else if (floatX >= 320 && floatY >= 840) {
      floatYSpeed = 0;
      floatXSpeed = -5;
    } else if (floatX <= 320) {
      floatXSpeed = 1;
      floatYSpeed = (float) -(0.0001 * Math.pow((-floatX + 580),2));
    }
  }
}