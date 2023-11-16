import processing.core.PApplet;
import processing.core.PImage;

/**
 * shoots a bascketball into a hoop with clouds moving in the background 
 * @author Preston Wong
 *
 */

public class Sketch extends PApplet {

  PImage ImgBackground;
  PImage ImgClouds;

  // location and speed variables for the circle
	float floatX = 730; // 200 and 800 start
  float floatY = 475; // 730 and 475 end
  float floatXSpeed = 5;
  float floatYSpeed = 5;

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

    // adjust the circle location 
      floatX = floatX + floatXSpeed;
      floatY = floatY + floatYSpeed;

    // detects if the ball has hit the hoop, and it it has, it cycles through some movements to get back to the starting position
    if (floatX >= 730 && (floatY >= 475 && floatY < 900)) {
      floatYSpeed = 5;
      floatXSpeed = 0;
    } else if (floatX >= 730 && floatY <= 900) {
      floatYSpeed = 0;
      floatXSpeed = -5;
    } else if (floatX <= 100 && (floatY <= 900 && floatY >= 800)) {
      floatXSpeed = 0;
      floatYSpeed = -1;
    }
    

    // moves the ball in the parabolic shape for the shot
    if (floatX <= 100 && floatY <= 800) {
      floatYSpeed = 0;
      floatXSpeed = 0;
    }
  }
}